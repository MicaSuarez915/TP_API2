package model;

public class Anulado extends EstadoReclamo{
	
	private String medidasTomadas;

	public Anulado() {
		// TODO Auto-generated constructor stub
	}

	public Anulado(String medidasTomadas) {
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