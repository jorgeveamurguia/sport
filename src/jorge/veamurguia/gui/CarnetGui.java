/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AutorGui.java
 *
 * Created on 13-abr-2010, 1:10:35
 */

package jorge.veamurguia.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author jorge
 */
public class CarnetGui extends javax.swing.JFrame implements Printable {

    /** Creates new form AutorGui */
    public CarnetGui( ) {
    	initComponents();
    }
	public void Imprimir(){

			this.setVisible(true);
			PrinterJob printJob = PrinterJob.getPrinterJob();
		    printJob.setPrintable(this);
		    try {
				printJob.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
	        System.out.println( "...");
	}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(10, 0));


        getContentPane().add(jLabel1);


        getContentPane().add(jLabel2);


        getContentPane().add(jLabel3);


        getContentPane().add(jLabel4);


        getContentPane().add(jLabel5);


        getContentPane().add(jLabel6);


        getContentPane().add(jLabel7);
        
        jLabel1.setText("Nombre   :");
		jLabel2.setText("Apellido   :");
		jLabel3.setText("D.n.i.     :");
		jLabel4.setText("Direccion:");
		jLabel5.setText("IDCliente:");
	   	jLabel6.setText("BarCode :");
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	CarnetGui a =new CarnetGui();
            	a.Imprimir();
                a.dispose();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
    
    public int print( Graphics g,PageFormat pf,int pi )throws PrinterException {
		System.out.println( "Imprimiendo");
		if( pi >= 1 ) {
		  return( Printable.NO_SUCH_PAGE );
		  }
		
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.translate( pf.getImageableX(),pf.getImageableY() );
		//Font f = Font.getFont( "Courier" );
		//System.out.println( f );
		//g2.setFont( f );
		// En este caso, se envía directamente el objeto Graphics2D a
		// la impresora
		
		paint( g2);
		return( Printable.PAGE_EXISTS );
	}
    public void paint(Graphics g) {
        
    	System.out.println("paint");
    	 int X = (int)this.getLocation().getX();
    	 int Y = (int)this.getLocation().getY();
    	 int W = (int)this.getSize().getWidth()*2;
    	 int H = (int)this.getSize().getHeight();


   	  g.drawRect(X, Y, W, H);

   	    g.drawString(this.jLabel1.getText(), X+10, Y+15);
   	    g.drawString(this.jLabel2.getText(), X+10, Y+35);
   	    g.drawString(this.jLabel3.getText(), X+10, Y+55);
   	    g.drawString(this.jLabel4.getText(), X+10, Y+75);
   	    g.drawString(this.jLabel5.getText(), X+10, Y+95);
   	    g.drawString(this.jLabel6.getText(), X+10, Y+115);
   	    g.setFont(jLabel7.getFont());
   	    g.drawString(this.jLabel7.getText(), X+40, Y+155);

    }


}
