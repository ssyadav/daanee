package com.daanee.app.authserver.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.daanee.app.authserver.entity.Users;
import com.daanee.app.authserver.repository.UsersRepository;
import com.daanee.app.authserver.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepository;
//	@Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Users findByName(String username) {
		Optional<Users> users = userRepository.findByName(username);
		return users.get();
	}

//	@Override
//	public void saveUser(Users user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(1);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//		userRepository.save(user);
//	}

}
