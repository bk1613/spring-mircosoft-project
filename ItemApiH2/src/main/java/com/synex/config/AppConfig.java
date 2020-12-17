package com.synex.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.synex.model")
public class AppConfig {

//	@Bean
//	@Primary
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactory.setDataSource(dataSource());
//		entityManagerFactory.setPackagesToScan("com.synex.domain");
//		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		entityManagerFactory.setJpaProperties(jpaProperties());
//		
//		return entityManagerFactory;
//	}
//	
//	@Bean 
//	public LocalSessionFactoryBean sessionFactory(){
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan("com.synex.domain");
//		sessionFactory.setHibernateProperties(jpaProperties());
//		return sessionFactory;
//	}
	
	public Properties jpaProperties(){
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dilect", "org.hibernate.dialect.H2Dialect ");
		jpaProperties.setProperty("hibernate.show_sql", "false");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create"); 
		
		return jpaProperties;
	}
	
}
