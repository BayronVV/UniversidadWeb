package com.example.universidad.universidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universidad.universidad.entity.Docente;
import com.example.universidad.universidad.repository.DocenteRepository;
import com.example.universidad.universidad.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {
	
	@Autowired
	DocenteRepository docenteRepository;

	@Override
	public List<Docente> findDocentes() {
		// TODO Auto-generated method stub
		return docenteRepository.findAll();
	}

	@Override
	public Docente createDocente(Docente docente) {
		// TODO Auto-generated method stub
		Docente docenteCrear = new Docente();
		docenteCrear.setNombre(docente.getNombre());
		docenteCrear.setApellido(docente.getApellido());
		docenteCrear.setDireccion(docente.getDireccion());
		
		
		return docenteRepository.save(docenteCrear);
	}

	@Override
	public Docente updateDocente(Docente docente) {
		// TODO Auto-generated method stub
		Docente docenteActualizar = docenteRepository.findById(docente.getId())
				.orElseThrow();
		docenteActualizar.setNombre(docente.getNombre());
		docenteActualizar.setApellido(docente.getApellido());
		docenteActualizar.setDireccion(docente.getDireccion());
		
		
		return docenteRepository.save(docenteActualizar);
	}

	@Override
	public void deleteDocente(Integer idDocente) {
		// TODO Auto-generated method stub
		docenteRepository.deleteById(idDocente);
		
	}

}
