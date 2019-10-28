package com.npp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.npp.dto.UserDto;
import com.npp.entity.Administrator;
import com.npp.entity.GenericUser;
import com.npp.entity.StandardUser;
import com.npp.enumerator.UserRole;
import com.npp.repository.IGenericUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private IGenericUserRepository repository;

	@Autowired
	private PasswordEncoder bCryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		GenericUser user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		return new User(user.getUsername(), user.getPassword(), authorities);
//		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());

	}

	public GenericUser saveUser(UserDto user) {
		GenericUser newUser = new StandardUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bCryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setInscriptionDate(LocalDate.now());
		newUser.setRole(UserRole.USER);
		return repository.save(newUser);
	}
	
	public GenericUser saveAdmin(UserDto user) {
		GenericUser newUser = new Administrator();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bCryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setInscriptionDate(LocalDate.now());
		newUser.setRole(UserRole.ADMIN);
		return repository.save(newUser);
	}
}
