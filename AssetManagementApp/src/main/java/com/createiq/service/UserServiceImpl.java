package com.createiq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Role;
import com.createiq.entity.UserDetails;
import com.createiq.repositories.RoleRepository;
import com.createiq.repositories.UserDetailsRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	@Autowired
	private  RoleRepository roleRepository;

	@Override
	public UserDetails addUser(UserDetails user) {
			//List<Long> roleIds =     user.getRoles().stream().map(Role::getRoleId).toList();
			List<Role> roles = new ArrayList<>();
			user.getRoleIds().forEach(roleId ->  roles.add(roleRepository.findById(roleId).get()));
		    user.setRoles(roles);
		return userDetailsRepository.save(user);
	}

	@Override
	public List<UserDetails> findAll() {
		return userDetailsRepository.findAll();
	}

}
