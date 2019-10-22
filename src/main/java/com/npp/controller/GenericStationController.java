package com.npp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.GenericStation;

@RestController
@RequestMapping("/gstation")
@CrossOrigin(origins = "http://localhost:8034")
public class GenericStationController extends AbstractController<GenericStation, Long> {

}
