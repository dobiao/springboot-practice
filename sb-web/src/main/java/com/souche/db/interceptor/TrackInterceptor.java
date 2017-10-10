/**
 * Create by ray at 2015年6月4日 下午4:13:48.
 * Ray [email:rayinhangzhou@126.com]
 * TrackInterceptor.java is for :
 * Revision History
 * Date@Programmer: memo
 * ----------------------------------------------------------------
 * 2015年6月4日@Ray: initial
 **/
package com.souche.db.interceptor;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrackInterceptor extends HandlerInterceptorAdapter {
	final static Logger LOGGER_TRACK	= LoggerFactory.getLogger("track");
	@Autowired
	//RedisLockRepository	redisLockRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		request.setAttribute("requestTime", System.currentTimeMillis());
		/*if (StringUtils.isNotBlank(AuthNHolder.userId()) && request.getMethod().equalsIgnoreCase("post")) {
			String ip = CommonUtils.getIp(request);
			if (!redisLockRepository.lock(request.getRequestURI() + AuthNHolder.userId() + ip, 3)) { // 3s内无法重复请求同个接口，除非已返回响应
				return false;
			}
			return true;
		}*/
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*String ip = CommonUtils.getIp(request);
		String uri = request.getRequestURI();
		if (StringUtils.isNotBlank(AuthNHolder.userId()) && request.getMethod().equalsIgnoreCase("post")) {
			redisLockRepository.releaseLock(uri + AuthNHolder.userId() + ip);
		}
		long costTime = System.currentTimeMillis() - (Long) request.getAttribute("requestTime");
		String params = JSONObject.toJSONString(request.getParameterMap());
		LOGGER_TRACK.info("{}{},{},{},{}__{}ms", (costTime > 3000 ? "slow-->" : ""), uri, params,
				AuthNHolder.userPhone(), ip, costTime);
	}*/
}
