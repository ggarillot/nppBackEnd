package com.npp.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.npp.embedded.Localisation;
import com.npp.enumerator.GenericStationStatus;
import com.npp.ientity.IHasID;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class GenericStation implements IHasID<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private Localisation localisation;

	private int nSlots;

	@Enumerated
	private GenericStationStatus status;

	@OneToMany(mappedBy = "genericStation")
	private List<PowerBank> powerBank;
}
