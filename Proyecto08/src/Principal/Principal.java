package Principal;

import Ventanas.Juego;
import Ventanas.Registro;
import Ventanas.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		//Ventanas a utilizar
		//Ventana del Juego
		VentanaPrincipal vJuego=new VentanaPrincipal();
		
		//Generamos la ventana de Login
		Registro login=new Registro(vJuego);
		login.setVisible(true);
		
		
	}
	
	
	
}