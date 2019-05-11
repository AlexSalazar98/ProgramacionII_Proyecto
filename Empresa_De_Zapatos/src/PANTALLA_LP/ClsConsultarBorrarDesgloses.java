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

public class ClsConsultarBorrarDesgloses extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaDesgloses;
	private JLabel TxtTablaDesgloses;
	private JButton BotonBorrar;
	private JScrollPane PanelDesgloses;
	@SuppressWarnings("unused")
	private ClsTablaDesgloses TDesgloses;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBD;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Desgloses;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Desgloses";

	public  ClsConsultarBorrarDesgloses(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarDesgloses.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Desgloses");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 741, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBD = ObjGestor;

		TxtTablaDesgloses = new JLabel("Desgloses");
		TxtTablaDesgloses.setEnabled(false);
		TxtTablaDesgloses.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaDesgloses.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaDesgloses.setBounds(10, 11, 705, 23);
		getContentPane().add(TxtTablaDesgloses);
		CrearTablaDesgloses();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(626, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

	}

	private void CrearTablaDesgloses() {

		Desgloses = objGestorIFCBD.DameDesgloses();

		ClsTablaDesgloses TDesgloses = new ClsTablaDesgloses(Desgloses);
		Alinear = new DefaultTableCellRenderer();

		TablaDesgloses = new JTable(TDesgloses);

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaDesgloses.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(7).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(8).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(9).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(10).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(11).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(12).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(13).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(14).setCellRenderer(Alinear);
		TablaDesgloses.getColumnModel().getColumn(15).setCellRenderer(Alinear);
		TablaDesgloses.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaDesgloses.setFillsViewportHeight(true);
		TablaDesgloses.setRowSelectionAllowed(true);
		TablaDesgloses.getSelectionModel().addListSelectionListener(this);
		TDesgloses.fireTableDataChanged();

		PanelDesgloses = new JScrollPane();
		PanelDesgloses.setBounds(10, 45, 705, 190);
		PanelDesgloses.setViewportView(TablaDesgloses);
		getContentPane().add(PanelDesgloses);
		// TDesgloses.setData(objGestorIFCBA);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaDesgloses.getValueAt(TablaDesgloses.getSelectedRow(), 0));
			int NDesglose = Integer.parseInt(dato);
			MandarABorrar(NDesglose);
			TablaDesgloses.setVisible(false);
			Desgloses = objGestorIFCBD.DameDesgloses();
			ClsTablaDesgloses TablaActualizada = new ClsTablaDesgloses(Desgloses);
			TablaDesgloses.setModel(TablaActualizada);
			Alinear.setHorizontalAlignment(SwingConstants.CENTER);
			TablaDesgloses.getColumnModel().getColumn(0).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(1).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(2).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(3).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(4).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(5).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(6).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(7).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(8).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(9).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(10).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(11).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(12).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(13).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(14).setCellRenderer(Alinear);
			TablaDesgloses.getColumnModel().getColumn(15).setCellRenderer(Alinear);
			TablaDesgloses.setVisible(true);
			break;

		default:
			break;
		}

	}

	private void MandarABorrar(int NDesglose) {

		try {
			if (objGestorIFCBD.EliminarDesglosesDeArray(NDesglose)) {
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

		int Seleccionado = TablaDesgloses.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

}
