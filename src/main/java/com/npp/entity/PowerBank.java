package com.npp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.npp.enumerator.PowerBankStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerBank implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private PowerBankStatus status;

	private double level;

	@OneToMany(mappedBy = "powerBank")
	private List<Rental> rental;
	
	@ManyToOne 
	@JoinColumn(name = "id_genericStation", referencedColumnName = "id")
	private GenericStation genericStation;
}
