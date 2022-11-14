package com.createiq.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.createiq.entity.UserInfo;
import com.createiq.model.UserPrincipal;
import com.createiq.repositories.UserDetailsRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDetailsRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userEntity = userRepository.findByUsername(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new UserPrincipal(userEntity);
	}

}
