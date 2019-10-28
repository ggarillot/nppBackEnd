package com.npp.security;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Builder
public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	private final String jwtToken;

}
