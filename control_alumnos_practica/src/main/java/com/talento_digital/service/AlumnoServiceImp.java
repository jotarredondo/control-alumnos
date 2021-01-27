package com.talento_digital.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talento_digital.VO.AlumnoVO;
import com.talento_digital.dao.AlumnoDao;
import com.talento_digital.entity.Alumno;
import com.talento_digital.entity.Direccion;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	AlumnoDao dao;

	private AlumnoVO alumno;
	private static final Logger log = LoggerFactory.getLogger(AlumnoServiceImp.class);
	
	
	@Override
	public AlumnoVO save(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoVO findAll() {
			
		alumno = new AlumnoVO("No se puede listar los registros", "0", new ArrayList<Alumno>());
		try {
			alumno.setLista(dao.findAll());
			alumno.setMensaje(String.format("Los registros se listaron de manera exitosa, se contanilizaron %d registros", alumno.getLista().size()));
			alumno.setCodigo("1");
		} catch (Exception e) {
			log.error("El registro no se pudo listar en el metodo findAll() : " + e );
		}
		return alumno;
	}

	@Override
	public AlumnoVO findByid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoVO agregarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		return null;
	}

}
