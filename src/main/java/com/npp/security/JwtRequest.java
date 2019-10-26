package com.npp.security;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;

}
