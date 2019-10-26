package com.npp.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.npp.dto.UserDto;
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
//		if ("a".equals(username)) {
//			return new User("a", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}

		GenericUser user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());

	}

	public GenericUser save(UserDto user) {
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
}
