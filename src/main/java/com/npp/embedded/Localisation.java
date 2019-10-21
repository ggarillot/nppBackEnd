package com.npp.embedded;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Localisation {

	@Getter
	@Setter
	private double latitude;
	
	@Getter
	@Setter
	private double longitude;

}
