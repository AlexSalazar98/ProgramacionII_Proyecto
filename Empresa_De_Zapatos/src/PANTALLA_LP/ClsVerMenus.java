package PANTALLA_LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import LN.ClsGestorLN;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;

/**
 * Pantalla de introducir los datos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsVerMenus extends JFrame implements ActionListener {

	/**
	 * Variable para guardar el gestor
	 */
	private ClsGestorLN objGestorMID;
	/**
	 * Ni idea de para que sirve.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constantes para el LISENER de insertar.
	 */
	private final String ARTICULOS_INSERTAR_BUTTON = "Boton de articulos";
	private final String CLIENTES_INSERTAR_BUTTON = "Boton de clientes";
	private final String DESGLOSE_INSERTAR_BUTTON = "Boton de desglose";
	private final String ENVIOS_INSERTAR_BUTTON = "Boton de envios";
	private final String HERRAJES_INSERTAR_BUTTON = "Boton de herrajes";
	private final String MATERIALES_INSERTAR_BUTTON = "Boton de materiales";
	private final String PEDIDOS_INSERTAR_BUTTON = "Boton de pedidos";
	private final String SERIES_INSERTAR_BUTTON = "Boton de series";
	private final String SUELAS_INSERTAR_BUTTON = "Boton de suelas";

	private final String ARTICULOS_BORRAR_BUTTON = "Boton de articulos";
	private final String CLIENTES_BORRAR_BUTTON = "Boton de clientes";
	private final String DESGLOSE_BORRAR_BUTTON = "Boton de desglose";
	private final String ENVIOS_BORRAR_BUTTON = "Boton de envios";
	private final String HERRAJES_BORRAR_BUTTON = "Boton de herrajes";
	private final String MATERIALES_BORRAR_BUTTON = "Boton de materiales";
	private final String PEDIDOS_BORRAR_BUTTON = "Boton de pedidos";
	private final String SERIES_BORRAR_BUTTON = "Boton de series";
	private final String SUELAS_BORRAR_BUTTON = "Boton de suelas";

	private final String ARTICULOS_CONSULTAR_BUTTON = "Boton de articulos";
	private final String CLIENTES_CONSULTAR_BUTTON = "Boton de clientes";
	private final String DESGLOSE_CONSULTAR_BUTTON = "Boton de desglose";
	private final String ENVIOS_CONSULTAR_BUTTON = "Boton de envios";
	private final String PEDIDOS_CONSULTAR_BUTTON = "Boton de pedidos";

	private final String ENTREGAS_ACTUALIZAR_BUTTON = "Boton de entregas";

	/**
	 * Objetos instanciados
	 */
	private JDesktopPane PanelMenuIntrducirDatos;
	private JMenuBar menuBar;
	private JMenu Actualizar, Borrar, Consultar, Introducir;
	private JMenuItem ArticulosIntroducir, ClientesIntroducir, DesgloseIntroducir, EnviosIntroducir, HerrajesIntroducir,
			MaterialesIntroducir, PedidosIntroducir, SeriesIntroducir, SuelasIntroducir;
	private JMenuItem EntregasActualizar;
	private JMenuItem ArticulosBorrar, ClientesBorrar, DesgloseBorrar, EnviosBorrar, HerrajesBorrar, MaterialesBorrar,
			PedidosBorrar, SeriesBorrar, SuelasBorrar;
	private JMenuItem ArticulosConsultar, ClientesConsultar, DesgloseConsultar, EnviosConsultar, PedidosConsultar;
	private ClsIFIntroducirClientes IntFrameClientes;
	private ClsIFIntroducirSeries IntFrameSeries;
	private ClsIFIntroducirHerrajes IntFrameHerrajes;
	private ClsIFIntroducirSuelas IntFrameSuelas;
	private ClsIFIntroducirMateriales IntFrameMateriales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ClsGestorLN ObjGestor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsVerMenus frame = new ClsVerMenus(ObjGestor);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Constructor
	 */
	public ClsVerMenus(ClsGestorLN ObjGestor) {
		objGestorMID = ObjGestor;
		IniciarComponentes(ObjGestor);

	}

	/**
	 * Crea los componentes
	 */
	private void IniciarComponentes(ClsGestorLN ObjGestor) {

		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/**
		 * Inicializamos panel
		 */
		PanelMenuIntrducirDatos = new JDesktopPane();
		PanelMenuIntrducirDatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelMenuIntrducirDatos);
		PanelMenuIntrducirDatos.setLayout(null);
		PanelMenuIntrducirDatos.addComponentListener(null);

		/**
		 * Inicializamos la barra de menu
		 */
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLUE);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setJMenuBar(menuBar);

		/**
		 * Inicializamos boton de Introducir
		 */

		Actualizar = new JMenu("Actualizar");
		Actualizar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Actualizar.setForeground(Color.BLUE);
		menuBar.add(Actualizar);

		EntregasActualizar = new JMenuItem("Entregas");
		Actualizar.add(EntregasActualizar);
		EntregasActualizar.addActionListener(this);
		EntregasActualizar.setActionCommand(ENTREGAS_ACTUALIZAR_BUTTON);

		Borrar = new JMenu("Eliminar");
		Borrar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Borrar.setForeground(Color.BLUE);
		menuBar.add(Borrar);

		ArticulosBorrar = new JMenuItem("Articulos");
		Borrar.add(ArticulosBorrar);
		ArticulosBorrar.addActionListener(this);
		ArticulosBorrar.setActionCommand(ARTICULOS_BORRAR_BUTTON);

		JSeparator separator_8 = new JSeparator();
		Borrar.add(separator_8);

		ClientesBorrar = new JMenuItem("Clientes");
		Borrar.add(ClientesBorrar);
		ClientesBorrar.addActionListener(this);
		ClientesBorrar.setActionCommand(CLIENTES_BORRAR_BUTTON);

		JSeparator separator_9 = new JSeparator();
		Borrar.add(separator_9);

		DesgloseBorrar = new JMenuItem("Desglose de Pedido");
		Borrar.add(DesgloseBorrar);
		DesgloseBorrar.addActionListener(this);
		DesgloseBorrar.setActionCommand(DESGLOSE_BORRAR_BUTTON);

		JSeparator separator_10 = new JSeparator();
		Borrar.add(separator_10);

		EnviosBorrar = new JMenuItem("Envios");
		Borrar.add(EnviosBorrar);
		EnviosBorrar.addActionListener(this);
		EnviosBorrar.setActionCommand(ENVIOS_BORRAR_BUTTON);

		JSeparator separator_11 = new JSeparator();
		Borrar.add(separator_11);

		HerrajesBorrar = new JMenuItem("Herrajes");
		Borrar.add(HerrajesBorrar);
		HerrajesBorrar.addActionListener(this);
		HerrajesBorrar.setActionCommand(HERRAJES_BORRAR_BUTTON);

		JSeparator separator_12 = new JSeparator();
		Borrar.add(separator_12);

		MaterialesBorrar = new JMenuItem("Materiales");
		Borrar.add(MaterialesBorrar);
		MaterialesBorrar.addActionListener(this);
		MaterialesBorrar.setActionCommand(MATERIALES_BORRAR_BUTTON);

		JSeparator separator_13 = new JSeparator();
		Borrar.add(separator_13);

		PedidosBorrar = new JMenuItem("Pedidos");
		Borrar.add(PedidosBorrar);
		PedidosBorrar.addActionListener(this);
		PedidosBorrar.setActionCommand(PEDIDOS_BORRAR_BUTTON);

		JSeparator separator_14 = new JSeparator();
		Borrar.add(separator_14);

		SeriesBorrar = new JMenuItem("Series");
		Borrar.add(SeriesBorrar);
		SeriesBorrar.addActionListener(this);
		SeriesBorrar.setActionCommand(SERIES_BORRAR_BUTTON);

		JSeparator separator_15 = new JSeparator();
		Borrar.add(separator_15);

		SuelasBorrar = new JMenuItem("Suelas");
		Borrar.add(SuelasBorrar);
		SuelasBorrar.addActionListener(this);
		SuelasBorrar.setActionCommand(SUELAS_BORRAR_BUTTON);

		Consultar = new JMenu("Consultar");
		Consultar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Consultar.setForeground(Color.BLUE);
		menuBar.add(Consultar);

		ArticulosConsultar = new JMenuItem("Articulos");
		Consultar.add(ArticulosConsultar);
		ArticulosConsultar.addActionListener(this);
		ArticulosConsultar.setActionCommand(ARTICULOS_CONSULTAR_BUTTON);

		JSeparator separator_16 = new JSeparator();
		Consultar.add(separator_16);

		ClientesConsultar = new JMenuItem("Clientes");
		Consultar.add(ClientesConsultar);
		ClientesConsultar.addActionListener(this);
		ClientesConsultar.setActionCommand(CLIENTES_CONSULTAR_BUTTON);

		JSeparator separator_17 = new JSeparator();
		Consultar.add(separator_17);

		DesgloseConsultar = new JMenuItem("Desgloses de Pedidos");
		Consultar.add(DesgloseConsultar);
		DesgloseConsultar.addActionListener(this);
		DesgloseConsultar.setActionCommand(DESGLOSE_CONSULTAR_BUTTON);

		JSeparator separator_18 = new JSeparator();
		Consultar.add(separator_18);

		EnviosConsultar = new JMenuItem("Envios");
		Consultar.add(EnviosConsultar);
		EnviosConsultar.addActionListener(this);
		EnviosConsultar.setActionCommand(ENVIOS_CONSULTAR_BUTTON);

		JSeparator separator_19 = new JSeparator();
		Consultar.add(separator_19);

		PedidosConsultar = new JMenuItem("Pedidos");
		Consultar.add(PedidosConsultar);
		PedidosConsultar.addActionListener(this);
		PedidosConsultar.setActionCommand(PEDIDOS_CONSULTAR_BUTTON);

		Introducir = new JMenu("Introducir ");
		Introducir.setForeground(Color.BLUE);
		Introducir.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(Introducir);

		/**
		 * Inicializamos boton de Articulos
		 */
		ArticulosIntroducir = new JMenuItem("Articulos");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(ArticulosIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		ArticulosIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		ArticulosIntroducir.setActionCommand(ARTICULOS_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator = new JSeparator();
		Introducir.add(separator);

		/**
		 * Inicializamos boton de Clientes
		 */
		ClientesIntroducir = new JMenuItem("Clientes");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(ClientesIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		ClientesIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		ClientesIntroducir.setActionCommand(CLIENTES_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_1 = new JSeparator();
		Introducir.add(separator_1);

		/**
		 * Inicializamos boton de Desglose
		 */
		DesgloseIntroducir = new JMenuItem("Desglose de Pedido");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(DesgloseIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		DesgloseIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		DesgloseIntroducir.setActionCommand(DESGLOSE_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_2 = new JSeparator();
		Introducir.add(separator_2);

		/**
		 * Inicializamos boton de Envios
		 */
		EnviosIntroducir = new JMenuItem("Envios");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(EnviosIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		EnviosIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		EnviosIntroducir.setActionCommand(ENVIOS_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_3 = new JSeparator();
		Introducir.add(separator_3);

		/**
		 * Inicializamos boton de Herrajes
		 */
		HerrajesIntroducir = new JMenuItem("Herrajes");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(HerrajesIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		HerrajesIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		HerrajesIntroducir.setActionCommand(HERRAJES_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_4 = new JSeparator();
		Introducir.add(separator_4);

		/**
		 * Inicializamos boton de Materiales
		 */
		MaterialesIntroducir = new JMenuItem("Materiales");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(MaterialesIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		MaterialesIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		MaterialesIntroducir.setActionCommand(MATERIALES_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_5 = new JSeparator();
		Introducir.add(separator_5);

		/**
		 * Inicializamos boton de Pedidos
		 */
		PedidosIntroducir = new JMenuItem("Pedidos");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(PedidosIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		PedidosIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		PedidosIntroducir.setActionCommand(PEDIDOS_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_6 = new JSeparator();
		Introducir.add(separator_6);

		/**
		 * Inicializamos boton de Series
		 */
		SeriesIntroducir = new JMenuItem("Series");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(SeriesIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		SeriesIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		SeriesIntroducir.setActionCommand(SERIES_INSERTAR_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_7 = new JSeparator();
		Introducir.add(separator_7);

		/**
		 * Inicializamos boton de Suelas
		 */
		SuelasIntroducir = new JMenuItem("Suelas");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(SuelasIntroducir);
		/**
		 * Implementamos el escuchador al boton
		 */
		SuelasIntroducir.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		SuelasIntroducir.setActionCommand(SUELAS_INSERTAR_BUTTON);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		/**
		 * si pulsa en introducir series
		 */
		case SERIES_INSERTAR_BUTTON:
			IntroducirSeries();
			break;
		/**
		 * Si pulsa en introducir Herrajes
		 */
		case HERRAJES_INSERTAR_BUTTON:
			IntroducirHerrajes();
			break;
		/**
		 * Si pulsa en introducir Materiales
		 */
		case MATERIALES_INSERTAR_BUTTON:
			IntroducirMateriales();
			break;
		/**
		 * Si pulsa en introducir Suelas
		 */
		case SUELAS_INSERTAR_BUTTON:
			IntroducirSuelas();
			break;
		/**
		 * Si pulsa en introducir Clientes
		 */
		case CLIENTES_INSERTAR_BUTTON:
			IntroducirClientes();
			break;
		/**
		 * si pulsa en introducir envios
		 */
		case ENVIOS_INSERTAR_BUTTON:
			//IntroducirEnvios();
			break;
		default:
			break;
		}

	}

	/**
	 * Llamada al InternalFrame Para introducir Series
	 */
	private void IntroducirSeries() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaSeriesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameSeries = new ClsIFIntroducirSeries(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameSeries);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameSeries.setVisible(true);
		try {
			IntFrameSeries.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada al InternalFrame para introducir Herrajes
	 */
	private void IntroducirHerrajes() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaHerrajesAbierta()) {
			/**
			 * Creamos Objeto IFrameHerrajes
			 */
			IntFrameHerrajes = new ClsIFIntroducirHerrajes(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameHerrajes);
		}

		/**
		 * Lo hacemos visible
		 */
		IntFrameHerrajes.setVisible(true);
		IntFrameHerrajes.moveToFront();
		try {
			IntFrameHerrajes.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Llamada al InternalFrame para introducir Materiales
	 */
	private void IntroducirMateriales() {
		/**
		 * Comprobamos si esta abierta la ventana
		 */
		if (!ComprobarVentanaMaterialesAbierta()) {
			/**
			 * Creamos el objeto
			 */
			IntFrameMateriales = new ClsIFIntroducirMateriales(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameMateriales);
		}

		/**
		 * Lo hacemos visible
		 */
		IntFrameMateriales.setVisible(true);
		try {
			IntFrameMateriales.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Llamada al InternalFrame para introducir Suelas
	 */
	private void IntroducirSuelas() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaSuelasAbierta()) {
			/**
			 * Creamos el objeto
			 */
			IntFrameSuelas = new ClsIFIntroducirSuelas(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameSuelas);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameSuelas.setVisible(true);
		try {
			IntFrameSuelas.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Llamada al InternalFrame para introducir Clientes
	 */
	private void IntroducirClientes() {
		/**
		 * Comprobamos que la ventana no este abierta.
		 */
		if (!ComprobarVentanaClientesAbierta()) {
			/**
			 * creamos el objeto
			 */
			IntFrameClientes = new ClsIFIntroducirClientes(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameClientes);
		}

		/**
		 * Lo hacemos visible
		 */
		IntFrameClientes.setVisible(true);
		try {
			IntFrameClientes.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	public boolean ComprobarVentanaHerrajesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameHerrajes == null || IntFrameHerrajes.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameHerrajes.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameHerrajes.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameHerrajes);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para detectar si InternalFrame Herrajes esta abierto
	 * 
	 * @param inter recive el objeto
	 */
	public boolean ComprobarVentanaSeriesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameSeries == null || IntFrameSeries.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameSeries.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameSeries.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameSeries);

			mostrar = true;

		}
		return mostrar;

	}

	/**
	 * Metodo para detectar si InternalFrame Suelas esta abierto
	 * 
	 * @param inter recive el objeto
	 */
	public boolean ComprobarVentanaSuelasAbierta() {
		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameSuelas == null || IntFrameSuelas.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameSuelas.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameSuelas.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameSuelas);

			mostrar = true;

		}
		return mostrar;

	}

	/**
	 * Metodo para detectar si InternalFrame Materiales esta abierto
	 * 
	 * @param inter recive el objeto
	 */
	public boolean ComprobarVentanaMaterialesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameMateriales == null || IntFrameMateriales.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameMateriales.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameMateriales.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameSuelas);

			mostrar = true;

		}
		return mostrar;

	}

	/**
	 * Metodo para detectar si InternalFrame Clientes esta abierto
	 * 
	 * @param inter recive el objeto
	 */
	public boolean ComprobarVentanaClientesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameClientes == null || IntFrameClientes.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameClientes.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameClientes.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameSuelas);

			mostrar = true;

		}
		return mostrar;

	}
}
