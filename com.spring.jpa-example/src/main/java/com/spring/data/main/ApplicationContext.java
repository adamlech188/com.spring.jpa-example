package com.spring.data.main;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.core.env.Environment;



public class ApplicationContext {

	@Resource
	private Environment env; 
	
	public DataSource dataSource() { 
		
		BasicDataSource dataSource = new BasicDataSource(); 
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		return null; 
	}
	
}
