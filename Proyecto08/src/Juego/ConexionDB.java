package Juego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	//DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS DE LA BBDD
	private String host; //host donde está la base de datos
	private String bbdd; //nombre de la base de datos
	private String user; //nombre usuario para acceder base de datos
	private String pass; //password de usuario
	private String url; //proporcionara al metodod DriverManager la direccion de conexión en la forma adecuada

	
	
	//Conexion
	private Connection conexion = null; //maneja la conexion
	
	
	//Constructor (le pasaremos los datos necesarios para la conexion)
	
	public ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;		
		}
	
	
	//Metodo para conectarse con la BBDD: true si ha conseguido conectarse
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual automaticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) //No encuentra la base de datos
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch ( ClassNotFoundException noEncontroClase ) //No encuentra el driver para la conexion
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Devuelve una instancia de la conexion
	public Connection getConexion(){
		return this.conexion;
	}
	
}
