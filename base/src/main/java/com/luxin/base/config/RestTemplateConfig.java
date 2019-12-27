package com.luxin.base.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("ALL")
/**
 * RestTemplate 配置
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @ConditionalOnMissingBean({ RestOperations.class, RestTemplate.class })
    public RestTemplate restTemplate(SimpleClientHttpRequestFactory factory) {

        RestTemplate restTemplate = new RestTemplate(factory);

        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();

        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                iterator.remove();
            }
        }

        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate;
    }

    @Bean
    @ConditionalOnMissingBean({SimpleClientHttpRequestFactory.class})
    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 数据读取超时时间，即SocketTimeout
        factory.setReadTimeout(15000);// ms
        // 连接超时
        factory.setConnectTimeout(15000);// ms
        return factory;
    }
}
