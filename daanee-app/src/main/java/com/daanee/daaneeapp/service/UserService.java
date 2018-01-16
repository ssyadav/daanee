package com.daanee.daaneeapp.service;

import com.daanee.daaneeapp.entity.Users;

public interface UserService {
	public Users findUserByName(String username);

	public void saveUser(Users user);
}
