package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import LN.ClsGestorLN;
import Tablas.ClsTablaEntregas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_ENTREGADO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import COMUN.ItfProperty;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * Clase para actualizar el estado de las entregas de los pedidos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsActualizarEntregas extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Objetos de la clase
	 */
	private JTable table;
	private JLabel TxtActualizar;
	private JButton BotonActualizar;
	private JScrollPane scrollPane;
	private ClsTablaEntregas TPedidos;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFAE;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Pedidos;
	private ArrayList<ItfProperty> PedidosNoEntegados;

	/**
	 * constantes para el ActionLisener
	 */
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar";

	/**
	 * Constructor
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	public ClsActualizarEntregas(ClsGestorLN ObjGestor) {
		setIconifiable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon(ClsActualizarEntregas.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Actualizar Entregas");
		getContentPane().setLayout(null);
		this.setBounds(150, 150, 676, 299);

		Inicializar(ObjGestor);
	}

	/**
	 * Metodo para inicializar objetos
	 * 
	 * @param ObjGestor revibe el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFAE = ObjGestor;

		TxtActualizar = new JLabel("Actualizar el estado de las entregas");
		TxtActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		TxtActualizar.setFont(new Font("Tahoma", Font.BOLD, 20));
		TxtActualizar.setEnabled(false);
		TxtActualizar.setBounds(10, 11, 640, 25);
		getContentPane().add(TxtActualizar);

		BotonActualizar = new JButton("Actualizar");
		BotonActualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonActualizar.setBounds(550, 235, 100, 23);
		BotonActualizar.setEnabled(false);
		getContentPane().add(BotonActualizar);
		BotonActualizar.addActionListener(this);
		BotonActualizar.setActionCommand(ACTUALIZAR_BUTTON);

		CrearTabla();
	}

	/**
	 * Metodo para crear tabla
	 */
	private void CrearTabla() {

		PedidosNoEntegados = new ArrayList<ItfProperty>();

		Pedidos = objGestorIFAE.DamePedidos();

		for (ItfProperty a : Pedidos) {

			if (!a.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO)) {
				PedidosNoEntegados.add(a);
			}

		}

		TPedidos = new ClsTablaEntregas(PedidosNoEntegados);
		Alinear = new DefaultTableCellRenderer();

		table = new JTable(TPedidos);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JTableHeader header = table.getTableHeader();
		header.setVisible(true);
		header.setBackground(Color.black);
		header.setForeground(Color.black);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.getSelectionModel().addListSelectionListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 640, 177);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
	}

	/**
	 * Metodo escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ACTUALIZAR_BUTTON:
			MandarActualizar();
			break;

		default:
			break;
		}

	}

	/**
	 * Metodo escuchador de tabla
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {

		int Seleccionado = table.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonActualizar.setEnabled(true);
		}

	}

	/*
	 * Metodo para mandar a actualizar
	 */
	private void MandarActualizar() {

		int CantidadSeleccionados = table.getSelectedRowCount();

		int[] FilasSeleccionadas = new int[CantidadSeleccionados];
		FilasSeleccionadas = table.getSelectedRows();

		for (int i = 0; i < CantidadSeleccionados; i++) {

			String dato = String.valueOf(table.getValueAt(FilasSeleccionadas[i], 0));
			int NPedido = Integer.parseInt(dato);
			try {
				objGestorIFAE.ActualizarEntregasDePedidos(NPedido);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualizacion: " + e);
			}

		}

		JOptionPane.showMessageDialog(null, "Pedidos actualizados correctamente");
		ActualizarTabla();

	}

	/**
	 * Metodo para actualizar la tabla
	 */
	private void ActualizarTabla() {

		table.setVisible(false);

		PedidosNoEntegados = new ArrayList<ItfProperty>();

		Pedidos = objGestorIFAE.DamePedidos();

		for (ItfProperty a : Pedidos) {

			if (!a.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO)) {
				PedidosNoEntegados.add(a);
			}

		}

		ClsTablaEntregas TActualizada = new ClsTablaEntregas(PedidosNoEntegados);
		Alinear = new DefaultTableCellRenderer();

		table.setModel(TActualizada);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		table.setVisible(true);
	}
}
