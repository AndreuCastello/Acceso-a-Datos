package AlmacenLibros;

import java.io.Serializable;

public class Libro implements Serializable{

	private int Identificador=0;
	private String Nombre=null;
	private String Autor=null;
	private int AñoDePublicacion=0;
	private String Editor=null;
	private int NumPaginas=0;
	
	public Libro() {
		
	}
	
	public Libro(int i, String n, String a, int ap, String e, int np) {
		Identificador = i;
		Nombre = n;
		Autor = a;
		AñoDePublicacion = ap;
		Editor = e;
		NumPaginas = np;
		
	}

	public int getIdentificador() {
		return Identificador;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public String getAutor() {
		return Autor;
	}
	public int getAñoDePublicacion() {
		return AñoDePublicacion;
	}
	public String getEditor() {
		return Editor;
	}
	public int getNumPaginas() {
		return NumPaginas;
	}
	
	
	public void setEdad(int i) {
		Identificador = i;
	}
	public void setNombre(String n) {
		Nombre = n;
	}
	public void setAutor(String a) {
		Autor = a;
	}
	public void setAñoDePublicaion(int ap) {
		AñoDePublicacion = ap;
	}
	public void setEditor(String e) {
		Editor = e;
	}
	public void setNumPaginas(int np) {
		NumPaginas = np;
	}

	@Override
	public String toString() {
		return "Libro [Identificador=" + Identificador + ", Titulo=" + Nombre + ", Autor=" + Autor
				+ ", Año De Publicacion=" + AñoDePublicacion + ", Editor=" + Editor + ", NumPaginas=" + NumPaginas + "]";
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

