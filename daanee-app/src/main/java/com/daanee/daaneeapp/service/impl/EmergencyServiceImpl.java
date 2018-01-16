/**
 * 
 */
package com.daanee.daaneeapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daanee.daaneeapp.entity.Emergency;
import com.daanee.daaneeapp.repository.EmergencyRepository;
import com.daanee.daaneeapp.service.EmergencyService;

/**
 * @author satyaveer.yadav
 *
 */
@Service("emergencyService")
public class EmergencyServiceImpl implements EmergencyService {
	
	@Autowired
	private EmergencyRepository emergencyRepository;

	@Override
	public Emergency savePatientDetails(Emergency emergency) {
		emergencyRepository.save(emergency);
		return emergency;
		//emergencyRepository.flush();
	}

	@Override
	public Emergency findById(Integer id) {
		// TODO Auto-generated method stub
		return emergencyRepository.findById(id);
	}

}
