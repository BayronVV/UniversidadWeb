package com.example.universidad.universidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universidad.universidad.entity.Materia;
import com.example.universidad.universidad.repository.MateriaRespository;
import com.example.universidad.universidad.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	@Autowired
    MateriaRespository materiaRepository;
	@Override
	public List<Materia> findMaterias() {
		// TODO Auto-generated method stub
		return materiaRepository.findAll();
	}

	@Override
	public Materia createMateria(Materia materia) {
		// TODO Auto-generated method stub
		Materia materiaCrear = new Materia();
		materiaCrear.setNombre(materia.getNombre());
		materiaCrear.setCreditos(materia.getCreditos());
		materiaCrear.setDocente(materia.getDocente());
		return materiaRepository.save(materiaCrear);
	}

	@Override
	public Materia updateMateria(Materia materia) {
		// TODO Auto-generated method stub
		Materia materiaActualizar = materiaRepository.findById(materia.getId())
				.orElseThrow();
		materiaActualizar.setNombre(materia.getNombre());
		materiaActualizar.setCreditos(materia.getCreditos());
		materiaActualizar.setDocente(materia.getDocente());
	  
		return materiaRepository.save(materiaActualizar); 
	}

	@Override
	public void deleteMateria(Integer idMateria) {
		// TODO Auto-generated method stub
		materiaRepository.deleteById(idMateria);
		
	}

}
