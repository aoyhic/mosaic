package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * 인증	
		 */
			auth.inMemoryAuthentication()
			.withUser("admin").password("1234").roles("ADMIN")
			.and()
			.withUser("user").password("1234").roles("USER");			
			//인메모리 방식으로 쓰겠다는 것. 그리고 체인방식으로 연결했고 두명이 인증할 수 있음 
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
		/*
		 * 권한 
		 */
			http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/country/**").hasRole("ADMIN") //이 url에 대해서 admin 아이디가 접근할 수 있도록 권한을 준다는 뜻
				//.antMatchers("/city/**").hasRole("ADMIN")
				.antMatchers("/city/register").hasRole("ADMIN")
				.antMatchers("/city/unregister/**").hasRole("ADMIN")
				.antMatchers("/city/modify/**").hasRole("ADMIN")
				.and()
				.formLogin()
					.loginPage("/login")
				.permitAll(); //전부 허용한다는 뜻
		}
	 
}
