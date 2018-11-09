package View2;

import java.awt.Dimension;

import javax.swing.*;

import AlmacenLibros.Libro;
import model.GestionDatos;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LaunchView2 extends JFrame {

	private JButton comparar,buscar;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JButton btnGuardarLibro;
	private JButton btnSacarLibro;
	private JTextField txtId;
	private JTextField txtAutor;
	private JTextField txtPubl;
	private JTextField txtTitulo;
	private JTextField txtEditor;
	private JTextField txtNum;
	
	public LaunchView2() {
		
		setBounds(200,200,1070,480);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setBounds(10, 5, 150, 26);
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setBounds(165, 5, 150, 26);
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero1.setBounds(393, 8, 127, 20);
		fichero2 = new JTextField("",10);
		fichero2.setBounds(393, 33, 127, 20);
		palabra = new JTextField("",10);
		palabra.setBounds(602, 8, 86, 20);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f1.setBounds(320, 11, 63, 14);
		label_f2 = new JLabel("Fichero 2:");
		label_f2.setBounds(320, 36, 63, 14);
		label_pal = new JLabel("Palabra:");
		label_pal.setBounds(530, 11, 62, 14);
		
		primera = new JCheckBox("Primera aparición");
		primera.setBounds(694, 7, 150, 23);
		panel.setLayout(null);
		
		JTextArea txtSalida = new JTextArea();
        txtSalida.setBounds(429, 95, 594, 291);
        panel.add(txtSalida);
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
        
        btnGuardarLibro = new JButton("Guardar Libro");
        btnGuardarLibro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int Identificador=Integer.parseInt(txtId.getText());//Recogemos los datos introducidos en el id
        		String Nombre=txtTitulo.getText();
        		String Autor=txtAutor.getText();
        		int AñoDePublicacion=Integer.parseInt(txtPubl.getText());
        		String Editor=txtEditor.getText();
        		int NumPaginas=Integer.parseInt(txtNum.getText());
        		Libro l =new Libro(Identificador, Nombre, Autor, AñoDePublicacion,Editor,NumPaginas);//Creamos un objeto tipo libro
        		GestionDatos g = new GestionDatos();
        		
        		g.guardarLibro(l);
        		
        	}
        });
        btnGuardarLibro.setBounds(10, 95, 124, 26);
        panel.add(btnGuardarLibro);
        
        btnSacarLibro = new JButton("Sacar Libro");
        btnSacarLibro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id=txtId.getText()+".txt";
        		String m;
        		GestionDatos g = new GestionDatos();
        		m=g.recuperar(id);
        		txtSalida.setText(m);
        	}
        });
        btnSacarLibro.setBounds(10, 190, 124, 26);
        panel.add(btnSacarLibro);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(144, 101, 127, 14);
        panel.add(lblId);
        
        JLabel lblAutor = new JLabel("Autor");
        lblAutor.setBounds(144, 143, 127, 14);
        panel.add(lblAutor);
        
        JLabel lblTitulo = new JLabel("Titulo");
        lblTitulo.setBounds(144, 183, 127, 14);
        panel.add(lblTitulo);
        
        JLabel lblAoDePublicacion = new JLabel("A\u00F1o de publicacion");
        lblAoDePublicacion.setBounds(144, 229, 127, 14);
        panel.add(lblAoDePublicacion);
        
        JLabel lblEditor = new JLabel("Editor");
        lblEditor.setBounds(144, 280, 127, 14);
        panel.add(lblEditor);
        
        JLabel lblNumeroDePaginas = new JLabel("Numero de paginas");
        lblNumeroDePaginas.setBounds(144, 340, 127, 14);
        panel.add(lblNumeroDePaginas);
        
        txtId = new JTextField();
        txtId.setBounds(282, 98, 86, 20);
        panel.add(txtId);
        txtId.setColumns(10);
        
        txtAutor = new JTextField();
        txtAutor.setBounds(282, 140, 86, 20);
        panel.add(txtAutor);
        txtAutor.setColumns(10);
        
        txtPubl = new JTextField();
        txtPubl.setBounds(281, 226, 86, 20);
        panel.add(txtPubl);
        txtPubl.setColumns(10);
        
        txtTitulo = new JTextField();
        txtTitulo.setBounds(282, 180, 86, 20);
        panel.add(txtTitulo);
        txtTitulo.setColumns(10);
        
        txtEditor = new JTextField();
        txtEditor.setBounds(281, 277, 86, 20);
        panel.add(txtEditor);
        txtEditor.setColumns(10);
        
        txtNum = new JTextField();
        txtNum.setBounds(281, 337, 86, 20);
        panel.add(txtNum);
        txtNum.setColumns(10);
        
        JButton btnSacarTLibros = new JButton("Sacar todos los libros");
        btnSacarTLibros.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Libro> listaLibros=new ArrayList<Libro>();
        		txtSalida.setText("");
        		Libro aux;
        	GestionDatos g = new GestionDatos();
        	try {
				listaLibros=g.recuperarTodos();
				for(int i = 0; i<listaLibros.size();i++){
					txtSalida.setText(txtSalida.getText()+"\n"+listaLibros.get(i).toString());
					
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	}
        });
        btnSacarTLibros.setBounds(10, 377, 200, 37);
        panel.add(btnSacarTLibros);
        
        
		
	}	
	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	public String darPalabra(){
		return palabra.getText();
	}
	public boolean esPrimera() {
		return primera.isSelected();
	}
	
	public void showIgual(){
		
		JOptionPane.showMessageDialog(this.panel, "Son iguales");
	
	}
public void showEncontrada(int a){
		
	if (esPrimera()){
		JOptionPane.showMessageDialog(this.panel, "La primera coincidencia se ha encontrado en la linea "+a);
	}else{
		JOptionPane.showMessageDialog(this.panel, "La ultima coincidencia se ha encontrado en la linea "+a);
	}
	
	}
public void showNoEncontrado(){
	
	JOptionPane.showMessageDialog(this.panel, "No se ha encontrado la palabra");

}
	
		public void showDiferente(){
		
		JOptionPane.showMessageDialog(this.panel, "Son Diferentes");
	
	}
}