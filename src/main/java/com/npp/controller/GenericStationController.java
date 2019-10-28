package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.GenericStation;
import com.npp.entity.PowerBank;
import com.npp.iservice.IGenericStationService;
import com.npp.iservice.IPowerBankService;

@RestController
@RequestMapping("/gstation")
@CrossOrigin(origins = "*")

public class GenericStationController extends AbstractController<GenericStation, Long> {

	@Autowired
	private IPowerBankService powerBankService;
	
	@Autowired
	public GenericStationController(IGenericStationService service) {
		this.service = service;
	}

	@GetMapping("/get/{id}/powerBank")
	public ResponseEntity<List<PowerBank>> getPowerBankListOfThisStation(@PathVariable("id") Long id) {
		GenericStation station = service.getById(id);
		if ( station == null )
			return new ResponseEntity<List<PowerBank>>(HttpStatus.NOT_FOUND);
		
		List<PowerBank> powerBankList = powerBankService.findByGenericStation(station);
		return new ResponseEntity<List<PowerBank>>(powerBankList,HttpStatus.OK);
	}
}
