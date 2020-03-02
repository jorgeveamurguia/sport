package jorge.veamurguia.gui;


/** interfaz para definir la comunicacion entre cada uno de los frames para saber que boton ha pulsado
  * 
 * */
public interface IOpcionPulsada {

    
   int OPCION_PULSADA_ACEPTAR=0;
   int OPCION_PULSADA_CANCELAR=1;
	
   public void setOpcion (int opcion);
   public int  getOpcion ();
}
