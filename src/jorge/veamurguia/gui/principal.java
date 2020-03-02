package jorge.veamurguia.gui;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import jorge.veamurguia.basededatos.CrearBaseDatos;
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
public class principal extends javax.swing.JFrame implements MouseListener{
	
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuCategoria;
	private JMenuItem jMenuArticulo;
	private JMenuItem jMenuPersonal;
	private JMenuItem jMenuCliente;
	private JMenuItem jMenuVenta;
	
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuItem jMenuHacerCopia;
	private JMenuItem jMenuRestaurar;
	private JMenuItem jMenuAcercaDe;
	private JMenuItem jMenuNuevaBaseDeDatos;
	
	JFileChooser filechooser;
	private JMenuItem jMenuBaseDeDatos;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {

		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				principal inst = new principal();
				inst.setLocationRelativeTo(null);
				inst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				inst.setVisible(true);
			}
		});
	}
	
	public principal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Gestion de datos");
					{
						jMenuCliente = new JMenuItem();
						jMenu1.add(jMenuCliente);
						jMenuCliente.setText("Cliente");
						jMenuCliente.addMouseListener(this);
					}
					{
						jMenuPersonal = new JMenuItem();
						jMenu1.add(jMenuPersonal);
						jMenuPersonal.setText("Personal");
						jMenuPersonal.addMouseListener(this);

					}
					{
						jMenuArticulo = new JMenuItem();
						jMenu1.add(jMenuArticulo);
						jMenuArticulo.setText("Articulos");
						jMenuArticulo.addMouseListener(this);
					}
					{
						jMenuCategoria = new JMenuItem();
						jMenu1.add(jMenuCategoria);
						jMenuCategoria.setText("Categoria");
						jMenuCategoria.addMouseListener(this);

					}
					{
						jMenuVenta = new JMenuItem();
						jMenu1.add(jMenuVenta);
						jMenuVenta.setText("Venta");
						jMenuVenta.addMouseListener(this);

					}
					/*{
						jMenuLineaVenta = new JMenuItem();
						jMenu1.add(jMenuLineaVenta);
						jMenuLineaVenta.setText("Linea - Venta");
						jMenuLineaVenta.addMouseListener(this);

					}*/

					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("Herramientas");
					{
					    jMenuHacerCopia = new JMenuItem();
						jMenu2.add(jMenuHacerCopia);
						jMenuHacerCopia.setText("Copia de seguridad");
						jMenuHacerCopia.addMouseListener(this);

					}
					{
						jMenuRestaurar = new JMenuItem();
						jMenu2.add(jMenuRestaurar);
						jMenuRestaurar.setText("Restaurar copia de seguridad");
						jMenuRestaurar.addMouseListener(this);

					}
					{
						jMenuBaseDeDatos = new JMenuItem();
						jMenu2.add(jMenuBaseDeDatos);
						jMenuBaseDeDatos.setText("Seleccionar la base de datos");
						jMenuBaseDeDatos.addMouseListener(this);

					}
					{
						jMenuNuevaBaseDeDatos = new JMenuItem();
						jMenu2.add(jMenuNuevaBaseDeDatos );
						jMenuNuevaBaseDeDatos.setText("Nueva base de datos");
						jMenuNuevaBaseDeDatos.addMouseListener(this);

					}
					{
						jMenuAcercaDe = new JMenuItem();
						jMenu2.add(jMenuAcercaDe);
						jMenuAcercaDe.setText("Ayuda");
						jMenuAcercaDe.addMouseListener(this);

					}

				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.print("1"+arg0.getSource().toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.print("3"+arg0.getSource().toString());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.print("4"+arg0.getSource().toString());
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.print("5"+arg0.getSource());

		if(arg0.getSource()==jMenuArticulo){
	        EventQueue.invokeLater(new Runnable() {
	        public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new ArticuloGui());
                frame.pack();
                frame.setVisible(true);
            	}
	        });
		}else if(arg0.getSource()==jMenuCliente){
	        EventQueue.invokeLater(new Runnable() {
		        public void run() {
	                JFrame frame = new JFrame();
	                frame.setContentPane(new ClienteGui());
	                frame.pack();
	                frame.setVisible(true);
	            	}
		        });
		}else if(arg0.getSource()==jMenuCategoria){
	        EventQueue.invokeLater(new Runnable() {
		        public void run() {
	                JFrame frame = new JFrame();
	                frame.setContentPane(new CategoriaGui());
	                frame.pack();
	                frame.setVisible(true);
	            	}
		        });
		}else if(arg0.getSource()==jMenuPersonal){
	        EventQueue.invokeLater(new Runnable() {
		        public void run() {
	                JFrame frame = new JFrame();
	                frame.setContentPane(new PersonalGui());
	                frame.pack();
	                frame.setVisible(true);
	            	}
		        });
		}else if(arg0.getSource()==jMenuVenta){
	        EventQueue.invokeLater(new Runnable() {
		        public void run() {
	                JFrame frame = new JFrame();
	                frame.setContentPane(new VentaGui());
	                frame.pack();
	                frame.setVisible(true);
	            	}
		        });
		}else if(arg0.getSource()==jMenuBaseDeDatos){
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new ConexionGui().setVisible(true);
	            }
	        });
		}else if(arg0.getSource()==jMenuBaseDeDatos){

	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new ConexionGui().setVisible(true);
	            }
	        });
			
		}else if(arg0.getSource()==jMenuNuevaBaseDeDatos){

			GestorSql sql=GestorSql.getInstance();
			//sql =GestorSql.getInstance("mysql", "root", "");
			String nombre=JOptionPane.showInputDialog(this, "nombre de la base de datos");
			sql.crearSchema(nombre);
			sql.close();
			//sql =GestorSql.getInstance("prueba3", "root", "");

		}else if(arg0.getSource()==jMenuAcercaDe){
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new AutorGui().setVisible(true);
	            }
	        });
		}else if(arg0.getSource()==jMenuRestaurar){
			
			//String nombre=JOptionPane.showInputDialog(this, "nombre de la base de datos");

			filechooser = new JFileChooser();

			int returnVal = filechooser.showOpenDialog(this);
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	File file =filechooser.getSelectedFile();
		    	CrearBaseDatos basededatos=new CrearBaseDatos();
		    	basededatos.restore(file);
		    	JOptionPane.showMessageDialog(this, "Base de datos restaurada");

		    }
		}else if(arg0.getSource()==jMenuHacerCopia){

			filechooser = new JFileChooser();
			int returnVal = filechooser.showSaveDialog(this);

		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	File file =filechooser.getSelectedFile();
		    	CrearBaseDatos basededatos=new CrearBaseDatos();
		    	basededatos.backup(file);
		    	JOptionPane.showMessageDialog(this, "Copia de seguridad realizada");
		    	
		    }

		}		

		
	}
	


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.print("6"+arg0.getSource().toString());
		
	}

}
