package com.createiq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.entity.Lab;
import com.createiq.entity.Room;
import com.createiq.service.LabService;
import com.createiq.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private LabService labService;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/addRoom")
	public String addRoom(Model model) {
		model.addAttribute("labs", labService.findAll());
		return "addRoom";
	}
	
	@PostMapping("/addRoom")
	public String addLab(Room room) {
		System.out.println(room);
		roomService.addRoom(room);
		return "redirect:/allRooms";
	}
	
	@GetMapping("/allRooms")
	public String allLabs(Model model) {
		model.addAttribute("rooms", roomService.findAll());
		return "allRooms";
	}

}
