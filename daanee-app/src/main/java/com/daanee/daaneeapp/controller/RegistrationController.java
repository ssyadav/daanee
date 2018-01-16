package com.daanee.daaneeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daanee.daaneeapp.entity.Users;
import com.daanee.daaneeapp.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Users user = new Users();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@PostMapping(value="/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView createNewUser(@RequestBody Users user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Users userExists = userService.findUserByName(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			//modelAndView.addObject("user", new Users());
			
//			redirectAttrs.addFlashAttribute(user);
//			redirectAttrs.addAttribute("user", user);
			modelAndView.setViewName("redirect:login");
			//modelAndView.setViewName("/auth/login");
			
		}
		return modelAndView;
	}

}
