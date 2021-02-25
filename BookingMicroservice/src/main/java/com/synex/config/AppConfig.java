package com.synex.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		
		datasource.setUrl("jdbc:mysql://localhost:3306/hoteldb?serverTimezone=UTC&useLegacyDateTimeCode=false&allowPublicKeyRetrieval=true");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUsername("root");
		datasource.setPassword("Success@03");
//		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
//        datasource.setUsername("SCOTT");
//        datasource.setPassword("TIGER");

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
		jpaProperties.setProperty("hibernate.dilect", "org.hibernate.dialect.MySQL5Dialect");
//		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
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
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");//smtp = simple mail transfer protocol
		mailSender.setPort(587);
		mailSender.setUsername("sfremont2519@gmail.com");
		mailSender.setPassword("syn@112519");
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		
		// starttls hold good for SSL(Secured Socket Layer) as well as for TLS(Transport Layer Security)
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProperties.setProperty("mail.debug", "true");
		
		
		mailSender.setJavaMailProperties(javaMailProperties);
		
		return mailSender;
		
	}
}
