/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PersonalGui.java
 *
 * Created on 08-abr-2010, 22:30:03
 */

package jorge.veamurguia.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jorge.veamurguia.basededatos.GestorSql;
import jorge.veamurguia.entidad.Cliente;
import jorge.veamurguia.entidad.Venta;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 *
 * @author jorge
 */
public class ClienteGui extends JPanel implements 
	IIDCodigo,//pasa el codigo del cliente a la ventana que me ha llamado 
	MouseListener ,//activa el evento de la tabla
	IOpcionPulsada  //recojo el evento de mensaje por ventana
	//Printable //para poder imprimir el carnet
	{
    
	GestorSql sql;

	Cliente[] Clientes;
	IIDCodigo idcodigo;
	int opcionPulsada=-1;
	boolean filtro=false;

	
    public ClienteGui() {
        initComponents();
        /*if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }*/
		sql =GestorSql.getInstance();
		refresh();

    }
    
    public ClienteGui(IIDCodigo codigo) {
        initComponents();
        /*if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }*/
		sql =GestorSql.getInstance();
		refresh();
    	idcodigo=codigo;

    	// TODO Auto-generated constructor stub
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
       // bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    	masterScrollPane = new javax.swing.JScrollPane();
    	{
    		TableModel jTable1Model = 
    			new DefaultTableModel(
    					new String[][] { { "One", "Two" }, { "Three", "Four" } },
    					new String[] { "Column 1", "Column 2" });
    		jTable1 = new JTable();
    		masterScrollPane.setViewportView(jTable1);
    		jTable1.setModel(jTable1Model);
    	}

        idLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        apellidosLabel = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nombreField = new javax.swing.JTextField();
        apellidosField = new javax.swing.JTextField();
        direccionField = new javax.swing.JTextField();
        dniField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        imprimirButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        clearButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        idLabel.setText("Id:");

        nombreLabel.setText("Nombre:");

        apellidosLabel.setText("Apellidos:");

        direccionLabel.setText("Direccion:");

        dniLabel.setText("Dni:");


        saveButton.setText("Salvar");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Recargar");
        refreshButton.addActionListener(formListener);

        newButton.setText("Añadir");
        newButton.addActionListener(formListener);

        deleteButton.setText("Borrar");
        imprimirButton.setText("Imprimir");
        imprimirButton.addActionListener(formListener);
        jTable1.addMouseListener(this);

        deleteButton.addActionListener(formListener);

        jCheckBox1.setText("Filtrar");
        jCheckBox1.addActionListener(formListener);

        clearButton.setText("limpiar");
        clearButton.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(nombreLabel)
                            .addComponent(apellidosLabel)
                            .addComponent(direccionLabel)
                            .addComponent(dniLabel)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imprimirButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton))
                            .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(apellidosField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(direccionField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(dniField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidosLabel)
                    .addComponent(apellidosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionLabel)
                    .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLabel)
                    .addComponent(dniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(refreshButton)
                        .addComponent(deleteButton)
                        .addComponent(newButton)
                        .addComponent(imprimirButton)
                        .addComponent(clearButton)
                        )
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );

    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                ClienteGui.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                ClienteGui.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ClienteGui.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ClienteGui.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jCheckBox1) {
                ClienteGui.this.filterButtonActionPerformed(evt);
            }
            else if (evt.getSource() == clearButton) {
                ClienteGui.this.clearButtonActionPerformed(evt);
            }
            else if (evt.getSource() == imprimirButton) {
                ClienteGui.this.imprimirButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

    	refresh();
    	
    }//GEN-LAST:event_refreshButtonActionPerformed
    @SuppressWarnings("unchecked")
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
    	filtro=!filtro;
    	refresh();
    	
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

    	Venta venta=new  Venta();
    	
    	int selected = jTable1.getSelectedRows()[0];
    	
        /*int id=Integer.parseInt(jTable1.getModel().getValueAt(selected[0], 0).toString());
        Articulo articulo=new Articulo();
        articulo.ID=id;
*/
        
       // Articulo articulo =new Articulo();
        //articulo.ID_Categoria=categoria;
        //devuelve todas las compras realizadas con este articulo.
    	venta.ID_Cliente=Clientes[selected];
    	Object objetos[] = sql.find(venta);//devuelve todos los articulos relacionados con categoria ID

        if(objetos.length>0){
        	JFrame frame = new JFrame();
	  		MessageGui inst = new MessageGui(frame,this,"No se puede borrar el Cliente si no borras antes todas sus ventas",false,true);
	  		inst.setVisible(true);
        }else{
            sql.borrar(Clientes[selected]);
            refresh();
        }
       /* if(getOpcion()==IOpcionPulsada.OPCION_PULSADA_ACEPTAR){

        	//articulo.ID=id;
	        sql.borrar(articulos[selected]);
	        //sql.borrar(articulo);
	        //si hay una categoria vinculada a un articulo no se puede borrar 
	        //o preguntar si se quiere borrar todos los articulos relacionados
	        refresh();
        }
*/    
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed

        
    	Cliente Cliente=new Cliente();
    	try {
    		if(idField.getText().length()>0)
    			Cliente.ID=Integer.parseInt(idField.getText());
    		Cliente.Apellidos=apellidosField.getText();
    		Cliente.Nombre=nombreField.getText();
    		Cliente.Direccion=direccionField.getText();
    		Cliente.DNI=dniField.getText();
    		
    		

        if( ! sql.crear(Cliente)){
      		
      		MessageGui inst = new MessageGui(new JFrame(),this,"Ya existe el ID",false,true);
      		inst.setVisible(true);
          }
    	}catch(NumberFormatException ex){
    	  		JFrame frame = new JFrame();
    	  		MessageGui inst = new MessageGui(frame,this,"No es un ID válido",false,true);
    	  		inst.setVisible(true);
    	}
    	refresh();   		

    
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

    	Cliente Cliente=new Cliente();
        
    	Cliente.ID=Integer.parseInt(idField.getText());
        if(apellidosField.getText().length()>=0)
        	Cliente.Apellidos=apellidosField.getText();
        if(nombreField.getText().length()>=0)
        	Cliente.Nombre=nombreField.getText();
        if(direccionField.getText().length()>=0)
        	Cliente.Direccion=direccionField.getText();
        if(dniField.getText().length()>=0)
        	Cliente.DNI=dniField.getText();

   	    if( ! sql.update(Cliente)){
	  		JFrame frame = new JFrame();
	  		MessageGui inst = new MessageGui(frame,this,"error al actualizar el Cliente",false,true);
	  		inst.setVisible(true);

	      }    		
   	    refresh();

    
    }//GEN-LAST:event_saveButtonActionPerformed


    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

        idField.setText("");
        nombreField.setText(""); 
        direccionField.setText(""); 
        apellidosField.setText(""); 
        dniField.setText(""); ;
    	
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosField;
    private javax.swing.JLabel apellidosLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton imprimirButton;
    private javax.swing.JTextField direccionField;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JTextField dniField;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nombreField;
    private JTable jTable1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new ClienteGui());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public void refresh(){

    	Object[] objeto, objeto2;
    	Cliente Cliente= new Cliente();
    	if(filtro){
    		if(idField.getText().length()>0)
    			Cliente.ID=Integer.parseInt(idField.getText());
    		if(nombreField.getText().length()>0)
    			Cliente.Nombre=nombreField.getText();
    		if(apellidosField.getText().length()>0)
    			Cliente.Apellidos=apellidosField.getText();
    		if(direccionField.getText().length()>0)
    			Cliente.Direccion=direccionField.getText();
    		if(dniField.getText().length()>0)
    			Cliente.DNI=dniField.getText();

    		
    	}
    	objeto=sql.find(Cliente,filtro);
    	
    	System.out.print("Objetos encontrados"+objeto.length);
    	
    	Clientes= new Cliente[objeto.length];
    	
    	String [] [] columns =new String[objeto.length][];
    	String [] results;
    	for(int i=0 ; i<objeto.length; i++){
    		
    		Clientes[i] =(Cliente)objeto[i];
    		results =new String[5];
    		results[0]=""+Clientes[i].ID;
    		results[1]=Clientes[i].Apellidos;
    		results[2]=Clientes[i].Direccion;
    		results[3]=Clientes[i].DNI;//
    		results[4]=Clientes[i].Nombre;
				// TODO: handle exception
       		columns[i]= results;
    	}
		TableModel jTable1Model = 
			new DefaultTableModel(
					columns ,
					new String[] { "ID", "Apellidos","Direccion","DNI","Nombre" });
		
		jTable1.setModel(jTable1Model);
    }

    private void imprimirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

    	 int selected = jTable1.getSelectedRows()[0];
	      	
    	 CarnetGui imprimirCarnet= new CarnetGui();
    	  
    	 if (idcodigo!=null){//pasa el id si ha sido llamado desde otra ventana
	        	idcodigo.setCodigo(Integer.parseInt(
	        			idField.getText()),
	        			Clientes[selected].Nombre+"-"+Clientes[selected].Apellidos);
	        }
    	  
    	 imprimirCarnet.jLabel1.setText("Nombre\t\t:"+ Clientes[selected].Nombre);
    	 imprimirCarnet.jLabel2.setText("Apellido\t:"+ Clientes[selected].Apellidos);
    	 imprimirCarnet.jLabel3.setText("Dni\t\t:"+ Clientes[selected].DNI);
    	 imprimirCarnet.jLabel4.setText("Direccion:"+ Clientes[selected].Direccion);
    	 imprimirCarnet.jLabel5.setText("IDCliente:"+ Clientes[selected].ID);
    	 imprimirCarnet.jLabel6.setText("BarCode\t:");

    	 //Imprimir barcode 
	        try {
	        	imprimirCarnet.jLabel7= new ClienteCarnet("*"+Clientes[selected].ID+"*");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
			imprimirCarnet.Imprimir();

    }
    //GEN-LAST:event_refreshButtonActionPerformed
   @Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	      int selected = jTable1.getSelectedRows()[0];
	      	
	  	
	        idField.setText(Clientes[selected].ID+"");
	        apellidosField.setText(Clientes[selected].Apellidos);
	        dniField.setText(Clientes[selected].DNI);
	        nombreField.setText(Clientes[selected].Nombre);
	        direccionField.setText(Clientes[selected].Direccion);
	
	        if (idcodigo!=null){//pasa el id si ha sido llamado desde otra ventana
	        	idcodigo.setCodigo(Integer.parseInt(
	        			idField.getText()),
	        			Clientes[selected].Nombre+"-"+Clientes[selected].Apellidos);
	        }

	}

	/*@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void setOpcion(int opcion) {
		// TODO Auto-generated method stub
//		opcionPulsada=opcion;
	}

	@Override
	public int getOpcion() {
		// TODO Auto-generated method stub
	 	return 0;//opcionPulsada;
	}

	@Override
	public int getIDCodigo() {
		// TODO Auto-generated method stub
		return 0;//GUI_idCatergoria;
	}

	@Override
	public String getIDValor() {
		// TODO Auto-generated method stub
		return  null;//GUI_valorCatergoria;
	}

	@Override
	public void setCodigo(int codigo, String valor) {
		// TODO Auto-generated method stub
	/*	System.out.print("recogo");
		if(valor==null)
		{
			IDCategoriaField.setText("");
		}else
			IDCategoriaField.setText(valor);
		GUI_idCatergoria=codigo;
		GUI_valorCatergoria=valor;
	*/
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	 public int print( Graphics g,PageFormat pf,int pi )throws PrinterException {
		System.out.println( "Imprimiendo");
		if( pi >= 1 ) {
		  return( Printable.NO_SUCH_PAGE );
		  }
		Graphics2D g2 = (Graphics2D)g;
		g2.translate( pf.getImageableX(),pf.getImageableY() );
		Font f = Font.getFont( "Courier" );
		System.out.println( f );
		g2.setFont( f );
		// En este caso, se envía directamente el objeto Graphics2D a
		// la impresora
		paint( g2 );
		return( Printable.PAGE_EXISTS );
	}*/
    
}