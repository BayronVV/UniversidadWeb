package com.example.universidad.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.universidad.universidad.entity.Docente;

public interface DocenteRepository extends JpaRepository <Docente, Integer>{

}
