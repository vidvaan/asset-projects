package com.createiq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.entity.Role;
import com.createiq.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@GetMapping("/addRole")
	public String addLab() {
		return "addRole";
	}
	
	@PostMapping("/addRole")
	public String addLab(Role role) {
		roleService.addRole(role);
		return "redirect:allRoles";
	}
	
	@GetMapping("/allRoles")
	public String allRoles(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "allRoles";
	}

}
