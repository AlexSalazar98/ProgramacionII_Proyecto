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
import javax.swing.ListSelectionModel;

public class ClsConsultarBorrarEnvios extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaEnvios;
	private JLabel TxtTablaEnvios;
	private JButton BotonBorrar, BotonActualizar;
	private JScrollPane PanelEnvios;
	@SuppressWarnings("unused")
	private ClsTablaEnvios TEnvios;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBE;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Envios;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Envios";
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar Envios";

	public ClsConsultarBorrarEnvios(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarEnvios.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Envios");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 741, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBE = ObjGestor;

		TxtTablaEnvios = new JLabel("Envios");
		TxtTablaEnvios.setEnabled(false);
		TxtTablaEnvios.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaEnvios.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaEnvios.setBounds(10, 11, 705, 23);
		getContentPane().add(TxtTablaEnvios);
		CrearTablaEnvios();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(626, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

		BotonActualizar = new JButton("\u27F3");
		BotonActualizar.setBounds(672, 11, 43, 31);
		getContentPane().add(BotonActualizar);
		BotonActualizar.addActionListener(this);
		BotonActualizar.setActionCommand(ACTUALIZAR_BUTTON);

	}

	private void CrearTablaEnvios() {

		Envios = objGestorIFCBE.DameEnvios();

		ClsTablaEnvios TEnvios = new ClsTablaEnvios(Envios);
		Alinear = new DefaultTableCellRenderer();

		TablaEnvios = new JTable(TEnvios);
		TablaEnvios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaEnvios.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(7).setCellRenderer(Alinear);
		TablaEnvios.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaEnvios.setFillsViewportHeight(true);
		TablaEnvios.setRowSelectionAllowed(true);
		TablaEnvios.getSelectionModel().addListSelectionListener(this);
		TEnvios.fireTableDataChanged();

		PanelEnvios = new JScrollPane();
		PanelEnvios.setBounds(10, 45, 705, 190);
		PanelEnvios.setViewportView(TablaEnvios);
		getContentPane().add(PanelEnvios);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaEnvios.getValueAt(TablaEnvios.getSelectedRow(), 0));
			int NEnvio = Integer.parseInt(dato);
			if (PreguntarEntregado() == 0) {
				MandarABorrar(NEnvio);
				ActualizarTabla();
			}
			break;

		case ACTUALIZAR_BUTTON:
			BotonBorrar.setEnabled(false);
			ActualizarTabla();
			break;

		default:
			break;
		}

	}

	private int PreguntarEntregado() {

		return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar el registro?", "BORRAR",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	}

	private void MandarABorrar(int NEnvio) {

		try {
			if (objGestorIFCBE.EliminarEnviosDeArray(NEnvio)) {
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

		int Seleccionado = TablaEnvios.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

	private void ActualizarTabla() {
		TablaEnvios.setVisible(false);
		Envios = objGestorIFCBE.DameEnvios();
		ClsTablaEnvios TablaActualizada = new ClsTablaEnvios(Envios);
		TablaEnvios.setModel(TablaActualizada);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaEnvios.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaEnvios.getColumnModel().getColumn(7).setCellRenderer(Alinear);
		TablaEnvios.setVisible(true);
	}
}
