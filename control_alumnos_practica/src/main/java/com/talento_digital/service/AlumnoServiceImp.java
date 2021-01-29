package com.talento_digital.service;

import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.talento_digital.VO.AlumnoVO;
import com.talento_digital.VO.DireccionVO;
import com.talento_digital.dao.AlumnoDao;
import com.talento_digital.entity.Alumno;
import com.talento_digital.entity.Direccion;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	AlumnoDao dao;

	private AlumnoVO alumnoVo;
	private static final Logger log = LoggerFactory.getLogger(AlumnoServiceImp.class);
	
	@Override
	@Transactional
	public AlumnoVO save(Alumno alumno) {
		
		alumnoVo = new AlumnoVO("No se puede agregar los registros", "0", new ArrayList<Alumno>());
		try {
			dao.save(alumno);
			alumnoVo.setLista(Arrays.asList(alumno));
			alumnoVo.setMensaje(String.format("La alumno ha sido ingresada con éxito con el id  %d .", alumnoVo.getLista().get(0).getIdAlumno()));
			alumnoVo.setCodigo("1");
		} catch (Exception e) {
			log.error("El registro no se pudo agregar en la clase AlumnoServiceImp : " + e);
		}
		
		return alumnoVo;
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoVO findAll() {
			
		alumnoVo = new AlumnoVO("No se puede listar los registros", "0", new ArrayList<Alumno>());
		try {
			alumnoVo.setLista(dao.findAll());
			alumnoVo.setMensaje(String.format("Los registros se listaron de manera exitosa, se contanilizaron %d registros", alumnoVo.getLista().size()));
			alumnoVo.setCodigo("1");
		} catch (Exception e) {
			log.error("El registro no se pudo listar en el metodo findAll() : " + e );
		}
		return alumnoVo;
	}

	@Override
	@Transactional
	public AlumnoVO agregarDireccion(Integer id, Direccion direccion) {
		alumnoVo = new AlumnoVO("No se puede agregar la direccion", "0",new ArrayList<Alumno>());
		try {
			Alumno temp = dao.findById(id).get();
			temp.setDireccion(direccion);
			alumnoVo.setLista(Arrays.asList(dao.save(temp)));
			alumnoVo.setMensaje(String.format("Se agrego correctamente la dirección al registro %d", temp.getIdAlumno()));
			alumnoVo.setCodigo("1");
		} catch (Exception e) {
			log.error("La direccion no se pudo agregar al registro en el metodo agregarDireccion() : " + e );
		}
		return alumnoVo;
	}

}
