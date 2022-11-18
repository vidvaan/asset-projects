package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Role;
import com.createiq.model.RoleModel;
import com.createiq.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long roleId) {
		return roleRepository.findById(roleId).get();
	}

	@Override
	public Role add(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteById(Long roleId) {
		roleRepository.deleteById(roleId);
	}
	
	  
	
}
