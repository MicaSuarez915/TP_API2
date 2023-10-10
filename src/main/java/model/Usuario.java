package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//// import org.springframework.stereotype.Component;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "condicion_usuario", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn(name = "id_usuario")
	@Column(name="id_usuario", nullable=false)
	public int id;
	public String nombre;
	public String apellido;
	public int dni;
	public String nombreUsuario;
	public String contrasenia;
	@Column(name = "condicion_usuario")
	public String condicionUsuario;



	
	
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
