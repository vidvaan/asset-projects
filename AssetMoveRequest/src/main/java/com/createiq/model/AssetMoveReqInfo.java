package com.createiq.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetMoveReqInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestId;
	private String createdBy;
	private Timestamp createdDate;
	private String status;
	private String currentStep;
	private String assignedTo;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "reqtypeId")
	private AssetMoveReqType assetMoveReqType;
	
	
	
	
	
		

}
