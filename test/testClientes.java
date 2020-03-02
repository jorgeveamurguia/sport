import static org.junit.Assert.*;
import jorge.veamurguia.entidad.Cliente;
import junit.framework.TestCase;


public class testClientes extends TestCase{

	public void testCliente(){
		Cliente cliente,cliente2 ;
		cliente =new Cliente();
		cliente.Apellidos="veamurguia";
		cliente.Nombre="jorge";

		cliente2 =new Cliente();
		cliente2.Apellidos="veamurguia";
		cliente2.Nombre="jorge";
		
	}
	
}
