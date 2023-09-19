package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado_reclamo_tabla")
@DiscriminatorValue("Terminado")

public class Terminado extends EstadoReclamo{

	public Terminado(String medidasTomadas) {
		// TODO Auto-generated constructor stub
		super( medidasTomadas);
	}


	public Terminado() {

	}
}
