package com.wzk.core;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Component  
@Aspect
public class RwDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return RwDataSourceHolder.getDbType();
	}

}
