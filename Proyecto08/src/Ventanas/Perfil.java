package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridBagConstraints;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

import Juego.Jugador;
//import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Perfil extends JPanel {
	private Jugador player1;
	private JTextField CuadroNombre;
	private JTextField CuadroPrimerApellido;
	private JTextField Cuadro2oApellido;
	private JTextField CuadroEdad;
	private JTextField CuadroPuntos;
	private JTextField CuadroMensajes;
	private Jugador player;

	
	
	
	/**
	 * Create the panel.
	 */
	public Perfil() {
		setBounds(100, 100, 1200, 675);
		setLayout(null);
		//Aqui intentamos poner la imagen pero no sabia como
		ImageIcon imageIcon = new ImageIcon (Perfil.class.getResource("/Imagenes/perfil.png"));
		//Image image = imageIcon.getImage();
		//Image newimg = reescalar(image, 200, 200);
		//imageIcon = new ImageIcon(newimg);
		//GridBagLayout gridBagLayout = new GridBagLayout();
		//gridBagLayout.columnWidths = new int[]{200, 99, 107, 0};
		//gridBagLayout.rowHeights = new int[]{200, 0};
		//gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, Double.MIN_VALUE};
		//gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		//setLayout(gridBagLayout);
		
		//Cuadro para la imagen
		JLabel Imagen = new JLabel("");
		Imagen.setIcon(imageIcon);
		//Imagen.setBounds(10, 11, 299, 303);
		add(Imagen);
		
		//Cajas para los datos del jugador
		JLabel CajaNombre = new JLabel("Nombre");
		CajaNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CajaNombre.setBounds(319, 11, 101, 20);
		add(CajaNombre);
		
		CuadroNombre = new JTextField();
		CuadroNombre.setBounds(319, 36, 200, 20);
		add(CuadroNombre);
		CuadroNombre.setColumns(10);
		
		JLabel CajaPrimerApellido = new JLabel("1er Apellido");
		CajaPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CajaPrimerApellido.setBounds(319, 67, 101, 20);
		add(CajaPrimerApellido);
		
		CuadroPrimerApellido = new JTextField();
		CuadroPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CuadroPrimerApellido.setBounds(319, 92, 200, 20);
		add(CuadroPrimerApellido);
		CuadroPrimerApellido.setColumns(10);
		
		JLabel CajaSegundoApellido = new JLabel("2o Apellido");
		CajaSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CajaSegundoApellido.setBounds(319, 123, 101, 20);
		add(CajaSegundoApellido);
		
		Cuadro2oApellido = new JTextField();
		Cuadro2oApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cuadro2oApellido.setBounds(319, 148, 200, 20);
		add(Cuadro2oApellido);
		Cuadro2oApellido.setColumns(10);
		
		JLabel CajaEdad = new JLabel("Edad");
		CajaEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CajaEdad.setBounds(319, 179, 101, 20);
		add(CajaEdad);
		
		CuadroEdad = new JTextField();
		CuadroEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CuadroEdad.setBounds(319, 202, 200, 20);
		add(CuadroEdad);
		CuadroEdad.setColumns(10);
		
		JLabel CajaPuntos = new JLabel("Puntos");
		CajaPuntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CajaPuntos.setBounds(319, 233, 101, 20);
		add(CajaPuntos);
		
		CuadroPuntos = new JTextField();
		CuadroPuntos.setEditable(false);
		CuadroPuntos.setBounds(319, 258, 200, 20);
		add(CuadroPuntos);
		CuadroPuntos.setColumns(10);
		
		JLabel CajaMensajes = new JLabel("Mensajes");
		CajaMensajes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CajaMensajes.setBounds(700, 16, 156, 25);
		add(CajaMensajes);
		
		CuadroMensajes = new JTextField();
		CuadroMensajes.setEditable(false);
		CuadroMensajes.setBounds(700, 52, 440, 170);
		add(CuadroMensajes);
		CuadroMensajes.setColumns(10);
		
		JButton BotonActu = new JButton("Actualizar Datos");
		BotonActu.addMouseListener(new BotonActualizar());
		BotonActu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonActu.setBounds(319, 289, 200, 39);
		add(BotonActu);
	
	}
		//INNER CLASS PARA EL BOTÓN GUARDAR CAMBIOS
		private class BotonActualizar implements MouseListener {
			//Formato que tiene que aparecer en una inner class de un mouseListener
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			//MousseListener que vamos a utilizar
			@Override
			public void mousePressed(MouseEvent e) {
				player.setNombre(CuadroNombre.getText());
				player.setApellidos(CuadroPrimerApellido.getText());
				player.setApellidos(Cuadro2oApellido.getText());
				player.setEdad(Integer.parseInt(CuadroEdad.getText()));
				CuadroMensajes.setText("Cambios guardados con éxito para el jugador "+player.getNombre()+" "+player.getApellido1()+" "+player.getApellido2()+" de "+player.getEdad()+" años.");
				} 
			}	
		
		//Aqui tendria que pasar los datos del jugador que se hayan guardado
		public void setJugador(Jugador player){
			this.player=player;
			CuadroNombre.setText(player.getNombre());
			CuadroPrimerApellido.setText(player.getApellido1());
			Cuadro2oApellido.setText(player.getApellido2());
			CuadroEdad.setText(String.valueOf(player.getEdad()));
			CuadroPuntos.setText(String.valueOf(player.getPuntos()));
		
			//ventanaPerfil.setJugador(player);
		
		
		
		
		
		
	}
}
