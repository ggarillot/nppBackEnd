package com.npp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.PowerBank;

@RestController
@RequestMapping("/powerBank")
@CrossOrigin(origins = "http://localhost:8034")
public class PowerBankController extends AbstractController<PowerBank, Long>{
	
}
