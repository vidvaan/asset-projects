package com.createiq.service;

import java.util.List;

import com.createiq.entity.Role;

public interface RoleService {
	public Role addRole(Role role);
	public List<Role> findAll();
	public Role findById(Long roleId);
	public Role add(Role role);
	public void deleteById(Long roleId);
}
