package PANTALLA_LP;

import java.awt.EventQueue;
import javax.swing.JFrame;
import LN.ClsGestorLN;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.sql.SQLException;

public class ClsVerPantallaPrincipal extends JFrame implements ActionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constantes para el LISENER.
	 */
	private final String SALIR_BUTTON = "Boton de salir";
	private final String INTRODUCIR_DATOS_BUTTON = "Menu introducir datos";
	private final String CONSULTAR_DATOS_BUTTON = "Menu consultar datos";
	private final String BORRAR_DATOS_BUTTON = "Menu borrar datos";
	/**
	 * Instanciamos el JFrame
	 */
	private JFrame frame;
	/**
	 * Instanciamos los JButton
	 */
	JButton Salir = null;
	JButton MenuBorrarDatos = null;
	JButton MenuIntroduccirDatos = null;
	JButton MenuConsultarDatos = null;

	/**
	 * Launch the application.
	 */
	public static void main() {

		/**
		 * Creamos un objeto Gestor y un objeto Datos.
		 */
		ClsGestorLN objGestor = new ClsGestorLN();

		/**
		 * Llamadas a metodos para cargar los datos en Arrays nada mas iniciar la
		 * aplicacion.
		 */
		try {
			objGestor.ObjetosRecuperadosSerie();
			objGestor.ObjetosRecuperadosSuelas();
			objGestor.ObjetosRecuperadosMateriales();
			objGestor.ObjetosRecuperadosHerrajes();
			objGestor.ObjetosRecuperadosClientes();
			objGestor.ObjetosRecuperadosEnvios();
			objGestor.ObjetosRecuperadosPedidos();
			objGestor.ObjetosRecuperadosArticulos();
			objGestor.ObjetosRecuperadosDesglose();
		} catch (SQLException e) {

			/**
			 * Lanza mensaje de excepcion en caso de que no pueda cargar la informacion
			 */
			System.out.println("Ejecute la aplicacion MySQLWorkBench");
			System.out.println(e);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsVerPantallaPrincipal window = new ClsVerPantallaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClsVerPantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Inicializamos el frame
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Menu Principal");

		/**
		 * Inicializamos el Boton MenuIntroduccirDatos y lo relazcionamos con el
		 * LISTENER
		 */
		MenuIntroduccirDatos = new JButton("Menu Introducir Datos");
		MenuIntroduccirDatos.addActionListener(this);
		MenuIntroduccirDatos.setActionCommand(INTRODUCIR_DATOS_BUTTON);

		/**
		 * Inicializamos el Boton MenuConsultarDatos y lo relazcionamos con el LISTENER
		 */
		MenuConsultarDatos = new JButton("Menu Consultar Datos");
		MenuConsultarDatos.addActionListener(this);
		MenuConsultarDatos.setActionCommand(CONSULTAR_DATOS_BUTTON);

		/**
		 * Inicializamos el Boton MenuBorrarDatos y lo relazcionamos con el LISTENER
		 */
		MenuBorrarDatos = new JButton("Menu Borrar Datos");
		MenuBorrarDatos.addActionListener(this);
		MenuBorrarDatos.setActionCommand(BORRAR_DATOS_BUTTON);

		/**
		 * Inicializamos el Boton Salir y lo relazcionamos con el LISTENER
		 */
		Salir = new JButton("Salir");
		Salir.addActionListener(this);
		Salir.setActionCommand(SALIR_BUTTON);

		/**
		 * Instanciamos el JLabel Y definimos el mensaje
		 */
		JLabel Bienvenido = new JLabel("\u00A1Bienvenido!");
		Bienvenido.setEnabled(false);
		Bienvenido.setFont(new Font("Arial Black", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(149).addComponent(Bienvenido,
						GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(127).addComponent(MenuIntroduccirDatos,
						GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(127).addComponent(MenuConsultarDatos,
						GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(127).addComponent(MenuBorrarDatos,
						GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(127).addComponent(Salir,
						GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(24).addComponent(Bienvenido).addGap(11)
				.addComponent(MenuIntroduccirDatos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addGap(11).addComponent(MenuConsultarDatos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addGap(11).addComponent(MenuBorrarDatos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addGap(11).addComponent(Salir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)));
		frame.getContentPane().setLayout(groupLayout);

	}

	/**
	 * Gestionamos la escucha de los Botones y sus acciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String Comando = e.getActionCommand();

		switch (Comando) {

		/**
		 * Si pulsan Salir cerramos la apliccacion
		 */
		case SALIR_BUTTON:
			frame.dispose();
			break;

		/**
		 * Si pulsan el boton Introducir Datos vamos al menu correspondiente
		 */
		case INTRODUCIR_DATOS_BUTTON:
			System.out.println("Hola esto es para introducir datos");
			break;

		/**
		 * Si pulsan el boton Consultar Datos vamos al menu correspondiente
		 */
		case CONSULTAR_DATOS_BUTTON:
			System.out.println("Hola esto es para consultar datos");
			break;

		/**
		 * Si pulsan el boton Borrar Datos vamos al menu correspondiente
		 */
		case BORRAR_DATOS_BUTTON:
			System.out.println("Hola esto es para borrar datos");
			break;

		default:
			break;
		}

	}
}
