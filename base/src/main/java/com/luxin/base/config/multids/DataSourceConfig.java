package com.luxin.base.config.multids;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource1")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }


    @Bean
    public RoutingDataSource routingDataSource(){
        RoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object,Object> map = new HashMap<>();
        map.put("ds1",this.dataSource1());
        map.put("ds2",this.dataSource2());
        routingDataSource.setTargetDataSources(map);
        routingDataSource.setDefaultTargetDataSource(this.dataSource1());
        return routingDataSource;

    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(this.routingDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));
        return bean.getObject();
    }





}
