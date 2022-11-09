package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Lab;
import com.createiq.entity.Room;
import com.createiq.repositories.LabRepository;
import com.createiq.repositories.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private LabRepository labRepository;

	@Override
	public Room addRoom(Room room) {
		Lab  lab = labRepository.findById(room.getLab().getLabId()).get();
		room.setLab(lab);
		return roomRepository.save(room);
	}

	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

}
