package model;

public class Anulado extends EstadoReclamo{

	private String medidasTomadas;

	public Anulado(String medidasTomadas) {
		super(medidasTomadas);
		// TODO Auto-generated constructor stub

	}

	public String getMedidasTomadas() {
		return medidasTomadas;
	}

	public void setMedidasTomadas(String medidasTomadas) {
		this.medidasTomadas = medidasTomadas;
	}
	
	

}