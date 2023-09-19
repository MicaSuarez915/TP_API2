package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado_reclamo_tabla")
@DiscriminatorValue("Nuevo")

public class Nuevo extends EstadoReclamo{

	public Nuevo(String medidasTomadas) {
		// TODO Auto-generated constructor stub
		super( medidasTomadas);
	}

	public Nuevo() {

	}
}
