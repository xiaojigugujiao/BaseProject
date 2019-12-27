package com.luxin.base.config.threadpool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "task.pool")
public class TaskThreadPoolConfig {

    private int corePoolSize ;

    private int maxPoolSize ;

    private int keepAliveSecondes ;

    private int queueCapacity ;

    private String threadNamePrefix;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getKeepAliveSecondes() {
        return keepAliveSecondes;
    }

    public void setKeepAliveSecondes(int keepAliveSecondes) {
        this.keepAliveSecondes = keepAliveSecondes;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }
}
