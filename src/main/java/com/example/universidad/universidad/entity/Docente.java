package com.example.universidad.universidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "docentes")
@Entity
public class Docente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String nombre;
	 private String apellido;
	 private String direccion;
	 
	 

}
