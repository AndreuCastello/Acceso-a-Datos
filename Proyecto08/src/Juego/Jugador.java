package Juego;


public class Jugador {
	private String nombre;
	private String apellidos;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int puntos;
	private int id;
	
	//Private jugador
	
	public String getNombre() {
		return nombre;
	}
		
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
		
	public String getApellidos() {
		return apellidos;
	}	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
		
	}
	
	public int getEdad() {
		return edad;
	}	
	public void setEdad(int edad) {
		this.edad = edad;
		
	}
	
	public int getPuntos() {
		return puntos;
	}	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
		
	}
	
	public String getApellido1() {
		return apellido1;
	}	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
		
	}
	
	public String getApellido2() {
		return apellido2;
	}	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
		
	}

	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public Jugador() {

	}
	
	//Metodo para comprobar si una cadena es un numero
	//Devuelve true si es un numero
	public boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
			
		}
	}
	
	//Metodo para comprobar si una cadena es un conjunto de espcacios.
	public boolean sonEspacios(String cad)
	{
		for(int i =0; i<cad.length(); i++)
		if(cad.charAt(i) != ' ')
			return false;
		
		return true;
	}
	
	public String toString(){
		return this.nombre+" "+this.apellido1+" "+this.apellido2+" de "+this.edad+" años";
	}
	

}
	