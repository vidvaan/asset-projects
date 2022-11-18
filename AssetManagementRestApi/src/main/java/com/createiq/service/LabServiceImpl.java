package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Lab;
import com.createiq.repositories.LabRepository;

@Service
public class LabServiceImpl implements LabService {
	@Autowired
	private LabRepository labRepository;

	@Override
	public Lab addLab(Lab lab) {
		return labRepository.save(lab);
	}

	@Override
	public List<Lab> findAll() {
		return labRepository.findAll();
	}

}
