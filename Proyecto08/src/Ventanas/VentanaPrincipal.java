package Ventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	//Clase que almacena el jugador
	private Jugador player;
	
	//clase que almacena la ventana de Juego
	//Es un JPANEL que se añade a este JFRAME
	private Juego ventanaJuego =new Juego();
	
	//clase que almacena la ventana de Perfil
	//sera un Jpanel que se añadira a este JFRAME
	private Perfil ventanaPerfil =new Perfil();
	
	//Identificadores
	final static String VENTANAJ = "Ventana Juego";
	final static String VENTANAP = "Ventana Perfil";
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 675);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentanas = new JMenu("Ventanas");
		menuBar.add(mnVentanas);
		//Menu para juego
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mnVentanas.add(mntmJuego);
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane,  VENTANAJ);
			}
		});
		//Menu para perfil
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnVentanas.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane,  VENTANAP);
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//JPanel ventanaJuego = new JPanel();
		contentPane.add(ventanaJuego,VENTANAJ);
		
		//JPanel ventanaPerfil = new JPanel();
		contentPane.add(ventanaPerfil,VENTANAP);
	}
	
	//Pasa los datos del jugador a JPANEL ventanJuego de tipo juego
	
	public void setJugador(Jugador player){
		this.player=player;
		ventanaJuego.setJugador(player);
		//ventanaPerfil.setJugador(player);
	}
	
	
	
}

