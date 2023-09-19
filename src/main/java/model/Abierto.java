package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado_reclamo_tabla")
@DiscriminatorValue("Abierto")
public class Abierto extends EstadoReclamo{

	public Abierto( String medidasTomadas) {
		super( medidasTomadas);
			// TODO Auto-generated constructor stub
		this.setMedidasTomadas(medidasTomadas);

	}

	public Abierto() {

	}
}
