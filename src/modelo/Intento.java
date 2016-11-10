package modelo;

import java.util.Date;

public class Intento {

	private int numero;
	private Date fechaHora;
	private String respuestaMaquina;

	public Intento(int numero, Date fechaHora, String respuestaMaquina) {
		super();
		this.numero = numero;
		this.fechaHora = fechaHora;
		this.respuestaMaquina = respuestaMaquina;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getRespuestaMaquina() {
		return respuestaMaquina;
	}

	public void setRespuestaMaquina(String respuestaMaquina) {
		this.respuestaMaquina = respuestaMaquina;
	}

}
