package com.example.universidad.universidad.dto;

import com.example.universidad.universidad.entity.Docente;
import com.example.universidad.universidad.entity.Materia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MateriaDTO {
	
	private Integer id;
	private String nombre;
	private Integer creditos;
	private Integer docente;


}
