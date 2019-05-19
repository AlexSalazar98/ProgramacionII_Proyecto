package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JButton;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import COMUN.ItfProperty;
import LN.ClsGestorLN;
import Tablas.ClsTablaArticulos;
import Tablas.ClsTablaPedidos;
import Tablas.ClsTablaSeries;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ClsIFIntroducirDesgloses extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Objetos de la clase
	 */
	private JTabbedPane Pestañas;
	private JTextField RecogerNDesglose, RecogerNColor, RecogerP5, RecogerP6, RecogerP7, RecogerP8, RecogerP9,
			RecogerP0, RecogerP1, RecogerP2, RecogerP3, RecogerP4;
	private JPanel General, Cantidades, Articulos;
	private JButton BotonConfirmar;
	private JComboBox<Integer> RecogerNPedido, RecogerRefArt, RecogerNSerie;
	private JSplitPane SeriesPedidos;
	private JScrollPane PanelPedidos, PanelArticulos, PanelSeries;
	private JTable TablaSeries, TablaArticulos, TablaPedidos;
	private int Color, NumeroDePie5, NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1,
			NumeroDePie2, NumeroDePie3, NumeroDePie4;

	/**
	 * ArrayList para las tablas
	 */
	private ArrayList<ItfProperty> Pedidos, Series, ArticulosT;

	/**
	 * Para el Lisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Desgloses";

	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIDes;

	/**
	 * Constructor
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	public ClsIFIntroducirDesgloses(ClsGestorLN ObjGestor) {
		setTitle("Introducir Desgloses");
		setFrameIcon(new ImageIcon(ClsIFIntroducirDesgloses.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		this.setBounds(175, 175, 491, 301);

		Inicializar(ObjGestor);
		ObtenerUltimoID();
	}

	/**
	 * Metodo para inicializar objetos
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFIDes = ObjGestor;

		Pedidos = objGestorIFIDes.OrdenarPedidos();
		Series = objGestorIFIDes.DameSeries();
		ArticulosT = objGestorIFIDes.DameArticulos();

		Pestañas = new JTabbedPane(JTabbedPane.TOP);
		Pestañas.setBounds(0, 0, 475, 271);
		getContentPane().add(Pestañas);

		General = new JPanel();
		Pestañas.addTab("General", null, General, null);
		General.setBounds(175, 175, 445, 290);
		General.setLayout(null);

		JLabel TxtNDesglose = new JLabel("N\u00FAmero de Desglose:");
		TxtNDesglose.setBounds(10, 11, 166, 19);
		General.add(TxtNDesglose);
		TxtNDesglose.setEnabled(false);
		TxtNDesglose.setFont(new Font("Tahoma", Font.BOLD, 15));

		BotonConfirmar = new JButton("Confirmar Desglose");
		BotonConfirmar.setBounds(311, 216, 159, 27);
		General.add(BotonConfirmar);
		BotonConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonConfirmar.addActionListener(this);
		BotonConfirmar.setActionCommand(CONFIRMAR_BUTTON);

		RecogerNDesglose = new JTextField();
		RecogerNDesglose.setBounds(186, 11, 70, 19);
		General.add(RecogerNDesglose);
		RecogerNDesglose.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNDesglose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNDesglose.setEnabled(false);
		RecogerNDesglose.setEditable(false);
		RecogerNDesglose.setColumns(10);

		JLabel TxtNPedido = new JLabel("N\u00FAmero de Pedido:");
		TxtNPedido.setEnabled(false);
		TxtNPedido.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNPedido.setBounds(10, 57, 146, 19);
		General.add(TxtNPedido);

		RecogerNPedido = new JComboBox<Integer>();
		RecogerNPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNPedido.setBounds(166, 57, 49, 22);
		General.add(RecogerNPedido);

		JLabel TxtRefArt = new JLabel("Referencia del Art\u00EDculo:");
		TxtRefArt.setEnabled(false);
		TxtRefArt.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtRefArt.setBounds(10, 105, 177, 19);
		General.add(TxtRefArt);

		RecogerRefArt = new JComboBox<Integer>();
		RecogerRefArt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerRefArt.setBounds(197, 105, 49, 22);
		General.add(RecogerRefArt);

		JLabel TxtNSerie = new JLabel("N\u00FAmero de Serie:");
		TxtNSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNSerie.setEnabled(false);
		TxtNSerie.setBounds(270, 109, 130, 15);
		General.add(TxtNSerie);

		RecogerNSerie = new JComboBox<Integer>();
		RecogerNSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNSerie.setBounds(410, 105, 49, 22);
		General.add(RecogerNSerie);

		JLabel TxtNColor = new JLabel("N\u00FAmero de Color:");
		TxtNColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNColor.setEnabled(false);
		TxtNColor.setBounds(68, 163, 130, 19);
		General.add(TxtNColor);

		RecogerNColor = new JTextField();
		RecogerNColor.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNColor.setBounds(208, 164, 86, 20);
		General.add(RecogerNColor);
		RecogerNColor.setColumns(10);

		Cantidades = new JPanel();
		Pestañas.addTab("Cantidades", null, Cantidades, null);
		Cantidades.setLayout(null);

		JLabel TxtCantidades = new JLabel("Cantidad de cada n\u00FAmero de pie:");
		TxtCantidades.setEnabled(false);
		TxtCantidades.setHorizontalAlignment(SwingConstants.CENTER);
		TxtCantidades.setFont(new Font("Tahoma", Font.BOLD, 20));
		TxtCantidades.setBounds(10, 11, 450, 25);
		Cantidades.add(TxtCantidades);

		JLabel TxtP5 = new JLabel("Pie 5:");
		TxtP5.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP5.setEnabled(false);
		TxtP5.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP5.setBounds(71, 54, 46, 24);
		Cantidades.add(TxtP5);

		JLabel TxtP6 = new JLabel("Pie 6:");
		TxtP6.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP6.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP6.setEnabled(false);
		TxtP6.setBounds(71, 89, 46, 24);
		Cantidades.add(TxtP6);

		JLabel TxtP7 = new JLabel("Pie 7:");
		TxtP7.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP7.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP7.setEnabled(false);
		TxtP7.setBounds(71, 124, 46, 24);
		Cantidades.add(TxtP7);

		JLabel TxtP8 = new JLabel("Pie 8:");
		TxtP8.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP8.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP8.setEnabled(false);
		TxtP8.setBounds(71, 159, 46, 24);
		Cantidades.add(TxtP8);

		JLabel TxtP9 = new JLabel("Pie 9:");
		TxtP9.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP9.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP9.setEnabled(false);
		TxtP9.setBounds(71, 194, 46, 24);
		Cantidades.add(TxtP9);

		RecogerP5 = new JTextField();
		RecogerP5.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP5.setBounds(127, 58, 86, 20);
		Cantidades.add(RecogerP5);
		RecogerP5.setColumns(10);

		RecogerP6 = new JTextField();
		RecogerP6.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP6.setBounds(127, 93, 86, 20);
		Cantidades.add(RecogerP6);
		RecogerP6.setColumns(10);

		RecogerP7 = new JTextField();
		RecogerP7.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP7.setBounds(127, 128, 86, 20);
		Cantidades.add(RecogerP7);
		RecogerP7.setColumns(10);

		RecogerP8 = new JTextField();
		RecogerP8.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP8.setBounds(127, 163, 86, 20);
		Cantidades.add(RecogerP8);
		RecogerP8.setColumns(10);

		RecogerP9 = new JTextField();
		RecogerP9.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP9.setBounds(127, 198, 86, 20);
		Cantidades.add(RecogerP9);
		RecogerP9.setColumns(10);

		JLabel TxtP0 = new JLabel("Pie 0:");
		TxtP0.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP0.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP0.setEnabled(false);
		TxtP0.setBounds(244, 54, 46, 24);
		Cantidades.add(TxtP0);

		RecogerP0 = new JTextField();
		RecogerP0.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP0.setColumns(10);
		RecogerP0.setBounds(300, 58, 86, 20);
		Cantidades.add(RecogerP0);

		JLabel TxtP1 = new JLabel("Pie 1:");
		TxtP1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP1.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP1.setEnabled(false);
		TxtP1.setBounds(244, 89, 46, 24);
		Cantidades.add(TxtP1);

		RecogerP1 = new JTextField();
		RecogerP1.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP1.setColumns(10);
		RecogerP1.setBounds(300, 93, 86, 20);
		Cantidades.add(RecogerP1);

		JLabel TxtP2 = new JLabel("Pie 2:");
		TxtP2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP2.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP2.setEnabled(false);
		TxtP2.setBounds(244, 124, 46, 24);
		Cantidades.add(TxtP2);

		RecogerP2 = new JTextField();
		RecogerP2.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP2.setColumns(10);
		RecogerP2.setBounds(300, 128, 86, 20);
		Cantidades.add(RecogerP2);

		JLabel TxtP3 = new JLabel("Pie 3:");
		TxtP3.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP3.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP3.setEnabled(false);
		TxtP3.setBounds(244, 159, 46, 24);
		Cantidades.add(TxtP3);

		RecogerP3 = new JTextField();
		RecogerP3.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP3.setColumns(10);
		RecogerP3.setBounds(300, 163, 86, 20);
		Cantidades.add(RecogerP3);

		JLabel TxtP4 = new JLabel("Pie 4:");
		TxtP4.setHorizontalAlignment(SwingConstants.CENTER);
		TxtP4.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtP4.setEnabled(false);
		TxtP4.setBounds(244, 194, 46, 24);
		Cantidades.add(TxtP4);

		RecogerP4 = new JTextField();
		RecogerP4.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerP4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerP4.setColumns(10);
		RecogerP4.setBounds(300, 198, 86, 20);
		Cantidades.add(RecogerP4);

		SeriesPedidos = new JSplitPane();
		SeriesPedidos.setOrientation(JSplitPane.VERTICAL_SPLIT);
		SeriesPedidos.setResizeWeight(0.5);
		Pestañas.addTab("Pedidos/Series", null, SeriesPedidos, null);

		Articulos = new JPanel();
		Pestañas.addTab("Art\u00EDculos", null, Articulos, null);
		Articulos.setLayout(null);

		/**
		 * Llamadas para crear las tablas
		 */
		CrearTablaSeries();
		CrearTablaPedidos();
		CrearTablaArticulos();

		/**
		 * Cargamos combobox series
		 */
		for (ItfProperty a : Series) {

			RecogerNSerie.addItem(a.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE));
		}

		/**
		 * cargamos combobox articulos
		 */
		for (ItfProperty a : ArticulosT) {

			RecogerRefArt.addItem(a.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA));
		}

		/**
		 * Cargamos combobox pedidos
		 */
		for (ItfProperty a : Pedidos) {

			RecogerNPedido.addItem(a.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO));
		}

	}

	/**
	 * Metodo para crear tabla
	 */
	private void CrearTablaPedidos() {

		ClsTablaPedidos TPedidos = new ClsTablaPedidos(Pedidos);
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();

		TablaPedidos = new JTable(TPedidos);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);

		JTableHeader header = TablaPedidos.getTableHeader();
		header.setVisible(true);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		TablaPedidos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaPedidos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaPedidos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPedidos.setFillsViewportHeight(true);
		TablaPedidos.setEnabled(false);
		TablaPedidos.setRowSelectionAllowed(true);
		TPedidos.fireTableDataChanged();

		PanelPedidos = new JScrollPane();
		SeriesPedidos.setLeftComponent(PanelPedidos);
		PanelPedidos.setViewportView(TablaPedidos);
		TPedidos.setData(Pedidos);
	}

	/**
	 * Metodo para crear tabla
	 */
	private void CrearTablaArticulos() {

		ClsTablaArticulos TArticulos = new ClsTablaArticulos(ArticulosT);
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();

		TablaArticulos = new JTable(TArticulos);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);

		JTableHeader header = TablaArticulos.getTableHeader();
		header.setVisible(true);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		TablaArticulos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		TablaArticulos.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		TablaArticulos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaArticulos.setFillsViewportHeight(true);
		TablaArticulos.setEnabled(false);
		TablaArticulos.setRowSelectionAllowed(true);
		TArticulos.fireTableDataChanged();

		PanelArticulos = new JScrollPane();
		PanelArticulos.setBounds(0, 25, 470, 207);
		PanelArticulos.setViewportView(TablaArticulos);
		Articulos.add(PanelArticulos);

		JLabel TxtArticulos = new JLabel("Tabla de Art\u00EDculos");
		TxtArticulos.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		TxtArticulos.setBounds(10, 0, 450, 29);
		Articulos.add(TxtArticulos);
	}

	/**
	 * Metodo para crear tabla
	 */
	private void CrearTablaSeries() {

		ClsTablaSeries TSeries = new ClsTablaSeries(Series);
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();

		TablaSeries = new JTable(TSeries);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);

		JTableHeader header = TablaSeries.getTableHeader();
		header.setVisible(true);
		header.setFont(new Font("Tahoma", Font.BOLD, 13));

		TablaSeries.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		TablaSeries.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		TablaSeries.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaSeries.setFillsViewportHeight(true);
		TablaSeries.setEnabled(false);
		TablaSeries.setRowSelectionAllowed(true);
		TSeries.fireTableDataChanged();

		PanelSeries = new JScrollPane();
		SeriesPedidos.setRightComponent(PanelSeries);
		PanelSeries.setViewportView(TablaSeries);
		TSeries.setData(objGestorIFIDes);
	}

	/**
	 * Escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case CONFIRMAR_BUTTON:
			Comporobar();
			ObtenerUltimoID();
			break;

		default:
			break;
		}

	}

	/**
	 * Metodo para comprobar que los valores introducidos son adecuados
	 */
	private void Comporobar() {

		boolean comprobado = true;

		try {
			Color = Integer.parseInt(RecogerNColor.getText());
		} catch (Exception e) {
			comprobado = false;
			JOptionPane.showMessageDialog(null, "Numero de Color erroneo");
		}

		if (RecogerP5.getText().equals("")) {
			NumeroDePie5 = 0;
		} else {
			try {
				NumeroDePie5 = Integer.parseInt(RecogerP5.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP6.getText().equals("")) {
			NumeroDePie6 = 0;
		} else {
			try {
				NumeroDePie6 = Integer.parseInt(RecogerP6.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP7.getText().equals("")) {
			NumeroDePie7 = 0;
		} else {
			try {
				NumeroDePie7 = Integer.parseInt(RecogerP7.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP8.getText().equals("")) {
			NumeroDePie8 = 0;
		} else {
			try {
				NumeroDePie8 = Integer.parseInt(RecogerP8.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP9.getText().equals("")) {
			NumeroDePie9 = 0;
		} else {
			try {
				NumeroDePie9 = Integer.parseInt(RecogerP9.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP0.getText().equals("")) {
			NumeroDePie0 = 0;
		} else {
			try {
				NumeroDePie0 = Integer.parseInt(RecogerP0.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP1.getText().equals("")) {
			NumeroDePie1 = 0;
		} else {
			try {
				NumeroDePie1 = Integer.parseInt(RecogerP1.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP2.getText().equals("")) {
			NumeroDePie2 = 0;
		} else {
			try {
				NumeroDePie2 = Integer.parseInt(RecogerP2.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP3.getText().equals("")) {
			NumeroDePie3 = 0;
		} else {
			try {
				NumeroDePie3 = Integer.parseInt(RecogerP3.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (RecogerP4.getText().equals("")) {
			NumeroDePie4 = 0;
		} else {
			try {
				NumeroDePie4 = Integer.parseInt(RecogerP4.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "Cantidad de pie erronea");
			}
		}

		if (comprobado) {
			MandarAGestor();
		}

	}

	/**
	 * Metodo para poner campos vacios
	 */
	private void PonerVacio() {

		RecogerNColor.setText("");
		RecogerP0.setText("");
		RecogerP1.setText("");
		RecogerP2.setText("");
		RecogerP3.setText("");
		RecogerP4.setText("");
		RecogerP5.setText("");
		RecogerP6.setText("");
		RecogerP7.setText("");
		RecogerP8.setText("");
		RecogerP9.setText("");

	}

	/**
	 * Metodo para mandar los datos al gestor
	 */
	private void MandarAGestor() {

		int NumeroDePedido = Integer.parseInt(RecogerNDesglose.getText());
		int ReferenciaDelArticulo = Integer.parseInt(RecogerRefArt.getSelectedItem().toString());
		int Serie = Integer.parseInt(RecogerNSerie.getSelectedItem().toString());

		int CantidadTotal = NumeroDePie5 + NumeroDePie6 + NumeroDePie7 + NumeroDePie8 + NumeroDePie9 + NumeroDePie0
				+ NumeroDePie1 + NumeroDePie2 + NumeroDePie3 + NumeroDePie4;
		int Pedidos_NPedido = Integer.parseInt(RecogerNPedido.getSelectedItem().toString());

		try {
			if (objGestorIFIDes.CrearDesgloseDePedido(NumeroDePedido, ReferenciaDelArticulo, Serie, Color, NumeroDePie5,
					NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1, NumeroDePie2,
					NumeroDePie3, NumeroDePie4, CantidadTotal, Pedidos_NPedido)) {
				JOptionPane.showMessageDialog(null, "Desglose introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID del Desglose repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

		PonerVacio();

	}

	/**
	 * Metodo para obtener automaticamente el siguiente ID.
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Desgloses = objGestorIFIDes.OrdenarDesgloses();

		ItfProperty UltimoObjeto = Desgloses.get(Desgloses.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		RecogerNDesglose.setText(IDActualizado);

	}
}
