package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.ConexionDB;
import Juego.Jugador;
import Juego.JugadorDB;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Registro extends JFrame {
	//
	private JPanel contentPane;
	//Cajas de informacion
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	//No crea un nuevo objeto de la clase Login, sino una etiqueta de referencia a un objeto tipo login
	private Registro referencia;
	//Permitir acceso desde esta ventana, Login, a otra, Juego, pasandola como referencia
	private VentanaPrincipal ventana_Juego;
	//Generamos un nuevo jugador
	private Jugador player1=new Jugador();
	
	 //Manejadores de la base de datos
		private ConexionDB db;
		private JugadorDB jdb;
		private Connection conexion; //Conexión
		private boolean connected =false; //Conexión con éxito


	/**
	 * Create the frame.
	 */
	public Registro(VentanaPrincipal vJ) {
		
		//referencia se asocia al objeto creado que es tipo login.
		referencia=this;
		//La etiqueta ventana_Juego se asocia al input de Login. Se hace visible a toda la clase
		ventana_Juego=vJ;
		
		
		player1.setNombre("");
		player1.setApellido1("");
		player1.setApellido2("");
		player1.setEdad(999);
		player1.setId(0);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta DATOS JUGADOR
		JLabel DatosJugador = new JLabel("DATOS JUGADOR");
		DatosJugador.setForeground(Color.BLACK);
		DatosJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		DatosJugador.setBounds(175, 11, 194, 37);
		contentPane.add(DatosJugador);
		
		//Etiqueta NOMBRE
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(10, 97, 118, 23);
		contentPane.add(lblNombre);
		
		//Etiqueta APELLIDO1
		JLabel lblApellido = new JLabel("APELLIDO 1");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApellido.setBounds(10, 139, 118, 23);
		contentPane.add(lblApellido);
		
		//Etiqueta APELLIDO2
		JLabel lblApellido_1 = new JLabel("APELLIDO 2");
		lblApellido_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApellido_1.setBounds(10, 181, 118, 23);
		contentPane.add(lblApellido_1);
		
		//Etiqueta EDAD
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEdad.setBounds(10, 223, 118, 23);
		contentPane.add(lblEdad);
		
		//Campo para introducir el nombre
		textField = new JTextField();
		textField.setBounds(138, 97, 406, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		//Listener para introducir el intro
		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Al pulsar intro guarda el campo
				player1.setNombre(textField.getText());
				
			}
		});
		
		//Campo para introducir el Apellido1
		textField_1 = new JTextField();
		textField_1.setBounds(138, 139, 406, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//Listener para introducir el intro
				textField_1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						//Al pulsar intro guarda el campo
						player1.setApellido1(textField_1.getText());
						
					}
				});
		
		//Campo para introducir el Apellido2
		textField_2 = new JTextField();
		textField_2.setBounds(138, 181, 406, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		//Listener para introducir el intro
				textField_2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						//Al pulsar intro guarda el campo
						player1.setApellido2(textField_2.getText());
						
					}
				});
		
		//Campo para introducir la EDAD
		textField_3 = new JTextField();
		textField_3.setBounds(138, 223, 406, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		//Listener para introducir el intro
				textField.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						//Al pulsar intro guarda el campo
						//Comprueba si el dato es numerico
						if(player1.isNumeric(textField_3.getText())==true)
						player1.setEdad(Integer.parseInt(textField_3.getText()));
						else
							player1.setEdad(999);
					}
				});
		//Campo de texto para comentarios
		textField_4 = new JTextField();
		textField_4.setBounds(10, 343, 534, 81);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
				
		//Creamos nuestro objeto para el manejo de la base de datos
				db=new ConexionDB("localhost","mathdice","root","");
				//Establecemos la conexion
				connected=db.connectDB();
				//Asignamos con el getter la conexion establecida
				conexion=db.getConexion();
				//Pasamos la conexión a un nuevo objeto UsuariosDB para insertar datos.
				jdb=new JugadorDB(conexion); 
		
		//Boton Jugar		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Al pulsar el boton escribimos el mensaje por textField_4
				if (player1.getEdad()==999){
					textField_4.setText("EDAD no correcto o falta. Pulsa intro");
				}else if (player1.sonEspacios(player1.getNombre()))	{
					textField_4.setText("Falta el nombre o no ha pulsado intro");
				}else if (player1.sonEspacios(player1.getApellido1())){	
					textField_4.setText("Falta el primer apellido o no ha pulsado intro");
				}else if (player1.sonEspacios(player1.getApellido2())){	
					textField_4.setText("Falta el segundo apellido o no ha pulsado intro");				
				}else{ 	
					//REGISTRAR USUARIO EN LA BASE DE DATOS
					jdb.insertarUsuario(textField.getText(), textField_1.getText(), textField_2.getText(), Integer.valueOf(textField_3.getText()));
				
					if (db.connectDB()){//MÉTODO BOLEANO QUE DEVUELVE TRUE SI SE HA CONECTADO BIEN A LA BBDD
						textField_4.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellido1()+" "+player1.getApellido2()+" de "+player1.getEdad()+" años.\nConectado con éxito a la BBDD.");	
					}else{
						textField_4.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellido1()+" "+player1.getApellido2()+" de "+player1.getEdad()+" años.\nError al conectar con la BBDD");
					}
					
				//Carga la informacion del jugador en la siguiente ventana
				ventana_Juego.setJugador(player1);
				//Poner visible la siguiente venatana
				ventana_Juego.setVisible(true);
				//Poner en invisible la ventana de los datos del jugador
				referencia.setVisible(false);
				
			
			}
				//Mostrar la otra ventana
				ventana_Juego=new VentanaPrincipal();
				
			}	
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 295, 534, 37);
		contentPane.add(btnNewButton);
		
		
		
	}
}
