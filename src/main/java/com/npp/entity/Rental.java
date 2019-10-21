package com.npp.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rental implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDate beginDate;
	
	private LocalDate limitDate;
	
	private LocalDate endDate;
	
	private boolean wasFaulty;
	
	@ManyToOne
	@JoinColumn(name = "id_genericUser", referencedColumnName = "id")
	private GenericUser genericUser;
	
	@ManyToOne
	@JoinColumn(name = "id_powerBank", referencedColumnName = "id")
	private PowerBank powerBank;

}
