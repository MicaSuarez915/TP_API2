package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado_reclamo_tabla")
@DiscriminatorValue("En Proceso")
public class EnProceso extends EstadoReclamo{

	public EnProceso() {
		// TODO Auto-generated constructor stub
		super();
	}

}
