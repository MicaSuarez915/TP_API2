package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado_reclamo_tabla")
@DiscriminatorValue("Anulado")
public class Anulado extends EstadoReclamo{


	public Anulado(String medidasTomadas) {
		super();
		// TODO Auto-generated constructor stub
		this.setMedidasTomadas(medidasTomadas);

	}

	public Anulado() {

	}

	

}