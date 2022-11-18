package com.createiq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>{

}
