package LP;

import java.sql.SQLException;
import LN.ClsGestorLN;

/**
 * Generamos un menu principal para poder insertar, consultar, borrar datos o
 * salir.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 *
 */

public class ClsMenuPrincipal {

	public static void MenuPrincipal() {

		/**
		 * Creamos un objeto Gestor y un objeto Datos.
		 */
		ClsGestorLN objGestor = new ClsGestorLN();
		ClsMostrarDatos objMostrarDatos = new ClsMostrarDatos();
		// ClsVerPantallaPrincipal.main(objGestor);
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

		/**
		 * Variable para elegir la opcion de menu.
		 */
		int opcion;

		/**
		 * 
		 * Mostramos las opciones del menu principal.
		 *
		 */
		System.out.println("¡Bienvenido!");

		/**
		 * Mostaramos el menu.
		 */
		do {
			System.out.println("Elije la opcion que desees realizar: ");
			System.out.println(
					"1- Introducir datos: \n" + "2- Consultar datos: \n" + "3- Borrar datos: \n" + "4- Salir: ");

			/**
			 * 
			 * Pedimos la opcion a escoger por el usuario.
			 *
			 */
			opcion = UtilidadesLP.leerEntero();

			/**
			 * 
			 * Segun la opcion escogida realizamos las siguientes tareas.
			 *
			 */
			switch (opcion) {
			/**
			 * 
			 * opcion=1 menu de introducir datos.
			 *
			 */
			case 1:
				ClsMenuIntroducirDatos.MenuIntroducirDatos(objGestor);
				break;
			/**
			 * 
			 * opcion=2 menu de consultar datos.
			 *
			 */
			case 2:
				ClsMenuConsultarDatos.MenuConsultarDatos(objGestor, objMostrarDatos);
				break;
			/**
			 * 
			 * opcion=3 menu de borrar datos.
			 *
			 */
			case 3:
				ClsMenuBorrarDatos.MenuBorrarDatos(objGestor);
				;
				break;
			/**
			 * 
			 * opcion=4 finalizamos la aplicacion
			 *
			 */
			case 4:
				System.out.println("Hemos acabado!");
				break;
			default:
				break;
			}

		} while (opcion != 4);

	}

}
