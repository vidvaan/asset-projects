package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Asset;
import com.createiq.entity.Lab;
import com.createiq.entity.Room;
import com.createiq.repositories.AssetRepository;
import com.createiq.repositories.LabRepository;
import com.createiq.repositories.RoomRepository;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private AssetRepository assetRepository;

	@Override
	public Asset addAsset(Asset asset) {
		Room room = roomRepository.findById(asset.getRoom().getRoomId()).get();
		asset.setRoom(room);
		return assetRepository.save(asset);
	}

	@Override
	public List<Asset> findAll() {
		return assetRepository.findAll();
	}

}
