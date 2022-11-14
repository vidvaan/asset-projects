package com.createiq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.entity.Lab;
import com.createiq.service.LabService;

@Controller
public class LabController {
	@Autowired
	private LabService labService;
	@GetMapping("/addLab")
	public String addLab() {
		return "addLab";
	}
	
	@PostMapping("/addLab")
	public String addLab(Lab lab) {
		System.out.println(lab);
		labService.addLab(lab);
		return "redirect:/allLabs";
	}
	
	@GetMapping("/allLabs")
	public String allLabs(Model model) {
		model.addAttribute("labs", labService.findAll());
		return "allLabs";
	}

}
