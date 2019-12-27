package com.luxin.base.config.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//@Configuration
//@EnableAsync
public class MyThreadPoolTaskExecutor {

    @Autowired
    private TaskThreadPoolConfig config;

    @Bean
    public Executor myTaskAsyncPool(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(config.getMaxPoolSize());
        executor.setCorePoolSize(config.getCorePoolSize());
        executor.setKeepAliveSeconds(config.getKeepAliveSecondes());
        executor.setQueueCapacity(config.getQueueCapacity());
        executor.setThreadNamePrefix(config.getThreadNamePrefix());

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;

    }

}
