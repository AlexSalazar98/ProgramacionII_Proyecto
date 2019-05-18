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
import Tablas.ClsTablaDesgloses;

import javax.swing.ListSelectionModel;

public class ClsConsultarBorrarDesgloses extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaDesgloses;
	private JLabel TxtTablaDesgloses;
	private JButton BotonBorrar, BotonActualizar;
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
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar Desgloses";

	/**
	 * Constructor
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	public ClsConsultarBorrarDesgloses(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarDesgloses.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Desgloses");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 1253, 302);
		Inicializar(ObjGestor);
	}

	/**
	 * Inicializador de objetos
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBD = ObjGestor;

		TxtTablaDesgloses = new JLabel("Desgloses");
		TxtTablaDesgloses.setEnabled(false);
		TxtTablaDesgloses.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaDesgloses.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaDesgloses.setBounds(10, 11, 1217, 37);
		getContentPane().add(TxtTablaDesgloses);
		CrearTablaDesgloses();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(1138, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

		BotonActualizar = new JButton("\u27F3");
		BotonActualizar.setBounds(1184, 11, 43, 31);
		getContentPane().add(BotonActualizar);
		BotonActualizar.addActionListener(this);
		BotonActualizar.setActionCommand(ACTUALIZAR_BUTTON);

	}

	/**
	 * Metodo para crear la tabla
	 */
	private void CrearTablaDesgloses() {

		Desgloses = objGestorIFCBD.DameDesgloses();

		ClsTablaDesgloses TDesgloses = new ClsTablaDesgloses(Desgloses);
		Alinear = new DefaultTableCellRenderer();

		TablaDesgloses = new JTable(TDesgloses);
		TablaDesgloses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JTableHeader header = TablaDesgloses.getTableHeader();
		header.setVisible(true);
		header.setBackground(Color.black);
		header.setForeground(Color.black);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

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
		PanelDesgloses.setBounds(10, 50, 1217, 185);
		PanelDesgloses.setViewportView(TablaDesgloses);
		getContentPane().add(PanelDesgloses);
		// TDesgloses.setData(objGestorIFCBA);

	}

	/**
	 * Escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaDesgloses.getValueAt(TablaDesgloses.getSelectedRow(), 0));
			int NDesglose = Integer.parseInt(dato);
			if (PreguntarEntregado() == 0) {
				MandarABorrar(NDesglose);
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

	/**
	 * Preguntar por confirmacion
	 * 
	 * @return devolvemos la confirmacion
	 */
	private int PreguntarEntregado() {

		return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar el registro?", "BORRAR",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	}

	/**
	 * Metodo para mandar a borrar
	 * 
	 * @param NDesglose parametro por el cual borrar
	 */
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

	/**
	 * Escuhcador de tabla
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {

		int Seleccionado = TablaDesgloses.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

	/**
	 * Metodo para actualizar la tabla
	 */
	private void ActualizarTabla() {
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

	}
}
