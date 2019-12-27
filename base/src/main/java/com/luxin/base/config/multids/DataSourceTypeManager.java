package com.luxin.base.config.multids;

public class DataSourceTypeManager {

    private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"ds1");


    public static String getDataSourceType(){
        return threadLocal.get();
    }

    public static void setDataSourceType(String dataSourceType){
        threadLocal.set(dataSourceType);
        System.out.println(threadLocal.get());
    }

    public static void clearDataSourceType(){
        threadLocal.remove();
    }



}
