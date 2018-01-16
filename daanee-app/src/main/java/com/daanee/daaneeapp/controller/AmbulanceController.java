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

import com.daanee.daaneeapp.entity.Ambulance;

@RestController
public class AmbulanceController {
	
	@Autowired
	private AmbulanceService ambulanceService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AmbulanceController.class);
	
	@GetMapping("/ambulance")
	public ModelAndView showEmergencyPage(Model model) {
		ModelAndView mav = new ModelAndView("ambulance/ambulance");
		LOGGER.info("showAmbulancePage");
		if (!model.containsAttribute("ambulance")) {
			Ambulance ambulance = new Ambulance();
			mav.addObject("ambulance", ambulance);
		} else
			mav.addObject(model);
		return mav;
	}
	
	@PostMapping("/ambulance")
	public ModelAndView saveEmergencyDetails(Ambulance ambulance, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView();
		Ambulance savedDetails = ambulanceService.saveAmbulanceDetails(ambulance);
		//modelAndView.addObject("emergency", saveDetails);
		redirectAttrs.addFlashAttribute(savedDetails);
		redirectAttrs.addAttribute("ambulance", savedDetails);
		modelAndView.setViewName("redirect:ambulancesuccess");
		return modelAndView;
	}
	
	@GetMapping("/ambulancesuccess")
	public ModelAndView showEmergencySuccess(Ambulance ambulance) {
		ModelAndView modelAndView = new ModelAndView();
//		Integer id = Integer.parseInt(emergency);
//		Emergency emergencyq = emergencyService.findById(id);
		modelAndView.addObject("ambulance", ambulance);
		modelAndView.setViewName("ambulance/ambulancesuccess");
		return modelAndView;
	}
}
