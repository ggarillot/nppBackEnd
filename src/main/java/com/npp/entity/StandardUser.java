package com.npp.entity;

import javax.persistence.Entity;

import lombok.Builder;

@Entity
@Builder
public class StandardUser extends GenericUser {

	private static final long serialVersionUID = 1L;

}
