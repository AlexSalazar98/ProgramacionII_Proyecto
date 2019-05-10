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
	private JButton BotonBorrar;
	private JScrollPane PanelSuelas;
	@SuppressWarnings("unused")
	private ClsTablaSeries TSuelas;
	private DefaultTableCellRenderer Alinear ; 

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

	public ClsConsultarBorrarSuelas(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarSeries.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Suelas");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 453, 302);
		Inicializar(ObjGestor);
	}

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

	}

	private void CrearTablaSuelas() {

		Suelas = objGestorIFCBSu.DameSuelas();

		ClsTablaSuelas TSuelas = new ClsTablaSuelas(Suelas);
		Alinear = new DefaultTableCellRenderer();

		TablaSuelas = new JTable(TSuelas);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaSuelas.getValueAt(TablaSuelas.getSelectedRow(), 0));
			int NSerie = Integer.parseInt(dato);
			MandarABorrar(NSerie);
			TablaSuelas.setVisible(false);
			Suelas = objGestorIFCBSu.DameSuelas();
			ClsTablaSuelas TablaActualizada = new ClsTablaSuelas(Suelas);
			TablaSuelas.setModel(TablaActualizada);
			Alinear.setHorizontalAlignment(SwingConstants.CENTER);
			TablaSuelas.getColumnModel().getColumn(0).setCellRenderer(Alinear);
			TablaSuelas.getColumnModel().getColumn(1).setCellRenderer(Alinear);
			TablaSuelas.getColumnModel().getColumn(2).setCellRenderer(Alinear);			
			TablaSuelas.setVisible(true);
			break;

		default:
			break;
		}

	}

	private void MandarABorrar(int NSerie) {

		try {
			if (objGestorIFCBSu.EliminarSuelasDeArray(NSerie)) {
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

		int Seleccionado = TablaSuelas.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

}
