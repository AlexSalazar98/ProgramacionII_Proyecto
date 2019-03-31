package LP;

import java.sql.SQLException;
import java.text.ParseException;
import LN.ClsGestorLN;

/**
 * Creamos un menu donde podamos borrar los datos de nuestra base de datos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 * 
 */
public class ClsMenuBorrarDatos {

	public static void MenuBorrarDatos(ClsGestorLN objGestorMB) throws ParseException {

		/**
		 * 
		 * Variable para guardar la opcion elegida por el usuario.
		 *
		 */
		int opcionBorrar;

		do {
			/**
			 * 
			 * Mostramos al usuario las opciones que tiene para elegir a la hora de Borrar
			 * datos.
			 * 
			 */
			System.out.println("Elije la entidad de la que deseas Borrar datos: ");
			System.out.println("1- Borrar datos de Suelas: \n" + "2- Borrar datos de Series: \n"
					+ "3- Borrar datos de Pedidos: \n" + "4- Borrar datos de Materiales: \n"
					+ "5- Borrar datos de Herrajes: \n" + "6- Borrar datos de Envios: \n"
					+ "7- Borrar datos de Clientes: \n" + "8- Borrar datos de Articulos: \n"
					+ "9- Borrar datos de Desglose de Pedido: \n" + "10- Regresar al Menu Principal: ");

			/**
			 * 
			 * Pedimos los datos que deseen introducir.
			 *
			 */
			opcionBorrar = UtilidadesLP.leerEntero();
			switch (opcionBorrar) {
			case 1:
				BorrarDatosSuelas(objGestorMB);
				break;

			case 2:
				BorrarDatosSeries(objGestorMB);
				break;

			case 3:
				BorrarDatosPedidos();
				break;

			case 4:
				BorrarDatosMateriales();
				break;

			case 5:
				BorrarDatosHerrajes();
				break;

			case 6:
				BorrarDatosEnvios();
				break;

			case 7:
				BorrarDatosClientes();
				break;

			case 8:
				BorrarDatosArticulos();
				break;

			case 9:
				BorrarDatosDesgloseDePedido();
				break;

			default:
				break;
			}

		} while (opcionBorrar != 10);
	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Suelas.
	 *
	 */
	public static void BorrarDatosSuelas(ClsGestorLN objGestorBSu) {

	}

	/**
	 *  Pedimos los datos a Borrar en la entidad Series.
	 * @param objGestorBse objeto gestor.
	 */
	public static void BorrarDatosSeries(ClsGestorLN objGestorBse) {
		/**
		 * Pedimos el numero de Serie que se quiera eliminar.
		 */
		System.out.println("Inserte el Numero de Serie que desee eliminar:");
		/**
		 * Variable para recoger el numero de serie
		 */
		 int NºDeSerie = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			/**
			 * Llamamos al metodo borrar y le pasamos el parametro.
			 */
			objGestorBse.EliminarSeriesDeArray(NºDeSerie);
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		}

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Pedidos.
	 *
	 */
	public static void BorrarDatosPedidos() {

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Materiales.
	 *
	 */
	public static void BorrarDatosMateriales() {

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Herrajes.
	 *
	 */
	public static void BorrarDatosHerrajes() {

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Envios.
	 *
	 */
	public static void BorrarDatosEnvios() {

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Clientes.
	 *
	 */
	public static void BorrarDatosClientes() {

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Articulo
	 *
	 */
	public static void BorrarDatosArticulos() {

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Desglose de Pedidos.
	 *
	 */
	public static void BorrarDatosDesgloseDePedido() {

	}
}
