package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


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

	public JPanel Panel;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Constuctor
	 */
	public ClsIFIntroducirSeries() {
		Inicializar();
	}

	/**
	 * Para inicializar los objetos
	 */
	private void Inicializar() {
		setBounds(158, 81, 175, 38);
		setClosable(true);
		setTitle("Introducir Series");
		getContentPane().setLayout(new GridLayout(3, 2));

		JLabel Texto1 = new JLabel("Numero De Serie:");
		Texto1.setEnabled(false);
		Texto1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Texto1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Texto1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(textField);
		textField.setColumns(5);

		JLabel Texto2 = new JLabel("Descripci\u00F3n:");
		Texto2.setEnabled(false);
		Texto2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Texto2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Texto2);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(textField_1);
		textField_1.setColumns(5);

		JLabel TextoVacio = new JLabel("");
		getContentPane().add(TextoVacio);

		JButton Boton = new JButton("Confirmar Serie");
		Boton.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(Boton);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
