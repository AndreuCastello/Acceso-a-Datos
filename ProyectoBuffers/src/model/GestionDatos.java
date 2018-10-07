package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import AlmacenLibros.Libro;
import controller.GestionEventos;

public class GestionDatos {


	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		
		FileReader fich1 = new FileReader(fichero1);
		BufferedReader br1 = new BufferedReader(fich1);
		FileReader fich2 = new FileReader(fichero2);
		BufferedReader br2 = new BufferedReader(fich2);

		String str1;
		String str2;
		
	
	str1=br1.readLine(); //Leemos el fichero
	str2=br2.readLine();

	boolean verdadero=false;

	if (str1 != null && str2 != null) { //Comprobamos que el texto contiene algo
        do {

            if (str1.equals(str2)) { //comparamos la linea
                verdadero = true;
            }

            str1 = br1.readLine();//leemos la siguiente linea
            str2 = br2.readLine();
        } while (((str1 != null || str2 != null) && verdadero));//El bucle continua hasta que se acaba el texto o las lineas son diferentes
    }

	    br1.close();//cerramos flujos
	    br2.close();

		return verdadero;//devolvemos resultado

	}
	
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la función
		int numFila=0;
		if(primera_aparicion){//comprobamos si esta marcado el check
			
			FileReader fich1 = new FileReader(fichero1);//creamos los flujos
			BufferedReader br1 = new BufferedReader(fich1);
			
			String str1;
			
	        
	        boolean encontrado = false;
	        

	        str1 = br1.readLine();//leemos el fichero


	        while(str1!=null && !encontrado){//El bucle continua hasta que se termina el fichero o encontramos la primera coincidencia
	            if(str1.equals(palabra)){//comprobamos que la palabra introducida este dentro del fichero

	            	encontrado=true;
	            }
	            numFila++;
	            str1=br1.readLine();
	        }

	        if(!encontrado){
	            numFila=-1;
	        
	        }
	        	
	        
		}else{
			FileReader fich1 = new FileReader(fichero1);
			BufferedReader br1 = new BufferedReader(fich1);
			
			String str1;
	        
	       
	        
	        int aux=0;

	        str1 = br1.readLine();


	        while(str1!=null){
	            if(str1.equals(palabra)){
	            numFila=aux;
	                
	            }
	            aux++;
	            str1=br1.readLine();
	        }

	        if(numFila==0){
	            numFila=-1;
	        
	        }else{
	        	numFila++;
	        }
		}
		
		
		
		return numFila;
	}	
	
		
	public void guardarLibro(Libro l){
		File  libro=new File("./mislibros/"+Integer.toString(l.getIdentificador())+".txt");//Creamos un fichero con el identificador del libro
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(libro));
			out.writeObject(l);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			intentarCerrar(out);
        }
        
	}
	
	public String recuperar(String f) {
		Libro l = null;
		String aux;
		aux="Libro no encontrado";
		File l2=new File(f);//Cuando pasamos un id buscamos el id + la extension .txt
        ObjectInputStream in=null;
        try {
            in = new ObjectInputStream(new FileInputStream("./mislibros/"+f));
            l = (Libro) in.readObject();       
            aux=l.toString();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de fichero");
        } catch (IOException ex) {
        	System.err.println("Error IO");
        }finally{
            intentarCerrar(in);
        }
        
        return aux;
	}
	public ArrayList<Libro> recuperarTodos() throws IOException, ClassNotFoundException{//Creamos el array de libros
		ArrayList<Libro> listaLibros=new ArrayList<Libro>();
		Libro e;
		
		File[] paths;
		ObjectInputStream in=null;
		File folder = new File("./mislibros/");
		String[] ficheros = folder.list();//Creamos un array con todos los ficheros de la carpeta
		if (ficheros == null)
			  System.out.println("No hay ficheros en el directorio especificado");
			else { 
			  for (int x=0;x<ficheros.length;x++){//Recogemos cada fichero de la carpeta
				  
				 File aux=new File("./mislibros/"+ficheros[x]);
			  
				 in=new ObjectInputStream(new FileInputStream(aux));
				 e=(Libro)in.readObject();
				  listaLibros.add(e);
				  
			}
			}
		return listaLibros;
	}

	
	public static void intentarCerrar(Closeable aCerrar) {
		try {
			if (aCerrar != null) {
				aCerrar.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
		
	}
	

