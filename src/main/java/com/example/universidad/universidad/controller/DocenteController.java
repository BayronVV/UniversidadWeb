package com.example.universidad.universidad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocenteController {

	
	@GetMapping
	public String holaMundo (){
		
		return "prueba1";
	}
}
