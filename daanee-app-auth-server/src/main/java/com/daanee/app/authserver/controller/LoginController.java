package com.daanee.app.authserver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daanee.app.authserver.entity.Users;
import com.daanee.app.authserver.service.UserService;

@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(Model model) {
		ModelAndView mav = new ModelAndView("login");
		logger.info("Login");
		if (!model.containsAttribute("user")) {
			Users user = new Users();
			mav.addObject("user", user);
		} else
			mav.addObject(model);
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPeople(@Valid @ModelAttribute("user") Users user, BindingResult result, RedirectAttributes attr,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			if (result.getFieldErrors().toString().contains("userName")
					|| result.getFieldErrors().toString().contains("password")) {
				attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
				attr.addFlashAttribute("user", user);
				return "redirect:/login";
			}
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users user1 = userService.findByName(auth.getName());
		if (null != user1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", user.getName());
			return "redirect:/home";
		} else {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			attr.addFlashAttribute("user", user);
			attr.addFlashAttribute("error", "user not found");
			return "redirect:/login";
		}
	}

}
