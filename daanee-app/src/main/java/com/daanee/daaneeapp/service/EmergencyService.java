package com.daanee.daaneeapp.service;

import com.daanee.daaneeapp.entity.Emergency;

public interface EmergencyService {
	
	public Emergency savePatientDetails(Emergency emergency);

	public Emergency findById(Integer id);

}
