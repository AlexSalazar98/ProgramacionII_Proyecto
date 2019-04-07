package PANTALLA_LP;

import java.awt.EventQueue;

import javax.swing.JFrame;

import LN.ClsGestorLN;
import LP.ClsMenuIntroducirDatos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClsVerPantallaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(ClsGestorLN ObjGestor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsVerPantallaPrincipal window = new ClsVerPantallaPrincipal(ObjGestor);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClsVerPantallaPrincipal(ClsGestorLN ObjGestor) {
		initialize(ObjGestor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ClsGestorLN ObjGestor) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton MenuIntroduccirDatos = new JButton("Menu Introducir Datos\r\n");
		MenuIntroduccirDatos.setBounds(127, 57, 175, 38);
		frame.getContentPane().add(MenuIntroduccirDatos);

		JButton MenuConsultarDatos = new JButton("Menu Consultar Datos");
		MenuConsultarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		MenuConsultarDatos.setBounds(127, 106, 175, 38);
		frame.getContentPane().add(MenuConsultarDatos);

		JButton MenuBorrarDatos = new JButton("Menu Borrar Datos");
		MenuBorrarDatos.setBounds(127, 155, 175, 38);
		frame.getContentPane().add(MenuBorrarDatos);

		JButton Salir = new JButton("Salir");
		Salir.setBounds(127, 204, 175, 38);
		frame.getContentPane().add(Salir);

		class Listener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClsMenuIntroducirDatos.MenuIntroducirDatos(ObjGestor);

			}
		}
		MenuIntroduccirDatos.addActionListener(new Listener());
	}
}
