package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
//// import org.springframework.stereotype.Component;
//@Component
@Entity
@Table(name="usuarios_tabla")
@DiscriminatorValue("Dueño")
public class Duenio extends Usuario{

	@OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)
	private List<Unidad> unidades = new ArrayList<Unidad>();

	@OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL)
	public List<Reclamo> reclamosRealizados = new ArrayList<Reclamo>();

	public Duenio() {
		// TODO Auto-generated constructor stub
	}

	public Duenio(String nombre, String apellido, int dni, String usuario, String contra) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = usuario;
		this.contrasenia = contra;
	}

	public void agregarUnidad(Unidad unidad1) {
		this.unidades.add(unidad1);
	}

	public void getUnidades() {
		for(Unidad u: unidades) {
			u.toString();
		}
	}

	public void getReclamosRealizados() {
		for(Reclamo r: reclamosRealizados) {
			r.toString();
		}
	}

	public void agregarReclamo(Reclamo reclamo1) {
		this.reclamosRealizados.add(reclamo1);
	}

	public void consultarReclamo(int numeroReclamo) {
		for(Reclamo r: reclamosRealizados) {
			if (r.getNumero()==numeroReclamo) {
				r.toString();
				break;
			}
		}
	}
	
	

}
