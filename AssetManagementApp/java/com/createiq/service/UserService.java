package com.createiq.service;

import java.util.List;

import com.createiq.entity.UserInfo;

public interface UserService {

	public UserInfo addUser(UserInfo user);
	public List<UserInfo> findAll();

}
