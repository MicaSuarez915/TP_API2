package model;

import javax.persistence.*;

//@Entity
//@Table(name="reclamos_tabla")
public class Reclamo {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@PrimaryKeyJoinColumn
	//@Column(name="id", nullable=false)
	private int numero;
	private Unidad unidad;
	private AreaComun areaComun;
	private String descripcion;
	private Foto foto;
	private EstadoReclamo estado;
	private Usuario usuario;

	public Reclamo(String descripcion, Foto foto) {
		super();
		this.descripcion = descripcion;
		this.foto = foto;
	}
	public Reclamo(){

	}

	@Override
	public String toString() {
		return "Reclamo [unidad=" + unidad.toString() + ", areaComun=" + areaComun.toString() + ", descripcion=" + descripcion + ", foto="
				+ foto + "]";
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public void setUsuario(Usuario usuario){this.usuario=usuario;}

	public Usuario getUsuario() {
		return usuario;
	}

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
	
	public void getEstadoReclamo() {
		
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
