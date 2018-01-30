package com.souche.db.config;

import com.souche.db.listener.ApplicationStartListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dubiao on 2018/1/30.
 */
@Configuration
public class ListenerConfig {
    @Bean
    public ApplicationStartListener applicationStartListener(){
        return new ApplicationStartListener();
    }

}
