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

	/**
	 * Metodo que reune el menu principal
	 */
	public static void MenuPrincipal() {

		/**
		 * Creamos un objeto Gestor y un objeto Datos.
		 */
		ClsGestorLN objGestor = new ClsGestorLN();
		ClsMostrarDatos objMostrarDatos = new ClsMostrarDatos();

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
		System.out.println("ˇBienvenido!");

		/**
		 * Mostaramos el menu.
		 */
		do {
			System.out.println("Elije la opcion que desees realizar: ");
			System.out.println("1- Introducir datos: \n" + "2- Consultar datos: \n" + "3- Borrar datos: \n"
					+ "4- Actualizar pedidos entregados: \n" + "5- Salir: ");

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
				break;
			/**
			 * 
			 * opcion=4 actualizamos entregas
			 *
			 */
			case 4:
				ActualizarEntregas(objGestor, objMostrarDatos);
				break;
			/**
			 * 
			 * opcion=5 finalizamos la aplicacion
			 *
			 */
			case 5:
				System.out.println("Hemos acabado!");
				break;

			}

		} while (opcion != 5);

	}

	/**
	 * Metodo directo para actualizar Entregas de Pedidos
	 * 
	 * @param objGestor       objeto gestor para acceder al gestor
	 * @param objMostrarDatos objeto MostrarDatos para mostrar los pedidos
	 */
	public static void ActualizarEntregas(ClsGestorLN objGestor, ClsMostrarDatos objMostrarDatos) {

		/**
		 * me muestra los pedidos
		 */
		objMostrarDatos.VerPedidos(objGestor);
		/**
		 * pedidos numero de pedido a actualizar
		 */
		System.out.println("Dime el numero de Pedido del que desas actualizar su entrega:");
		int Pedido = UtilidadesLP.leerEntero();

		/**
		 * Lo mandamos al gestor
		 */
		try {
			if (objGestor.ActualizarEntregasDePedidos(Pedido) == true) {
				System.out.println("Pedido actualizado correctamente!");
			}
		} catch (SQLException e) {
			System.out.println("La actualizacion no se a podido hacer: " + e);
		}
	}

}
