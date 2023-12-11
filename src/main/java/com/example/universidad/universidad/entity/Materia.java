package com.example.universidad.universidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "materias")
@Entity
public class Materia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
    private String nombre;
    private Integer creditos;
    @OneToOne
    @JoinColumn(name="docente_id")
    private Docente docente;

}
