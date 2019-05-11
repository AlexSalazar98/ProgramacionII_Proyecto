package PANTALLA_LP;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import COMUN.ItfProperty;
import Excepciones.ClsBorrarExcepcion;
import LN.ClsGestorLN;

public class ClsConsultarBorrarHerrajes extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaClientes;
	private JLabel TxtTablaClientes;
	private JButton BotonBorrar;
	private JScrollPane PanelClientes;
	@SuppressWarnings("unused")
	private ClsTablaClientes TClientes;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBA;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Clientes;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Clientes";

	public ClsConsultarBorrarHerrajes(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarClientes.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Clientes");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 741, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBA = ObjGestor;

		TxtTablaClientes = new JLabel("Clientes");
		TxtTablaClientes.setEnabled(false);
		TxtTablaClientes.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaClientes.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaClientes.setBounds(10, 11, 705, 23);
		getContentPane().add(TxtTablaClientes);
		CrearTablaClientes();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(626, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

	}

	private void CrearTablaClientes() {

		Clientes = objGestorIFCBA.DameClientes();

		ClsTablaClientes TClientes = new ClsTablaClientes(Clientes);
		Alinear = new DefaultTableCellRenderer();

		TablaClientes = new JTable(TClientes);

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaClientes.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaClientes.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaClientes.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaClientes.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaClientes.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaClientes.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaClientes.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaClientes.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaClientes.setFillsViewportHeight(true);
		TablaClientes.setRowSelectionAllowed(true);
		TablaClientes.getSelectionModel().addListSelectionListener(this);
		TClientes.fireTableDataChanged();

		PanelClientes = new JScrollPane();
		PanelClientes.setBounds(10, 45, 705, 190);
		PanelClientes.setViewportView(TablaClientes);
		getContentPane().add(PanelClientes);
		// TClientes.setData(objGestorIFCBA);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaClientes.getValueAt(TablaClientes.getSelectedRow(), 0));
			int NSerie = Integer.parseInt(dato);
			MandarABorrar(NSerie);
			TablaClientes.setVisible(false);
			Clientes = objGestorIFCBA.DameClientes();
			ClsTablaClientes TablaActualizada = new ClsTablaClientes(Clientes);
			TablaClientes.setModel(TablaActualizada);
			Alinear.setHorizontalAlignment(SwingConstants.CENTER);
			TablaClientes.getColumnModel().getColumn(0).setCellRenderer(Alinear);
			TablaClientes.getColumnModel().getColumn(1).setCellRenderer(Alinear);
			TablaClientes.getColumnModel().getColumn(2).setCellRenderer(Alinear);
			TablaClientes.getColumnModel().getColumn(3).setCellRenderer(Alinear);
			TablaClientes.getColumnModel().getColumn(4).setCellRenderer(Alinear);
			TablaClientes.getColumnModel().getColumn(5).setCellRenderer(Alinear);
			TablaClientes.getColumnModel().getColumn(6).setCellRenderer(Alinear);
			TablaClientes.setVisible(true);
			break;

		default:
			break;
		}

	}

	private void MandarABorrar(int NSerie) {

		try {
			if (objGestorIFCBA.EliminarClientesDeArray(NSerie)) {
				JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		} catch (ClsBorrarExcepcion e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		int Seleccionado = TablaClientes.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

}
