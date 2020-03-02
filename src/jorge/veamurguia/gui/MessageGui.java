package jorge.veamurguia.gui;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import org.jdesktop.application.Application;

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
public class MessageGui extends javax.swing.JDialog implements ActionListener {
	private JLabel mensaje;
	private JButton bntAceptar;
	private JButton btnCancelar;
	IOpcionPulsada opcionPulsada;

	/**
	* Auto-generated main method to display this JDialog
	*/
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				Message inst = new Message(frame);
				inst.setVisible(true);
			}
		});
	}
	*/
	public MessageGui(JFrame frame,IOpcionPulsada frame2, String texto, boolean cancelar, boolean aceptar) {
		super(frame);
		this.setModal(true);
		initGUI(texto, cancelar, aceptar);
		opcionPulsada=frame2;
		opcionPulsada.setOpcion(IOpcionPulsada.OPCION_PULSADA_CANCELAR);
		//por si el usuario cierra la ventana
	}
	
	private void initGUI(String texto, boolean cancelar, boolean aceptar) {
		try {
			FormLayout thisLayout = new FormLayout(
					"max(p;5dlu), 37dlu, 49dlu, 83dlu", 
					"19dlu, 43dlu, 24dlu, 21dlu");
			getContentPane().setLayout(thisLayout);
			{
				mensaje = new JLabel();
				getContentPane().add(mensaje, new CellConstraints("2, 2, 3, 1, default, default"));
				mensaje.setName(texto);
				Dimension dimen =mensaje.getSize();
				dimen.height=dimen.height*4;
				mensaje.setSize(dimen );
				mensaje.setText(texto);
			}
			{if(aceptar){
				bntAceptar = new JButton();
				getContentPane().add(bntAceptar, new CellConstraints("3, 4, 1, 1, default, default"));
				bntAceptar.addActionListener(this);
				bntAceptar.setName("aceptar");}
			}
			{if(cancelar){
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar, new CellConstraints("4, 4, 1, 1, default, default"));
				btnCancelar.addActionListener(this);
				btnCancelar.setName("cancelar");}
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
        if (evt.getSource() == bntAceptar) {
        	opcionPulsada.setOpcion(IOpcionPulsada.OPCION_PULSADA_ACEPTAR);
        }
        this.dispose();

	}

}
