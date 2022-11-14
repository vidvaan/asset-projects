package com.createiq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.createiq.entity.UserInfo;

public interface UserDetailsRepository extends JpaRepository<UserInfo, Long>{

	@Query("SELECT u from UserInfo u inner join fetch u.roles where u.username = ?1")
	UserInfo findByUsername(String username);

}
