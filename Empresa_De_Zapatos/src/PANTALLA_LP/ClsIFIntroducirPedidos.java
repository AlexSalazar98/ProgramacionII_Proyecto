package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import LN.ClsGestorLN;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import COMUN.ItfProperty;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

/**
 * Clase para crear INternalFrame de pedidos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsIFIntroducirPedidos extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve
	 */
	private static final long serialVersionUID = 1L;

	private JLabel TxtNPedido, TxtFechaPedido, TxtFechaEntega, TxtNCliente, TxtNombreApellidos;
	private JTextField RecogerNPedido, RecogerNombreApellidos;
	private JDateChooser RecogerFechaPedido, RecogerFechaEntrega;
	@SuppressWarnings("rawtypes")
	private JComboBox RecogerNumeroCliente;
	private JTable table;
	JScrollPane JSCClientes;
	private ArrayList<ItfProperty> Clientes;
	private ClsGestorLN objGestorIFIP;
	private JButton BotonVerClientes, BotonConfPedido;
	private Date FechaDePedido, FechaDeEntrega;
	private Boolean Entregado;

	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Envios";
	private final String MOSTRAR_CLINETES_BOTON = "Mostrar tabla con clientes";
	private final String COMBOBOX_SELECCIONAR = "Seleccionar del combobox";

	public ClsIFIntroducirPedidos(ClsGestorLN objGestor) {
		setResizable(false);
		setMaximizable(false);
		setFrameIcon(new ImageIcon(ClsIFIntroducirPedidos.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setClosable(true);
		setTitle("Introducir Pedidos");
		setIconifiable(true);
		getContentPane().setLayout(null);
		this.setBounds(150, 150, 729, 380);

		Inicializar(objGestor);
		ObtenerUltimoID();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void Inicializar(ClsGestorLN objGestor) {

		objGestorIFIP = objGestor;

		Clientes = objGestorIFIP.DameClientes();

		TxtNPedido = new JLabel("Numero de Pedido:");
		TxtNPedido.setEnabled(false);
		TxtNPedido.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNPedido.setBounds(10, 27, 163, 24);
		getContentPane().add(TxtNPedido);

		RecogerNPedido = new JTextField();
		RecogerNPedido.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNPedido.setEnabled(false);
		RecogerNPedido.setEditable(false);
		RecogerNPedido.setBounds(161, 29, 86, 20);
		getContentPane().add(RecogerNPedido);
		RecogerNPedido.setColumns(10);

		TxtFechaPedido = new JLabel("Fecha de Pedido:");
		TxtFechaPedido.setEnabled(false);
		TxtFechaPedido.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtFechaPedido.setBounds(10, 127, 131, 24);
		getContentPane().add(TxtFechaPedido);

		RecogerFechaPedido = new JDateChooser();
		RecogerFechaPedido.setDateFormatString("dd-MM-yyyy");
		RecogerFechaPedido.setBounds(161, 127, 124, 24);
		getContentPane().add(RecogerFechaPedido);

		TxtFechaEntega = new JLabel("Fecha de Entrega:");
		TxtFechaEntega.setEnabled(false);
		TxtFechaEntega.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtFechaEntega.setBounds(309, 131, 152, 17);
		getContentPane().add(TxtFechaEntega);

		RecogerFechaEntrega = new JDateChooser();
		RecogerFechaEntrega.setDateFormatString("dd-MM-yyyy");
		RecogerFechaEntrega.setBounds(471, 127, 124, 24);
		getContentPane().add(RecogerFechaEntrega);

		TxtNombreApellidos = new JLabel("Nombre y Apellidos:");
		TxtNombreApellidos.setEnabled(false);
		TxtNombreApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNombreApellidos.setBounds(309, 76, 152, 24);
		getContentPane().add(TxtNombreApellidos);

		RecogerNombreApellidos = new JTextField();
		RecogerNombreApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNombreApellidos.setEditable(false);
		RecogerNombreApellidos.setEnabled(false);
		RecogerNombreApellidos.setBounds(471, 80, 163, 20);
		getContentPane().add(RecogerNombreApellidos);
		RecogerNombreApellidos.setColumns(10);

		TxtNCliente = new JLabel("Numero de Cliente:");
		TxtNCliente.setEnabled(false);
		TxtNCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNCliente.setBounds(10, 76, 163, 24);
		getContentPane().add(TxtNCliente);

		RecogerNumeroCliente = new JComboBox();
		RecogerNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNumeroCliente.setBounds(161, 78, 86, 20);
		getContentPane().add(RecogerNumeroCliente);
		RecogerNumeroCliente.addActionListener(this);
		RecogerNumeroCliente.setActionCommand(COMBOBOX_SELECCIONAR);

		BotonConfPedido = new JButton("Confirmar Pedido");
		BotonConfPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonConfPedido.setBounds(551, 316, 152, 23);
		getContentPane().add(BotonConfPedido);
		BotonConfPedido.addActionListener(this);
		BotonConfPedido.setActionCommand(CONFIRMAR_BUTTON);

		BotonVerClientes = new JButton("Ver Clientes");
		BotonVerClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonVerClientes.setBounds(594, 161, 109, 23);
		getContentPane().add(BotonVerClientes);
		BotonVerClientes.addActionListener(this);
		BotonVerClientes.setActionCommand(MOSTRAR_CLINETES_BOTON);

		for (ItfProperty a : Clientes) {

			RecogerNumeroCliente.addItem(a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO));

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case MOSTRAR_CLINETES_BOTON:
			CrearTabla();
			break;

		case COMBOBOX_SELECCIONAR:
			CargarNombreCliente();
			break;

		case CONFIRMAR_BUTTON:
			FromatearFechaPedio();
			FormatearFechaEntrega();
			int resultado;
			do {

				resultado = PreguntarEntregado();

				if (resultado == 0) {
					Entregado = true;
				} else if (resultado == 1) {
					Entregado = false;
				}
			} while (resultado == -1);
			if (MandarAGestor()) {
				PonerVacio();
				ObtenerUltimoID();
			}
			break;

		default:
			break;
		}

	}

	/**
	 * Para poner vacios lo huecos
	 */
	private void PonerVacio() {
		RecogerNombreApellidos.setText("");
	}

	/**
	 * Confirmar la entrega del pedido
	 * 
	 * @return nos devuelve la respuesta (INT)
	 */
	private int PreguntarEntregado() {

		return JOptionPane.showConfirmDialog(null, "¿Esta entregado el pedido?", "Pedido Entregado",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	}

	/**
	 * Mandar al gestor
	 * 
	 * @return nos devuelve true/false
	 */
	private boolean MandarAGestor() {

		boolean Hecho = false;

		int Npedido = Integer.parseInt(RecogerNPedido.getText());
		int NCliente = Integer.parseInt(RecogerNumeroCliente.getSelectedItem().toString());
		String NYAcliente = RecogerNombreApellidos.getText();

		try {
			if (objGestorIFIP.CrearPedidos(Npedido, FechaDePedido, FechaDeEntrega, Entregado, NCliente, NYAcliente)) {
				Hecho = true;
				JOptionPane.showMessageDialog(null, "Pedido introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID del Pedido repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

		return Hecho;
	}

	/**
	 * Metodo para parsear fechas de pedido
	 */
	private void FromatearFechaPedio() {
		DateFormat miFormato;
		String fecha;

		/**
		 * fromateamos la fecha de otro modo diferente al anterior para sacarla por
		 * pantalla.
		 */
		miFormato = DateFormat.getDateInstance(DateFormat.SHORT);
		fecha = miFormato.format(RecogerFechaPedido.getDate());

		try {
			FechaDePedido = miFormato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para parsear fechas de entrega
	 */
	private void FormatearFechaEntrega() {
		DateFormat miFormato;
		String fecha;

		/**
		 * fromateamos la fecha de otro modo diferente al anterior para sacarla por
		 * pantalla.
		 */
		miFormato = DateFormat.getDateInstance(DateFormat.SHORT);
		fecha = miFormato.format(RecogerFechaEntrega.getDate());

		try {
			FechaDeEntrega = miFormato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

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
		JSCClientes.setBounds(10, 199, 693, 106);
		this.getContentPane().add(JSCClientes);
		TClientes.setData(Clientes);

	}

	/**
	 * Metodo para obtener el nombre del Cliente seleccionado
	 */
	private void CargarNombreCliente() {

		ItfProperty ObjetoSeleccionado;

		for (ItfProperty a : Clientes) {
			if (a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO).equals(RecogerNumeroCliente.getSelectedItem())) {
				ObjetoSeleccionado = a;
				String Nombre = ObjetoSeleccionado.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS);
				RecogerNombreApellidos.setText(Nombre);
			}
		}
	}

	/**
	 * Metodo para obtener automaticamente el siguiente ID.
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Pedidos = objGestorIFIP.OrdenarPedidos();

		ItfProperty UltimoObjeto = Pedidos.get(Pedidos.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		RecogerNPedido.setText(IDActualizado);

	}
}
