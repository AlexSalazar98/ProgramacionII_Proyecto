package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import COMUN.ItfProperty;
import Excepciones.ClsBorrarExcepcion;
import LN.ClsGestorLN;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Clase para consultar y borrar datos de la tabla series
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsConsultarBorrarSeries extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaSeries;
	private JLabel TxtTablaSeries;
	private JButton BotonBorrar;
	private JScrollPane PanelSeries;
	@SuppressWarnings("unused")
	private ClsTablaSeries TSeries;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBS;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Series;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Series";

	public ClsConsultarBorrarSeries(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarSeries.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Series");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 453, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBS = ObjGestor;

		TxtTablaSeries = new JLabel("Series");
		TxtTablaSeries.setEnabled(false);
		TxtTablaSeries.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaSeries.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaSeries.setBounds(10, 11, 414, 23);
		getContentPane().add(TxtTablaSeries);
		CrearTablaSeries();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(335, 236, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

	}

	private void CrearTablaSeries() {

		Series = objGestorIFCBS.DameSeries();

		ClsTablaSeries TSeries = new ClsTablaSeries(Series);
		Alinear = new DefaultTableCellRenderer();

		TablaSeries = new JTable(TSeries);

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaSeries.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaSeries.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaSeries.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaSeries.setFillsViewportHeight(true);
		TablaSeries.setRowSelectionAllowed(true);
		TablaSeries.getSelectionModel().addListSelectionListener(this);
		TSeries.fireTableDataChanged();

		PanelSeries = new JScrollPane();
		PanelSeries.setBounds(10, 45, 414, 190);
		PanelSeries.setViewportView(TablaSeries);
		getContentPane().add(PanelSeries);
		// TSeries.setData(objGestorIFCBS);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaSeries.getValueAt(TablaSeries.getSelectedRow(), 0));
			int NSerie = Integer.parseInt(dato);
			MandarABorrar(NSerie);
			TablaSeries.setVisible(false);
			Series = objGestorIFCBS.DameSeries();
			ClsTablaSeries TablaActualizada = new ClsTablaSeries(Series);
			TablaSeries.setModel(TablaActualizada);
			Alinear.setHorizontalAlignment(SwingConstants.CENTER);
			TablaSeries.getColumnModel().getColumn(0).setCellRenderer(Alinear);
			TablaSeries.getColumnModel().getColumn(1).setCellRenderer(Alinear);
			TablaSeries.setVisible(true);
			break;

		default:
			break;
		}

	}

	private void MandarABorrar(int NSerie) {

		try {
			if (objGestorIFCBS.EliminarSeriesDeArray(NSerie)) {
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

		int Seleccionado = TablaSeries.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

}
