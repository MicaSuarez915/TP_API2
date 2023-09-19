package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_estado", discriminatorType = DiscriminatorType.STRING)
public class EstadoReclamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id_estado_reclamo", nullable=false)
	private int idEstadoReclamo;
	@Column(name = "tipo_estado")
	public String tipo;
	private String medidasTomadas;
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
	public List<Reclamo> reclamosAsociados = new ArrayList<Reclamo>();


	public EstadoReclamo(String medidasTomadas) {
		// TODO Auto-generated constructor stub
		super();
		this.medidasTomadas = medidasTomadas;
	}

	public EstadoReclamo(){

	}


	public String getMedidasTomadas() {
		return medidasTomadas;
	}

	public void setMedidasTomadas(String medidasTomadas) {
		this.medidasTomadas = medidasTomadas;
	}

	public int getIdEstadoReclamo() {
		return idEstadoReclamo;
	}

	public void setIdEstadoReclamo(int idEstadoReclamo) {
		this.idEstadoReclamo = idEstadoReclamo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void getReclamosAsociados() {
		for(Reclamo r: reclamosAsociados) {
			r.toString();
		};
	}

	public void addReclamosAsociados(Reclamo e) {
		this.reclamosAsociados.add( e);
	}
}