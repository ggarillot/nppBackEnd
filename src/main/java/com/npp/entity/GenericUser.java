package com.npp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.npp.enumerator.GenericUserProfile;
import com.npp.ientity.IHasID;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class GenericUser implements IHasID<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String surname;

	@Email
	@Column(unique = true)
	private String email;

	private String password;

	private LocalDate inscriptionDate;

	private String visaCard;
	
	private GenericUserProfile profile;

	@OneToMany(mappedBy = "genericUser")
	private List<Subscription> subscription;

	@OneToMany(mappedBy = "genericUser")
	private List<Rental> rental;

}
