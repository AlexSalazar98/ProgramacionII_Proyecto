package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_ENTREGADO;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import COMUN.ItfProperty;
import LN.ClsGestorLN;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Clase para sacar tabla con ciertos atributos de pedidos y otros de desgloses
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsPedidosMasDesglose extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	private JLabel TxtBuscador, TxtFechaI, TxtFechaF;
	private JButton BotonExportar;
	private JDateChooser RecogerFInicio, RecogerFFinal;
	private JScrollPane scrollPane;
	private JButton BotonBuscar, BotonTotales;
	private Date FechaDeEntregaInicio, FechaDeEntregaFinal;
	private DefaultTableCellRenderer Alinear;
	private ClsTablaPedidoMasDesglose TDesgloses;
	private int contador = 0;

	/**
	 * Para tener el gestor.
	 */
	private ClsGestorLN objGestorIFPMD;

	/**
	 * Arrays con informacion
	 */
	ArrayList<ItfProperty> Pedidos, Desgloses;
	ArrayList<ItfProperty> PedidosEntreFechas;
	ArrayList<ItfProperty> DesglosesEntreFechas;
	ArrayList<ItfProperty> PedidosNoEntegados;

	/**
	 * Para el Lisener
	 */
	private final String BUSCAR_BUTTON = "Boton de buscar";
	private final String EXPORTAR_BUTTON = "Boton de exportar a excel";
	private final String TOTALES_BUTTON = "Boton de sacar totales";
	

	/**
	 * Constructor
	 * 
	 * @param ObjGestor
	 */
	public ClsPedidosMasDesglose(ClsGestorLN ObjGestor) {

		setFrameIcon(new ImageIcon(ClsPedidosMasDesglose.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Infome de producci\u00F3n");
		this.setBounds(25, 25, 1253, 302);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);

		Inicializar(ObjGestor);
	}

	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFPMD = ObjGestor;

		TxtBuscador = new JLabel("Buscador por fechas de entrega");
		TxtBuscador.setEnabled(false);
		TxtBuscador.setHorizontalAlignment(SwingConstants.CENTER);
		TxtBuscador.setFont(new Font("Tahoma", Font.BOLD, 20));
		TxtBuscador.setBounds(10, 11, 1217, 25);
		getContentPane().add(TxtBuscador);

		BotonExportar = new JButton("Exportar ");
		BotonExportar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonExportar.setBounds(1134, 238, 93, 23);
		getContentPane().add(BotonExportar);
		BotonExportar.addActionListener(this);
		BotonExportar.setActionCommand(EXPORTAR_BUTTON);

		TxtFechaI = new JLabel("Fecha de inicio:");
		TxtFechaI.setEnabled(false);
		TxtFechaI.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtFechaI.setBounds(401, 47, 116, 25);
		getContentPane().add(TxtFechaI);

		RecogerFInicio = new JDateChooser();
		RecogerFInicio.setBounds(527, 47, 90, 20);
		RecogerFInicio.setDateFormatString("dd-MM-yyyy");
		getContentPane().add(RecogerFInicio);

		TxtFechaF = new JLabel("Fecha final:");
		TxtFechaF.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtFechaF.setEnabled(false);
		TxtFechaF.setBounds(627, 47, 89, 25);
		getContentPane().add(TxtFechaF);

		RecogerFFinal = new JDateChooser();
		RecogerFFinal.setBounds(726, 47, 89, 20);
		RecogerFFinal.setDateFormatString("dd-MM-yyyy");
		getContentPane().add(RecogerFFinal);

		BotonBuscar = new JButton("\ud83d\udd0e");
		BotonBuscar.setBounds(1184, 47, 43, 25);
		getContentPane().add(BotonBuscar);
		BotonBuscar.addActionListener(this);
		BotonBuscar.setActionCommand(BUSCAR_BUTTON);

		BotonTotales = new JButton("Totales");
		BotonTotales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonTotales.setBounds(10, 244, 89, 23);
		getContentPane().add(BotonTotales);
		BotonTotales.addActionListener(this);
		BotonTotales.setActionCommand(TOTALES_BUTTON);

	}

	private void ObtenerDatos() {

		Pedidos = objGestorIFPMD.OrdenarPedidos();
		Desgloses = objGestorIFPMD.OrdenarDesgloses();

		PedidosEntreFechas = new ArrayList<ItfProperty>();
		DesglosesEntreFechas = new ArrayList<ItfProperty>();
		PedidosNoEntegados = new ArrayList<ItfProperty>();

		for (ItfProperty a : Pedidos) {

			if (!a.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO)) {
				PedidosNoEntegados.add(a);
			}

		}

		/**
		 * Para formatear las fechas
		 */
		SimpleDateFormat miFormato = new SimpleDateFormat("yyyy-MM-dd");

		int NPedido;
		int NPedidoDesglose;

		for (ItfProperty a : PedidosNoEntegados) {
			String AComparar = String.valueOf(a.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA));

			FormatearFechaEntregaInicio();
			FormatearFechaEntregaFinal();

			int antes = miFormato.format(FechaDeEntregaInicio).compareTo(AComparar);
			int despues = miFormato.format(FechaDeEntregaFinal).compareTo(AComparar);

			if (antes <= 0 && despues >= 0) {
				PedidosEntreFechas.add(a);
			}

		}

		for (ItfProperty a : PedidosEntreFechas) {
			NPedido = a.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO);

			for (ItfProperty b : Desgloses) {
				NPedidoDesglose = b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO);

				if (NPedido == NPedidoDesglose) {
					DesglosesEntreFechas.add(b);

				}

			}

		}

		if (DesglosesEntreFechas.size() == 0) {
			String MENSAJE;
			MENSAJE = "No existen pedidos en esas fechas";

			JOptionPane.showMessageDialog(null, MENSAJE, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	/**
	 * Metodo para parsear fechas de entrega inicio
	 */
	private void FormatearFechaEntregaInicio() {
		DateFormat miFormato;
		String fecha;

		/**
		 * fromateamos la fecha de otro modo diferente al anterior para sacarla por
		 * pantalla.
		 */
		miFormato = DateFormat.getDateInstance(DateFormat.SHORT);
		fecha = miFormato.format(RecogerFInicio.getDate());

		try {
			FechaDeEntregaInicio = miFormato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para parsear fechas de entrega final
	 */
	private void FormatearFechaEntregaFinal() {
		DateFormat miFormato;
		String fecha;

		/**
		 * fromateamos la fecha de otro modo diferente al anterior para sacarla por
		 * pantalla.
		 */
		miFormato = DateFormat.getDateInstance(DateFormat.SHORT);
		fecha = miFormato.format(RecogerFFinal.getDate());

		try {
			FechaDeEntregaFinal = miFormato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void CrearTabla() {

		TDesgloses = new ClsTablaPedidoMasDesglose(DesglosesEntreFechas);
		Alinear = new DefaultTableCellRenderer();

		table = new JTable(TDesgloses);

		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(7).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(8).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(9).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(10).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(11).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(12).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(13).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(14).setCellRenderer(Alinear);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		TDesgloses.fireTableDataChanged();

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 1217, 146);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case BUSCAR_BUTTON:
			ObtenerDatos();
			if (contador == 0) {
				CrearTabla();
				contador = contador + 1;
			} else {
				ActualizarTabla();
			}
			break;

		case EXPORTAR_BUTTON:
			try {
				@SuppressWarnings("unused")
				ClsExportar ObjExportar = new ClsExportar(table);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		default:
			break;
		}

	}

	private void ActualizarTabla() {

		table.setVisible(false);
		ClsTablaPedidoMasDesglose TablaActualizada = new ClsTablaPedidoMasDesglose(DesglosesEntreFechas);
		table.setModel(TablaActualizada);
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(4).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(5).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(6).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(7).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(8).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(9).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(10).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(11).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(12).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(13).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(14).setCellRenderer(Alinear);
		table.setVisible(true);

	}

}
