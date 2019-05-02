package PANTALLA_LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
public class ClsVerMenuIntroducirDatos extends JFrame implements ActionListener {

	/**
	 * Variable para guardar el gestor
	 */
	private ClsGestorLN objGestorMID;
	/**
	 * Ni idea de para que sirve.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constantes para el LISENER.
	 */
	private final String ARTICULOS_BUTTON = "Boton de articulos";
	private final String CLIENTES_BUTTON = "Boton de clientes";
	private final String DESGLOSE_BUTTON = "Boton de desglose";
	private final String ENVIOS_BUTTON = "Boton de envios";
	private final String HERRAJES_BUTTON = "Boton de herrajes";
	private final String MATERIALES_BUTTON = "Boton de materiales";
	private final String PEDIDOS_BUTTON = "Boton de pedidos";
	private final String SERIES_BUTTON = "Boton de series";
	private final String SUELAS_BUTTON = "Boton de suelas";
	/**
	 * Objetos instanciados
	 */
	private JDesktopPane PanelMenuIntrducirDatos;
	private JMenuBar menuBar;
	private JMenu Introducir;
	private JMenuItem Articulos, Clientes, Desglose, Envios, Herrajes, Materiales, Pedidos, Series, Suelas;
	private ClsIFIntroducirClientes IntFrameClientes;
	private ClsIFIntroducirSeries IntFrameSeries;
	private ClsIFIntroducirHerrajes IntFrameHerrajes;
	private ClsIFIntroducirSuelas IntFrameSuelas;
	private ClsIFIntroducirMateriales IntFrameMateriales;

	private ArrayList<JInternalFrame> VentanasAbiertas = new ArrayList<JInternalFrame>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ClsGestorLN ObjGestor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsVerMenuIntroducirDatos frame = new ClsVerMenuIntroducirDatos(ObjGestor);
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
	public ClsVerMenuIntroducirDatos(ClsGestorLN ObjGestor) {
		objGestorMID = ObjGestor;
		IniciarComponentes(ObjGestor);

	}

	/**
	 * Crea los componentes
	 */
	private void IniciarComponentes(ClsGestorLN ObjGestor) {

		setTitle("Menu Introducir Datos");
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
		Introducir = new JMenu("Introducir ");
		Introducir.setForeground(Color.BLUE);
		Introducir.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(Introducir);

		/**
		 * Inicializamos boton de Articulos
		 */
		Articulos = new JMenuItem("Articulos");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Articulos);
		/**
		 * Implementamos el escuchador al boton
		 */
		Articulos.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Articulos.setActionCommand(ARTICULOS_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator = new JSeparator();
		Introducir.add(separator);

		/**
		 * Inicializamos boton de Clientes
		 */
		Clientes = new JMenuItem("Clientes");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Clientes);
		/**
		 * Implementamos el escuchador al boton
		 */
		Clientes.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Clientes.setActionCommand(CLIENTES_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_1 = new JSeparator();
		Introducir.add(separator_1);

		/**
		 * Inicializamos boton de Desglose
		 */
		Desglose = new JMenuItem("Desglose de Pedido");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Desglose);
		/**
		 * Implementamos el escuchador al boton
		 */
		Desglose.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Desglose.setActionCommand(DESGLOSE_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_2 = new JSeparator();
		Introducir.add(separator_2);

		/**
		 * Inicializamos boton de Envios
		 */
		Envios = new JMenuItem("Envios");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Envios);
		/**
		 * Implementamos el escuchador al boton
		 */
		Envios.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Envios.setActionCommand(ENVIOS_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_3 = new JSeparator();
		Introducir.add(separator_3);

		/**
		 * Inicializamos boton de Herrajes
		 */
		Herrajes = new JMenuItem("Herrajes");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Herrajes);
		/**
		 * Implementamos el escuchador al boton
		 */
		Herrajes.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Herrajes.setActionCommand(HERRAJES_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_4 = new JSeparator();
		Introducir.add(separator_4);

		/**
		 * Inicializamos boton de Materiales
		 */
		Materiales = new JMenuItem("Materiales");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Materiales);
		/**
		 * Implementamos el escuchador al boton
		 */
		Materiales.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Materiales.setActionCommand(MATERIALES_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_5 = new JSeparator();
		Introducir.add(separator_5);

		/**
		 * Inicializamos boton de Pedidos
		 */
		Pedidos = new JMenuItem("Pedidos");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Pedidos);
		/**
		 * Implementamos el escuchador al boton
		 */
		Pedidos.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Pedidos.setActionCommand(PEDIDOS_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_6 = new JSeparator();
		Introducir.add(separator_6);

		/**
		 * Inicializamos boton de Series
		 */
		Series = new JMenuItem("Series");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Series);
		/**
		 * Implementamos el escuchador al boton
		 */
		Series.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Series.setActionCommand(SERIES_BUTTON);

		/**
		 * Separador de botones
		 */
		JSeparator separator_7 = new JSeparator();
		Introducir.add(separator_7);

		/**
		 * Inicializamos boton de Suelas
		 */
		Suelas = new JMenuItem("Suelas");
		/**
		 * Añadimos al boton generico
		 */
		Introducir.add(Suelas);
		/**
		 * Implementamos el escuchador al boton
		 */
		Suelas.addActionListener(this);
		/**
		 * Añadimos comando al boton para la escucha
		 */
		Suelas.setActionCommand(SUELAS_BUTTON);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		/**
		 * si pulsa en series
		 */
		case SERIES_BUTTON:
			IntroducirSeries();
			break;
		/**
		 * Si pulsa en Herrajes
		 */
		case HERRAJES_BUTTON:
			IntroducirHerrajes();
			break;
		/**
		 * Si pulsa en Materiales
		 */
		case MATERIALES_BUTTON:
			IntroducirMateriales();
			break;
		/**
		 * Si pulsa en Suelas
		 */
		case SUELAS_BUTTON:
			IntroducirSuelas();
			break;
		/**
		 * Si pulsa en Clientes
		 */
		case CLIENTES_BUTTON:
			IntroducirClientes();
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
			VentanasAbiertas.add(IntFrameSeries);
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
			VentanasAbiertas.add(IntFrameHerrajes);
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
			VentanasAbiertas.add(IntFrameMateriales);
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
			VentanasAbiertas.add(IntFrameSuelas);
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
			VentanasAbiertas.add(IntFrameClientes);
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

			JOptionPane.showMessageDialog(rootPane, "La ventana '" + Nombre + "' que intenta abrir ya está abierta");

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

			JOptionPane.showMessageDialog(rootPane, "La ventana '" + Nombre + "' que intenta abrir ya está abierta");

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

			JOptionPane.showMessageDialog(rootPane, "La ventana '" + Nombre + "' que intenta abrir ya está abierta");

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

			JOptionPane.showMessageDialog(rootPane, "La ventana '" + Nombre + "' que intenta abrir ya está abierta");

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

			JOptionPane.showMessageDialog(rootPane, "La ventana '" + Nombre + "' que intenta abrir ya está abierta");

			IntFrameClientes.toFront();

			PanelMenuIntrducirDatos.moveToFront(IntFrameSuelas);

			mostrar = true;

		}
		return mostrar;

	}
}
