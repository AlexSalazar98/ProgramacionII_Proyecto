package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import LN.ClsGestorLN;
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
import javax.swing.ImageIcon;

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
	private JLabel TxtNYA;
	private JTextField RecogerNYA;
	private JLabel TxtDNINIF;
	private JTextField RecogerDNINIF;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JLabel TxtEstancia;
	private JLabel TxtDireccion;
	private JTextField RecogerDireccion;
	private JLabel TxtProvincia;
	private JTextField RecogerProvincia;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JLabel TextOtrosDatos;
	private JLabel TxtTelefono;
	private JTextField RecogerTel;
	private JLabel TxtEmail;
	private JTextField RecogerEmail;
	private JButton BotonConfirmar;
	private int NCliente;
	private int  NumTel;
	/**
	 * constante para el boton confirmar
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Cliente";
	private JSeparator separator_12;
	private JSeparator separator_13;
	private JSeparator separator_14;
	private JLabel TxtInfo;

	/**
	 * constructor
	 * 
	 * @param objGestor recive el gestor
	 */
	public ClsIFIntroducirClientes(ClsGestorLN objGestor) {
		setFrameIcon(new ImageIcon(ClsIFIntroducirClientes.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setResizable(false);
		setMaximizable(false);
		setIconifiable(true);
		setClosable(true);
		setTitle("Insertar Clientes");
		getContentPane().setLayout(null);
		this.setBounds(100, 100, 530, 520);
		Inicializar(objGestor);
	}

	/**
	 * metodo para inicializar objetos
	 * 
	 * @param ObjGestor recive el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		JLabel TxtNCliente = new JLabel("  N\u00FAmero de Cliente*:");
		TxtNCliente.setBounds(0, 5, 191, 28);
		TxtNCliente.setEnabled(false);
		TxtNCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNCliente.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(TxtNCliente);

		RecogerNCliente = new JTextField();
		RecogerNCliente.setBounds(172, 6, 111, 28);
		RecogerNCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerNCliente.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(RecogerNCliente);
		RecogerNCliente.setColumns(10);

		separator = new JSeparator();
		separator.setBounds(0, 46, 111, 28);
		separator.setForeground(Color.BLACK);
		getContentPane().add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(111, 46, 111, 28);
		separator_1.setForeground(Color.BLACK);
		getContentPane().add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(222, 46, 111, 28);
		separator_2.setForeground(Color.BLACK);
		getContentPane().add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(333, 46, 111, 28);
		separator_3.setForeground(Color.BLACK);
		getContentPane().add(separator_3);

		TxtDatos = new JLabel(" Datos Personales:");
		TxtDatos.setBounds(0, 72, 333, 28);
		TxtDatos.setEnabled(false);
		TxtDatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtDatos.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(TxtDatos);

		TxtNYA = new JLabel("Nombre y Apellidos*: ");
		TxtNYA.setBounds(0, 111, 181, 28);
		TxtNYA.setEnabled(false);
		TxtNYA.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNYA.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtNYA);

		RecogerNYA = new JTextField();
		RecogerNYA.setBounds(172, 112, 111, 28);
		RecogerNYA.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNYA.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerNYA);
		RecogerNYA.setColumns(10);

		TxtDNINIF = new JLabel("DNI o NIF*:");
		TxtDNINIF.setBounds(278, 111, 111, 28);
		TxtDNINIF.setEnabled(false);
		TxtDNINIF.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDNINIF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtDNINIF);

		RecogerDNINIF = new JTextField();
		RecogerDNINIF.setBounds(388, 112, 111, 28);
		RecogerDNINIF.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerDNINIF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(RecogerDNINIF);
		RecogerDNINIF.setColumns(10);

		separator_4 = new JSeparator();
		separator_4.setBounds(0, 168, 111, 28);
		separator_4.setForeground(Color.BLACK);
		getContentPane().add(separator_4);

		separator_5 = new JSeparator();
		separator_5.setBounds(111, 168, 111, 28);
		separator_5.setForeground(Color.BLACK);
		getContentPane().add(separator_5);

		separator_6 = new JSeparator();
		separator_6.setBounds(222, 168, 111, 28);
		separator_6.setForeground(Color.BLACK);
		getContentPane().add(separator_6);

		separator_7 = new JSeparator();
		separator_7.setBounds(333, 168, 111, 28);
		separator_7.setForeground(Color.BLACK);
		getContentPane().add(separator_7);

		TxtEstancia = new JLabel(" Estancia del Cliente:");
		TxtEstancia.setBounds(0, 207, 333, 28);
		TxtEstancia.setHorizontalAlignment(SwingConstants.LEFT);
		TxtEstancia.setEnabled(false);
		TxtEstancia.setFont(new Font("Tahoma", Font.BOLD, 25));
		getContentPane().add(TxtEstancia);

		TxtDireccion = new JLabel("Direcci\u00F3n*: ");
		TxtDireccion.setBounds(0, 246, 111, 28);
		TxtDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		TxtDireccion.setEnabled(false);
		getContentPane().add(TxtDireccion);

		RecogerDireccion = new JTextField();
		RecogerDireccion.setBounds(111, 247, 111, 28);
		RecogerDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(RecogerDireccion);
		RecogerDireccion.setColumns(10);

		TxtProvincia = new JLabel("Provincia*:");
		TxtProvincia.setBounds(222, 246, 111, 28);
		TxtProvincia.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		TxtProvincia.setEnabled(false);
		getContentPane().add(TxtProvincia);

		RecogerProvincia = new JTextField();
		RecogerProvincia.setBounds(333, 247, 111, 28);
		RecogerProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerProvincia.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerProvincia);
		RecogerProvincia.setColumns(10);

		separator_8 = new JSeparator();
		separator_8.setBounds(0, 305, 111, 28);
		separator_8.setForeground(Color.BLACK);
		getContentPane().add(separator_8);

		separator_9 = new JSeparator();
		separator_9.setBounds(111, 305, 111, 28);
		separator_9.setForeground(Color.BLACK);
		getContentPane().add(separator_9);

		separator_10 = new JSeparator();
		separator_10.setBounds(222, 305, 111, 28);
		separator_10.setForeground(Color.BLACK);
		getContentPane().add(separator_10);

		separator_11 = new JSeparator();
		separator_11.setBounds(333, 305, 111, 28);
		separator_11.setForeground(Color.BLACK);
		getContentPane().add(separator_11);

		TextOtrosDatos = new JLabel(" Otros Datos:");
		TextOtrosDatos.setBounds(0, 344, 333, 28);
		TextOtrosDatos.setHorizontalAlignment(SwingConstants.LEFT);
		TextOtrosDatos.setEnabled(false);
		TextOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		getContentPane().add(TextOtrosDatos);

		TxtTelefono = new JLabel("Tel\u00E9fono:");
		TxtTelefono.setBounds(0, 383, 111, 28);
		TxtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtTelefono.setEnabled(false);
		getContentPane().add(TxtTelefono);

		RecogerTel = new JTextField();
		RecogerTel.setBounds(111, 384, 111, 28);
		RecogerTel.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerTel);
		RecogerTel.setColumns(10);

		TxtEmail = new JLabel("Email:");
		TxtEmail.setBounds(222, 383, 111, 28);
		TxtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		TxtEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtEmail.setEnabled(false);
		getContentPane().add(TxtEmail);

		RecogerEmail = new JTextField();
		RecogerEmail.setBounds(333, 384, 111, 28);
		RecogerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(RecogerEmail);
		RecogerEmail.setColumns(10);

		BotonConfirmar = new JButton("Confirmar Cliente");
		BotonConfirmar.setBounds(314, 451, 185, 28);
		BotonConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(BotonConfirmar);
		BotonConfirmar.addActionListener(this);
		BotonConfirmar.setActionCommand(CONFIRMAR_BUTTON);

		separator_12 = new JSeparator();
		separator_12.setForeground(Color.BLACK);
		separator_12.setBounds(441, 168, 111, 28);
		getContentPane().add(separator_12);

		separator_13 = new JSeparator();
		separator_13.setForeground(Color.BLACK);
		separator_13.setBounds(441, 46, 111, 28);
		getContentPane().add(separator_13);

		separator_14 = new JSeparator();
		separator_14.setForeground(Color.BLACK);
		separator_14.setBounds(441, 305, 111, 28);
		getContentPane().add(separator_14);

		TxtInfo = new JLabel("Los campos con * son obligatorios");
		TxtInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TxtInfo.setEnabled(false);
		TxtInfo.setBounds(10, 451, 212, 23);
		getContentPane().add(TxtInfo);

		/**
		 * copiamos el objeto gestor
		 */
		objGestorIFIC = ObjGestor;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean correcto = false;
		ClsComprobarDNI_NIF objComprobarDNI_NIF = null;
		String DNI_NIF = null;
		if (!RecogerDNINIF.getText().equals("")) {
			DNI_NIF = RecogerDNINIF.getText().toUpperCase();
			objComprobarDNI_NIF = new ClsComprobarDNI_NIF();
		}

		switch (e.getActionCommand()) {
		case CONFIRMAR_BUTTON:
			do {

				try {
					if (!RecogerDNINIF.getText().equals("")) {
						correcto = objComprobarDNI_NIF.ComprobarDNI_NIF(DNI_NIF);
					}
				} catch (ClsDNI_NIFValidoExcepcion a) {
					RecogerDNINIF.setText("");
					correcto = false;
					/**
					 * Mensaje de excepcion
					 */
					JOptionPane.showMessageDialog(null, a.getMessage());
				}
			} while (!correcto && RecogerDNINIF.getText() == "");
			if (correcto && !RecogerNCliente.getText().equals("") && !RecogerNYA.getText().equals("")
					&& !RecogerDireccion.getText().equals("") && !RecogerProvincia.getText().equals("")) {
				Comporobar();
			} else {
				String MENSAJE = "Rellene los campos obligatorios";
				JOptionPane.showMessageDialog(null, MENSAJE, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			break;
		}
	}

	private void Comporobar() {

		boolean comprobado = true;

		try {
			NCliente = Integer.parseInt(RecogerNCliente.getText());
			
		} catch (Exception e) {
			comprobado = false;
			JOptionPane.showMessageDialog(null, "Introduce un numero entero en Número de Cliente");
		}
		
		
		if (RecogerTel.getText().equals("")) {
			NumTel = 0;
		} else {
			try {
				NumTel = Integer.parseInt(RecogerTel.getText());				
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Número de teléfono erroneo");
			}
		}

		if (comprobado) {
			MandarAGestor();
		}

	}

	/**
	 * Metodo para mandar la infor al Gestor
	 */
	private void MandarAGestor() {

		/**
		 * Variables para recoger infor y mandarla al gestor
		 */		
		String NomYAp = RecogerNYA.getText();
		String DNI_NIF = RecogerDNINIF.getText();
		String Provincia = RecogerProvincia.getText();
		String Email;
		if (RecogerEmail.getText().equals("")) {
			Email = "";
		} else {
			Email = RecogerEmail.getText();
		}
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

		PonerVacio();
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
