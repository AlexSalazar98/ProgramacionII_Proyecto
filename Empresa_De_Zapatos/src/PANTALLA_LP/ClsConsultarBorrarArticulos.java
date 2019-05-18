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
import Tablas.ClsTablaArticulos;

import javax.swing.ListSelectionModel;

public class ClsConsultarBorrarArticulos extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaArticulos;
	private JLabel TxtTablaArticulos;
	private JButton BotonBorrar, BotonActualizar;
	private JScrollPane PanelArticulos;
	@SuppressWarnings("unused")
	private ClsTablaArticulos TArticulos;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBA;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Articulos;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Articulos";
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar Articulos";

	/**
	 * Constructor
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	public ClsConsultarBorrarArticulos(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarArticulos.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Articulos");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 741, 302);
		Inicializar(ObjGestor);
	}

	/**
	 * Metodo para inicializar objetos
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBA = ObjGestor;

		TxtTablaArticulos = new JLabel("Art\u00EDculos");
		TxtTablaArticulos.setEnabled(false);
		TxtTablaArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaArticulos.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaArticulos.setBounds(168, 11, 367, 23);
		getContentPane().add(TxtTablaArticulos);
		CrearTablaArticulos();

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

	/**
	 * Metodo para crear la tabla
	 */
	private void CrearTablaArticulos() {

		Articulos = objGestorIFCBA.DameArticulos();

		ClsTablaArticulos TArticulos = new ClsTablaArticulos(Articulos);
		Alinear = new DefaultTableCellRenderer();

		TablaArticulos = new JTable(TArticulos);
		TablaArticulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JTableHeader header = TablaArticulos.getTableHeader();
		header.setVisible(true);
		header.setBackground(Color.black);
		header.setForeground(Color.black);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaArticulos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaArticulos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaArticulos.setFillsViewportHeight(true);
		TablaArticulos.setRowSelectionAllowed(true);
		TablaArticulos.getSelectionModel().addListSelectionListener(this);
		TArticulos.fireTableDataChanged();

		PanelArticulos = new JScrollPane();
		PanelArticulos.setBounds(10, 45, 705, 190);
		PanelArticulos.setViewportView(TablaArticulos);
		getContentPane().add(PanelArticulos);

	}

	/**
	 * Metodo escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:
			String dato = String.valueOf(TablaArticulos.getValueAt(TablaArticulos.getSelectedRow(), 0));
			int NArticulo = Integer.parseInt(dato);

			if (PreguntarEntregado() == 0) {
				MandarABorrar(NArticulo);
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
	 * Metodo para preguntar por la confirmacion
	 * 
	 * @return nos devuelve la respuesta
	 */
	private int PreguntarEntregado() {

		return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar el registro?", "BORRAR",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	}

	/**
	 * Metodo para actualizar la tabla
	 */
	private void ActualizarTabla() {

		TablaArticulos.setVisible(false);
		Articulos = objGestorIFCBA.DameArticulos();
		ClsTablaArticulos TablaActualizada = new ClsTablaArticulos(Articulos);
		TablaArticulos.setModel(TablaActualizada);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaArticulos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaArticulos.setVisible(true);

	}

	/**
	 * Metodo para mandar a borrar
	 * 
	 * @param NArticulo mandamos la referencia
	 */
	private void MandarABorrar(int NArticulo) {

		try {
			if (objGestorIFCBA.EliminarArticulosDeArray(NArticulo)) {
				JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		} catch (ClsBorrarExcepcion e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	/**
	 * Escuchador de tablas
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {

		int Seleccionado = TablaArticulos.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}
}
