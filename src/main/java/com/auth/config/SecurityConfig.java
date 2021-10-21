package com.auth.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth.mapper.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder encoder;
   @Autowired
   MyUserDetailService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().authenticationEntryPoint((request,response,exp)->response.sendError(HttpServletResponse.SC_UNAUTHORIZED));
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	
//	
//	public NoOpPasswordEncoder noPasswordEncoder() {
//		return  (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
	/*
	 * @Bean public PasswordEncoder bCryptPasswordEncoder() { BCryptPasswordEncoder
	 * b=new BCryptPasswordEncoder(); return b; }
	 */
}
