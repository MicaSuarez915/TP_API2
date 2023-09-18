package model;

public class Desestimado extends EstadoReclamo{
	private String medidasTomadas;

	public Desestimado() {
		// TODO Auto-generated constructor stub
	}

	public Desestimado(String medidasTomadas) {
		super();
		this.medidasTomadas = medidasTomadas;
	}

	public String getMedidasTomadas() {
		return medidasTomadas;
	}

	public void setMedidasTomadas(String medidasTomadas) {
		this.medidasTomadas = medidasTomadas;
	}
	
	

}
