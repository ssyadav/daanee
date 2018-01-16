package com.daanee.daaneeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daanee.daaneeapp.entity.Users;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {
	 Users findByEmail(String email);
	 Users findByName(String name);
}
