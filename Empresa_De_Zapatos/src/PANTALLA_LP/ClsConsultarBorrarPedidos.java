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
 * Clase para mostrar y borrar pedidos de la tabla
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsConsultarBorrarPedidos extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private JTable TablaPedidos;
	private JLabel TxtTablaPedidos;
	private JButton BotonBorrar;
	private JScrollPane PanelPedidos;
	private ClsTablaPedidos TPedidos;
	private DefaultTableCellRenderer Alinear;

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFCBP;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Pedidos;
	int ObjetoRecuperado;

	/**
	 * Para el Lisener
	 */
	private final String BORRAR_BUTTON = "Boton de confirmar Pedidos";

	public ClsConsultarBorrarPedidos(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsConsultarBorrarPedidos.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Consultar Pedidos");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(25, 25, 591, 302);
		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFCBP = ObjGestor;

		TxtTablaPedidos = new JLabel("Pedidos");
		TxtTablaPedidos.setEnabled(false);
		TxtTablaPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		TxtTablaPedidos.setFont(new Font("Tahoma", Font.BOLD, 25));
		TxtTablaPedidos.setBounds(10, 11, 558, 23);
		getContentPane().add(TxtTablaPedidos);
		CrearTablaPedidos();

		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setEnabled(false);
		BotonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonBorrar.setBounds(479, 238, 89, 23);
		getContentPane().add(BotonBorrar);
		BotonBorrar.addActionListener(this);
		BotonBorrar.setActionCommand(BORRAR_BUTTON);

	}

	private void CrearTablaPedidos() {

		Pedidos = objGestorIFCBP.DamePedidos();

		TPedidos = new ClsTablaPedidos(Pedidos);
		Alinear = new DefaultTableCellRenderer();

		TablaPedidos = new JTable(TPedidos);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		TablaPedidos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaPedidos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPedidos.setFillsViewportHeight(true);
		TablaPedidos.setRowSelectionAllowed(true);
		TablaPedidos.getSelectionModel().addListSelectionListener(this);
		TPedidos.fireTableDataChanged();

		PanelPedidos = new JScrollPane();
		PanelPedidos.setBounds(10, 45, 558, 190);
		PanelPedidos.setViewportView(TablaPedidos);
		getContentPane().add(PanelPedidos);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case BORRAR_BUTTON:

			String dato = String.valueOf(TablaPedidos.getValueAt(TablaPedidos.getSelectedRow(), 0));
			int NSerie = Integer.parseInt(dato);
			MandarABorrar(NSerie);
			TablaPedidos.setVisible(false);
			Pedidos = objGestorIFCBP.DamePedidos();
			ClsTablaPedidos TablaActualizada = new ClsTablaPedidos(Pedidos);
			TablaPedidos.setModel(TablaActualizada);
			Alinear.setHorizontalAlignment(SwingConstants.CENTER);
			TablaPedidos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
			TablaPedidos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
			TablaPedidos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
			TablaPedidos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
			TablaPedidos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
			TablaPedidos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
			TablaPedidos.setVisible(true);
			break;

		default:
			break;
		}

	}

	private void MandarABorrar(int NSerie) {

		try {
			if (objGestorIFCBP.EliminarPedidosDeArray(NSerie)) {
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

		int Seleccionado = TablaPedidos.getSelectedRowCount();

		if (Seleccionado > 0) {
			BotonBorrar.setEnabled(true);
		}

	}

}