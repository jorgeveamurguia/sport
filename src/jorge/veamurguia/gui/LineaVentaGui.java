/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LineaVentaGui.java
 *
 * Created on 11-abr-2010, 12:57:34
 */

package jorge.veamurguia.gui;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jorge.veamurguia.basededatos.GestorSql;
import jorge.veamurguia.entidad.Articulo;
import jorge.veamurguia.entidad.LineaVenta;
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
public class LineaVentaGui extends JPanel implements IIDCodigo, MouseListener ,IOpcionPulsada {

	int opcionPulsada=-1;
	boolean filtro=false;
	
	IIDFiltroVenta ventafiltrada=null;
	boolean filtroVenta=false;
	
	//parametro recogido de la pantalla de categoria
	int GUI_idVenta=-1;
	String GUI_valorVenta=null;
	
	int GUI_idArticulo=-1;
	String GUI_valorArticulo=null;

	int ventanaLlamada=0;
	final int ventanaArticulo=1;
	final int ventanaVenta=2;

	
	
	GestorSql sql;

	LineaVenta[] lineaVentas;
	//"ID", "ID_Venta","ID_Articulo","Precio","Cantidad","Descuento","Impuesto","Total" 	
	final int ID_POSITION=0;
	final int VENTA_POSITION=1;
	final int ARTICULO_POSITION=2;
	final int PRECIO_POSITION=3;
	final int CANTIDAD_POSITION=4;	
	final int DESCUENTO_POSITION=5;	
	final int IMPUESTO_POSITION=6;	
	final int TOTAL_POSITION=7;	
	
	
	
    public LineaVentaGui() {
        initComponents();

        sql =GestorSql.getInstance();
		refresh();
    }
    
    public LineaVentaGui(IIDFiltroVenta codigo) {
    	filtroVenta=true;
    	ventafiltrada=codigo;
    	initComponents();

        sql =GestorSql.getInstance();
		refresh();
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        IDVentaLabel = new javax.swing.JLabel();
        IDArticuloLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        cantidadLabel = new javax.swing.JLabel();
        descuentoLabel = new javax.swing.JLabel();
        impuestoLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        IDVentaField = new javax.swing.JTextField();
        IDArticuloField = new javax.swing.JTextField();
        precioField = new javax.swing.JTextField();
        cantidadField = new javax.swing.JTextField();
        descuentoField = new javax.swing.JTextField();
        impuestoField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        findButton = new javax.swing.JButton();
        findButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();


        masterScrollPane.setViewportView(jTable1);

        idLabel.setText("Id:");

        IDVentaLabel.setText("IDVenta:");

        IDArticuloLabel.setText("IDArticulo:");

        precioLabel.setText("Precio:");

        cantidadLabel.setText("Cantidad:");

        descuentoLabel.setText("Descuento:");

        impuestoLabel.setText("Impuesto:");


        saveButton.setText("Salvar");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Recarga");
        refreshButton.addActionListener(formListener);

        newButton.setText("Añadir");
        newButton.addActionListener(formListener);

        deleteButton.setText("Borrar");


        deleteButton.addActionListener(formListener);

        clearButton.setText("limpiar");
        clearButton.addActionListener(formListener);

        jCheckBox1.setText("Filtrar");
        jCheckBox1.addActionListener(formListener);

        if(filtroVenta){
        	findButton.setEnabled(false);	
        	IDVentaField.setEditable(false);
        	IDVentaField.setText(ventafiltrada.getIDVenta()+"");
        }
        findButton.setText("Seleccionar");
        findButton.addActionListener(formListener);

        findButton1.setText("Seleccionar");
        findButton1.addActionListener(formListener);

        jTable1.addMouseListener(this);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(idLabel)
                    .addComponent(IDVentaLabel)
                    .addComponent(IDArticuloLabel)
                    .addComponent(precioLabel)
                    .addComponent(cantidadLabel)
                    .addComponent(descuentoLabel)
                    .addComponent(impuestoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidadField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(descuentoField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(impuestoField, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(precioField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IDVentaField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDArticuloField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(findButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDVentaLabel)
                    .addComponent(IDVentaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDArticuloLabel)
                    .addComponent(IDArticuloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioLabel)
                    .addComponent(precioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadLabel)
                    .addComponent(cantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descuentoLabel)
                    .addComponent(descuentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(impuestoLabel)
                    .addComponent(impuestoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(jCheckBox1)
                    .addComponent(clearButton))
                .addContainerGap())
        );

    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                LineaVentaGui.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                LineaVentaGui.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                LineaVentaGui.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                LineaVentaGui.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == clearButton) {
                LineaVentaGui.this.clearButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jCheckBox1) {
                LineaVentaGui.this.jCheckBox1ActionPerformed(evt);
            }
            else if (evt.getSource() == findButton) {
                LineaVentaGui.this.findButtonActionPerformed(evt);
            }
            else if (evt.getSource() == findButton1) {
                LineaVentaGui.this.findButton1ActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    public void refresh(){

	    Float total,precio,descuento,sumatorioTotal=new Float(0);	

    	Object[] objeto, objeto2;
    	LineaVenta lineaVenta= new LineaVenta();

    	if(filtroVenta && ventafiltrada!=null){
        	lineaVenta.ID_Venta=new Venta();
        	lineaVenta.ID_Venta.ID=ventafiltrada.getIDVenta();
        	IDVentaField.setText(ventafiltrada.getIDVenta()+"");
        	GUI_idVenta=ventafiltrada.getIDVenta();
    	}

    	if(filtro){
    		if(idField.getText().length()>0)
    			lineaVenta.ID=Integer.parseInt(idField.getText());
    		/*if(Field.getText().length()>0)
    			articulo.Articulo=articuloField.getText();
    		if(codigoField.getText().length()>0)
        		articulo.Codigo=codigoField.getText();
    		if(GUI_idCatergoria!=-1){
        		articulo.ID_Categoria=new Categoria();
        		articulo.ID_Categoria.ID=GUI_idCatergoria;
    		}
    	*/	
    	}
    	objeto=sql.find(lineaVenta,filtro);
    	
    	System.out.print("Objetos encontrados"+objeto.length);
    	
    	lineaVentas= new LineaVenta[objeto.length];
    	
    	String [] [] columns =new String[objeto.length][];
    	String [] results;
    	for(int i=0 ; i<objeto.length; i++){
    		
    		lineaVentas[i] =(LineaVenta)objeto[i];
    		results =new String[8];
    		results[ID_POSITION]=""+lineaVentas[i].ID;
    		{
    			objeto2=sql.find(lineaVentas[i].ID_Venta,false);
    			lineaVentas[i].ID_Venta=(Venta)objeto2[0];
    			results[VENTA_POSITION]=lineaVentas[i].ID_Venta.ID+"";//
    		}
    		{
    			objeto2=sql.find(lineaVentas[i].ID_Articulo,false);
    			lineaVentas[i].ID_Articulo=(Articulo)objeto2[0];
    			results[ARTICULO_POSITION]=lineaVentas[i].ID_Articulo.Articulo;//
    		}

    		//results[3]=articulo.ID_Categoria.Categoria;//
    		results[CANTIDAD_POSITION]=lineaVentas[i].Cantidad+"";
    		results[DESCUENTO_POSITION]=lineaVentas[i].Descuento+"";
    		results[IMPUESTO_POSITION]=lineaVentas[i].Impuesto+"";
    		results[PRECIO_POSITION]=lineaVentas[i].Precio+"";
    		if(lineaVentas[i].Descuento!=null & lineaVentas[i].Descuento.compareTo(new Float(0))!=0){
    			precio=lineaVentas[i].Cantidad*
	    			lineaVentas[i].Precio*
	    			(1+(lineaVentas[i].Impuesto/100));
    			
    			descuento=precio*lineaVentas[i].Descuento/100;
    			total=precio-descuento;

    		}else{//sin descuento
    			total=lineaVentas[i].Cantidad*lineaVentas[i].Precio*(1+(lineaVentas[i].Impuesto/100));
    		}
    		sumatorioTotal+= total;
    		results[TOTAL_POSITION]=""+total;
    		
    		// TODO: handle exception
       		columns[i]= results;
    	}
    	if(filtroVenta && ventafiltrada!=null){
    		ventafiltrada.getPrecioTotal(sumatorioTotal);
    	}
    	//}
    	//results =new String[2];
    	//results[0]="dato1";
    	//results=new String[] { "dato1", "dato2" };
    	
    	//columns[0]=results;
		TableModel jTable1Model = 
			new DefaultTableModel(
					//new String[][] { { "dato1", "dato2" }, { "dato21", "dato22" } },
					columns ,
					new String[] { "ID", "ID_Venta","ID_Articulo","Precio","Cantidad","Descuento","Impuesto","Total" });
		jTable1.setModel(jTable1Model);
    }
   
    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
    	refresh();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
//puedo borrar lo que quiera
    	
    	int selected = jTable1.getSelectedRows()[0];

        LineaVenta lineaVenta=lineaVentas[selected];
        
       	sql.borrar(lineaVenta);
       	refresh();
 
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed

        
    	LineaVenta lineaVenta=new LineaVenta();
    	try {
    		if(idField.getText().length()>0)
    			lineaVenta.ID=Integer.parseInt(idField.getText());


    		lineaVenta.Cantidad=Integer.valueOf(cantidadField.getText());
    		lineaVenta.Precio=Float.valueOf(precioField.getText());
    		lineaVenta.Impuesto=Float.valueOf(impuestoField.getText());
    		lineaVenta.Descuento=Float.valueOf(descuentoField.getText());

    		
    		lineaVenta.ID_Articulo=new Articulo();
    		lineaVenta.ID_Articulo.ID=GUI_idArticulo;

    		lineaVenta.ID_Venta=new Venta();
    		lineaVenta.ID_Venta.ID=GUI_idVenta;

    		
    		

        if( ! sql.crear(lineaVenta)){
      		
      		MessageGui inst = new MessageGui(new JFrame(),this,"No es un codigo numero válido el ID",false,true);
      		inst.setVisible(true);
          }
    	}catch(NumberFormatException ex){
    	 //   if( ! sql.crear(articulo)){
    	  		JFrame frame = new JFrame();
    	  		MessageGui inst = new MessageGui(frame,this,"error al crear la linea venta",false,true);
    	  		inst.setVisible(true);

    	  //    }    		
    	}
    	refresh();   		

    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
    	LineaVenta lineaVenta=new LineaVenta();
    	try {
    		lineaVenta.ID=Integer.parseInt(idField.getText());


    		lineaVenta.Cantidad=Integer.valueOf(cantidadField.getText());
    		lineaVenta.Precio=Float.valueOf(precioField.getText());
    		lineaVenta.Impuesto=Float.valueOf(impuestoField.getText());
    		lineaVenta.Descuento=Float.valueOf(descuentoField.getText());
    		
    		lineaVenta.ID_Articulo=new Articulo();
    		lineaVenta.ID_Articulo.ID=GUI_idArticulo;

    		lineaVenta.ID_Venta=new Venta();
    		lineaVenta.ID_Venta.ID=GUI_idVenta;
    		

        if( ! sql.update(lineaVenta)){
      		
      		MessageGui inst = new MessageGui(new JFrame(),this,"No es un codigo numero válido el ID",false,true);
      		inst.setVisible(true);
          }
    	}catch(NumberFormatException ex){
    	 //   if( ! sql.crear(articulo)){
    	  		JFrame frame = new JFrame();
    	  		MessageGui inst = new MessageGui(frame,this,"error al actualizar la linea venta",false,true);
    	  		inst.setVisible(true);

    	  //    }    		
    	}
    	refresh();   		

    }//GEN-LAST:event_saveButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

    
    	idField.setText("");

    	descuentoField.setText("");
    	cantidadField.setText("");
    	impuestoField.setText("");
        precioField.setText("");
        
        
        GUI_idArticulo=-1;//null;//ventas[selected].ID_Cliente.ID;
        GUI_valorArticulo=null;
        IDArticuloField.setText("");
        
        GUI_idVenta=-1;
        GUI_valorVenta=null;

        IDVentaField.setText("");


    }//GEN-LAST:event_clearButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    	filtro=!filtro;
    	refresh();

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
    	
    	ventanaLlamada=ventanaVenta;
    	
		final IIDCodigo codigo=this;
        
        Runnable otroHilo=new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new VentaGui(codigo));
                frame.pack();
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(otroHilo);

    }//GEN-LAST:event_findButtonActionPerformed

    private void findButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButton1ActionPerformed
    	
    	ventanaLlamada=ventanaArticulo; 
    	
		final IIDCodigo codigo=this;
        
        Runnable otroHilo=new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new ArticuloGui(codigo));
                frame.pack();
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(otroHilo);
    }//GEN-LAST:event_findButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDArticuloField;
    private javax.swing.JLabel IDArticuloLabel;
    private javax.swing.JTextField IDVentaField;
    private javax.swing.JLabel IDVentaLabel;
    private javax.swing.JTextField cantidadField;
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descuentoField;
    private javax.swing.JLabel descuentoLabel;
    private javax.swing.JButton findButton;
    private javax.swing.JButton findButton1;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField impuestoField;
    private javax.swing.JLabel impuestoLabel;
    private JTable jTable1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane masterScrollPane;
    //private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField precioField;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new LineaVentaGui());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

	@Override
	public int getIDCodigo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getIDValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCodigo(int codigo, String valor) {
		
        GUI_idArticulo=codigo;
        GUI_valorArticulo=valor;
        IDArticuloField.setText(GUI_valorArticulo);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	

		int selected = jTable1.getSelectedRows()[0];

        GUI_idVenta=lineaVentas[selected].ID_Venta.ID;
        GUI_valorVenta=lineaVentas[selected].ID_Venta.ID+"";
        
        GUI_idArticulo=lineaVentas[selected].ID_Articulo.ID;
        GUI_valorArticulo=lineaVentas[selected].ID_Articulo.Articulo;

        idField.setText(lineaVentas[selected].ID+"");
        IDVentaField.setText(GUI_valorVenta);	        
        
        IDArticuloField.setText(GUI_valorArticulo);
        
        precioField.setText(lineaVentas[selected].Precio+"");
        cantidadField.setText(lineaVentas[selected].Cantidad +"");
        descuentoField.setText(lineaVentas[selected].Descuento+"");
        impuestoField.setText(lineaVentas[selected].Impuesto+"");
	        

	}

	@Override
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
		
	}

	@Override
	public int getOpcion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOpcion(int opcion) {
		// TODO Auto-generated method stub
		
	}

}