import static org.junit.Assert.*;
import jorge.veamurguia.entidad.*;
import jorge.veamurguia.basededatos.GestorSql;

import junit.framework.Assert;
import junit.framework.TestCase;


public class testSql extends TestCase{

	GestorSql sql;
	Personal personal;

	public void setup(){
		
	}
	
	public testSql(){
		
		sql = GestorSql.getInstance("test","root","");//inicio la base de datos
		
		personal=new Personal();
		personal.Apellidos="veamurguia";
		personal.ID=1;
		personal.Nombre="Jorge";
	//	jorge.veamurguia.basededatos.Slq;

	}

	public void testCrearTablasSql(){
		
		Personal personal=new Personal();
		Categoria categoria=new Categoria();
		Articulo articulo=new Articulo();
		Cliente cliente=new Cliente();
		Compra compra =new Compra();
		
		Assert.assertTrue("error al crear la tabla",sql.createTable(personal));
		Assert.assertTrue("error al crear la tabla",sql.createTable(categoria));
		Assert.assertTrue("error al crear la tabla",sql.createTable(articulo));
		Assert.assertTrue("error al crear la tabla",sql.createTable(cliente));
		Assert.assertTrue("error al crear la tabla",sql.createTable(compra));

		
	}

	public void testPersonalCrear(){

		Assert.assertTrue("error al crear",sql.crear(personal));
		
	}
	public void testPersonalActualizar(){

		personal.DNI="25000000";
		Assert.assertTrue("error al actualizar",sql.update(personal));
			
	}
	public void testCategoriaBuscar(){
		
		personal=new Personal();
		personal.Apellidos="fernandez";
		personal.ID=2;
		personal.DNI="8900000";

		personal.Nombre="jaime";

		sql.crear(personal);//si no existe lo crea 
		
		Personal personales[]=null;
		//personal2=(Personal[])
		Object [] objeto=sql.find(personal);
		
		Assert.assertTrue("hay mas o menos",objeto.length==1);
		Personal personal2=(Personal ) objeto [0];
		System.out.println("Personal="+personal +"Personal2="+personal2);
		
		Assert.assertEquals("Son los mismos datos",personal,personal2);

		Assert.assertTrue("Son los mismos datos",personal.equals(personal2));
	}

	public void testCategoriaBuscarTodos(){
		
		Categoria categoria=new Categoria();
		categoria.Categoria="maletas";
		categoria.ID=1;
		sql.crear(categoria);//si no existe lo crea 

		categoria.Categoria="sillas";
		categoria.ID=2;
		sql.crear(categoria);//si no existe lo crea 
		
		categoria.Categoria="lamparas";
		categoria.ID=3;
		sql.crear(categoria);//si no existe lo crea 
		
		categoria.Categoria="espejos";
		categoria.ID=4;
		sql.crear(categoria);//si no existe lo crea 
		
		categoria=new Categoria();//establece null para buscar todos
		
		Categoria categorias[]=null;
		//personal2=(Personal[])
		Object [] objeto=sql.find(categoria);
		

		Assert.assertTrue("hay mas o menos",objeto.length==4);
	
	}
	public void testCategoriaDameMayor(){
		
		Categoria categoria=new Categoria();

		Assert.assertEquals(5, sql.maxValorId(categoria));//si no existe lo crea 
	}
	
	public void testCategoriaDameArticulos(){
		
		Categoria categoria=new Categoria();
		Articulo articulo=new Articulo();
		articulo.ID=1;
		articulo.Codigo="Lamp1";
		articulo.precio=new Float(1.4);
		articulo.Articulo="lampara de techo";
		categoria.ID=3;
		articulo.ID_Categoria=categoria;

		sql.crear(articulo);

		articulo.ID=2;
		articulo.Codigo="Lamp2";
		sql.crear(articulo);

		
		articulo=new Articulo();
		articulo.ID_Categoria=categoria;
		
		Object [] objeto=sql.find(articulo);

		
		Assert.assertEquals(2, objeto.length);//si no existe lo crea 

		Articulo articulo2=(Articulo) objeto [0];

		Categoria categoria2=articulo2.ID_Categoria;
		Assert.assertEquals(categoria.ID, categoria2.ID);//si no existe lo crea 
		
		
	}
	public void testCategoriaBorrarArticulos(){
		
		Categoria categoria=new Categoria();
		Articulo articulo=new Articulo();
		categoria.ID=3;
		articulo.ID_Categoria=categoria;

		sql.borrar(articulo);//solo marco la categoria debe haber un borrado multiple
		
		Object [] objeto=sql.find(new Articulo());

		
		Assert.assertEquals(0, objeto.length);//si no existe lo crea 

		
		
	}
	

	public void testPersonalBorrar(){

		personal.Apellidos=null;
		personal.Nombre=null;

		Assert.assertTrue("error al borrar",sql.borrar(personal));
			
	}
	public void testBorrarTablas(){

		sql.execute("Drop Table Personal");
		sql.execute("Drop Table Categoria");
		sql.execute("Drop Table Articulo");
		sql.execute("Drop Table Cliente");
		sql.execute("Drop Table Compra");
		
	}
	
}
