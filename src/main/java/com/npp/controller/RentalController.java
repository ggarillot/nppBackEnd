package com.npp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.Rental;

@RestController
@RequestMapping("/rental")
@CrossOrigin(origins = "http://localhost:8034")
public class RentalController extends AbstractController<Rental, Long>{
	
}
