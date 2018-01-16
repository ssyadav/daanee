package com.daanee.app.authserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmergencyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmergencyController.class);
	
	@GetMapping("/emergency")
	public String showLogin() {
//		ModelAndView mav = new ModelAndView("emergency");
//		LOGGER.info("Login");
//		if (!model.containsAttribute("user")) {
//			Emergency emergency = new Emergency();
//			mav.addObject("emergency", emergency);
//		} else
//			mav.addObject(model);
		return "emergency.html";
	}
}
