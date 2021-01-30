package com.talento_digital;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.talento_digital.entity.Direccion;
import com.talento_digital.service.DireccionServiceImp;



@SpringBootApplication
public class ControlAlumnosPracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlAlumnosPracticaApplication.class, args);
		
		
//		AnnotationConfigApplicationContext acab = new AnnotationConfigApplicationContext(AppConfig.class);
//		AlumnoServiceImp alumno = acab.getBean(AlumnoServiceImp.class);
//		DireccionServiceImp direccion = acab.getBean(DireccionServiceImp.class);
//		
//		List<Direccion> lista = direccion.findAll().getLista();
//		for (Direccion direccion2 : lista) {
//			if (direccion2.getAlumno() == null) {
//				System.out.println("tiene un nulo");
//			}
//			else {
//				System.out.println("no tiene nulo");
//			}
//		}
//		
//		
//			
//		Alumno alu = new Alumno();
//		alu.setIdAlumno(12);
//		alu.setNombre("Connor");
//		alu.setApellido("Mcgregor");
//		alu.setEdad(33);
//		alu.setEmail("monkey@gmail.com");
//		alu.setRut("22100300-1");
//		
//		Date fecha = new Date(11-10-1995);
//		alu.setFechaIngreso(fecha);
//		
//		
//		
//		System.out.println(alumno.save(alu));
		
		
	}

}
