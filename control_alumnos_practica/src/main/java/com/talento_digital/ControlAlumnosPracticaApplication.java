package com.talento_digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.talento_digital.dao.AlumnoDao;
import com.talento_digital.dao.DireccionDao;
import com.talento_digital.service.AlumnoServiceImp;

@SpringBootApplication
public class ControlAlumnosPracticaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ControlAlumnosPracticaApplication.class, args);
		
		AnnotationConfigApplicationContext acab = new AnnotationConfigApplicationContext(AppConfig.class);
		AlumnoServiceImp alumno = acab.getBean(AlumnoServiceImp.class);
		DireccionDao direccion = acab.getBean(DireccionDao.class);
		
		System.out.println(alumno.findAll().getLista());
		
		
	}

}
