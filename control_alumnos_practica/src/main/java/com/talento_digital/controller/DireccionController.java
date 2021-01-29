package com.talento_digital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.talento_digital.entity.Direccion;
import com.talento_digital.service.DireccionServiceImp;

@Controller
public class DireccionController {
	
	@Autowired
	private DireccionServiceImp direccionServicio;
	
	
	@GetMapping("/direcciones")
	public String direcciones(ModelMap model) {
		
		List<Direccion> direcciones = direccionServicio.findAll().getLista();
		
		List<Direccion> filtrada = new ArrayList<Direccion>();

		for (Direccion direccion : direcciones) {
			if(direccion.getAlumno() == null) {
				
				filtrada.add(direccion);
				model.addAttribute("filtrada", direcciones);
				model.addAttribute("direcciones", direcciones);
				return "direccion";
			}
			
			
			
		}
		model.addAttribute("direcciones", direcciones);
		return "direccion";
	}

}
