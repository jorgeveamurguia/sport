/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame1.java
 *
 * Created on 13-abr-2010, 21:46:26
 */

package jorge.veamurguia.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import jorge.veamurguia.basededatos.GestorSql;


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
public class ConexionGui extends javax.swing.JFrame implements ActionListener{

	GestorSql sql;

    /** Creates new form NewJFrame1 */
    public ConexionGui() {
        initComponents();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        
        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel1.setText("base de datos");
        getContentPane().add(jLabel1);

        getContentPane().add(jTextField1);
        jTextField1.setPreferredSize(new java.awt.Dimension(65, 21));

        jLabel2.setText("login");
        getContentPane().add(jLabel2);

        getContentPane().add(jTextField2);
        jTextField2.setPreferredSize(new java.awt.Dimension(54, 21));

        jLabel3.setText("password");
        getContentPane().add(jLabel3);

        {
        	jTextField3 = new javax.swing.JTextField();
        	getContentPane().add(jTextField3);
        	jTextField3.setPreferredSize(new java.awt.Dimension(79, 21));
        }
        
        {
        	jButton1 = new javax.swing.JButton();
        	getContentPane().add(jButton1);
        	jButton1.setText("aceptar");
        	jButton1.addActionListener(this);

        }
        
        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConexionGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jButton1){
			sql =GestorSql.getInstance();
	    	if(sql!=null){
	    		sql.close();
	    		sql=null;
	    	}

			sql=GestorSql.getInstance(jTextField1.getText(),jTextField2.getText(),jTextField3.getText());
	    	if(sql==null){
	        	JOptionPane.showConfirmDialog(this, 
	        			"No se pudo establecer la conexion con la base de datos", 
	        			"Base de datos",  JOptionPane.CLOSED_OPTION,JOptionPane.QUESTION_MESSAGE);
			}else
			{
	        	JOptionPane.showConfirmDialog(this, 
	        			"conectado a :"+jTextField1.getText(), 
	        			"Base de datos",  JOptionPane.CLOSED_OPTION,JOptionPane.QUESTION_MESSAGE);
				this.dispose();
			}
		}
	}

}
