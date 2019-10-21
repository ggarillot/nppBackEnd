package com.npp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.npp.embedded.Localisation;
import com.npp.enumerator.GenericStationStatus;

import lombok.Data;

@Data
public abstract class GenericStation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Embedded
	private Localisation localisation;

	private int nSlots;

	@Enumerated
	private GenericStationStatus status;

	@OneToMany (mappedBy = "genericStation")
	private List<PowerBank> powerBank;
}
