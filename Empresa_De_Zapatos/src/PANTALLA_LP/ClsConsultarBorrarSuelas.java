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
import Tablas.ClsTablaSeries;
import Tablas.ClsTablaSuelas;

import javax.swing.ListSelectionModel;

/**
 * Clase para consultar y borrar suelas
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsConsultarBorrarSuelas extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaSuelas;
	private JLabel TxtTablaSuelas;
	private JButton BotonBorrar, BotonActualizar;
	private JScrollPane PanelSuelas;
	@SuppressWarnings("unused")
	private ClsTablaSeries TSuelas;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBSu;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Suelas;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Suelas";
	private final String ACTUALIZAR_BUTTON = "Boton de actualizar Suelas";

	/**
	 * Constructro
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	public ClsConsultarBorrarSuelas(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarSeries.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Suelas");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 453, 302);
		Inicializar(ObjGestor);
	}

	/**
	 * Metodo inicializador de objetos
	 * 
	 * @param ObjGestor recibe el gestro
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBSu = ObjGestor;

		TxtTablaSuelas = new JLabel("Suelas");
		TxtTablaSuelas.setEnabled(false);
		TxtTablaSuelas.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaSuelas.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaSuelas.setBounds(10, 11, 414, 23);
		getContentPane().add(TxtTablaSuelas);
		CrearTablaSuelas();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(335, 236, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

		BotonActualizar = new JButton("\u27F3");
		BotonActualizar.setBounds(381, 11, 43, 31);
		getContentPane().add(BotonActualizar);
		BotonActualizar.addActionListener(this);
		BotonActualizar.setActionCommand(ACTUALIZAR_BUTTON);
	}

	/**
	 * Metodo para crear tabla
	 */
	private void CrearTablaSuelas() {

		Suelas = objGestorIFCBSu.DameSuelas();

		ClsTablaSuelas TSuelas = new ClsTablaSuelas(Suelas);
		Alinear = new DefaultTableCellRenderer();

		TablaSuelas = new JTable(TSuelas);
		TablaSuelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JTableHeader header = TablaSuelas.getTableHeader();
		header.setVisible(true);
		header.setBackground(Color.black);
		header.setForeground(Color.black);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaSuelas.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaSuelas.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaSuelas.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaSuelas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaSuelas.getSelectionModel().addListSelectionListener(this);
		TablaSuelas.setFillsViewportHeight(true);
		TablaSuelas.setRowSelectionAllowed(true);
		TSuelas.fireTableDataChanged();

		PanelSuelas = new JScrollPane();
		PanelSuelas.setBounds(10, 45, 414, 190);
		PanelSuelas.setViewportView(TablaSuelas);
		getContentPane().add(PanelSuelas);
		// TSeries.setData(objGestorIFCBS);

	}

	/**
	 * Escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaSuelas.getValueAt(TablaSuelas.getSelectedRow(), 0));
			int NSuela = Integer.parseInt(dato);
			if (PreguntarEntregado() == 0) {
				MandarABorrar(NSuela);
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
	 * Metodo para preguntar por la confirmacion de borrado
	 * 
	 * @return devolvemos confirm.
	 */
	private int PreguntarEntregado() {

		return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar el registro?", "BORRAR",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	}

	/**
	 * Metodo para mandar a borrar
	 * 
	 * @param NSuela mandamos parametro
	 */
	private void MandarABorrar(int NSuela) {

		try {
			if (objGestorIFCBSu.EliminarSuelasDeArray(NSuela)) {
				JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		} catch (ClsBorrarExcepcion e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	/**
	 * Escuchador de tabla
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {

		int Seleccionado = TablaSuelas.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

	/**
	 * Metodo para actualizar la tabla
	 */
	private void ActualizarTabla() {
		TablaSuelas.setVisible(false);
		Suelas = objGestorIFCBSu.DameSuelas();
		ClsTablaSuelas TablaActualizada = new ClsTablaSuelas(Suelas);
		TablaSuelas.setModel(TablaActualizada);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaSuelas.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaSuelas.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaSuelas.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaSuelas.setVisible(true);
	}
}
