package com.synex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);//authenticatication
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder () {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/userForm", "/saveUser", "/updateUser","/deleteUser", "/", "/saverole", "/roleForm", "/deleterole").permitAll()//all request is authorized to be accessed, get user, save user, create role wihtout logging in
		.anyRequest().authenticated()//must be authenticated
		.and()
		.formLogin().loginPage("/login").permitAll()//override the security login with a cutomized login that was created in jsp/html while permitting a login page as a view, which need to be authenticated
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler)//any issues redirect to AccessDenial page
		.and()
		.httpBasic()//at defualt enable http
		.and()
		.csrf().disable(); //csrf = cross-site-resource-forgery is enabled by default keeping security a secret in mind
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/*", "/js/*");//sercurity ignore and allow these contents to be accessed
		
		
	}
}
