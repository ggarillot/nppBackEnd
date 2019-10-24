package com.npp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.npp.enumerator.PowerBankStatus;
import com.npp.ientity.IHasID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerBank implements IHasID<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private PowerBankStatus status;

	private double level;

	@JsonIgnore
	@OneToMany(mappedBy = "powerBank")
	private List<Rental> rentalList;

	@ManyToOne
	@JoinColumn(name = "id_genericStation", referencedColumnName = "id")
	private GenericStation genericStation;
}
