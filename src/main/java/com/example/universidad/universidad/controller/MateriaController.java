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

import com.example.universidad.universidad.dto.MateriaDTO;
import com.example.universidad.universidad.entity.Materia;
import com.example.universidad.universidad.service.MateriaService;


@RestController
@RequestMapping("/materias")
public class MateriaController {
	
	
	@Autowired
    MateriaService materiaService;
	
	@GetMapping
public List<Materia> findMaterias (){
		
		return materiaService.findMaterias();
	}
	
	@PostMapping
	public Materia crearMateria(@RequestBody MateriaDTO materia) {
		
		return materiaService.createMateria(materia);
	}
	
	
	@PutMapping
	 public Materia actMateria(@RequestBody Materia materia) {
		 
		return materiaService.updateMateria(materia);
	 }
	 
	 @DeleteMapping("/{idMateria}")
	 public void delteMateria(@PathVariable Integer idMateria ) {
		 
		 materiaService.deleteMateria(idMateria);
	 }
}
