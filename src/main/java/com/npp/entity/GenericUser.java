package com.npp.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
public abstract class GenericUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String surname;

	@Email
	private String email;

	private String password;

	private LocalDate inscriptionDate;

	private String visaCard;

	@OneToMany(mappedBy = "genericUser")
	private List<Subscription> subscription;

	@OneToMany(mappedBy = "genericUser")
	private List<Rental> rental;
}
