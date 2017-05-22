package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

//JPanel que incluira todo l onecesario para jugar
//Se colocara en el JFrame VentanaPrincipal

public class Juego extends JPanel {
	//Paneles generales
	private JPanel contentPane;
	
	//Array de dados
	private ImageIcon[] dados3=new ImageIcon[3];
	private ImageIcon[] dados6=new ImageIcon[6];
	private ImageIcon[] dados12=new ImageIcon[12];
	private ImageIcon dadoGris;
	private Random dado=new Random(); //Variable que permite controlar el random del so dados
	
	//Almacenamos los numero aleatorios necesarios para despues realizar el calculo
	private int[] numerosAlmacenadosDados3=new int[3];
	private int[] numerosAlmacenadosDados6=new int[6];
	private int numerosAlmacenadosDados12;
	
	//Clase que almacena el Jugador
	private Jugador player;
	JLabel nombreJugador;
	JLabel puntuacion;
	
	//JLabel de las imagenes
	private JLabel dado1,dado2,dado3;
	private JLabel dado4,dado5;
	private JLabel dado6;

	//JLabel de los botones de control
	private JButton suma,resta,mathdice;
	//Caja de resultado
	private JTextField resultado;
	
	//diferentes variables que nos permiten realizar el control del flujo de operaciones
	private boolean tocaNumero=true;
	private int operacion=0;
	private int numerosIntroducidos=0;
	private boolean esSuma=true;
	
	//JLable de muestra de resultados
	private JLabel resultadoLabel;
	private JLabel resultadoOK;
	//Boton repetir
	private JButton repetir;
	
	/**
	 * Create the frame.
	 */
	public Juego() {
		
		//Panel principal
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 675);
		
		contentPane = this; //new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Dados, cofiguracion general
		dado1 = new JLabel("");
		dado1.setBounds(10, 11, 229, 211);
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setBounds(249, 11, 234, 211);
		contentPane.add(dado2);
		
		dado3 = new JLabel("");
		dado3.setBounds(493, 11, 229, 211);
		contentPane.add(dado3);
		
		dado4 = new JLabel("");
		dado4.setBounds(10, 233, 234, 211);
		contentPane.add(dado4);
		
		dado5 = new JLabel("");
		dado5.setBounds(249, 233, 234, 211);
		contentPane.add(dado5);
		
		dado6 = new JLabel("");
		dado6.setBounds(125, 455, 229, 170);
		contentPane.add(dado6);
		
		//Texto de bienvenida jugador
		nombreJugador = new JLabel("Bienvenido");
		nombreJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		nombreJugador.setBounds(732, 11, 414, 44);
		contentPane.add(nombreJugador);
		
		//Caja de puntuacion
		puntuacion = new JLabel("Tu puntuacion es: ");
		puntuacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		puntuacion.setBounds(732, 66, 229, 44);
		contentPane.add(puntuacion);
		
		//Colocamos los botones de suma y resta
		suma = new JButton("+");
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tocaNumero){
					resultado.setText(resultado.getText()+"+");
					tocaNumero=true;
					esSuma=true;
				}
			}
		});
		suma.setFont(new Font("Tahoma", Font.BOLD, 20));
		suma.setBounds(732, 121, 151, 65);
		contentPane.add(suma);
		
		resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tocaNumero){
					resultado.setText(resultado.getText()+"-");
					tocaNumero=true;
					esSuma=false;
				}
			}
		});
		resta.setFont(new Font("Tahoma", Font.BOLD, 20));
		resta.setBounds(995, 121, 151, 65);
		contentPane.add(resta);
		
		//Caja de resultados
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setFont(new Font("Tahoma", Font.BOLD, 20));
		resultado.setBounds(732, 197, 414, 65);
		contentPane.add(resultado);
		resultado.setColumns(10);
		//Colocamos el boton de resultado
		mathdice = new JButton("MATHDICE");
		mathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numerosIntroducidos>1){
					resultadoLabel.setText("Tu operación es "+String.valueOf(operacion));
					repetir.setEnabled(true);
					if((numerosAlmacenadosDados12+1)==operacion){
						resultadoOK.setText("CORRECTO");//El resultado es correcto
						//Desactivamos el boton mathdice para no aumentar los puntos indefinidamente
						mathdice.setEnabled(false);
						player.setPuntos(player.getPuntos()+5);
						puntuacion.setText("Tu puntuacion es: "+player.getPuntos());	
					}else{
						resultadoOK.setText("INTENTALO DE NUEVO");
						//desactivamos el boton mathdice para forzar a repetir
						mathdice.setEnabled(false);
					}
				}
			}
		});

		mathdice.setFont(new Font("Tahoma", Font.BOLD, 20));
		mathdice.setBounds(732, 273, 414, 65);
		contentPane.add(mathdice);
		
		//Caja de resultado
		resultadoLabel = new JLabel("");
		resultadoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		resultadoLabel.setBounds(732, 425, 414, 65);
		contentPane.add(resultadoLabel);
		
		//Caja de resultado OK
		resultadoOK = new JLabel("");
		resultadoOK.setFont(new Font("Tahoma", Font.BOLD, 20));
		resultadoOK.setBounds(732, 501, 414, 65);
		contentPane.add(resultadoOK);
		//Boton REPETIR
		repetir = new JButton("REPETIR");
		repetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarBotones();
				//Al apretar repetir reactivamos boton mathdice
				mathdice.setEnabled(true);
				repetir.setEnabled(false);
			}
		});
		repetir.setEnabled(false);
		repetir.setFont(new Font("Tahoma", Font.BOLD, 20));
		repetir.setBounds(732, 349, 414, 65);
		contentPane.add(repetir);
		
		
		inicializarBotones();
		
	}
	
	
	
	//Setter para pasar a este JPANEL los datos de palyer
	public void setJugador(Jugador player){
		this.player=player;
		nombreJugador.setText("Bienvenido al juego "+player.getNombre());
		puntuacion.setText("Tu puntuacion es: "+player.getPuntos());
	}
	
	//Operaciones aritmeticas
	
	private void setOperacion(int num){
		numerosIntroducidos++;
	if(numerosIntroducidos>1){
		if(esSuma) operacion=operacion+num;
		else operacion=operacion-num;
	}else{
		operacion=num;
	}
}


private void inicializarBotones(){
	//Cargamos todas las imagenes en los arrays
	for(int i=0;i<dados3.length;i++){
		dados3[i]=new ImageIcon(getClass().getResource("/Imagenes/dado"+String.valueOf(i+1)+"_3.png"));
	}
	for(int i=0;i<dados6.length;i++){
		dados6[i]=new ImageIcon(getClass().getResource("/Imagenes/dado"+String.valueOf(i+1)+"_6.png"));
	}
	for(int i=0;i<dados12.length;i++){
		dados12[i]=new ImageIcon(getClass().getResource("/Imagenes/dadodoce_"+String.valueOf(i+1)+".png"));
	}
	dadoGris=new ImageIcon(getClass().getResource("/Imagenes/dadogris.png"));
	
	//Colocamos los dados de 3 caras
			for(int i=0;i<numerosAlmacenadosDados3.length;i++) numerosAlmacenadosDados3[i]=dado.nextInt(3); //Numero aleatorio
			dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]); //imagen dentro de los JLABEL
			dado1.setName("1");
			dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]); 
			dado2.setName("2");
			dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]); 
			dado3.setName("3");
			dado1.addMouseListener(new ListenerDados());
			dado2.addMouseListener(new ListenerDados());
			dado3.addMouseListener(new ListenerDados());
	//Colocamos los dados de 6 caras		
			for(int i=0;i<numerosAlmacenadosDados6.length;i++) numerosAlmacenadosDados6[i]=dado.nextInt(6); //Numero aleatorio
			dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]); 
			dado4.setName("4");
			dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]); 
			dado5.setName("5");
			dado4.addMouseListener(new ListenerDados());
			dado5.addMouseListener(new ListenerDados());
	//Colocamos los dados de 12 caras		
			numerosAlmacenadosDados12=dado.nextInt(12); //Numero aleatorio
			dado6.setIcon(dados12[numerosAlmacenadosDados12]);
			//Reseteamos cajas
			resultadoLabel.setText("");
			resultadoOK.setText("");
			resultado.setText("");
			
	//Reseteamos semaforos y valores
			tocaNumero=true;
			operacion=0;
			numerosIntroducidos=0;
			esSuma=true;
}			
			
	//Implementacion especifica de un ActionListener
			//A traves de un Inner class
			private class ListenerDados implements MouseListener {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel dado = (JLabel) e.getSource();
					int numeroDado=Integer.valueOf(dado.getName());
					if (tocaNumero){
						if(numeroDado<4)
							resultado.setText(resultado.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
						else
							resultado.setText(resultado.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
						dado.removeMouseListener(this);
						dado.setIcon(dadoGris);
						tocaNumero=false;
						if(numeroDado<4)
							setOperacion(numerosAlmacenadosDados3[numeroDado-1]+1);
						else
							setOperacion(numerosAlmacenadosDados6[numeroDado-4]+1);
					}
				}
				
				//ListenerDados al implementar MouseListener debe tambien implementar los siguientes casos

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				
				
				}
				
			}

//En los atributos de la clase añado las siguientes declaraciones

//Listeners para cada dado
      //private MouseListener[] listener_dados=new MouseListener[5];
      //private boolean[] listener_activos=new boolean[5];  //True si el listener está activo

//JLabels de las imágenes de los dados que podrán ser pulsados

//Es un poco redudante y chapuza, pero era para no cambiar el código con los nombres dado1,dado2,dado3,dado4,dado5

//private JLabel[] dados=new JLabel[5]; //Permitirá hacer bucle sobre dados para poner/quitar listeners

//En el constructor de la clase asigno los valores del array de dados cada vez que defino el label de un dado al estilo

             // dado1 = new JLabel("");
              //dado1.setBounds(10, 10, 150, 150);
             // contentPane.add(dado1);
             // dados[0]=dado1;

//En InicializarJuego(), asigno todos los listeners a los dados y pongo sus semáforos a true añadiendo el siguiente código

      //Añadimos listeners a los dados 1 a 5 y avisamos que están activos
             // for (int i=0; i<dados.length; i++)
               //   {listener_dados[i]=new ListenerDados();
               //   dados[i].addMouseListener(listener_dados[i]);
                //  listener_activos[i]=true;}

//En la implementación de la inner class del Mouse sobre los dados, ListenerDados() borro el listener del dado pulsado y pongo a false su semáforo correspondiente con líneas de códico como estas:



             //  JLabel dado = (JLabel) e.getSource();
             // int numeroDado=Integer.valueOf(dado.getName());
            //  dado=dados[numeroDado-1];

          //   ....

              //borro listener y actualizo semáforo

              //    dado.removeMouseListener(listener_dados[numeroDado-1]); //o dado.removeMouseListener(this);
              //    listener_activos[numeroDado-1]=false;
              //    dado.setIcon(dadoGris);



//Dentro del listener del botón Mathdice que cierra la jugada y abre la opción a hacer otra borro los listeners de los dados que no han sido pulsados

  //Borramos los listeners de los dados no pulsados para que no estén activos la siguiente jugada
                 // for (int i=0; i<listener_dados.length; i++)
                   //   {
                  //      if (listener_activos[i]); 
                    //     {dados[i].removeMouseListener(listener_dados[i]);
                    //      listener_activos[i]=false;}
                   //   }
           //   }
