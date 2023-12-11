package com.example.universidad.universidad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universidad.universidad.entity.Docente;
import com.example.universidad.universidad.service.DocenteService;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

	@Autowired
	DocenteService docenteService; 
	
	@GetMapping
	public List<Docente> findDocentes (){
		
		return docenteService.findDocentes();
	}
	
	@GetMapping("/{idDocente}")
	public Docente getDocente(@PathVariable Integer idDocente ) {
		 
		 return docenteService.getDocente(idDocente);
	 }
	
@PostMapping
public Docente crearDocente(@RequestBody Docente docente) {
	
	return docenteService.createDocente(docente);
}

 @PutMapping
 public Docente actDocente(@RequestBody Docente docente) {
	 
	 return docenteService.updateDocente(docente);
 }
 
 @DeleteMapping("/{idDocente}")
 public void delteDocente(@PathVariable Integer idDocente ) {
	 
	 docenteService.deleteDocente(idDocente);
 }
 
}
