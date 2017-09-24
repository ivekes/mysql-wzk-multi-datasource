package com.wzk.core;

import java.util.Random;

public class RwDataSourceHolder {
	public static final String MASTER = "master";	//主(写)连接池
	public static final String SLAVE = "slave";		//从(读)连接池
	
	public static ThreadLocal<String> holder = new ThreadLocal<String>();
    private static int slaves = 1;  //slaves的个数
    private static Random random = new Random();
    
	// 设置数据源类型
    public static void setDbType(String dbType) {
    	if(dbType.equals(MASTER)){
    		holder.set(MASTER);
    	}else{
    		holder.set(SLAVE + random.nextInt(slaves));
    	}
    }
    // 获取数据源类型 
    public static String getDbType() {
        return (holder.get());
    }
    // 清除数据源类型 
    public static void clearDbType() {
    	holder.remove();
    }
}
