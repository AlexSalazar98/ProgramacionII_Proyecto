package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import LN.ClsGestorLN;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Comparadores_y_Comprobadores.ClsComprobarDNI_NIF;
import Excepciones.ClsDNI_NIFValidoExcepcion;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Clase InternalFrame para introducir Clientes
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsIFIntroducirClientes extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIC;
	/**
	 * Objetos para la pantalla
	 */
	private JTextField RecogerNCliente;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel TxtDatos;
	private JLabel Vacio2;
	private JLabel Vacio3;
	private JLabel Vacio4;
	private JLabel TxtNYA;
	private JTextField RecogerNYA;
	private JLabel TxtDNINIF;
	private JTextField RecogerDNINIF;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JLabel TxtEstancia;
	private JLabel Vacio5;
	private JLabel Vacio6;
	private JLabel Vacio7;
	private JLabel TxtDireccion;
	private JTextField RecogerDireccion;
	private JLabel TxtProvincia;
	private JTextField RecogerProvincia;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JLabel TextOtrosDatos;
	private JLabel Vacio8;
	private JLabel Vacio9;
	private JLabel Vacio10;
	private JLabel TxtTelefono;
	private JTextField RecogerTel;
	private JLabel TxtEmail;
	private JTextField RecogerEmail;
	private JLabel Vacio11;
	private JLabel Vacio12;
	private JLabel Vacio13;
	private JButton BotonConfirmar;
	/**
	 * constante para el boton confirmar
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Cliente";
	private JLabel Vacio;
	private JLabel Vacio1;

	/**
	 * constructor
	 * 
	 * @param objGestor recive el gestor
	 */
	public ClsIFIntroducirClientes(ClsGestorLN objGestor) {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Insertar Clientes");
		this.setBounds(200, 300, 460, 348);
		getContentPane().setLayout(new GridLayout(11, 4));
		Inicializar(objGestor);
	}

	/**
	 * metodo para inicializar objetos
	 * 
	 * @param ObjGestor recive el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {
		JLabel TxtNCliente = new JLabel("N\u00FAmero de Cliente:");
		TxtNCliente.setEnabled(false);
		TxtNCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNCliente.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtNCliente);

		RecogerNCliente = new JTextField();
		RecogerNCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerNCliente.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(RecogerNCliente);
		RecogerNCliente.setColumns(10);

		Vacio = new JLabel("");
		Vacio.setEnabled(false);
		getContentPane().add(Vacio);

		Vacio1 = new JLabel("");
		getContentPane().add(Vacio1);

		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		getContentPane().add(separator);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		getContentPane().add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		getContentPane().add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		getContentPane().add(separator_3);

		TxtDatos = new JLabel("Datos Personales:");
		TxtDatos.setEnabled(false);
		TxtDatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtDatos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtDatos);

		Vacio2 = new JLabel("");
		Vacio2.setEnabled(false);
		getContentPane().add(Vacio2);

		Vacio3 = new JLabel("");
		Vacio3.setEnabled(false);
		getContentPane().add(Vacio3);

		Vacio4 = new JLabel("");
		Vacio4.setEnabled(false);
		getContentPane().add(Vacio4);

		TxtNYA = new JLabel("Nombre y Apellidos: ");
		TxtNYA.setEnabled(false);
		TxtNYA.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNYA.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtNYA);

		RecogerNYA = new JTextField();
		RecogerNYA.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNYA.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerNYA);
		RecogerNYA.setColumns(10);

		TxtDNINIF = new JLabel("DNI o NIF:");
		TxtDNINIF.setEnabled(false);
		TxtDNINIF.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDNINIF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtDNINIF);

		RecogerDNINIF = new JTextField();
		RecogerDNINIF.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerDNINIF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(RecogerDNINIF);
		RecogerDNINIF.setColumns(10);

		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		getContentPane().add(separator_4);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		getContentPane().add(separator_5);

		separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		getContentPane().add(separator_6);

		separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		getContentPane().add(separator_7);

		TxtEstancia = new JLabel("Estancia del Cliente:");
		TxtEstancia.setHorizontalAlignment(SwingConstants.CENTER);
		TxtEstancia.setEnabled(false);
		TxtEstancia.setFont(new Font("Tahoma", Font.BOLD, 25));
		getContentPane().add(TxtEstancia);

		Vacio5 = new JLabel("");
		Vacio5.setEnabled(false);
		getContentPane().add(Vacio5);

		Vacio6 = new JLabel("");
		Vacio6.setEnabled(false);
		getContentPane().add(Vacio6);

		Vacio7 = new JLabel("");
		Vacio7.setEnabled(false);
		getContentPane().add(Vacio7);

		TxtDireccion = new JLabel("Direcci\u00F3n: ");
		TxtDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		TxtDireccion.setEnabled(false);
		getContentPane().add(TxtDireccion);

		RecogerDireccion = new JTextField();
		RecogerDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(RecogerDireccion);
		RecogerDireccion.setColumns(10);

		TxtProvincia = new JLabel("Provincia:");
		TxtProvincia.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		TxtProvincia.setEnabled(false);
		getContentPane().add(TxtProvincia);

		RecogerProvincia = new JTextField();
		RecogerProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerProvincia.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerProvincia);
		RecogerProvincia.setColumns(10);

		separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		getContentPane().add(separator_8);

		separator_9 = new JSeparator();
		separator_9.setForeground(Color.BLACK);
		getContentPane().add(separator_9);

		separator_10 = new JSeparator();
		separator_10.setForeground(Color.BLACK);
		getContentPane().add(separator_10);

		separator_11 = new JSeparator();
		separator_11.setForeground(Color.BLACK);
		getContentPane().add(separator_11);

		TextOtrosDatos = new JLabel("Otros Datos:");
		TextOtrosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		TextOtrosDatos.setEnabled(false);
		TextOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		getContentPane().add(TextOtrosDatos);

		Vacio8 = new JLabel("");
		Vacio8.setEnabled(false);
		getContentPane().add(Vacio8);

		Vacio9 = new JLabel("");
		Vacio9.setEnabled(false);
		getContentPane().add(Vacio9);

		Vacio10 = new JLabel("");
		Vacio10.setEnabled(false);
		getContentPane().add(Vacio10);

		TxtTelefono = new JLabel("Tel\u00E9fono:");
		TxtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtTelefono.setEnabled(false);
		getContentPane().add(TxtTelefono);

		RecogerTel = new JTextField();
		RecogerTel.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerTel);
		RecogerTel.setColumns(10);

		TxtEmail = new JLabel("Email:");
		TxtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		TxtEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtEmail.setEnabled(false);
		getContentPane().add(TxtEmail);

		RecogerEmail = new JTextField();
		RecogerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerEmail);
		RecogerEmail.setColumns(10);

		Vacio11 = new JLabel("");
		Vacio11.setEnabled(false);
		getContentPane().add(Vacio11);

		Vacio12 = new JLabel("");
		Vacio12.setEnabled(false);
		getContentPane().add(Vacio12);

		Vacio13 = new JLabel("");
		Vacio13.setEnabled(false);
		getContentPane().add(Vacio13);

		BotonConfirmar = new JButton("Confirmar Cliente");
		BotonConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(BotonConfirmar);
		BotonConfirmar.addActionListener(this);
		BotonConfirmar.setActionCommand(CONFIRMAR_BUTTON);

		/**
		 * copiamos el objeto gestor
		 */
		objGestorIFIC = ObjGestor;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean correcto = false;
		String DNI_NIF = RecogerDNINIF.getText().toUpperCase();
		ClsComprobarDNI_NIF objComprobarDNI_NIF = new ClsComprobarDNI_NIF();

		switch (e.getActionCommand()) {
		case CONFIRMAR_BUTTON:
			do {

				try {
					correcto = objComprobarDNI_NIF.ComprobarDNI_NIF(DNI_NIF);

				} catch (ClsDNI_NIFValidoExcepcion a) {
					RecogerDNINIF.setText("");
					correcto = false;
					/**
					 * Mensaje de excepcion
					 */
					JOptionPane.showMessageDialog(null, a.getMessage());
				}
			} while (!correcto && RecogerDNINIF.getText() == "");
			if (correcto && RecogerDNINIF.getText() != null) {
				MandarAGestor();
				PonerVacio();
			}
			break;

		default:
			break;
		}
	}

	/**
	 * Metodo para mandar la infor al Gestor
	 */
	private void MandarAGestor() {

		/**
		 * Variables para recoger infor y mandarla al gestor
		 */
		int NCliente = Integer.parseInt(RecogerNCliente.getText());
		int NumTel = Integer.parseInt(RecogerTel.getText());
		String NomYAp = RecogerNYA.getText();
		String DNI_NIF = RecogerDNINIF.getText();
		String Provincia = RecogerProvincia.getText();
		String Email = RecogerEmail.getText();
		String Direccion = RecogerDireccion.getText();

		try {
			if (objGestorIFIC.CrearClientes(NCliente, NomYAp, DNI_NIF, Direccion, Provincia, NumTel, Email)) {
				JOptionPane.showMessageDialog(null, "Cliente introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "DNI o NIF del Cliente repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}
	}

	/**
	 * Metodo para poner vacios los cuadros de insertar.
	 */
	private void PonerVacio() {

		/**
		 * recuadros a poner vacios
		 */
		RecogerNCliente.setText("");
		RecogerTel.setText("");
		RecogerNYA.setText("");
		RecogerDNINIF.setText("");
		RecogerProvincia.setText("");
		RecogerEmail.setText("");
		RecogerDireccion.setText("");
	}
}
