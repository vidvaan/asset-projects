package com.createiq;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.createiq.entity.Role;
import com.createiq.entity.UserInfo;
import com.createiq.repositories.UserDetailsRepository;

@SpringBootApplication
public class AssetManagementAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementAppApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder byCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public void run(String... args) throws Exception {

		Role role1 = new Role();
		role1.setRoleName("ADMIN");

		UserInfo userInfo = new UserInfo();
		userInfo.setDepartment("IT");
		userInfo.setEmail("admin@gmail.com");
		userInfo.setFname("Balaji");
		userInfo.setLname("G");
		userInfo.setPassword(byCryptPasswordEncoder().encode("balaji"));
		userInfo.setUsername("balaji");
		userInfo.setPhone("9959096502");
		userInfo.setIsActive(true);
		userInfo.setRoles(Arrays.asList(new Role[] { role1 }));

		//userDetailsRepository.save(userInfo);

	}

}
