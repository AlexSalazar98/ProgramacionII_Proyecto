package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DIRECCION;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_PROVINCIA;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_TELEFONO;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JPanel;
import LN.ClsGestorLN;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import COMUN.ItfProperty;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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

	private ArrayList<ItfProperty> Clientes;

	private JButton BotonConfirmarEnvio;
	private JLabel TxtNEnvio;
	private JTextField RecogerNEnvio;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Envios";
	private final String COMBOBOX_SELECCIONAR = "Seleccionar del combobox";
	private final String RECUPERAR_BOTON = "Recuperar datos del cliente";
	private final String MOSTRAR_CLINETES_BOTON = "Mostrar tabla con clientes";

	JPanel Panel;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIE;
	private JLabel TxtNCliente;
	private JLabel TxtNYACliente;
	private JTextField RecogerNYACliente;
	private JButton BotonCogerRestoValores;
	private JLabel TxtDirEnvio;
	private JTextField RecogerDirEnvio;
	private JLabel TxtPoblacion;
	private JTextField RecogerPoblacionEnvio;
	private JLabel TxtDatosDeEnvio;
	private JLabel TxtCPEnvios;
	private JTextField RecogerCP;
	private JLabel TxtEnvio;
	private JTextField RecogerProvinciaEnvio;
	private JLabel lblNewLabel;
	private JTextField RecogerTelefono;
	private JButton MostrarClientes;
	private JTable table;
	JScrollPane JSCClientes;

	/**
	 * Constructor.
	 */
	public ClsIFIntroducirEnvios(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsIFIntroducirEnvios.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Introducir Clientes");
		getContentPane().setLayout(null);
		this.setBounds(125, 125, 742, 559);

		Panel = new JPanel();
		this.setClosable(true);
		this.setResizable(false);
		this.setIconifiable(true);
		this.setMaximizable(false);
		Inicializar(ObjGestor);
		ObtenerUltimoID();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFIE = ObjGestor;
		getContentPane().setLayout(null);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 274, 706, 12);
		getContentPane().add(horizontalStrut);

		BotonConfirmarEnvio = new JButton("Confirmar Envio");
		BotonConfirmarEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonConfirmarEnvio.setBounds(547, 491, 144, 27);
		getContentPane().add(BotonConfirmarEnvio);
		BotonConfirmarEnvio.addActionListener(this);
		BotonConfirmarEnvio.setActionCommand(CONFIRMAR_BUTTON);

		TxtNEnvio = new JLabel("  N\u00FAmero de Envio:");
		TxtNEnvio.setEnabled(false);
		TxtNEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNEnvio.setBounds(10, 25, 152, 23);
		getContentPane().add(TxtNEnvio);

		RecogerNEnvio = new JTextField();
		RecogerNEnvio.setEnabled(false);
		RecogerNEnvio.setEditable(false);
		RecogerNEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerNEnvio.setBounds(172, 26, 86, 20);
		getContentPane().add(RecogerNEnvio);
		RecogerNEnvio.setColumns(10);

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

		BotonCogerRestoValores = new JButton("Recuperar Datos Cliente");
		BotonCogerRestoValores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonCogerRestoValores.setBounds(489, 164, 202, 23);
		getContentPane().add(BotonCogerRestoValores);
		BotonCogerRestoValores.addActionListener(this);
		BotonCogerRestoValores.setActionCommand(RECUPERAR_BOTON);

		TxtDirEnvio = new JLabel("  Direcci\u00F3n: ");
		TxtDirEnvio.setHorizontalAlignment(SwingConstants.LEFT);
		TxtDirEnvio.setEnabled(false);
		TxtDirEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDirEnvio.setBounds(10, 210, 103, 20);
		getContentPane().add(TxtDirEnvio);

		RecogerDirEnvio = new JTextField();
		RecogerDirEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		RecogerDirEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerDirEnvio.setBounds(108, 210, 127, 20);
		getContentPane().add(RecogerDirEnvio);
		RecogerDirEnvio.setColumns(10);

		TxtPoblacion = new JLabel("Poblaci\u00F3n:");
		TxtPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPoblacion.setEnabled(false);
		TxtPoblacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtPoblacion.setBounds(245, 210, 86, 20);
		getContentPane().add(TxtPoblacion);

		RecogerPoblacionEnvio = new JTextField();
		RecogerPoblacionEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerPoblacionEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerPoblacionEnvio.setBounds(341, 210, 86, 20);
		getContentPane().add(RecogerPoblacionEnvio);
		RecogerPoblacionEnvio.setColumns(10);

		TxtDatosDeEnvio = new JLabel("Datos de envio:");
		TxtDatosDeEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		TxtDatosDeEnvio.setFont(new Font("Tahoma", Font.BOLD, 20));
		TxtDatosDeEnvio.setEnabled(false);
		TxtDatosDeEnvio.setBounds(10, 160, 167, 26);
		getContentPane().add(TxtDatosDeEnvio);

		TxtCPEnvios = new JLabel("Codigo Postal:");
		TxtCPEnvios.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtCPEnvios.setHorizontalAlignment(SwingConstants.CENTER);
		TxtCPEnvios.setEnabled(false);
		TxtCPEnvios.setBounds(447, 210, 123, 19);
		getContentPane().add(TxtCPEnvios);

		RecogerCP = new JTextField();
		RecogerCP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerCP.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerCP.setBounds(580, 210, 111, 20);
		getContentPane().add(RecogerCP);
		RecogerCP.setColumns(10);

		TxtEnvio = new JLabel("Provincia:");
		TxtEnvio.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtEnvio.setEnabled(false);
		TxtEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		TxtEnvio.setBounds(10, 241, 93, 22);
		getContentPane().add(TxtEnvio);

		RecogerProvinciaEnvio = new JTextField();
		RecogerProvinciaEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerProvinciaEnvio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerProvinciaEnvio.setBounds(108, 244, 127, 20);
		getContentPane().add(RecogerProvinciaEnvio);
		RecogerProvinciaEnvio.setColumns(10);

		lblNewLabel = new JLabel(" Tel\u00E9fono:");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(245, 241, 94, 22);
		getContentPane().add(lblNewLabel);

		RecogerTelefono = new JTextField();
		RecogerTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerTelefono.setBounds(341, 243, 111, 20);
		getContentPane().add(RecogerTelefono);
		RecogerTelefono.setColumns(10);

		MostrarClientes = new JButton("Mostrar Lista Clientes");
		MostrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MostrarClientes.setBounds(489, 297, 202, 23);
		getContentPane().add(MostrarClientes);
		MostrarClientes.addActionListener(this);
		MostrarClientes.setActionCommand(MOSTRAR_CLINETES_BOTON);

		Clientes = objGestorIFIE.DameClientes();

		for (ItfProperty a : Clientes) {

			comboBox.addItem(a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO));

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case COMBOBOX_SELECCIONAR:
			CargarNombreCliente();
			break;

		case MOSTRAR_CLINETES_BOTON:
			CrearTabla();
			break;

		case RECUPERAR_BOTON:
			CargarRestoDeValores();
			break;

		case CONFIRMAR_BUTTON:
			while (!ComprobarCamposVacios()) {
				if (RecogerCP.getText().equals("")) {
					RecogerCP.setText(JOptionPane.showInputDialog("Codigo Postal:", new ImageIcon("\\u27Oe")));
				}
				if (RecogerPoblacionEnvio.getText().equals("")) {
					RecogerPoblacionEnvio.setText(JOptionPane.showInputDialog("Población"));
				}
			}
			if (ComprobarCamposVacios()) {
				MandarAGestor();
				PonerVacio();
				ObtenerUltimoID();
			}
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

	/**
	 * Metodo para crear la tabla de clientes
	 */
	private void CrearTabla() {

		table = null;

		ClsTablaClientes TClientes = new ClsTablaClientes(Clientes);
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();

		table = new JTable(TClientes);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		TClientes.fireTableDataChanged();

		JSCClientes = new JScrollPane(table);
		JSCClientes.setBounds(15, 339, 700, 130);
		this.getContentPane().add(JSCClientes);
		TClientes.setData(Clientes);

	}

	/**
	 * Metodo para cargar los valores en los campos
	 */
	// private void CargarDatos() {

	// Clientes = objGestorIFIE.DameClientes();
	// }

	/**
	 * Metodo para obtener el nombre del Cliente seleccionado
	 */
	private void CargarNombreCliente() {

		ItfProperty ObjetoSeleccionado;

		for (ItfProperty a : Clientes) {
			if (a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO).equals(comboBox.getSelectedItem())) {
				ObjetoSeleccionado = a;
				String Nombre = ObjetoSeleccionado.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS);
				RecogerNYACliente.setText(Nombre);
			}
		}
	}

	/**
	 * metodo para cargar el resto de los valores del objeto en los campos
	 */
	private void CargarRestoDeValores() {

		ItfProperty ObjetoSeleccionado;

		for (ItfProperty a : Clientes) {
			if (a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO).equals(comboBox.getSelectedItem())) {
				ObjetoSeleccionado = a;
				String Direccion = ObjetoSeleccionado.getStringProperty(PROPIEDAD_CLIENTE_DIRECCION);
				String Provincia = ObjetoSeleccionado.getStringProperty(PROPIEDAD_CLIENTE_PROVINCIA);
				String telefono = Integer.toString(ObjetoSeleccionado.getIntegerProperty(PROPIEDAD_CLIENTE_TELEFONO));
				RecogerDirEnvio.setText(Direccion);
				RecogerProvinciaEnvio.setText(Provincia);
				RecogerTelefono.setText(telefono);
			}
		}

	}

	/**
	 * Mandar lo datos al gestor
	 */
	private void MandarAGestor() {

		int NumeroDeEnvio = Integer.parseInt(RecogerNEnvio.getText());
		String NombreCliente = RecogerNYACliente.getText();
		String DireccionDeEnvio = RecogerDirEnvio.getText();
		String PoblacionDeEnvio = RecogerPoblacionEnvio.getText();
		int CPDeEnvio = Integer.parseInt(RecogerCP.getText());
		String ProvinciaDeEnvio = RecogerProvinciaEnvio.getText();
		int TelefonoDeEnvio = Integer.parseInt(RecogerTelefono.getText());
		int NumeroDeCliente_Envio = Integer.parseInt(comboBox.getSelectedItem().toString());

		try {
			if (objGestorIFIE.CrearEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
					ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio)) {
				JOptionPane.showMessageDialog(null, "Envio introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID del Envio repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

	}

	/**
	 * Metodo para dejar vacios los campos
	 */
	private void PonerVacio() {

		RecogerCP.setText("");
		RecogerDirEnvio.setText("");
		RecogerNEnvio.setText("");
		RecogerPoblacionEnvio.setText("");
		RecogerProvinciaEnvio.setText("");
		RecogerTelefono.setText("");

	}

	private boolean ComprobarCamposVacios() {

		boolean comprobar = true;

		if (RecogerCP.getText().equals("") || RecogerPoblacionEnvio.getText().equals("")) {
			comprobar = false;

		}

		return comprobar;
	}
}
