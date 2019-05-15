package PANTALLA_LP;

import java.awt.Color;
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
import javax.swing.table.JTableHeader;

import COMUN.ItfProperty;
import Excepciones.ClsBorrarExcepcion;
import LN.ClsGestorLN;
import javax.swing.ListSelectionModel;

public class ClsConsultarBorrarMateriales extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaMateriales;
	private JLabel TxtTablaMateriales;
	private JButton BotonBorrar, BotonActualizar;
	private JScrollPane PanelMateriales;
	@SuppressWarnings("unused")
	private ClsTablaMateriales TMateriales;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBM;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Materiales;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Materiales";
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar Materiales";

	public ClsConsultarBorrarMateriales(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarMateriales.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Materiales");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 418, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBM = ObjGestor;

		TxtTablaMateriales = new JLabel("Materiales");
		TxtTablaMateriales.setEnabled(false);
		TxtTablaMateriales.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaMateriales.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaMateriales.setBounds(10, 11, 381, 23);
		getContentPane().add(TxtTablaMateriales);
		CrearTablaMateriales();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(303, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

		BotonActualizar = new JButton("\u27F3");
		BotonActualizar.setBounds(348, 11, 43, 31);
		getContentPane().add(BotonActualizar);
		BotonActualizar.addActionListener(this);
		BotonActualizar.setActionCommand(ACTUALIZAR_BUTTON);

	}

	private void CrearTablaMateriales() {

		Materiales = objGestorIFCBM.DameMateriales();

		ClsTablaMateriales TClientes = new ClsTablaMateriales(Materiales);
		Alinear = new DefaultTableCellRenderer();

		TablaMateriales = new JTable(TClientes);
		TablaMateriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JTableHeader header = TablaMateriales.getTableHeader();
		header.setVisible(true);
		header.setBackground(Color.black);
		header.setForeground(Color.black);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaMateriales.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaMateriales.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaMateriales.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaMateriales.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaMateriales.setFillsViewportHeight(true);
		TablaMateriales.setRowSelectionAllowed(true);
		TablaMateriales.getSelectionModel().addListSelectionListener(this);
		TClientes.fireTableDataChanged();

		PanelMateriales = new JScrollPane();
		PanelMateriales.setBounds(10, 45, 381, 190);
		PanelMateriales.setViewportView(TablaMateriales);
		getContentPane().add(PanelMateriales);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaMateriales.getValueAt(TablaMateriales.getSelectedRow(), 0));
			int NMaterial = Integer.parseInt(dato);
			if (PreguntarEntregado() == 0) {
				MandarABorrar(NMaterial);
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

	private void MandarABorrar(int NMaterial) {

		try {
			if (objGestorIFCBM.EliminarMaterialesDeArray(NMaterial)) {
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

		int Seleccionado = TablaMateriales.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

	private void ActualizarTabla() {
		TablaMateriales.setVisible(false);
		Materiales = objGestorIFCBM.DameMateriales();
		ClsTablaMateriales TablaActualizada = new ClsTablaMateriales(Materiales);
		TablaMateriales.setModel(TablaActualizada);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaMateriales.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaMateriales.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaMateriales.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaMateriales.setVisible(true);
	}
}
