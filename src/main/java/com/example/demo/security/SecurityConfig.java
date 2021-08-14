package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
			.withUser(System.getenv("DELIVERABLE_USER"))
			.password(passwordEncoder().encode(System.getenv("DELIVERABLE_PASS")))
			.authorities("ROLE_USER");
		
	}

}
