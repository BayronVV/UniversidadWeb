package com.example.universidad.universidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universidad.universidad.entity.Materia;
import com.example.universidad.universidad.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	@Autowired

	@Override
	public List<Materia> findDocentes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materia createMateria(Materia materia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materia updateMateria(Materia materia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMateria(Integer idMateria) {
		// TODO Auto-generated method stub
		
	}

}
