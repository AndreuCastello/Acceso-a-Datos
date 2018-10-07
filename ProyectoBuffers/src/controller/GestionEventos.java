package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import AlmacenLibros.Libro;
import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				try {
					call_buscarPalabra();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					view.showError("Error al buscar la palabra");
				}
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() {

		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		
		try {
			if (model.compararContenido(view.getFichero1().getText(),view.getFichero2().getText())){
				view.showIgual();
			
			}else{
				view.showDiferente();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			view.showError("Error al comparar contenido");
		}
		return 1;
	}

	private int call_buscarPalabra() throws IOException {

		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		
		int aux= model.buscarPalabra(view.getFichero1().getText(), view.darPalabra(), view.esPrimera());
		
		if (aux>0){
			view.showEncontrada(aux);
		}else{
			view.showNoEncontrado();
		}
		
		return 1;
	}
	
	
		
	

}