package model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="edificios_tabla")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id", nullable=false)
	private int id;
	private String direccion;
	@Transient
	private ArrayList <Unidad> unidades;
	@Transient
	private ArrayList <AreaComun> areasComunes;



	public Edificio() {
		// TODO Auto-generated constructor stub
	}

	public Edificio(String direccion) {
		super();
		this.direccion = direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}