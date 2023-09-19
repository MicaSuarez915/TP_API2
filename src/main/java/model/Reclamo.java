package model;

import javax.persistence.*;

@Entity
@Table(name="reclamos_tabla")
public class Reclamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id", nullable=false)
	private int numero;
	@ManyToOne
	@JoinColumn(name = "id_unidad", referencedColumnName = "id")
	private Unidad unidad;
	@ManyToOne
	@JoinColumn(name = "id_area_comun", referencedColumnName = "id")
	private AreaComun areaComun;
	private String descripcion;
	@Embedded
	private Foto foto;
	@ManyToOne
	@JoinColumn(name = "id_estado_reclamo", referencedColumnName = "id_estado_reclamo")

	private EstadoReclamo estado;
	@ManyToOne
	@JoinColumn(name = "duenio_id")
	private Duenio duenio;

	@ManyToOne
	@JoinColumn(name = "inquilino_id")
	private Inquilino inquilino;


	public Reclamo(String descripcion, Foto foto) {
		super();
		this.descripcion = descripcion;
		this.foto = foto;
		this.estado=new Nuevo("Creacion de Reclamo");
	}
	public Reclamo(){

	}


	@Override
	public String toString() {
		return "Reclamo [descripcion=" + descripcion + ", foto="
				+ foto + "]";
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public void setDuenio(Duenio duenio){this.duenio=duenio;}

	public Duenio getDuenio() {
		return duenio;
	}

	public Inquilino getInquilino() {return inquilino;}

	public void setInquilino(Inquilino inquilino) {this.inquilino = inquilino;}

	public AreaComun getAreaComun() {
		return areaComun;
	}

	public void setAreaComun(AreaComun areaComun) {
		this.areaComun = areaComun;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public EstadoReclamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoReclamo estado) {
		this.estado = estado;
	}
	
	
	
	

	

}
