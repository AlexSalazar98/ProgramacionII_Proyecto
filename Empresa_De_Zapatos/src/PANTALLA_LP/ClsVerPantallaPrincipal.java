package PANTALLA_LP;

import java.awt.EventQueue;
import javax.swing.JFrame;
import LN.ClsGestorLN;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ClsVerPantallaPrincipal extends JFrame implements ActionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
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
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Menu Principal");

		JButton MenuIntroduccirDatos = new JButton("Menu Introducir Datos\r\n");

		JButton MenuConsultarDatos = new JButton("Menu Consultar Datos");
		MenuConsultarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton MenuBorrarDatos = new JButton("Menu Borrar Datos");

		JButton Salir = new JButton("Salir");

		JLabel Bienvenido = new JLabel("\u00A1Bienvenido!");
		Bienvenido.setEnabled(false);
		Bienvenido.setFont(new Font("Arial Black", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(149)
					.addComponent(Bienvenido, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(MenuIntroduccirDatos, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(MenuConsultarDatos, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(MenuBorrarDatos, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(Salir, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(Bienvenido)
					.addGap(11)
					.addComponent(MenuIntroduccirDatos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(MenuConsultarDatos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(MenuBorrarDatos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(Salir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		frame.getContentPane().setLayout(groupLayout);

		Salir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println(e.);
		
	}
}
