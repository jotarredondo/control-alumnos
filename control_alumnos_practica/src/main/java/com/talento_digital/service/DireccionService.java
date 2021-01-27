package com.talento_digital.service;

import com.talento_digital.VO.DireccionVO;
import com.talento_digital.entity.Direccion;

public interface DireccionService {
	
	public DireccionVO save(Direccion direccion);
	
	public DireccionVO findAll();
	
	

}
