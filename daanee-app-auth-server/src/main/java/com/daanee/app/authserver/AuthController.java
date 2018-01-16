/**
 * 
 */
package com.daanee.app.authserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author satyaveer.yadav
 *
 */

@RestController
@RequestMapping("/rest/auth")
public class AuthController {

	@GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }
    @GetMapping
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
}
