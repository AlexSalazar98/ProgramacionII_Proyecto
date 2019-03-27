package LP;

import java.sql.SQLException;
import java.text.ParseException;

import LD.ClsDatos;
import LN.ClsGestorLN;

/**
 * Creamos un menu para poder consultar los diferentes tipos de datos que
 * tengamos en nuestra base de datos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 *
 */
public class ClsMenuConsultarDatos {

	public static void MenuConsultarDatos(ClsGestorLN objGestorMC, ClsDatos objDatosMC) throws ParseException {

		/**
		 * Intanciamos el objeto gestor para tener acceso a la clase gestor
		 */

		/**
		 * 
		 * Variable para guardar la opcion elegida por el usuario.
		 *
		 */
		int opcionConsultar;

		do {
			/**
			 * 
			 * Mostramos al usuario las opciones que tiene para elegir a la hora de
			 * consultar datos.
			 *
			 */
			System.out.println("Elije la entidad de la que deseas consultar datos: ");
			System.out.println("1- Consultar datos de Suelas: \n" + "2- Consultar datos de Series: \n"
					+ "3- Consultar datos de Pedidos: \n" + "4- Consultar datos de Materiales: \n"
					+ "5- Consultar datos de Herrajes: \n" + "6- Consultar datos de Envios: \n"
					+ "7- Consultar datos de Clientes: \n" + "8- Consultar datos de Articulos: \n"
					+ "9- Consultar datos de Desglose de Pedido: \n" + "10- Regresar al Menu Principal: ");

			/**
			 * 
			 * Pedimos los datos que deseen introducir.
			 *
			 */
			opcionConsultar = UtilidadesLP.leerEntero();
			switch (opcionConsultar) {
			case 1:
				ConsultarDatosSuelas();
				break;

			case 2:
				ConsultarDatosSeries(objGestorMC, objDatosMC);
				break;

			case 3:
				ConsultarDatosPedidos();
				break;

			case 4:
				ConsultarDatosMateriales();
				break;

			case 5:
				ConsultarDatosHerrajes();
				break;

			case 6:
				ConsultarDatosEnvios();
				break;

			case 7:
				ConsultarDatosClientes();
				break;

			case 8:
				ConsultarDatosArticulos();
				break;

			case 9:
				ConsultarDatosDesgloseDePedido();
				break;

			default:
				break;
			}

		} while (opcionConsultar != 10);

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Suelas.
	 *
	 */
	public static void ConsultarDatosSuelas() {

	}

	/**
	 * Pedimos los datos a consultar en la entidad Series.
	 * @param ObjGestCSeries relacion con LN
	 * @param objDatosCS relacion con LD
	 */
	public static void ConsultarDatosSeries(ClsGestorLN ObjGestCSeries, ClsDatos objDatosCS) {

		/**
		 * Rodeado de Try Catch para tratar excepcion y sacar un mensaje por pantalla.
		 */
		try {
			/**
			 * Llamada al gestor para recuperar datos de BD
			 */
			ObjGestCSeries.ObjetosRecuperadosSerie(objDatosCS);
		} catch (SQLException e) {

			System.out.println("Ha fallado la consulta: " + e);
		}
		
		
		/**
		 * Llamada al metodo Ver Series.
		 */
		ClsMostrarDatos.VerSeries(ObjGestCSeries);
	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Pedidos.
	 *
	 */
	public static void ConsultarDatosPedidos() {

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Materiales.
	 *
	 */
	public static void ConsultarDatosMateriales() {

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Herrajes.
	 *
	 */
	public static void ConsultarDatosHerrajes() {

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Envios.
	 *
	 */
	public static void ConsultarDatosEnvios() {

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Clientes.
	 *
	 */
	public static void ConsultarDatosClientes() {

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Articulo
	 *
	 */
	public static void ConsultarDatosArticulos() {

	}

	/**
	 * 
	 * Pedimos los datos a consultar en la entidad Desglose de Pedidos.
	 *
	 */
	public static void ConsultarDatosDesgloseDePedido() {

	}
}
