package com.talento_digital.VO;

import java.util.ArrayList;
import java.util.List;
import com.talento_digital.entity.Direccion;
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
public class DireccionVO {
	
	private String mensaje;
	private String codigo;
	private List<Direccion> lista = new ArrayList<Direccion>();
}
