package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import LN.ClsGestorLN;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta InternalFrame para introducir datos de Series
 *
 */
public class ClsIFIntroducirSeries extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIS;
	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Series";

	/**
	 * Instanciamos objetos
	 */
	public JPanel Panel;
	private JTextField NumeroDeSerie;
	private JTextField Descripción;

	/**
	 * Constuctor
	 */
	public ClsIFIntroducirSeries(ClsGestorLN ObjGestor) {
		Inicializar(ObjGestor);
	}

	/**
	 * Para inicializar los objetos
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {
		objGestorIFIS = ObjGestor;
		setBounds(158, 81, 491, 303);
		setClosable(true);
		setTitle("Introducir Series");
		getContentPane().setLayout(new GridLayout(3, 2));

		JLabel Texto1 = new JLabel("Numero De Serie:");
		Texto1.setEnabled(false);
		Texto1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Texto1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Texto1);

		NumeroDeSerie = new JTextField();
		NumeroDeSerie.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(NumeroDeSerie);
		NumeroDeSerie.setColumns(5);

		JLabel Texto2 = new JLabel("Descripci\u00F3n:");
		Texto2.setBackground(Color.WHITE);
		Texto2.setEnabled(false);
		Texto2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Texto2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Texto2);

		Descripción = new JTextField();
		Descripción.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Descripción);
		Descripción.setColumns(5);

		JLabel TextoVacio = new JLabel("");
		TextoVacio.setBackground(Color.WHITE);
		getContentPane().add(TextoVacio);

		JButton Boton = new JButton("Confirmar Serie");
		Boton.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(Boton);
		Boton.addActionListener(this);
		Boton.setActionCommand(CONFIRMAR_BUTTON);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case CONFIRMAR_BUTTON:
			MandarAlGestor();
			break;

		default:
			break;
		}
	}

	private void MandarAlGestor() {

		int NDS = Integer.parseInt(NumeroDeSerie.getText());
		String Des = Descripción.getText();
		try {
			objGestorIFIS.CrearSerie(NDS, Des);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
