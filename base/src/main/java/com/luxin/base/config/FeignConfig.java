package com.luxin.base.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

//    /**
//     * 覆盖默认的重试机制，不进行重试
//     *
//     * @return
//     */
//    @Bean
//    public Retryer feignRetryer() {
//        Retryer retryer = new Retryer.Default(100, TimeUnit.SECONDS.toMillis(10), 0);
//        return retryer;
//    }
//
//    /**
//     * 覆盖默认的超时机制
//     *
//     * @return
//     */
//    @Bean
//    public Request.Options feignOption() {
//        Request.Options option = new Request.Options(20000, 20000);
//        return option;
//    }
//
//    /**
//     * feign日志打印
//     * @return
//     */
//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return feign.Logger.Level.FULL;
//    }

}
