package com.npp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.StandardUser;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8034")
public class StandardUserController extends AbstractController<StandardUser, Long> {

}
