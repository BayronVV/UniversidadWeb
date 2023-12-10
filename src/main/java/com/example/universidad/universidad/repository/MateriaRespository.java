package com.example.universidad.universidad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import com.example.universidad.universidad.entity.Materia;

public interface MateriaRespository extends JpaRepository <Materia, Integer> {

}
