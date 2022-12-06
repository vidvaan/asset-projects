package com.createiq.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetRequestFlow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flowId;
	private String reuestType;
	private String step;
	private String status;
	private String actionTakenBy;
	private Timestamp actionTakenOn;
	private String requestId;
	
	
	

}
