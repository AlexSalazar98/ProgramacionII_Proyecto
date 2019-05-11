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
	private JTable TablaHerrajes;
	private JLabel TxtTablaHerrajes;
	private JButton BotonBorrar, BotonActualizar;
	private JScrollPane PanelHerrajes;
	@SuppressWarnings("unused")
	private ClsTablaHerrajes THerrajes;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBH;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Herrajes;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Herrajes";
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar Herrajes";

	public ClsConsultarBorrarHerrajes(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarHerrajes.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Herrajes");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 418, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBH = ObjGestor;

		TxtTablaHerrajes = new JLabel("Herrajes");
		TxtTablaHerrajes.setEnabled(false);
		TxtTablaHerrajes.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaHerrajes.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaHerrajes.setBounds(10, 11, 381, 23);
		getContentPane().add(TxtTablaHerrajes);
		CrearTablaHerrajes();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(303, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

		BotonActualizar = new JButton("\u21bb");
		BotonActualizar.setBounds(349, 11, 43, 31);
		getContentPane().add(BotonActualizar);
		BotonActualizar.addActionListener(this);
		BotonActualizar.setActionCommand(ACTUALIZAR_BUTTON);

	}

	private void CrearTablaHerrajes() {

		Herrajes = objGestorIFCBH.DameHerrajes();

		ClsTablaHerrajes THerrajes = new ClsTablaHerrajes(Herrajes);
		Alinear = new DefaultTableCellRenderer();

		TablaHerrajes = new JTable(THerrajes);

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaHerrajes.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaHerrajes.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaHerrajes.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaHerrajes.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaHerrajes.setFillsViewportHeight(true);
		TablaHerrajes.setRowSelectionAllowed(true);
		TablaHerrajes.getSelectionModel().addListSelectionListener(this);
		THerrajes.fireTableDataChanged();

		PanelHerrajes = new JScrollPane();
		PanelHerrajes.setBounds(10, 45, 381, 190);
		PanelHerrajes.setViewportView(TablaHerrajes);
		getContentPane().add(PanelHerrajes);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaHerrajes.getValueAt(TablaHerrajes.getSelectedRow(), 0));
			int NHerrajes = Integer.parseInt(dato);
			MandarABorrar(NHerrajes);
			ActualizarTabla();
			break;

		case ACTUALIZAR_BUTTON:
			ActualizarTabla();
			break;

		default:
			break;
		}

	}

	private void MandarABorrar(int NHerrajes) {

		try {
			if (objGestorIFCBH.EliminarHerrajesDeArray(NHerrajes)) {
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

		int Seleccionado = TablaHerrajes.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

	private void ActualizarTabla() {
		TablaHerrajes.setVisible(false);
		Herrajes = objGestorIFCBH.DameHerrajes();
		ClsTablaHerrajes TablaActualizada = new ClsTablaHerrajes(Herrajes);
		TablaHerrajes.setModel(TablaActualizada);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaHerrajes.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaHerrajes.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaHerrajes.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaHerrajes.setVisible(true);
	}
}
