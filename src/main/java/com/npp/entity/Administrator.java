package com.npp.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
public class Administrator extends GenericUser {

	private static final long serialVersionUID = 1L;

}
