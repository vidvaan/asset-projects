package com.createiq.service;

import java.util.List;

import com.createiq.entity.Asset;

public interface AssetService {
	public Asset addAsset(Asset asset);
	public List<Asset> findAll();
}
