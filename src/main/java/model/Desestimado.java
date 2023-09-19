package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado_reclamo_tabla")
@DiscriminatorValue("Desestimado")
public class Desestimado extends EstadoReclamo{


	public Desestimado(String medidasTomadas) {
		super();
		this.setMedidasTomadas(medidasTomadas);
	}


	public Desestimado() {

	}
}
