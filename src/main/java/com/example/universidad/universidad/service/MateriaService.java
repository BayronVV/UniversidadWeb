package com.example.universidad.universidad.service;

import java.util.List;

import com.example.universidad.universidad.entity.Materia;

public interface MateriaService {
	
    List<Materia>findDocentes();
	
    Materia createMateria(Materia materia);
    Materia updateMateria(Materia materia);
	void deleteMateria(Integer idMateria);

}
