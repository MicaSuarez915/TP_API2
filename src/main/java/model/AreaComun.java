package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


public class AreaComun {

	private int idAreaComun;
	private String nombreAreaComun;
	private String descripcion;

	public AreaComun(int idAreaComun, String nombreAreaComun) {
		// TODO Auto-generated constructor stub
		super();
		this.idAreaComun=idAreaComun;
		this.nombreAreaComun=nombreAreaComun;
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
}