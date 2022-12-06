package com.createiq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.model.AssetMoveReqType;
import com.createiq.repo.AssetMoveReqTypeRepository;

@RestController
public class AssetRequestTypeController {
	
	@Autowired
	private AssetMoveReqTypeRepository assetMoveReqTypeRepository;
	
	@PostMapping("/assetMoveReqType")
	public ResponseEntity<AssetMoveReqType> createTutorial(@RequestBody AssetMoveReqType assetMoveReqType) {
		try {
			AssetMoveReqType _assAssetMoveReqType = assetMoveReqTypeRepository.save(assetMoveReqType);
			return new ResponseEntity<>(_assAssetMoveReqType, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/assetMoveReqTypes")
	public ResponseEntity<List<AssetMoveReqType>> findAll(@RequestParam(defaultValue = "") String reuestType) {
		List<AssetMoveReqType> assetMoveReqTypes = new ArrayList<>();
		try {
			if ("".equals(reuestType)) {
				assetMoveReqTypeRepository.findAll().forEach(assetMoveReqTypes::add);
			} else {
//				assetMoveReqTypeRepository.findByTitleContaining(title).forEach(tutorials::add);
			}

			if (assetMoveReqTypes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(assetMoveReqTypes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
