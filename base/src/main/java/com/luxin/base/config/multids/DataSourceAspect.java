package com.luxin.base.config.multids;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceAspect {

    @Pointcut("execution(public * com.luxin.base.service.IMultiService.*(..))")
    public void checkPoint(){}

    @Before("checkPoint()")
    public void before(JoinPoint joinPoint){
        System.out.println("======================有没有生效=============================");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //如果方法体上使用了DataSource注解
        if (method.isAnnotationPresent(DataSource.class)) {
            //获取该方法上的注解名
            DataSource datasource = method.getAnnotation(DataSource.class);
            //将方法体上的注解的值赋予给DataSourceHolder数据源持有类
            DataSourceTypeManager.setDataSourceType(datasource.name());
        }
    }

    @AfterReturning(value = "checkPoint()", returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        DataSourceTypeManager.clearDataSourceType();
    }
}
