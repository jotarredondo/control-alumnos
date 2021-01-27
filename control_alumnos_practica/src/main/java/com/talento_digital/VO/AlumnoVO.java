package com.talento_digital.VO;

import java.util.ArrayList;
import java.util.List;

import com.talento_digital.entity.Alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoVO {
	
	private String mensaje;
	private String codigo;
	private List<Alumno> lista = new ArrayList<Alumno>();

}
