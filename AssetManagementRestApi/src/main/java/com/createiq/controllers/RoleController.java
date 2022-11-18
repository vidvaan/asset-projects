package com.createiq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.entity.Role;
import com.createiq.model.RoleModel;
import com.createiq.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> findAll() {
		List<Role> roles = roleService.findAll();
		if (roles.isEmpty()) {
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<Role> findById(@PathVariable Long roleId) {
		Role role = roleService.findById(roleId);
		if (role == null) {
			return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Role> add(@RequestBody RoleModel roleModel) {
		Role role = new Role();
		role.setRoleName(roleModel.getRoleName());
		Role roleObj = roleService.add(role);
		return new ResponseEntity<Role>(roleObj, HttpStatus.OK);
	}
	
	@PutMapping("/{roleId}")
	public ResponseEntity<Role> update(@RequestBody RoleModel roleModel,@PathVariable Long roleId) {
		Role role = roleService.findById(roleId);
		role.setRoleName(roleModel.getRoleName());
		roleService.add(role);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
	
	@DeleteMapping("/{roleId}")
	public ResponseEntity<?> delete(@PathVariable Long roleId) {
		roleService.deleteById(roleId);
		return new ResponseEntity("deleted", HttpStatus.OK);
	}

}
