package com.createiq.service;

import java.util.List;

import com.createiq.entity.UserDetails;

public interface UserService {

	public UserDetails addUser(UserDetails user);
	public List<UserDetails> findAll();

}
