package com.createiq.service;

import java.util.List;

import com.createiq.entity.Lab;

public interface LabService {
	public Lab addLab(Lab lab);
	public List<Lab> findAll();

}
