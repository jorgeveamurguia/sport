package jorge.veamurguia.basededatos;

//import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jorge.veamurguia.entidad.*;

public class CrearBaseDatos {

	GestorSql sql ;

	public CrearBaseDatos(){
		
		sql =GestorSql.getInstance();
		
	}
	public static void main(String[] arg){
		new CrearBaseDatos().CrearBase();
		
	}
	
	/*public CrearBaseDatos(){
		sql =GestorSql.getInstance("mysql", "root", "");
		sql.crearSchema("prueba3");
		sql.close();
		sql =GestorSql.getInstance("prueba3", "root", "");

	}*/
	public void CrearBase(){
		Articulo articulo=new Articulo();
		Categoria categoria=new Categoria();
		Cliente cliente=new Cliente();

		Venta venta=new Venta();

		LineaVenta lineaVenta = new LineaVenta();

		Personal personal=new Personal();
		
		
		sql.createTable(personal);
		sql.createTable(categoria);
		sql.createTable(articulo);
		sql.createTable(cliente);
		sql.createTable(lineaVenta );
		sql.createTable(venta);
	
	}
	/*public void crearDatos(){
		Categoria categoria=new Categoria();
		categoria.ID=1;
		categoria.Categoria="Equitacion";
		sql.crear(categoria);
		
		categoria.ID=2;
		categoria.Categoria="Natacion";
		sql.crear(categoria);
	}*/
	/** genera un fichero en texto plano con los datos guardados en la base de datos.
	 * */
	public void  backup(File filename){

		StringBuffer cadenaSql=
			sql.backup(new Articulo()).append(
			sql.backup(new Categoria())).append(
			sql.backup(new Cliente())).append(
			sql.backup(new Venta())).append(
			sql.backup(new LineaVenta())).append(
			sql.backup(new Personal()));

	    	      
	        BufferedWriter input;
			try {
				input = new BufferedWriter(new FileWriter(filename));
				input.write(cadenaSql.toString());
				input.flush();
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}
	/**restaura a partir de un fichero de texto la base de atos en la conexon instanciada 
	 * */
	public void  restore(File filename){

		//sql.crearSchema(nombre);
		//sql.close();
		sql =GestorSql.getInstance();
		String cadenaSql=null;
		BufferedReader input;
		try {
			input = new BufferedReader(new FileReader(filename));
			cadenaSql=input.readLine();

			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(String cadena :cadenaSql.split(";")) {
			sql.execute(cadena);
		}

		
/*		sql.crearSchema("jorge");
		sql.close();
		sql =GestorSql.getInstance("jorge");
	*/	
		
	}
	
	
}
