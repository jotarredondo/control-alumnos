package com.talento_digital.controller;

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
		
		List<Direccion> lista = direccionServicio.findAll().getLista();
		
		model.addAttribute("lista", lista);
		
		return "direccion";
	}

}
