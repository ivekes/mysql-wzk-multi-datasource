package com.wzk.aop;


import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.wzk.annotation.DynamicDataSourceAnnotation;
import com.wzk.core.RwDataSourceHolder;

public class DataSourceAspect implements MethodBeforeAdvice,AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		RwDataSourceHolder.clearDbType(); 
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (method.isAnnotationPresent(DynamicDataSourceAnnotation.class)){
			DynamicDataSourceAnnotation datasource = method.getAnnotation(DynamicDataSourceAnnotation.class);  
            RwDataSourceHolder.setDbType(datasource.dataSource());  
        }else{  
        	RwDataSourceHolder.setDbType(RwDataSourceHolder.SLAVE);  
        }  
	}

}
