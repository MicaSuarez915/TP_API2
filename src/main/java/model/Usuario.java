package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;



public abstract class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	private int dni;
	private String nombreUsuario;
	private String contrasenia;
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private ArrayList<Reclamo> reclamosRealizados;
	private String condicionUsuario;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(String nombre, String apellido, int dni, String nombreUsuario, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}


 	public void getReclamosRealizados() {
		for(Reclamo r: reclamosRealizados) {
			r.toString();
		}
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setReclamosRealizados(ArrayList<Reclamo> reclamosRealizados) {
		this.reclamosRealizados = reclamosRealizados;
	}


	
	
	public void hacerReclamo(Reclamo reclamo1) {
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


	@java.lang.Override
	public java.lang.String toString() {
		return "Usuario{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", dni=" + dni +
				", nombreUsuario='" + nombreUsuario + '\'' +
				", contrasenia='" + contrasenia + '\'' +
				'}';
	}
}
