package com.daanee.app.authserver.service;

import com.daanee.app.authserver.entity.Users;

public interface UserService {
	Users findByName(String username);
	//public void saveUser(Users user);
}
