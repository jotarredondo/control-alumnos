package com.talento_digital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.talento_digital.VO.DireccionVO;
import com.talento_digital.entity.Alumno;
import com.talento_digital.entity.Direccion;
import com.talento_digital.service.AlumnoServiceImp;
import com.talento_digital.service.DireccionServiceImp;

@Controller
public class DireccionController {
	
	@Autowired
	private DireccionServiceImp direccionServicio;
	
	@Autowired
	private AlumnoServiceImp servicio;
	
	private String mensaje = null;
	
	
	@PostMapping("/direccion")
	public String direccion(ModelMap model, RedirectAttributes flash) {
		
		List<Alumno> alumnos = servicio.findAll().getLista();
		
		List<Direccion> direcciones = direccionServicio.findAll().getLista();
		
		List<Alumno> filtrada = new ArrayList<Alumno>();
		
		List<Direccion> filtradaD = new ArrayList<Direccion>();
		
		for (Alumno alumnoTemp : alumnos) {
				
			if(alumnoTemp.getDireccion() == null) {
				
				filtrada.add(alumnoTemp);
			}
		}
		for (Direccion direccionTemp : direcciones) {
			if(direccionTemp.getAlumno() == null) {
				filtradaD.add(direccionTemp);
			}
		}
		
		model.addAttribute("filtradaD", filtradaD);
		model.addAttribute("filtrada", filtrada);
		model.addAttribute("direcciones", direcciones);
		model.addAttribute("lista", alumnos);
		model.addAttribute("fecha",servicio.fecha());
		return "direccion";
	}
	
	@PostMapping("/agregarDireccion")
	public String agregarDireccion(ModelMap model, RedirectAttributes flash,@ModelAttribute Direccion direccionNueva) {
		
		DireccionVO temp = null;
		
		if(direccionNueva.getAlumno() == null) {
			temp = direccionServicio.save(direccionNueva);
			
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("direcciones", direccionServicio.findAll().getLista());
			model.addAttribute("lista", servicio.findAll().getLista());
			return "index";
		}
	
		Alumno alumnoTemp = direccionNueva.getAlumno();
		servicio.agregarDireccion(alumnoTemp.getIdAlumno(), direccionNueva);
		temp = direccionServicio.save(direccionNueva);
		
		if (temp.getCodigo().equals("0")) {
			mensaje = "La direccion no pudo ser registrado, intente en otro momento";
			return "index";
		}
		
		mensaje = "La dirección se se registró exitosamente en la base de datos";
		
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("direcciones", direccionServicio.findAll().getLista());
		model.addAttribute("lista", servicio.findAll().getLista());
		return "index";
	}
	

}
