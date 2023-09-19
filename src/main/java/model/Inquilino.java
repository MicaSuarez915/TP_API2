package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuarios_tabla")
@DiscriminatorValue("Inquilino")
public class Inquilino extends Usuario{
	@ManyToOne
	@JoinColumn(name = "unidad_id")
	private Unidad unidad;
	@OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL)
	public List<Reclamo> reclamosRealizados = new ArrayList<Reclamo>();

	public Inquilino() {
		// TODO Auto-generated constructor stub
	}

	public Inquilino(String nombre, String apellido, int dni, String nombreUsuario, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
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

	/**
	public String getCondicionUsuario() {
		return condicionUsuario;
	}

	public void setCondicionUsuario(String condicionUsuario) {
		this.condicionUsuario = condicionUsuario;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Inquilino{" +
				"nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", dni=" + dni +
				", condicionUsuario='" + condicionUsuario + '\'' +
				", nombreUsuario='" + nombreUsuario + '\'' +
				", contrasenia='" + contrasenia + '\'' +
				'}';
	}**/
}
