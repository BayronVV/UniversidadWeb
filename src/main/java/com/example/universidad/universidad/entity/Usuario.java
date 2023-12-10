package com.example.universidad.universidad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	private Integer id;
	
	@Column(nullable=false, length=50)
	private String nombre;
	
	@Column(nullable=false, length=50)
	private String email;
}
