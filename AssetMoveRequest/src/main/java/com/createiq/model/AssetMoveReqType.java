package com.createiq.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetMoveReqType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reqtypeId;
	private String requestType;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "requesttype_approval", joinColumns = { @JoinColumn(name = "reqtypeId") }, inverseJoinColumns = {
			@JoinColumn(name = "approvalId") })
	private List<AssetMoveReqApproval> assetMoveReqApproval;
	

}
