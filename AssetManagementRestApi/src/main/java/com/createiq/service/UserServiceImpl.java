package com.createiq.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Role;
import com.createiq.entity.UserInfo;
import com.createiq.repositories.RoleRepository;
import com.createiq.repositories.UserDetailsRepository;
import com.createiq.util.MailSendUtil;
import com.createiq.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private PasswordUtil passwordUtil;

	@Autowired
	private MailSendUtil mailSendUtil;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	//@Transactional
	public UserInfo addUser(UserInfo user) {
		// List<Long> roleIds = user.getRoles().stream().map(Role::getRoleId).toList();
		try {
			List<Role> roles = new ArrayList<>();
			user.getRoleIds().forEach(roleId -> roles.add(roleRepository.findById(roleId).get()));
			user.setRoles(roles);

			String password = passwordUtil.generateSecurePassword();
			System.out.println(password);
			user.setPassword(password);
			UserInfo userInfo = userDetailsRepository.save(user);
			throw new RuntimeException();
			// mailSendUtil.sendSimpleMail(userInfo.getEmail(), "User Password Deatils",
			// password);
			// return userInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<UserInfo> findAll() {
		return userDetailsRepository.findAll();
	}

}
