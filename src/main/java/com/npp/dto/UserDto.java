package com.npp.dto;

import java.time.LocalDate;

import com.npp.enumerator.UserRole;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private LocalDate inscriptionDate;
	private UserRole role;
	
	
	
}
