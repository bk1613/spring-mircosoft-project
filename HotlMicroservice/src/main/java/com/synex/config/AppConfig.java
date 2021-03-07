package com.synex.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class AppConfig {
	//this service application does not return jsp page name. does not need for now. reserved for future
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;

	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		
//		datasource.setUrl("jdbc:mysql://localhost:3306/hoteldb?serverTimezone=UTC&useLegacyDateTimeCode=false&allowPublicKeyRetrieval=true");
//		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		datasource.setUsername("root");
//		datasource.setPassword("Success@03");
		
		
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        datasource.setUsername("SCOTT");
        datasource.setPassword("TIGER");

		return datasource;
	}
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.synex.domain");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaProperties(jpaProperties());
		
		return entityManagerFactory;
	}
	
	@Bean 
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		/* sessionFactory.setAnnotatedClasses(Hotel.class); */
		sessionFactory.setPackagesToScan("com.synex.domain");
		sessionFactory.setHibernateProperties(jpaProperties());
		return sessionFactory;
	}
	
	public Properties jpaProperties(){
		Properties jpaProperties = new Properties();
//		jpaProperties.setProperty("hibernate.dilect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		jpaProperties.setProperty("hibernate.show_sql", "false");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // hbm = hibernate mapping, ddl = data definition language
		
		return jpaProperties;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
		
	}
}
