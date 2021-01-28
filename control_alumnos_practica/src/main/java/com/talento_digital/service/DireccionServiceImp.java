package com.talento_digital.service;

import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talento_digital.VO.DireccionVO;
import com.talento_digital.dao.DireccionDao;
import com.talento_digital.entity.Direccion;

@Service
public class DireccionServiceImp implements DireccionService {
	
	@Autowired
	DireccionDao dao;
	
	private DireccionVO direccionVo;
	private static final Logger log = LoggerFactory.getLogger(DireccionServiceImp.class);
	
	
	@Override
	@Transactional
	public DireccionVO save(Direccion direccion) {
		direccionVo = new DireccionVO("No se puede agregar el registro", "0", new ArrayList<Direccion>());
		try {
			dao.save(direccion);
			direccionVo.setLista(Arrays.asList(direccion));
			direccionVo.setMensaje(String.format("La dirección ha sido ingresada con éxito con el id  %d .", direccionVo.getLista().get(0).getIdDireccion()));
			direccionVo.setCodigo("1");
		} catch (Exception e) {
			log.error("El registro no se pudo agregar en la clase DireccionServiceImp : " + e);
		}
		return direccionVo;
	}

	@Override
	@Transactional(readOnly = true)
	public DireccionVO findAll() {
		
		direccionVo = new DireccionVO("No se puede listar los registros", "0", new ArrayList<Direccion>());
		try {
			direccionVo.setLista(dao.findAll());
			direccionVo.setMensaje(String.format("Los registros se listaron de manera exitosa, se contanilizaron %d registros", direccionVo.getLista().size()));
			direccionVo.setCodigo("1");
		} catch (Exception e) {
			log.error("El registro no se pudo listar en el metodo findAll() : " + e );
		}
		return direccionVo;
	}

}
