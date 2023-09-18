package model;

public class Habitantes {
	private Duenio duenio;
	private Inquilino inquilino;
	private Unidad unidad;

	public Habitantes() {
		// TODO Auto-generated constructor stub
	}

	public Habitantes(Duenio duenio, Inquilino inquilino, Unidad unidad) {
		super();
		this.duenio = duenio;
		this.inquilino = inquilino;
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "Habitantes [duenio=" + duenio + ", inquilino=" + inquilino + ", unidad=" + unidad + "]";
	}
	
	

}
