package com.talento_digital.service;

import com.talento_digital.VO.AlumnoVO;
import com.talento_digital.entity.Alumno;
import com.talento_digital.entity.Direccion;

public interface AlumnoService {

	public AlumnoVO save (Alumno alumno);
	
	public AlumnoVO findAll();
	
	public AlumnoVO findByid(Integer id);
	
	public AlumnoVO agregarDireccion(Direccion direccion);
	
}
