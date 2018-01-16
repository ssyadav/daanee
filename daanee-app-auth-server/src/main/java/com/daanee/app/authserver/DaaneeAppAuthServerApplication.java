/**
 * 
 */
package com.daanee.app.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author satyaveer.yadav
 *
 */
//@EnableEurekaClient
@SpringBootApplication
@EnableAuthorizationServer
public class DaaneeAppAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaaneeAppAuthServerApplication.class, args);
	}

}
