/**
 * 
 */
package com.daanee.app.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author satyaveer.yadav
 *
 */
@Configuration
public class MvcConfiguration  extends WebMvcConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}
	
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        
//		if (!registry.hasMappingForPattern("/resources/**")) {
//            registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
//         }
//        if (!registry.hasMappingForPattern("/ui/vendor/**")) {
//        	registry.addResourceHandler("/ui/vendor/**").addResourceLocations("classpath:/resources/static/vendor/");
//        }
//        if (!registry.hasMappingForPattern("/ui/js/**")) {
//        	registry.addResourceHandler("/ui/js/**").addResourceLocations("classpath:/resources/static/js/");
//        }
//        if (!registry.hasMappingForPattern("/ui/fonts/**")) {
//        	registry.addResourceHandler("/ui/fonts/**").addResourceLocations("classpath:/resources/static/fonts/");
//        }
//        if (!registry.hasMappingForPattern("/ui/data/**")) {
//        	registry.addResourceHandler("/ui/data/**").addResourceLocations("classpath:/resources/static/data/");
//        }
//        if (!registry.hasMappingForPattern("/ui/css/**")) {
//        	registry.addResourceHandler("/ui/css/**").addResourceLocations("classpath:/resources/static/css/");
//        }
//    }
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/","classpath:/resources/vendor/bootstrap/css/",
            "classpath:/resources/vendor/bootstrap/js/" ,"classpath:/resources/static/vendor/bootstrap/css/", 
            "classpath:/resources/static/vendor/bootstrap/js/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
