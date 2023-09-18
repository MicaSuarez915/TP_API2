package model;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="usuarios_tabla")
public class Duenio extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id", nullable=false)
	private int id;
	private String nombre;
	private String apellido;
	private int dni;
	private String condicionUsuario="Duenio";
	@Transient
	private ArrayList<Reclamo> reclamosRealizados;
	private ArrayList<Unidad> unidades;


	public Duenio() {
		// TODO Auto-generated constructor stub
	}

	public Duenio(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public void agregarUnidad(Unidad unidad1) {
		this.unidades.add(unidad1);
	}

	public void getUnidades() {
		for(Unidad u: unidades) {
			u.toString();
		}
	}

	
	
	

}
