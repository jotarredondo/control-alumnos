package com.talento_digital.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	private String rut;
	private String nombre;
	private String apellido;
	private String email;
	private int edad;
	private String fechaIngreso;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direccion", referencedColumnName = "id_direccion")
	private Direccion direccion;
	
	
		
}
