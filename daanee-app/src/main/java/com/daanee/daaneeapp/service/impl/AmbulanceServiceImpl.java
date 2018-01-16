/**
 * 
 */
package com.daanee.daaneeapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daanee.daaneeapp.controller.AmbulanceService;
import com.daanee.daaneeapp.entity.Ambulance;
import com.daanee.daaneeapp.repository.AmbulanceRepository;

/**
 * @author satyaveer.yadav
 *
 */
@Service("ambulanceService")
public class AmbulanceServiceImpl implements AmbulanceService {

	@Autowired
	private AmbulanceRepository ambulanceRepository;
	
	
	@Override
	public Ambulance saveAmbulanceDetails(Ambulance ambulance) {
		// TODO Auto-generated method stub
		return ambulanceRepository.save(ambulance);
	}

}
