package jorge.veamurguia.entidad;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Personal.java
//  @ Date : 01/03/2010
//  @ Author :jorge.veamurguia
//  @email:jorge.veamruguia@gmail.com
//




public class Personal {
	public Integer ID;
	public String Nombre;
	public String Apellidos;
	public String Direccion;
	public String DNI;
	public void Vender() {
	
	}
	
	public void Comprar() {
	
	
	}
	public String  toString(){
		return "[ID:"+ID+"][Nombre:"+Nombre+"][Direccion:"+Direccion+"][DNI:"+DNI+"]"; 
	}
	public boolean equals(Object obj)
	    {
	        if( obj instanceof Personal )
	        {
	        	Personal  oObjetoLocal = (Personal )obj;

	            if(this.DNI.compareTo(oObjetoLocal.DNI) == 0)
	            {
	                   return true;
	            }
	        }
	        return false;
	 }    
	 /*public int hashCode()
	 {
	     return Integer.parseInt(DNI);
	 }*/
}