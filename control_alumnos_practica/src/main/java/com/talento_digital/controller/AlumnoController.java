package com.talento_digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.talento_digital.entity.Alumno;
import com.talento_digital.service.AlumnoServiceImp;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoServiceImp servicio;
	
	
	@GetMapping("/")
	public String index(ModelMap model) {
		
		
		
		return "index";
	}
	
	@GetMapping("/alumnos")
	public String alumnos(ModelMap model) {
		List<Alumno> lista = servicio.findAll().getLista();
		
		model.addAttribute("lista", lista);
		return "index";
	}

}
