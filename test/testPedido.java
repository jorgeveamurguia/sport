import static org.junit.Assert.*;
import jorge.veamurguia.entidad.Almacen;
import jorge.veamurguia.entidad.Articulo;
import jorge.veamurguia.entidad.LineaPedido;
import jorge.veamurguia.entidad.Pedido;
import jorge.veamurguia.entidad.Personal;
import jorge.veamurguia.entidad.Proveedor;
import junit.framework.TestCase;


public class testPedido extends TestCase{

	public void testPedido(){
		Pedido pedido=new Pedido();
		Personal personal=new Personal();
		LineaPedido lineaPedido;
		Almacen almacen=new Almacen();
		Proveedor proveedor=new Proveedor();
		
		lineaPedido=new LineaPedido();
		Articulo articulo=new Articulo();
		articulo.ID=1;
		articulo.Codigo="CA-MA-02";
		articulo.Articulo="camiseta manga larga";
		almacen.Articulos.put(articulo,20);//lleno el almacen
		//meterlo en la linea de pedido		
		lineaPedido.ID_Articulo=articulo;
		lineaPedido.Cantidad=7;
		lineaPedido.Precio=20.5F;
		pedido.lineas.add(lineaPedido);
		
		lineaPedido=new LineaPedido();
		articulo=new Articulo();
		articulo.ID=2;
		articulo.Codigo="BI-ES-02";
		articulo.Articulo="bici estatica";
		almacen.Articulos.put(articulo,15);//lleno el almacen
		//meterlo en la linea de pedido
		lineaPedido.ID_Articulo=articulo;
		lineaPedido.Cantidad=2;
		lineaPedido.Precio=200.5F;
		pedido.lineas.add(lineaPedido);
		
		
		proveedor.ID=1;
		proveedor.Proveedor="Distribuciones lopez";
		
		pedido.ID=1;//id del pedido
		personal.ID=1;//id de la persona
		personal.Nombre="tabajador1";
		lineaPedido.ID=1;//id de la linea  
		
		lineaPedido.ID_Pedido=pedido;//objeto del pedido
		pedido.ID_Personal= personal;//persona que hace el pedido
		
		pedido.ID_Proveedor=proveedor;

		
		
		
		pedido.Listar();
		
	}
	
}
