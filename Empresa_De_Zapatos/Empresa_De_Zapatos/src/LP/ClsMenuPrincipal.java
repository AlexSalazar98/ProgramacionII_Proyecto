package LP;

import java.text.ParseException;

/**
 * 
 *@author Alex Salazar
 *@author David Requeta 
 *Generamos un menu principal para poder insertar, consultar, borrar datos o salir.
 *
 */

public class ClsMenuPrincipal {

	public static void MenuPrincipal() throws ParseException {

		int opcion;

		/**
		 * 
		 *Mostramos las opciones del menu principal.
		 *
		 */
		System.out.println("¡Bienvenido!");

		do {
			System.out.println("Elije la opcion que desees realizar: ");
			System.out.println(
					"1- Introducir datos: \n" + "2- Consultar datos: \n" + "3- Borrar datos: \n" + "4- Salir: ");

			/**
			 * 
			 *Pedimos la opcion a escoger por el usuario.
			 *
			 */
			opcion = UtilidadesLP.leerEntero();

			/**
			 * 
			 *Segun la opcion escogida realizamos las siguientes tareas.
			 *
			 */
			switch (opcion) {
			/**
			 * 
			 *opcion=1 menu de introducir datos.
			 *
			 */
			case 1:
				ClsMenuIntroducirDatos.MenuIntroducirDatos();
				break;
			/**
			 * 
			 *opcion=2 menu de consultar datos.
			 *
			 */
			case 2:
				ClsMenuConsultarDatos.MenuConsultarDatos();
				break;
			/**
			 * 
			 *opcion=3 menu de borrar datos.
			 *
			 */
			case 3:
				ClsMenuBorrarDatos.MenuBorrarDatos();;
				break;
			/**
			 * 
			 *opcion=4 finalizamos la aplicacion
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
