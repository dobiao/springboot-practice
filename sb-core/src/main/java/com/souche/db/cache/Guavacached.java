package com.souche.db.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 本地缓存, 使用guava的缓存机制, 存在内存中
 * 不支持分布式环境, 慎用. 仅限单机版本
 *
 * @author victorhan
 */

@Service
public class Guavacached implements CacheService {

    private static Logger logger = LoggerFactory.getLogger(Guavacached.class);

    private boolean enable = true;

    private static Map<String, LoadingCache<String, String>> cacheMap = Maps.newConcurrentMap();

    private void removeCache(String key) {
        cacheMap.remove(key);
    }

    private LoadingCache<String, String> getCache(String key) {
        return cacheMap.get(key);
    }

    private LoadingCache<String, String> newCache(String key) {
        LoadingCache<String, String> cache = cacheMap.get(key);
        if (cache == null) {
            cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return null;
                }
            });
            cacheMap.put(key, cache);
        }
        return cache;
    }

    private LoadingCache<String, String> newCache(String key, int expire) {
        if (expire == 0) {
            return newCache(key);
        }
        LoadingCache<String, String> cache = cacheMap.get(key);
        if (cache == null) {
            cache = CacheBuilder.newBuilder().expireAfterAccess(expire, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return null;
                }
            });
            cacheMap.put(key, cache);
        }
        return cache;
    }


    @Override
    public String get(String key) {
        if (StringUtils.isEmpty(key) || !enable) {
            return null;
        }

        LoadingCache<String, String> cache;

        try {
            cache = getCache(key);
        } catch (Exception e) {
            return null;
        }
        if (cache != null) {
            try {
                return cache.get(key);
            } catch (ExecutionException e) {
                logger.error("guava cache ExecutionException:", e);
            }
        }
        return null;
    }

    @Override
    public void touch(String key, int expire) {
        String value = get(key);
        set(key, value, expire);
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        try {
            if (StringUtils.isEmpty(key) || clazz == null || !enable) {
                return null;
            }
            String jsonValue = get(key);
            return StringUtils.isEmpty(jsonValue) ? null : (T) JSON.parseObject(jsonValue, clazz);
        } catch (Exception e) {
            logger.error("guava cache Exception:", e);
            return null;
        }
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<Object> list = (List<Object>) getObject(key, List.class);
        if (list == null) {
            return null;
        }
        List<T> result = Lists.newArrayList();
        for (Object jsonObj : list) {
            result.add(JSON.parseObject(jsonObj.toString(), clazz));
        }
        return result;
    }

    @Override
    public void set(String key, String value) {
        if (StringUtils.isEmpty(key) || !enable) {
            return;
        }
        LoadingCache<String, String> cache = newCache(key);
        cache.put(key, value);
    }

    @Override
    public void set(String key, String value, int expireSecond) {
        if (StringUtils.isEmpty(key) || !enable) {
            return;
        }
        if (expireSecond < 0) {
            expireSecond = 0;
        }
        LoadingCache<String, String> cache = newCache(key, expireSecond);
        cache.put(key, value);
    }

    @Override
    public void setObject(String key, Object value) {
        if (StringUtils.isEmpty(key) || value == null || !enable) {
            return;
        }
        set(key, JSON.toJSONString(value));
    }

    @Override
    public void setObject(String key, Object value, int expireSecond) {
        if (StringUtils.isEmpty(key) || value == null || expireSecond < 0 || !enable) {
            return;
        }
        set(key, JSON.toJSONString(value), expireSecond);
    }

    @Override
    public void del(String key) {
        if (StringUtils.isEmpty(key) || !enable) {
            return;
        }
        LoadingCache<String, String> cache = getCache(key);
        if (cache != null) {
            cache.invalidate(key);
            removeCache(key);
        }
    }


    @Override
    public boolean add(String key, String value, int expireSecond) {
        LoadingCache<String, String> cache = getCache(key);
        if (cache == null) {
            set(key, value, expireSecond);
            return true;
        } else {
            long size = cache.size();
            if (size > 0) {
                return false;
            } else {
                set(key, value, expireSecond);
                return true;
            }
        }
    }

    public void init() {
        this.enable = true;
        logger.info("guava cached inited...");
        logger.warn("注意不要在集群环境使用, guava cache");
    }

    public static void main(String[] args) {
        try {
            CacheService guavacached = new Guavacached();



            System.out.println(guavacached.get("test"));


            guavacached.set("test", "test value", 5);


            Thread.sleep(1000);
            System.out.println("after sleep 1 sec : " + guavacached.get("test"));
            Thread.sleep(10000);
            System.out.println("after sleep 10 sec : " + guavacached.get("test"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        cacheMap.clear();
    }

    @Override
    public Serializable getSerializableObject(String key) {
        try {
            if (StringUtils.isEmpty(key) || !enable) {
                return null;
            }
            String jsonValue = get(key);
            return StringUtils.isEmpty(jsonValue) ? null : (Serializable) JSON.parseObject(jsonValue, Serializable.class);
        } catch (Exception e) {
            logger.error("guava cache Exception:", e);
            return null;
        }
    }

    @Override
    public void setSerializableObject(String key, Serializable value) {
        if (StringUtils.isEmpty(key) || value == null || !enable) {
            return;
        }
        set(key, JSON.toJSONString(value));
    }

    @Override
    public void setSerializableObject(String key, Serializable value, int expireSecond) {
        if (StringUtils.isEmpty(key) || value == null || expireSecond < 0 || !enable) {
            return;
        }
        set(key, JSON.toJSONString(value), expireSecond);
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
