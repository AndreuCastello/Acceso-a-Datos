package AlmacenLibros;

import java.io.Serializable;

public class Libro implements Serializable{

	private int Identificador=0;
	private String Nombre=null;
	private String Autor=null;
	private int A�oDePublicacion=0;
	private String Editor=null;
	private int NumPaginas=0;
	
	public Libro() {
		
	}
	
	public Libro(int i, String n, String a, int ap, String e, int np) {
		Identificador = i;
		Nombre = n;
		Autor = a;
		A�oDePublicacion = ap;
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
	public int getA�oDePublicacion() {
		return A�oDePublicacion;
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
	public void setA�oDePublicaion(int ap) {
		A�oDePublicacion = ap;
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
				+ ", A�o De Publicacion=" + A�oDePublicacion + ", Editor=" + Editor + ", NumPaginas=" + NumPaginas + "]";
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

