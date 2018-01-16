package com.daanee.daaneeapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daanee.daaneeapp.entity.Emergency;
import com.daanee.daaneeapp.service.EmergencyService;

@RestController
public class EmergencyController {
	
	@Autowired
	private EmergencyService emergencyService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmergencyController.class);
	
	@GetMapping("/emergency")
	public ModelAndView showEmergencyPage(Model model) {
		ModelAndView mav = new ModelAndView("emergency/emergency");
		LOGGER.info("showEmergencyPage");
		if (!model.containsAttribute("emergency")) {
			Emergency emergency = new Emergency();
			mav.addObject("emergency", emergency);
		} else
			mav.addObject(model);
		return mav;
	}
	
	@PostMapping("/emergency")
	public ModelAndView saveEmergencyDetails(Emergency emergency, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView();
		Emergency saveDetails = emergencyService.savePatientDetails(emergency);
		//modelAndView.addObject("emergency", saveDetails);
		redirectAttrs.addFlashAttribute(saveDetails);
		redirectAttrs.addAttribute("emergency", saveDetails);
		modelAndView.setViewName("redirect:emergencysuccess");
		return modelAndView;
	}
	
	@GetMapping("/emergencysuccess")
	public ModelAndView showEmergencySuccess(Emergency emergency) {
		ModelAndView modelAndView = new ModelAndView();
//		Integer id = Integer.parseInt(emergency);
//		Emergency emergencyq = emergencyService.findById(id);
		modelAndView.addObject("emergency", emergency);
		modelAndView.setViewName("emergency/emergencysuccess");
		return modelAndView;
	}
}
