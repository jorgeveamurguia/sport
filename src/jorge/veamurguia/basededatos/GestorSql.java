package jorge.veamurguia.basededatos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.lang.reflect.Field;
import java.util.Vector;

 
/** GestorSql esta clase singelton, instancia una única clase que conecta
 *  a la base de datos y es capaz de insertar, actualizar objetos java 
 *  en SLQ. 
 *  
 *  Los objetos que son serializados en la base de datos deben tener 
 *  el campo ID como entero y el de clave foranea ID_objetojava
 *  
 * */

public class GestorSql {

	static String bd = "gestor";
	static String backUp = "jorge-backup";

	
    static String login = "root";
    static String password = "root2000";
    static String url = "jdbc:mysql://localhost/";


    Connection conn = null;

    private static GestorSql INSTANCE_REAL = null;
     
    private synchronized static void createInstance() {
        if (INSTANCE_REAL == null) { 
        	INSTANCE_REAL= new GestorSql(bd, login, password);
        	if(INSTANCE_REAL.conn==null)INSTANCE_REAL=null;
        }
    }
 
    public static GestorSql getInstance(String basededatos,String login, String  password) {
        if (INSTANCE_REAL == null) createInstance(basededatos, login, password);
        return INSTANCE_REAL;
    }
    private synchronized static void createInstance(String basededatos ,String login, String  password) {
        if (INSTANCE_REAL == null) { 
        	INSTANCE_REAL= new GestorSql(basededatos, login, password);
        	if(INSTANCE_REAL.conn==null)INSTANCE_REAL=null;
        }
    }
 
    public static GestorSql getInstance() {
        if (INSTANCE_REAL == null) createInstance();
        return INSTANCE_REAL;
    }

    //constructor privado para no generar mas de una instancias el singleton
    private GestorSql(String database,String login, String  password){
        
        try {
            Class.forName("com.mysql.jdbc.Connection");
            conn = (Connection) DriverManager.getConnection(url+database, login, password);
            if (conn != null) {
                System.out.println("Conexión a base de datos "+url+database+" ... Ok");
            }
        }
        catch(SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
        }
        catch(ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public boolean isConnect(){
    	return conn!=null;
    }
/**cierra la base de datos
 * */
    public void close(){
    	try {
			conn.close();
			INSTANCE_REAL=null; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public boolean executeBack(String cadenaSql){
        Statement s;
        try {
            s =(Statement) conn.createStatement();
            
            s.execute(cadenaSql);

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ejecutar ["+cadenaSql+"]"+ex);
            return false;
        }
        return true;
    }

    public boolean execute(String cadenaSql){
        Statement s;
        try {
            s =(Statement) conn.createStatement();
            
            s.executeUpdate(cadenaSql);

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ejecutar ["+cadenaSql+"]"+ex);
            return false;
        }
        return true;
    }
    /**ejecuta un insert en la base de datos del objeto
     * */

    public void crearSchema(String nombre){
    	new CrearBaseDatos().CrearBase();
    	execute("Create Database "+nombre);
  
    }
    //INSERT INTO personas (nombre,telefono,URL) VALUES ('Fede','4255','http://blogjapon.com.ar')"
    public boolean crear(Object clazz){
    
    	return execute(crear(clazz,true));
    	
    }	
    public String crear(Object clazz,boolean backup){

    	String cadenaSql="INSERT INTO "+clazz.getClass().getSimpleName()+"  ";
        String cadenaCampos= new String();
        String cadenaValores= new String();
        for (Field campo: clazz.getClass().getFields()){
        	try {
    			if(campo.getName().startsWith("ID_")){
    				//Class.forName(nombreCampo.substring(3));
    				Field campoForaneo;
						campoForaneo = campo.get(clazz).getClass().getField("ID");
    				int id=(Integer)campoForaneo.get(campo.get(clazz));
            		cadenaCampos=cadenaCampos+campo.getName()+","; 
            		cadenaValores=cadenaValores + id +",";
    			}else{
    			//	if(campo.get(clazz)!=null ){
            		cadenaCampos=cadenaCampos+campo.getName()+","; 

	        		if(campo.getName().compareTo("ID")!=0 
	        				&& !campo.getType().getName().contains("Float"))//recojo el ID
	        			cadenaValores=cadenaValores + ("'"+campo.get(clazz)+"',");
	        		else
	        			cadenaValores=cadenaValores + campo.get(clazz)+",";//el ID es numerico
    				}
       			//}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

       	}	
        cadenaSql =cadenaSql +"(" +cadenaCampos.substring(0,cadenaCampos.length()-1)+") VALUES " 
        					+"(" +cadenaValores.substring(0,cadenaValores.length()-1)+");";
        
        return cadenaSql;
    }

/**   recogo los campos con datos para actualizar, si los campos no estan asociados a datos 
 * es decir un campo esta a null no lo actualizamos, (no se puede actualizar un campo a null)
 * utilizamos el campo de ID para la ejecucion de la consula.
 * 
 * */

    public boolean update(Object clazz){
        
    	return execute(update(clazz,true));
    	
    }	

    public String update(Object clazz,boolean backup ){
        Statement s;
        String cadenaSql="UPDATE "+clazz.getClass().getSimpleName()+" SET ";
        String cadenaWhere="";
        for (Field campo: clazz.getClass().getFields()){
        	try {
        		if(campo.getName().compareTo("ID")!=0){//recojo el ID
        			if(campo.get(clazz)!=null )//si es null no lo actualices
        			{
            			if(campo.getName().startsWith("ID_")){
            				//Class.forName(nombreCampo.substring(3));
            				Field campoForaneo;
									campoForaneo = campo.get(clazz).getClass().getField("ID");
            				int id=(Integer)campoForaneo.get(campo.get(clazz));
            				cadenaSql =cadenaSql + " " +campo.getName()+" = " + id +",";
            			}else{
        				cadenaSql =cadenaSql + " " +campo.getName()+" = '"+campo.get(clazz)+"' ,";
            			}
        			}
        		}
        		else{
        			cadenaWhere=" Where "+campo.getName()+" = "+campo.get(clazz);
        		}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
        	} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }	
        cadenaSql = cadenaSql.substring(0,cadenaSql.length()-2) + cadenaWhere;

        return cadenaSql;
    }
    /** dev el max valor del campo id de un tabla determinada
     *
     * **/
    public int maxValorId(Object clazz) {
    	int id=1;
        String cadenaSql="select max(id) from "+clazz.getClass().getSimpleName();

        Statement s;
			try {
				s = (Statement) conn.createStatement();
		        ResultSet rs = s.executeQuery (cadenaSql);
		        while (rs.next())
		        {
		            id=rs.getInt(1)+1;
		        	System.out.println (id);
		        }

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    	return id;
    }
    
/** por cada objeto pasado al método se busca el campo ID para realizar el borrado
 *  o por el campo ID_ foraneo
 *  Ningún otro atributo será utilizado por el método 
 * */ 
    public boolean borrar(Object clazz){
        
    	return execute(borrar(clazz,true));
    	
    }	

    public String borrar(Object clazz,boolean backup){
        Statement s;
        String cadenaSql="Delete from "+clazz.getClass().getSimpleName();
        String cadenaWhere="";
        for (Field campo: clazz.getClass().getFields()){
        	try {
        		//solo seleccion ID_ o por ID
        		if(campo.get(clazz)!=null){//el !null marca el campo por el que se borrar
	    			if(campo.getName().startsWith("ID_")){
	    				Field campoForaneo;
							campoForaneo = campo.get(clazz).getClass().getField("ID");
						int id=(Integer)campoForaneo.get(campo.get(clazz));
	
	    				cadenaWhere =" Where  " +campo.getName()+" = "+id+" ";
	    				break;
	    			}else if(campo.getName().compareTo("ID")==0){//recojo el ID
	        			cadenaWhere=" Where "+campo.getName()+" = "+campo.get(clazz);
	        			break;
	    			}
        		}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
        	} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }	
        cadenaSql = cadenaSql + cadenaWhere;

        return cadenaSql;

    }

    //cadenaSql="select * from personas";
/** a través de un objeto entidad genero una consulta de búsqueda contra la base de datos 
 * devolviendo un array de objetos del mismo objeto rellenos de los datos pasados a la búsqueda
 * Cada uno de los campos introducidos genera una consulta con and, si se quiere realizar consultaws
 * con OR solamente hay que realizar varias consultas con cada uno de los campos y agregar los 
 * resultados al array
 * */
    public Object[] find(Object clazz){
    	
  
    	return find(clazz,false);
    }
    
    public Object[] find(Object clazz,boolean filter){

    	Statement s;
        String cadenaSql="select * from "+clazz.getClass().getSimpleName();
        String cadenaWhere="";
        for (Field campo: clazz.getClass().getFields()){
        	try {
        		String nombreCampo=campo.getName();
        		if(campo.get(clazz)!=null ) {
        			if(nombreCampo.startsWith("ID_")){
        				Field campoForaneo;

							campoForaneo = campo.get(clazz).getClass().getField("ID");
    					int id=(Integer)campoForaneo.get(campo.get(clazz));

        				if(filter)
        					cadenaWhere =cadenaWhere + " " +nombreCampo+" like '%"+id+"%' AND ";
        				else
        					cadenaWhere =cadenaWhere + " " +nombreCampo+" = '"+id+"' AND ";
        			}else
        				if(campo.getType().getName().contains("Float")){
        					//no se puede filtrar por Float
        				}
        				else
	        		if(nombreCampo.compareTo("ID")!=0){//recojo el ID
	        			if(filter)
	        				cadenaWhere =cadenaWhere + " " +nombreCampo+" like '%"+campo.get(clazz)+"%' AND ";
	        			else
	        				cadenaWhere =cadenaWhere + " " +nombreCampo+" = '"+campo.get(clazz)+"' AND ";
	        		}
	        		else{
	       				cadenaWhere=cadenaWhere+nombreCampo+" = "+campo.get(clazz) +" AND ";
	        		}
	        		
        		}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }	
        if(cadenaWhere.length()!=0){
        	cadenaSql =cadenaSql+" where "+ cadenaWhere.substring(0,cadenaWhere.length()-4);
        }
        
        //los datos de la consulta se rellenan en los objetos java
        try {
            s =(Statement) conn.createStatement();
            
            ResultSet rs = s.executeQuery (cadenaSql);
            Vector objetos=new Vector();
            Object  newClass=null;            
            Object  newClassInside=null;
            
            while (rs.next()){
					newClass=clazz.getClass().newInstance();
					objetos.add(newClass);
            	for (Field campo: newClass.getClass().getFields()){
            		
        			if(campo.getName().startsWith("ID_")){
        				//genero una clase del tipo de campo del objeto de la base de datos
						newClassInside=Class.forName("jorge.veamurguia.entidad."+campo.getName().substring(3)).newInstance();
        				//asocio el valor de la base de datos al objeto nuevo
        				newClassInside.getClass().getField("ID").set(newClassInside, rs.getObject(campo.getName()));
        				//asocio al valor del objeto de la base de datos al objeto nuevo
        				campo.set(newClass, newClassInside);
        			}
        			else
        				campo.set(newClass, rs.getObject(campo.getName()));
            	
            	}
            	
            }
            System.out.println(" ejecutar ["+cadenaSql+"]");
            return objetos.toArray();
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ejecutar ["+cadenaSql+"]"+ex);

        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return null;

     }
/*

    CREATE TABLE Customer     (SID integer,
         Last_Name varchar(30),
         First_Name varchar(30),
         PRIMARY KEY (SID));
*/
    public boolean createTable(Object clazz){
        
    	return execute(createTable(clazz,true));
    	
    }	
    
    public String createTable(Object clazz,boolean backup){
        Statement s;
        String cadenaSql="Create Table "+clazz.getClass().getSimpleName()+"(";
        for (Field campo: clazz.getClass().getFields()){
        	try {
        		if(campo.getName().matches("ID")){//recojo el ID
        			cadenaSql=cadenaSql + campo.getName()+" Integer NOT NULL AUTO_INCREMENT, ";
        		}else 	if(campo.getName().contains("ID")){//recojo el ID
        			cadenaSql=cadenaSql + campo.getName()+" Integer , ";
        		}else if(campo.getType().getName().contains("String")){
    				cadenaSql=cadenaSql+campo.getName()+" Varchar (50),";
    			}else if(campo.getType().getName().toLowerCase().contains("float")){
    				cadenaSql=cadenaSql+campo.getName()+" float,";
    			}else if(campo.getType().getName().contains("Date")){
    				cadenaSql=cadenaSql+campo.getName()+" Date,";
    			}else if(campo.getType().getName().contains("Integer")){
    				cadenaSql=cadenaSql+campo.getName()+" Integer,";
    			}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }	
        cadenaSql =cadenaSql+"PRIMARY KEY (ID));";

        return cadenaSql;

    }   
    /** por cada clase que se pasa por parametro crea una consulta SLQ para hacer una
     * copia de seguridad;
     * */
    public StringBuffer backup(Object clazz){
    	
		StringBuffer cadenaSql=new StringBuffer();

		cadenaSql.append(this.createTable(clazz,true));//recoge el texto de crear la tabla
		
				
		for(Object art: this.find(clazz)){//encuentra todos los objetos de esta clase
			cadenaSql.append(this.crear(art,true));//genera las consulta SQL
		}
	
		System.out.print(cadenaSql.toString());
		return cadenaSql;//dev la tabla y los datos
    }
}
