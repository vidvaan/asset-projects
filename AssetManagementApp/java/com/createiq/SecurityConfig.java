package com.createiq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
//	@Bean
//	protected InMemoryUserDetailsManager configAuthentication() {
//
//		List<UserDetails> users = new ArrayList<>();
//		List<GrantedAuthority> adminAuthority = new ArrayList<>();
//		adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
//		UserDetails admin = new User("devs", "{noop}devs", adminAuthority);
//		users.add(admin);
//
//		List<GrantedAuthority> employeeAuthority = new ArrayList<>();
//		employeeAuthority.add(new SimpleGrantedAuthority("EMPLOYEE"));
//		UserDetails employee = new User("ns", "{noop}ns", employeeAuthority);
//		users.add(employee);
//
//		List<GrantedAuthority> managerAuthority = new ArrayList<>();
//		managerAuthority.add(new SimpleGrantedAuthority("MANAGER"));
//		UserDetails manager = new User("vs", "{noop}vs", managerAuthority);
//		users.add(manager);
//
//		return new InMemoryUserDetailsManager(users);
//	}
	
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(passwordEncoder)
	      .and()
	      .build();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// declares which Page(URL) will have What access type
		http.authorizeRequests().antMatchers("/home").permitAll().antMatchers("/index").authenticated()
				.antMatchers("/admin").hasAuthority("ADMIN").antMatchers("/emp").hasAuthority("EMPLOYEE")
				.antMatchers("/mgr").hasAuthority("MANAGER").antMatchers("/common")
				.hasAnyAuthority("EMPLOYEE", "MANAGER")

				// Any other URLs which are not configured in above antMatchers
				// generally declared aunthenticated() in real time
				.anyRequest().authenticated()

				// Login Form Details
				.and().formLogin().defaultSuccessUrl("/index", true)
				
				// Exception Details
				//.and().exceptionHandling().accessDeniedPage("/accessDenied")

				// Logout Form Details
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

				// Exception Details
				//.and().exceptionHandling().accessDeniedPage("/accessDenied");
		return http.build();
	}

}
