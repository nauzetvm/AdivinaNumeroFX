package application;

import java.util.Date;
import java.util.Random;
import modelo.Intento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {

	private int numeroAdivinar;

	private int contadorIntentos;
	Intento[] intentos = new Intento[100];
	private String respuestaMaquina;

	@FXML
	TextField fxml_min;
	@FXML
	TextField fxml_max;
	@FXML
	Label fxml_infoGenerar;
	@FXML
	Button fxml_btnGenerar;
	@FXML
	TextField fxml_numeroJugado;
	@FXML
	Button fxml_btnJugar;
	@FXML
	Button fxml_btnIntentos;
	@FXML
	TextArea fxml_infoJugada;

	public void botonGenerar(ActionEvent evt) {
		try {
			if (fxml_min.getText().isEmpty() || fxml_max.getText().isEmpty()) {
				fxml_infoGenerar.setText("Debe introducir dos valores.");
			}
			int minimo = Integer.parseInt(fxml_min.getText());
			int maximo = Integer.parseInt(fxml_max.getText());
			if (minimo >= maximo) {
				fxml_infoGenerar.setText("Mínimo debe ser menor que máximo.");
			} else {
				fxml_infoGenerar.setText("Rango elegido: " + fxml_min.getText() + " y " + fxml_max.getText()
						+ ", ya puede comenzar a jugar.");
				numeroAdivinar = generarAleatorioEntre(minimo, maximo);
				fxml_btnGenerar.setDisable(true);
				fxml_numeroJugado.setDisable(false);
				fxml_btnJugar.setDisable(false);
				fxml_infoJugada.setDisable(false);
			}
		} catch (NumberFormatException e) {
			fxml_infoGenerar.setText("Error de formato.");
		}
	}

	public void botonJugar(ActionEvent evt) {
		int numJugado = Integer.parseInt(fxml_numeroJugado.getText());
		fxml_btnIntentos.setDisable(false);
		if (numJugado < numeroAdivinar) {
			respuestaMaquina = "Pruebe un numero mayor.\n";
			fxml_infoJugada.appendText(respuestaMaquina);
		} else if (numJugado > numeroAdivinar) {
			respuestaMaquina = "Pruebe un numero menor.\n";
			fxml_infoJugada.appendText(respuestaMaquina);
		} else {
			respuestaMaquina = "¡Ha acertado!\n";
			fxml_infoJugada.appendText("**************************\nEnhorabuena, has acertado! " + numeroAdivinar
					+ "\n**************************\n");
			fxml_btnGenerar.setDisable(true);
			fxml_numeroJugado.setDisable(true);
			fxml_btnJugar.setDisable(true);
		}
		Intento intento = new Intento(numJugado, new Date(), respuestaMaquina);
		intentos[contadorIntentos++] = intento;
	}

	public void verIntentos() {
		fxml_infoJugada.appendText("Sus intentos han sido:\n");
		for (int i = 0; i < intentos.length; i++) {
			try {
				fxml_infoJugada.appendText((i + 1) + " " + intentos[i].getNumero() + " " + intentos[i].getFechaHora()
						+ " -> " + intentos[i].getRespuestaMaquina());
			} catch (NullPointerException e) {
				break;
			}
		}
	}

	public int generarAleatorioEntre(int minimo, int maximo) {
		return minimo + new Random().nextInt(maximo - minimo);
	}

}