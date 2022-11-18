package com.createiq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.entity.Role;
import com.createiq.entity.UserInfo;
import com.createiq.service.RoleService;
import com.createiq.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	@GetMapping("/addUser")
	public String addLab(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "addUser";
	}
	
	@PostMapping("/addUser")
	public String addUser(UserInfo userDetails) {
		System.out.println("User Details : "+userDetails);
		 userService.addUser(userDetails);
		return "redirect:allUsers";
	}
	
	@GetMapping("/allUsers")
	public String allRoles(Model model) {
		model.addAttribute("users", userService.findAll());
		return "allUsers";
	}

}
