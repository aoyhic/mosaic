package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		DataSource dataSource;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * 인증	
		 */
//			auth.inMemoryAuthentication()
//			.withUser("admin").password("1234").roles("ADMIN")
//			.and()
//			.withUser("user").password("1234").roles("USER");			
			//인메모리 방식으로 쓰겠다는 것. 그리고 체인방식으로 연결했고 두명이 인증할 수 있음. 회원을 추가할 수 없고, 이건 테스툥임. DB로그인 안된 상태.
			//DB에 저장해서 써야하므로 데이타베이스 로그인이 되어있어야하고, DB에 저장해서 쓸 수 있어야함.
			
			//시큐리티가 알아서 데이타소스로 디비에 정보를 넣고 디비에서 정보를 가져오는 역할을 함.
			auth.jdbcAuthentication().dataSource(dataSource);
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
				.logout()
					.logoutSuccessUrl("/")
				.and()	
				.formLogin()
					.loginPage("/login")
				.permitAll(); //전부 허용한다는 뜻
		}
	 
}
