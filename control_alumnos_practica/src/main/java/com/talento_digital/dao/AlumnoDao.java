package com.talento_digital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.talento_digital.entity.Alumno;

public interface AlumnoDao extends JpaRepository<Alumno, Integer> {

}
