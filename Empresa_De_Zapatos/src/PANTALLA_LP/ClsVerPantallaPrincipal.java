package PANTALLA_LP;

import java.awt.EventQueue;
import javax.swing.JFrame;
import LN.ClsGestorLN;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta Pantalla pincipal de la aplicacion
 *
 */
public class ClsVerPantallaPrincipal extends JFrame implements ActionListener {

	/**
	 * Creamos un objeto Gestor y un objeto Datos.
	 */
	ClsGestorLN objGestor = new ClsGestorLN();

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
	private final String ACTUALIZAR_DATOS = "Actualizar datos de entregas";
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
	JButton ActualizarDatos = null;
	JLabel Bienvenido = null;

	/**
	 * Launch the application.
	 */
	public static void main() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsVerPantallaPrincipal window = new ClsVerPantallaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);

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

			String MENSAJE;
			MENSAJE = "Ejecute la aplicacion MySQLWorkBench";

			JOptionPane.showMessageDialog(null, MENSAJE);
			JOptionPane.showMessageDialog(null, e);

		}
		/**
		 * Inicializamos el frame
		 */
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 519, 414);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Menu Principal");
		frame.getContentPane().setLayout(null);

		/**
		 * Inicializamos el Boton MenuIntroduccirDatos y lo relazcionamos con el
		 * LISTENER
		 */
		MenuIntroduccirDatos = new JButton("Menu Introducir Datos");
		MenuIntroduccirDatos.setBounds(158, 81, 175, 38);
		MenuIntroduccirDatos.addActionListener(this);
		MenuIntroduccirDatos.setActionCommand(INTRODUCIR_DATOS_BUTTON);

		/**
		 * Inicializamos el Boton MenuConsultarDatos y lo relazcionamos con el LISTENER
		 */
		MenuConsultarDatos = new JButton("Menu Consultar Datos");
		MenuConsultarDatos.setBounds(158, 193, 175, 38);
		MenuConsultarDatos.addActionListener(this);
		MenuConsultarDatos.setActionCommand(CONSULTAR_DATOS_BUTTON);

		/**
		 * Inicializamos el Boton MenuBorrarDatos y lo relazcionamos con el LISTENER
		 */
		MenuBorrarDatos = new JButton("Menu Borrar Datos");
		MenuBorrarDatos.setBounds(158, 249, 175, 38);
		MenuBorrarDatos.addActionListener(this);
		MenuBorrarDatos.setActionCommand(BORRAR_DATOS_BUTTON);

		/**
		 * Inicializamos el Boton Salir y lo relazcionamos con el LISTENER
		 */
		Salir = new JButton("Salir");
		Salir.setBounds(158, 305, 175, 38);
		Salir.addActionListener(this);
		Salir.setActionCommand(SALIR_BUTTON);

		/**
		 * Instanciamos el JLabel Y definimos el mensaje
		 */
		Bienvenido = new JLabel("\u00A1Bienvenido!");
		Bienvenido.setBounds(181, 41, 175, 22);
		Bienvenido.setEnabled(false);
		Bienvenido.setFont(new Font("Arial Black", Font.BOLD, 15));

		/**
		 * Inicializamos el boton de Actualizar datos y lo relacionamos con el LISTENER
		 */
		ActualizarDatos = new JButton("Actualizar Datos ");
		ActualizarDatos.setBounds(158, 137, 175, 38);
		ActualizarDatos.addActionListener(this);
		ActualizarDatos.setActionCommand(ACTUALIZAR_DATOS);

		/**
		 * Los añadimos al FRAME
		 */
		frame.getContentPane().add(MenuIntroduccirDatos);
		frame.getContentPane().add(ActualizarDatos);
		frame.getContentPane().add(MenuConsultarDatos);
		frame.getContentPane().add(MenuBorrarDatos);
		frame.getContentPane().add(Salir);
		frame.getContentPane().add(Bienvenido);

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
			// System.out.println("Hola esto es para introducir datos");
			ClsVerMenuIntroducirDatos.main(null, objGestor);
			break;

		/**
		 * Si pulsan el boton de actualizar datos vamos a mostrar los pedido a
		 * actualizar.
		 */
		case ACTUALIZAR_DATOS:
			System.out.println("Esto es para actualizar datos");
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
