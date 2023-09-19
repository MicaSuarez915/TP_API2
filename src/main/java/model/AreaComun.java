package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="area_comun_tabla")
public class AreaComun {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id", nullable=false)
	private int idAreaComun;
	private String nombreAreaComun;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "edificio_id", referencedColumnName = "id")
	private Edificio edificio;
	@OneToMany(mappedBy = "areaComun", cascade = CascadeType.ALL)
	private List<Reclamo> reclamos = new ArrayList<Reclamo>();

	public AreaComun(String nombreAreaComun, String descripcion) {
		// TODO Auto-generated constructor stub
		super();
		this.nombreAreaComun=nombreAreaComun;
		this.descripcion = descripcion;
	}

	public String getNombreAreaComun() {
		return nombreAreaComun;
	}

	public int getIdAreaComun() {
		return idAreaComun;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public void getReclamos() {
		for(Reclamo r: reclamos) {
			r.toString();
		}
	}

	public void agregarReclamo(Reclamo reclamo1) {
		this.reclamos.add(reclamo1);
	}
}