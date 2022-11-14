package com.createiq.service;

import java.util.List;

import com.createiq.entity.Lab;
import com.createiq.entity.Room;

public interface RoomService {
	public Room addRoom(Room room);
	public List<Room> findAll();
}
