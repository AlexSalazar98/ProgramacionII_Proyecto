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
import java.awt.Toolkit;

/**
 * Pantalla de menus
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
	private final String ARTICULOS_INSERTAR_BUTTON = "Boton de insertar articulos";
	private final String CLIENTES_INSERTAR_BUTTON = "Boton de insertar clientes";
	private final String DESGLOSE_INSERTAR_BUTTON = "Boton de insertar desglose";
	private final String ENVIOS_INSERTAR_BUTTON = "Boton de insertar envios";
	private final String HERRAJES_INSERTAR_BUTTON = "Boton de insertar herrajes";
	private final String MATERIALES_INSERTAR_BUTTON = "Boton de insertar materiales";
	private final String PEDIDOS_INSERTAR_BUTTON = "Boton de insertar pedidos";
	private final String SERIES_INSERTAR_BUTTON = "Boton de insertar series";
	private final String SUELAS_INSERTAR_BUTTON = "Boton de insertar suelas";
	/**
	 * Constantes para el LISENER de borrar.
	 */
	private final String ARTICULOS_BORRAR_BUTTON = "Boton de borrar articulos";
	private final String CLIENTES_BORRAR_BUTTON = "Boton de borrar clientes";
	private final String DESGLOSE_BORRAR_BUTTON = "Boton de borrar desglose";
	private final String ENVIOS_BORRAR_BUTTON = "Boton de borrar envios";
	private final String HERRAJES_BORRAR_BUTTON = "Boton de borrar herrajes";
	private final String MATERIALES_BORRAR_BUTTON = "Boton de borrar materiales";
	private final String PEDIDOS_BORRAR_BUTTON = "Boton de borrar pedidos";
	private final String SERIES_BORRAR_BUTTON = "Boton de borrar series";
	private final String SUELAS_BORRAR_BUTTON = "Boton de borrar suelas";

	/**
	 * Constante para el LISENER de actualizar.
	 */
	private final String ENTREGAS_ACTUALIZAR_BUTTON = "Boton de actualizar entregas";

	/**
	 * Constante para el LISENER informes
	 */
	private final String INFORMES_PEDIDOS_MAS_DESGLOSES_BUTTON = "Informes pedidos mas desgloses";

	/**
	 * Objetos instanciados
	 */
	private JDesktopPane PanelMenuIntrducirDatos;
	private JMenuBar menuBar;
	private JMenu Actualizar, ConsultarBorrar, Introducir;
	private JMenuItem ArticulosIntroducir, ClientesIntroducir, DesgloseIntroducir, EnviosIntroducir, HerrajesIntroducir,
			MaterialesIntroducir, PedidosIntroducir, SeriesIntroducir, SuelasIntroducir;
	private JMenuItem EntregasActualizar;
	private JMenuItem ArticulosBorrar, ClientesBorrar, DesgloseBorrar, EnviosBorrar, HerrajesBorrar, MaterialesBorrar,
			PedidosBorrar, SeriesBorrar, SuelasBorrar;
	private ClsIFIntroducirClientes IntFrameClientes;
	private ClsIFIntroducirSeries IntFrameSeries;
	private ClsIFIntroducirHerrajes IntFrameHerrajes;
	private ClsIFIntroducirSuelas IntFrameSuelas;
	private ClsIFIntroducirMateriales IntFrameMateriales;
	private ClsIFIntroducirEnvios IntFrameEnvios;
	private ClsIFIntroducirArticulos IntFrameArticulos;
	private ClsIFIntroducirPedidos IntFramePedidos;
	private ClsIFIntroducirDesgloses IntFrameDesgloses;
	private ClsPedidosMasDesglose IntFramePedidosMasDesgloses;
	private JMenuItem PedidosDesglose;
	private ClsConsultarBorrarSeries IntFrameConsultarBorrarSeries;
	private ClsConsultarBorrarSuelas IntFrameConsultarBorrarSuelas;
	private ClsConsultarBorrarArticulos IntFrameConsultarBorrarArticulos;
	private ClsConsultarBorrarPedidos IntFrameConsultarBorrarPedidos;
	private ClsConsultarBorrarClientes IntFrameConsultarBorrarClientes;
	private ClsConsultarBorrarEnvios IntFrameConsultarBorrarEnvios;
	private ClsConsultarBorrarMateriales IntFrameConsultarBorrarMateriales;
	private ClsConsultarBorrarDesgloses IntFrameConsultarBorrarDesgloses;
	private ClsConsultarBorrarHerrajes IntFrameConsultarBorrarHerrajes;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClsVerMenus.class.getResource("/PANTALLA_LP/DEUSTO.png")));
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
		PanelMenuIntrducirDatos.setBackground(Color.WHITE);
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

		Actualizar = new JMenu("Actualizar");
		Actualizar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Actualizar.setForeground(Color.BLUE);
		menuBar.add(Actualizar);

		EntregasActualizar = new JMenuItem("Entregas");
		Actualizar.add(EntregasActualizar);
		EntregasActualizar.addActionListener(this);
		EntregasActualizar.setActionCommand(ENTREGAS_ACTUALIZAR_BUTTON);

		/**
		 * Inicializamos boton de Introducir
		 */

		ConsultarBorrar = new JMenu("Consultar");
		ConsultarBorrar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		ConsultarBorrar.setForeground(Color.BLUE);
		menuBar.add(ConsultarBorrar);

		ArticulosBorrar = new JMenuItem("Articulos");
		ConsultarBorrar.add(ArticulosBorrar);
		ArticulosBorrar.addActionListener(this);
		ArticulosBorrar.setActionCommand(ARTICULOS_BORRAR_BUTTON);

		JSeparator separator_8 = new JSeparator();
		ConsultarBorrar.add(separator_8);

		ClientesBorrar = new JMenuItem("Clientes");
		ConsultarBorrar.add(ClientesBorrar);
		ClientesBorrar.addActionListener(this);
		ClientesBorrar.setActionCommand(CLIENTES_BORRAR_BUTTON);

		JSeparator separator_9 = new JSeparator();
		ConsultarBorrar.add(separator_9);

		DesgloseBorrar = new JMenuItem("Desglose de Pedido");
		ConsultarBorrar.add(DesgloseBorrar);
		DesgloseBorrar.addActionListener(this);
		DesgloseBorrar.setActionCommand(DESGLOSE_BORRAR_BUTTON);

		JSeparator separator_10 = new JSeparator();
		ConsultarBorrar.add(separator_10);

		EnviosBorrar = new JMenuItem("Envios");
		ConsultarBorrar.add(EnviosBorrar);
		EnviosBorrar.addActionListener(this);
		EnviosBorrar.setActionCommand(ENVIOS_BORRAR_BUTTON);

		JSeparator separator_11 = new JSeparator();
		ConsultarBorrar.add(separator_11);

		HerrajesBorrar = new JMenuItem("Herrajes");
		ConsultarBorrar.add(HerrajesBorrar);
		HerrajesBorrar.addActionListener(this);
		HerrajesBorrar.setActionCommand(HERRAJES_BORRAR_BUTTON);

		JSeparator separator_12 = new JSeparator();
		ConsultarBorrar.add(separator_12);

		MaterialesBorrar = new JMenuItem("Materiales");
		ConsultarBorrar.add(MaterialesBorrar);
		MaterialesBorrar.addActionListener(this);
		MaterialesBorrar.setActionCommand(MATERIALES_BORRAR_BUTTON);

		JSeparator separator_13 = new JSeparator();
		ConsultarBorrar.add(separator_13);

		PedidosBorrar = new JMenuItem("Pedidos");
		ConsultarBorrar.add(PedidosBorrar);
		PedidosBorrar.addActionListener(this);
		PedidosBorrar.setActionCommand(PEDIDOS_BORRAR_BUTTON);

		JSeparator separator_14 = new JSeparator();
		ConsultarBorrar.add(separator_14);

		SeriesBorrar = new JMenuItem("Series");
		ConsultarBorrar.add(SeriesBorrar);
		SeriesBorrar.addActionListener(this);
		SeriesBorrar.setActionCommand(SERIES_BORRAR_BUTTON);

		JSeparator separator_15 = new JSeparator();
		ConsultarBorrar.add(separator_15);

		SuelasBorrar = new JMenuItem("Suelas");
		ConsultarBorrar.add(SuelasBorrar);
		SuelasBorrar.addActionListener(this);
		SuelasBorrar.setActionCommand(SUELAS_BORRAR_BUTTON);
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

		JMenu Informes = new JMenu("Informes");
		Informes.setForeground(Color.BLUE);
		Informes.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(Informes);

		PedidosDesglose = new JMenuItem("Pedidos + Desgloses");
		Informes.add(PedidosDesglose);
		PedidosDesglose.addActionListener(this);
		PedidosDesglose.setActionCommand(INFORMES_PEDIDOS_MAS_DESGLOSES_BUTTON);

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
			IntroducirEnvios();
			break;

		/**
		 * Si pulsa introducir Articulos
		 */
		case ARTICULOS_INSERTAR_BUTTON:
			IntroducirArticulos();
			break;

		/**
		 * Si pulsa introducir Pedidos
		 */
		case PEDIDOS_INSERTAR_BUTTON:
			IntroducirPedidos();
			break;

		/**
		 * Si pulsa introducir Desgloses.
		 */
		case DESGLOSE_INSERTAR_BUTTON:
			IntroducirDesgloses();
			break;
		/**
		 * Si pulsa informes pedidos + desgloses.
		 */
		case INFORMES_PEDIDOS_MAS_DESGLOSES_BUTTON:
			InformesPedidosDesgloses();
			break;

		/**
		 * Si pulsa consultar series.
		 */
		case SERIES_BORRAR_BUTTON:
			ConsultarBorrarSeries();
			break;

		/**
		 * Si pulsa consultar suelas.
		 */
		case SUELAS_BORRAR_BUTTON:
			ConsultarBorrarSuelas();
			break;

		/**
		 * Si pulsa consultar articulos.
		 */
		case ARTICULOS_BORRAR_BUTTON:
			ConsultarBorrarArticulos();
			break;

		/**
		 * Si pulsa consultar pedidos.
		 */
		case PEDIDOS_BORRAR_BUTTON:
			ConsultarBorrarPedidos();
			break;

		/**
		 * Si pulsa consultar clientes.
		 */
		case CLIENTES_BORRAR_BUTTON:
			ConsultarBorrarClientes();
			break;

		/**
		 * Si pulsa consultar desgloses.
		 */
		case DESGLOSE_BORRAR_BUTTON:
			ConsultarBorrarDesgloses();
			break;

		/**
		 * Si pulsa consultar herrajes.
		 */
		case HERRAJES_BORRAR_BUTTON:
			ConsultarBorrarHerrajes();
			break;

		/**
		 * Si pulsa consultar materiales.
		 */
		case MATERIALES_BORRAR_BUTTON:
			ConsultarBorrarMateriales();
			break;

		/**
		 * Si pulsa consultar envios.
		 */
		case ENVIOS_BORRAR_BUTTON:
			ConsultarBorrarEnvios();
			break;

		default:
			break;
		}

	}

	/**
	 * Llamada a InternalFrame para consultar y borrar envios
	 */
	private void ConsultarBorrarEnvios() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarEnviosAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarEnvios = new ClsConsultarBorrarEnvios(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarEnvios);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarEnvios.setVisible(true);
		try {
			IntFrameConsultarBorrarEnvios.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar materiales
	 */
	private void ConsultarBorrarMateriales() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarMaterialesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarMateriales = new ClsConsultarBorrarMateriales(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarMateriales);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarMateriales.setVisible(true);
		try {
			IntFrameConsultarBorrarMateriales.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar clientes
	 */
	private void ConsultarBorrarHerrajes() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarHerrajesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarHerrajes = new ClsConsultarBorrarHerrajes(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarHerrajes);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarHerrajes.setVisible(true);
		try {
			IntFrameConsultarBorrarHerrajes.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar clientes
	 */
	private void ConsultarBorrarDesgloses() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarDesglosesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarDesgloses = new ClsConsultarBorrarDesgloses(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarDesgloses);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarDesgloses.setVisible(true);
		try {
			IntFrameConsultarBorrarDesgloses.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar clientes
	 */
	private void ConsultarBorrarClientes() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarClientesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarClientes = new ClsConsultarBorrarClientes(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarClientes);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarClientes.setVisible(true);
		try {
			IntFrameConsultarBorrarPedidos.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar pedios
	 */
	private void ConsultarBorrarPedidos() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarPedidosAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarPedidos = new ClsConsultarBorrarPedidos(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarPedidos);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarPedidos.setVisible(true);
		try {
			IntFrameConsultarBorrarPedidos.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar suelas
	 */
	private void ConsultarBorrarArticulos() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarArticulosAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarArticulos = new ClsConsultarBorrarArticulos(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarArticulos);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarArticulos.setVisible(true);
		try {
			IntFrameConsultarBorrarArticulos.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar suelas
	 */
	private void ConsultarBorrarSuelas() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarSuelasAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarSuelas = new ClsConsultarBorrarSuelas(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarSuelas);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarSuelas.setVisible(true);
		try {
			IntFrameConsultarBorrarSuelas.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para consultar y borrar series
	 */
	private void ConsultarBorrarSeries() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaConsultarBorrarSeriesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameConsultarBorrarSeries = new ClsConsultarBorrarSeries(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameConsultarBorrarSeries);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameConsultarBorrarSeries.setVisible(true);
		try {
			IntFrameConsultarBorrarSeries.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para informes pedidos mas desgloses
	 */
	private void InformesPedidosDesgloses() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaPedidosDesglosesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFramePedidosMasDesgloses = new ClsPedidosMasDesglose(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFramePedidosMasDesgloses);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFramePedidosMasDesgloses.setVisible(true);
		try {
			IntFramePedidosMasDesgloses.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Llamada a InternalFrame para introducir Desgloses
	 */
	private void IntroducirDesgloses() {
		/**
		 * Comprobamos que no este ya abierto
		 */
		if (!ComprobarVentanaDesglosesAbierta()) {
			/**
			 * Creamos objeto IFrameSeries
			 */
			IntFrameDesgloses = new ClsIFIntroducirDesgloses(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameDesgloses);
		}
		/**
		 * Lo hacemos visible
		 */
		IntFrameDesgloses.setVisible(true);
		try {
			IntFrameDesgloses.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
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
	 * Metodo para acceder al InternalFrame de introducir Envios
	 */
	private void IntroducirEnvios() {
		/**
		 * Comprobamos que la ventana no este abierta.
		 */
		if (!ComprobarVentanaEnviosAbierta()) {
			/**
			 * creamos el objeto
			 */
			IntFrameEnvios = new ClsIFIntroducirEnvios(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameEnvios);
		}

		/**
		 * Lo hacemos visible
		 */
		IntFrameEnvios.setVisible(true);
		try {
			IntFrameEnvios.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Metodo para ir al InternalFrame introducir Articulos
	 */
	private void IntroducirArticulos() {
		/**
		 * Comprobamos que la ventana no este abierta.
		 */
		if (!ComprobarVentanaArticulosAbierta()) {
			/**
			 * creamos el objeto
			 */
			IntFrameArticulos = new ClsIFIntroducirArticulos(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFrameArticulos);
		}

		/**
		 * Lo hacemos visible
		 */
		IntFrameArticulos.setVisible(true);
		try {
			IntFrameArticulos.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Metodo para ir al InternalFrame introducir Pedidos
	 */
	private void IntroducirPedidos() {
		/**
		 * Comprobamos que la ventana no este abierta.
		 */
		if (!ComprobarVentanaPedidosAbierta()) {
			/**
			 * creamos el objeto
			 */
			IntFramePedidos = new ClsIFIntroducirPedidos(objGestorMID);
			PanelMenuIntrducirDatos.add(IntFramePedidos);
		}

		/**
		 * Lo hacemos visible
		 */
		IntFramePedidos.setVisible(true);
		try {
			IntFramePedidos.setSelected(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaPedidosDesglosesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFramePedidosMasDesgloses == null || IntFramePedidosMasDesgloses.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFramePedidosMasDesgloses.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFramePedidosMasDesgloses.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFramePedidosMasDesgloses);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para detectar si InternalFrame Herrajes esta abierto
	 * 
	 * @param inter recive el objeto
	 */
	private boolean ComprobarVentanaSeriesAbierta() {

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
	private boolean ComprobarVentanaSuelasAbierta() {
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
	private boolean ComprobarVentanaMaterialesAbierta() {

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
	private boolean ComprobarVentanaClientesAbierta() {

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

	/**
	 * Metodo para comprobar si la ventana envios esta abierta
	 * 
	 * @return nos devuelve el resultado
	 */
	private boolean ComprobarVentanaEnviosAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameEnvios == null || IntFrameEnvios.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameEnvios.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameEnvios.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameEnvios);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar si la ventana articulos esta abierta
	 * 
	 * @return nos devuelve el resultado
	 */
	private boolean ComprobarVentanaArticulosAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameArticulos == null || IntFrameArticulos.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameArticulos.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameArticulos.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameArticulos);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar si la ventana pedidos esta abierta
	 * 
	 * @return nos devuelve el resultado
	 */
	private boolean ComprobarVentanaPedidosAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFramePedidos == null || IntFramePedidos.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFramePedidos.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFramePedidos.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFramePedidos);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar si la ventana desgloses esta abierta
	 * 
	 * @return nos devuelve el resultado
	 */
	private boolean ComprobarVentanaDesglosesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameDesgloses == null || IntFrameDesgloses.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameDesgloses.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameDesgloses.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameDesgloses);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarSeriesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarSeries == null || IntFrameConsultarBorrarSeries.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarSeries.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarSeries.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarSeries);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarSuelasAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarSuelas == null || IntFrameConsultarBorrarSuelas.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarSuelas.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarSuelas.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarSuelas);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaHerrajesAbierta() {

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
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarArticulosAbierta() {
		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarArticulos == null || IntFrameConsultarBorrarArticulos.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarArticulos.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarArticulos.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarArticulos);

			mostrar = true;

		}

		return mostrar;

	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarPedidosAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarPedidos == null || IntFrameConsultarBorrarPedidos.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarPedidos.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarPedidos.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarPedidos);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarClientesAbierta() {

		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarClientes == null || IntFrameConsultarBorrarClientes.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarClientes.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarClientes.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarClientes);

			mostrar = true;

		}

		return mostrar;
	}

	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarEnviosAbierta() {
		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarEnvios == null || IntFrameConsultarBorrarEnvios.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarEnvios.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarEnvios.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarEnvios);

			mostrar = true;

		}

		return mostrar;
	}
	
	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarMaterialesAbierta() {
		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarMateriales == null || IntFrameConsultarBorrarMateriales.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarMateriales.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarMateriales.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarMateriales);

			mostrar = true;

		}

		return mostrar;
		
	}
	
	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarHerrajesAbierta() {
		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarHerrajes == null || IntFrameConsultarBorrarHerrajes.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarHerrajes.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarHerrajes.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarHerrajes);

			mostrar = true;

		}

		return mostrar;
	}
	
	/**
	 * Metodo para comprobar que la ventana esta abierta o no
	 * 
	 * @return nos dice si esta abierta o no
	 */
	private boolean ComprobarVentanaConsultarBorrarDesglosesAbierta() {
		boolean mostrar = false;

		boolean cerrado;
		if (IntFrameConsultarBorrarDesgloses == null || IntFrameConsultarBorrarDesgloses.isClosed()) {
			cerrado = true;
		} else {
			cerrado = false;
		}

		if (!cerrado) {
			String Nombre = IntFrameConsultarBorrarDesgloses.getTitle();

			JOptionPane.showMessageDialog(rootPane, "La ventana que intenta abrir ya está abierta", Nombre,
					JOptionPane.WARNING_MESSAGE);

			IntFrameConsultarBorrarDesgloses.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameConsultarBorrarDesgloses);

			mostrar = true;

		}

		return mostrar;
	}
}
