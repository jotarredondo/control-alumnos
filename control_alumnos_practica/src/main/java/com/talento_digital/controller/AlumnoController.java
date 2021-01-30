package com.talento_digital.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.talento_digital.VO.AlumnoVO;
import com.talento_digital.entity.Alumno;
import com.talento_digital.entity.Direccion;
import com.talento_digital.service.AlumnoServiceImp;
import com.talento_digital.service.DireccionServiceImp;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoServiceImp servicio;
	
	@Autowired
	private DireccionServiceImp direccionServicio;
	
	private String mensaje = null;
	private Alumno alumno = new Alumno();
	
	@GetMapping("/")
	public String index(ModelMap model) {
		
		model.addAttribute("fecha",servicio.fecha());
		return "index";
	}
	
	@GetMapping("/alumnos")
	public String alumnos(ModelMap model) {
		
		List<Alumno> alumnos = servicio.findAll().getLista();
		
		List<Direccion> direcciones = direccionServicio.findAll().getLista();
		
		List<Alumno> filtrada = new ArrayList<Alumno>();
		
		for (Alumno alumnoTemp : alumnos) {
				
			if(alumnoTemp.getDireccion() == null) {
				
				filtrada.add(alumnoTemp);
			}
		}
		
		model.addAttribute("filtrada", filtrada);
		model.addAttribute("direcciones", direcciones);
		model.addAttribute("lista", servicio.findAll().getLista());
		model.addAttribute("fecha",servicio.fecha());
		return "index";
	}
	
	@PostMapping("/agregar")
	public String agregar(ModelMap model,RedirectAttributes flash, @ModelAttribute Alumno alumnoNuevo) {
		
		alumnoNuevo.setFechaIngreso(servicio.fecha());
		AlumnoVO temp = servicio.save(alumnoNuevo);
		
		if (temp.getCodigo().equals("0")) {
			mensaje = "El alumno no puedo ser registrado, intente en otro momento";
			return "index";
		}
		
		mensaje = "El alumno se registró exitosamente en la base de datos";
		

		model.addAttribute("mensaje", mensaje);
		model.addAttribute("direcciones", direccionServicio.findAll().getLista());
		model.addAttribute("lista", servicio.findAll().getLista());
		return "redirect:/alumnos";
	}

}
