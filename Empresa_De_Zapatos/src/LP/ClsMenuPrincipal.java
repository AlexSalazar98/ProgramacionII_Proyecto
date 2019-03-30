package LP;

import java.sql.SQLException;
import java.text.ParseException;
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

	public static void MenuPrincipal() throws ParseException {

		/**
		 * Creamos un objeto Gestor.
		 */
		ClsGestorLN objGestor = new ClsGestorLN();
		/**
		 * Llamadas a metodos para cargar los datos en Arrays nada mas iniciar la
		 * aplicacion.
		 */
		try {
			objGestor.ObjetosRecuperadosSerie();
			objGestor.ObjetosRecuperadosSuelas();
		} catch (SQLException e) {

			System.out.println("Ejecute la aplicacion MySQLWorkBench");
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
		System.out.println("ˇBienvenido!");

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
				ClsMenuConsultarDatos.MenuConsultarDatos(objGestor);
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
