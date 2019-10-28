package com.npp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.npp.enumerator.UserRole;
import com.npp.ientity.IHasID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = StandardUser.class, name = "StandardUser"),
		@JsonSubTypes.Type(value = Administrator.class, name = "Administrator") })
public abstract class GenericUser implements IHasID<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected String name;

	protected String surname;

	@Column(unique = true)
	protected String username;

	@Email
	protected String email;

	protected String password;

	protected LocalDate inscriptionDate;

	protected String visaCard;

	@Enumerated(EnumType.STRING)
	protected UserRole role;

	@JsonIgnore
	@OneToMany(mappedBy = "genericUser")
	protected List<Subscription> subscriptionList;

	@JsonIgnore
	@OneToMany(mappedBy = "genericUser")
	protected List<Rental> rentalList;
}
