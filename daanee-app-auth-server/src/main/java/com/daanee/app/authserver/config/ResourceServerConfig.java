/**
 * 
 */
package com.daanee.app.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author satyaveer.yadav
 *
 */

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService customUserDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
						
//		http.authorizeRequests().antMatchers("/**/css/**").permitAll();
//		http.authorizeRequests().antMatchers("/**/js/**").permitAll();
//		http.authorizeRequests().antMatchers("/**/images/**").permitAll();
//		http.authorizeRequests().antMatchers("/webjars/**").permitAll();
//		http.authorizeRequests().antMatchers("/**/favicon.ico").permitAll();
		 http.csrf().disable();
		http
        .authorizeRequests()
        .antMatchers("/", "/login", "/registration**", "/about**", "/home", "/emergency")
        .permitAll();
		http
		.formLogin().loginPage("/login").permitAll()
		.and()
		.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
		.and()
		.authorizeRequests().anyRequest().authenticated();
		

		
//		http.requestMatchers().
//		antMatchers("/login", "/oauth/authorize").
//		and().authorizeRequests().anyRequest()
//				.authenticated().and().formLogin().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.parentAuthenticationManager(authenticationManager).userDetailsService(customUserDetailsService);
	}
	
	@Override
	  public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/data/**");
		web.ignoring().antMatchers("/fonts/**");
		web.ignoring().antMatchers("/icons-reference/**");
		web.ignoring().antMatchers("/icons-reference/fonts/**");
        web.ignoring().antMatchers("/img/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/vendor/font-awesome/css/**");
        web.ignoring().antMatchers("/vendor/bootstrap/css/**");
        web.ignoring().antMatchers("/vendor/bootstrap/js/**");
        web.ignoring().antMatchers("/vendor/**");
	  }
}
