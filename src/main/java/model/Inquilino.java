package model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="usuarios_tabla")
public class Inquilino extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id", nullable=false)
	private String nombre;
	private String apellido;
	private int dni;
	private ArrayList<Reclamo> reclamosRealizados;
	private String condicionUsuario="Inquilino";
	private String nombreUsuario;
	private String contrasenia;

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
	}
}
