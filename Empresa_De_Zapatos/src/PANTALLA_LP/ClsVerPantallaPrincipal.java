package PANTALLA_LP;

import java.awt.EventQueue;
import javax.swing.JFrame;
import LN.ClsGestorLN;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Toolkit;

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
	private final String ENTRAR_BUTTON = "Boton Entrar";

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
	private JButton EntrarAplicacion;
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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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

			JOptionPane.showMessageDialog(null, MENSAJE, "SIN CONEXION CON BD", JOptionPane.ERROR_MESSAGE);

		}
		/**
		 * Inicializamos el frame
		 */
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ClsVerPantallaPrincipal.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		frame.setResizable(false);	   
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(400, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Menu Principal");
		frame.getContentPane().setLayout(null);

		/**
		 * Inicializamos el Boton Entrar y lo relazcionamos con el LISTENER
		 */
		EntrarAplicacion = new JButton("Entrar");
		EntrarAplicacion.setBounds(158, 81, 175, 38);
		EntrarAplicacion.addActionListener(this);
		EntrarAplicacion.setActionCommand(ENTRAR_BUTTON);

		/**
		 * Inicializamos el Boton Salir y lo relazcionamos con el LISTENER
		 */
		Salir = new JButton("Salir");
		Salir.setBounds(158, 154, 175, 38);
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
		 * Los añadimos al FRAME
		 */
		frame.getContentPane().add(EntrarAplicacion);
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
		case ENTRAR_BUTTON:
			// System.out.println("Hola esto es para introducir datos");
			ClsVerMenus.main(null, objGestor);
			break;

		default:
			break;
		}

	}
}
