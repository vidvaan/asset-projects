package com.createiq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
