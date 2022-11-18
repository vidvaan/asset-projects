package com.createiq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.entity.Asset;
import com.createiq.entity.Lab;
import com.createiq.service.AssetService;
import com.createiq.service.RoomService;
import com.createiq.service.UserService;

@Controller
public class AssetController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	
	@Autowired
	private AssetService assetService;
	
	@GetMapping("/addAsset")
	public String addAsset(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("rooms", roomService.findAll());
		return "addAsset";
	}
	
	@PostMapping("/addAsset")
	public String addAsset(Asset asset) {
		System.out.println(asset);
		assetService.addAsset(asset);
		return "redirect:/allAssets";
	}
	
	@GetMapping("/allAssets")
	public String allLabs(Model model) {
		model.addAttribute("assets", assetService.findAll());
		return "allAssets";
	}

}
