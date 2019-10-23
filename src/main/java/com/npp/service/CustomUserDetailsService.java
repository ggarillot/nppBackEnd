package com.npp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npp.entity.GenericUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private GenericUserService service;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		GenericUser user = service.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities (GenericUser user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getProfile())); // One User has only one ROLE - USER or ADMIN
		return authorities;
	}
			
	
	

}
