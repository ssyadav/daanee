package com.daanee.daaneeapp.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class OauthConfig extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//    	http.authorizeRequests().antMatchers("/**/css/**").permitAll();
//		http.authorizeRequests().antMatchers("/**/js/**").permitAll();
//		http.authorizeRequests().antMatchers("/**/images/**").permitAll();
//		http.authorizeRequests().antMatchers("/webjars/**").permitAll();
//		http.authorizeRequests().antMatchers("/**/favicon.ico").permitAll();
    	http.csrf().disable();
        http
        .authorizeRequests()
        .antMatchers("/", "/registration**", "/about**", "/home", "/content", "/emergency", "/emergencysuccess",
        		"/ambulance", "/ambulancesuccess")
        .permitAll()
        .anyRequest()
        .authenticated();
//        http.authorizeRequests().antMatchers("/resource/static/css/**").permitAll().anyRequest().permitAll();
//        http.authorizeRequests().antMatchers("/resource/static/vendor/bootstrap/css/**").permitAll().anyRequest().permitAll();
//        http.authorizeRequests().antMatchers("/resource/static/vendor/bootstrap/js/**").permitAll().anyRequest().permitAll();
//        http.authorizeRequests().antMatchers("/resource/static/img/**").permitAll().anyRequest().permitAll();

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
