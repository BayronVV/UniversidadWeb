package com.example.universidad.universidad.service;

import java.util.List;

import com.example.universidad.universidad.entity.Docente;

public interface DocenteService {
	
	List<Docente>findDocentes();
	
	Docente createDocente(Docente docente);
	Docente updateDocente(Docente docente);
	void deleteDocente(Integer idDocente);
	
}
