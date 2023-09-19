package model;

import java.util.ArrayList;
import java.util.List;

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
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	private List<Unidad> unidades = new ArrayList<Unidad>();
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	private List<AreaComun> areasComunes =  new ArrayList<AreaComun>();



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

	public void agregarUnidad(Unidad unidad1) {
		this.unidades.add(unidad1);
	}

	public void getUnidades() {
		for(Unidad u: unidades) {
			u.toString();
		}
	}

	public void addAreaComun(AreaComun areaComun1) {
		this.areasComunes.add(areaComun1);
	}

	public void getAreasComunes() {
		for(AreaComun a: areasComunes) {
			a.toString();
		}
	}

}