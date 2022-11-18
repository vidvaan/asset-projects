package com.createiq.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long labId;
	 private String  labName;
	 private String location;
	 private String address;
	 @OneToMany(mappedBy = "lab")
	 private List<Room> rooms;

}
