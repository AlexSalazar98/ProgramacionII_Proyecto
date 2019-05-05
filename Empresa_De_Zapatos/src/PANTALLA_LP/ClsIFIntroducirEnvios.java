package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;

//import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DIRECCION;
//import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DNI_NIF;
//import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_EMAIL;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
//import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_PROVINCIA;
//import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_TELEFONO;
import java.awt.Component;
import javax.swing.Box;
//import javax.swing.DefaultListModel;
//import javax.swing.JList;
import javax.swing.JPanel;
//import COMUN.ItfProperty;
import LN.ClsGestorLN;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import COMUN.ItfProperty;

import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 * Clase de InternalFrame para insertar Envios
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsIFIntroducirEnvios extends JInternalFrame implements ActionListener {
	/**
	 * Esto no se para que sirve.
	 */
	private static final long serialVersionUID = 1L;

//	private JList<String> ListaDeClientes;
	private ArrayList<ItfProperty> Clientes;
	// private DefaultListModel<String> modelo = new DefaultListModel<String>();

	private JButton BotonConfirmarEnvio, BotonNEnvioAuto;
	private JLabel TxtNEnvio;
	private JTextField RecogerNEnvio;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Series";
	private final String AUTOMATICO_BUTTON = "Boton para poner automatico el ID";
	private final String COMBOBOX_SELECCIONAR = "Seleccionar del combobox";

	JPanel Panel;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIE;
	private JLabel TxtNCliente;
	private JLabel TxtNYACliente;
	private JTextField RecogerNYACliente;

	/**
	 * Constructor.
	 */
	public ClsIFIntroducirEnvios(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsIFIntroducirEnvios.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Introducir Clientes");
		getContentPane().setLayout(null);
		this.setBounds(125, 125, 578, 520);

		Panel = new JPanel();
		this.setClosable(true);
		this.setResizable(false);
		this.setIconifiable(true);
		this.setMaximizable(false);
		Inicializar(ObjGestor);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFIE = ObjGestor;
		getContentPane().setLayout(null);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 242, 542, 12);
		getContentPane().add(horizontalStrut);

		BotonConfirmarEnvio = new JButton("Confirmar Envio");
		BotonConfirmarEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonConfirmarEnvio.setBounds(408, 452, 144, 27);
		getContentPane().add(BotonConfirmarEnvio);
		BotonConfirmarEnvio.addActionListener(this);
		BotonConfirmarEnvio.setActionCommand(CONFIRMAR_BUTTON);

		TxtNEnvio = new JLabel("  Numero de Envio:");
		TxtNEnvio.setEnabled(false);
		TxtNEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNEnvio.setBounds(10, 25, 152, 23);
		getContentPane().add(TxtNEnvio);

		RecogerNEnvio = new JTextField();
		RecogerNEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerNEnvio.setBounds(172, 28, 86, 20);
		getContentPane().add(RecogerNEnvio);
		RecogerNEnvio.setColumns(10);

		BotonNEnvioAuto = new JButton("N\u00BA Envio Automatico");
		BotonNEnvioAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonNEnvioAuto.setBounds(268, 23, 167, 27);
		getContentPane().add(BotonNEnvioAuto);
		BotonNEnvioAuto.addActionListener(this);
		BotonNEnvioAuto.setActionCommand(AUTOMATICO_BUTTON);
		
		TxtNCliente = new JLabel("  N\u00BA Del Cliente: ");
		TxtNCliente.setEnabled(false);
		TxtNCliente.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNCliente.setBounds(20, 59, 123, 25);
		getContentPane().add(TxtNCliente);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(172, 62, 86, 22);
		getContentPane().add(comboBox);
		comboBox.addActionListener(this);
		comboBox.setActionCommand(COMBOBOX_SELECCIONAR);
		
		TxtNYACliente = new JLabel("  Nombre y Apellidos :");
		TxtNYACliente.setEnabled(false);
		TxtNYACliente.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNYACliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNYACliente.setBounds(10, 106, 167, 25);
		getContentPane().add(TxtNYACliente);
		
		RecogerNYACliente = new JTextField();
		RecogerNYACliente.setEditable(false);
		RecogerNYACliente.setEnabled(false);
		RecogerNYACliente.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNYACliente.setBounds(187, 110, 152, 20);
		getContentPane().add(RecogerNYACliente);
		RecogerNYACliente.setColumns(10);

		Clientes = objGestorIFIE.DameClientes();

		 for (ItfProperty a : Clientes) {

		 comboBox.addItem(a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO));

		 }

	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case COMBOBOX_SELECCIONAR:
			
			ItfProperty ObjetoSeleccionado;
			
			for (ItfProperty a: Clientes) {
				if(a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO).equals(comboBox.getSelectedItem())) {
				ObjetoSeleccionado = a;
				String Nombre = ObjetoSeleccionado.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS);
				RecogerNYACliente.setText(Nombre);
				}
			}
			
			break;
		case AUTOMATICO_BUTTON:
			ObtenerUltimoID();
			break;

		case CONFIRMAR_BUTTON:
			//MandarAGestor();
			//PonerVacio();
			break;

		default:
			break;
		}

	}

	/**
	 * Metodo para obtener automaticamente el siguiente ID.
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Envios = objGestorIFIE.OrdenarEnvios();

		ItfProperty UltimoObjeto = Envios.get(Envios.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		RecogerNEnvio.setText(IDActualizado);

	}
}
