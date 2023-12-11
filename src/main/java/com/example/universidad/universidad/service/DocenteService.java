package com.example.universidad.universidad.service;

import java.util.List;

import com.example.universidad.universidad.entity.Docente;

public interface DocenteService {
	
	List<Docente>findDocentes();
	Docente getDocente(Integer idDocente);
	Docente createDocente(Docente docente);
	Docente updateDocente(Docente docente);
	void deleteDocente(Integer idDocente);
	
}
