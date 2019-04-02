package LP;

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

	public static void MenuConsultarDatos(ClsGestorLN objGestorMC, ClsMostrarDatos objMostrarDatos) {

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
				ConsultarDatosSuelas(objGestorMC, objMostrarDatos);
				break;

			case 2:
				ConsultarDatosSeries(objGestorMC, objMostrarDatos);
				break;

			case 3:
				ConsultarDatosPedidos(objGestorMC, objMostrarDatos);
				break;

			case 4:
				ConsultarDatosMateriales(objGestorMC, objMostrarDatos);
				break;

			case 5:
				ConsultarDatosHerrajes(objGestorMC, objMostrarDatos);
				break;

			case 6:
				ConsultarDatosEnvios(objGestorMC, objMostrarDatos);
				break;

			case 7:
				ConsultarDatosClientes(objGestorMC, objMostrarDatos);
				break;

			case 8:
				ConsultarDatosArticulos(objGestorMC, objMostrarDatos);
				break;

			case 9:
				ConsultarDatosDesgloseDePedido(objGestorMC, objMostrarDatos);
				break;

			default:
				break;
			}

		} while (opcionConsultar != 10);

	}

	/**
	 * Pedimos los datos a consultar en la entidad Suelas.
	 * 
	 * @param ObjGestCSuelas    relacion con LN
	 * @param objMostrarDatosSU relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosSuelas(ClsGestorLN ObjGestCSuelas, ClsMostrarDatos objMostrarDatosSU) {

		/**
		 * LLamada al metodo Ver Suelas
		 */
		objMostrarDatosSU.VerSuelas(ObjGestCSuelas);
	}

	/**
	 * Pedimos los datos a consultar en la entidad Series.
	 * 
	 * @param ObjGestCSeries    relacion con LN
	 * @param objMostrarDatosSE relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosSeries(ClsGestorLN ObjGestCSeries, ClsMostrarDatos objMostrarDatosSE) {

		/**
		 * Llamada al metodo Ver Series.
		 */
		objMostrarDatosSE.VerSeries(ObjGestCSeries);
	}

	/**
	 * Pedimos los datos a consultar en la entidad Pedidos.
	 * 
	 * @param ObjGestCPedidos  relacion con LN
	 * @param objMostrarDatosP relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosPedidos(ClsGestorLN ObjGestCPedidos, ClsMostrarDatos objMostrarDatosP) {
		
		/**
		 * Llamada al metodo ver datos
		 */
		objMostrarDatosP.VerPedidos(ObjGestCPedidos);

	}

	/**
	 * Pedimos los datos a consultar en la entidad Materiales.
	 * 
	 * @param ObjGestCMateriales relacion con LN
	 * @param objMostrarDatosM   relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosMateriales(ClsGestorLN ObjGestCMateriales, ClsMostrarDatos objMostrarDatosM) {

		/**
		 * Llamada al metodo mostrar Materiales
		 */
		objMostrarDatosM.VerMateriales(ObjGestCMateriales);
	}

	/**
	 * Pedimos los datos a consultar en la entidad Herrajes.
	 * 
	 * @param ObjGestCHerrajes relacion con LN
	 * @param objMostrarDatosH relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosHerrajes(ClsGestorLN ObjGestCHerrajes, ClsMostrarDatos objMostrarDatosH) {

		/**
		 * Llamada al metodo mostrar Herrajes
		 */
		objMostrarDatosH.VerHerrajes(ObjGestCHerrajes);

	}

	/**
	 * Pedimos los datos a consultar en la entidad Envios
	 * 
	 * @param ObjGestCEnvios   relacion con LN
	 * @param objMostrarDatosE relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosEnvios(ClsGestorLN ObjGestCEnvios, ClsMostrarDatos objMostrarDatosE) {
		/**
		 * Llamamos al metodo ver Envios.
		 */
		objMostrarDatosE.VerEnvios(ObjGestCEnvios);

	}

	/**
	 * Pedimos los datos a consultar en la entidad Clientes.
	 * 
	 * @param ObjGestCClientes relacion con LN
	 * @param objMostrarDatosC relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosClientes(ClsGestorLN ObjGestCClientes, ClsMostrarDatos objMostrarDatosC) {

		/**
		 * Llamamos al metodo ver clientes
		 */
		objMostrarDatosC.VerClientes(ObjGestCClientes);
	}

	/**
	 * Pedimos los datos a consultar en la entidad Articulo
	 * 
	 * @param ObjGestCArticulos relacion con LN
	 * @param objMostrarDatosA  relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosArticulos(ClsGestorLN ObjGestCArticulos, ClsMostrarDatos objMostrarDatosA) {

	}

	/**
	 * Pedimos los datos a consultar en la entidad Desglose de Pedidos.
	 * 
	 * @param ObjGestCDesglose relacion con LN
	 * @param objMostrarDatosD relacion con ClsMostrarDatos
	 */
	public static void ConsultarDatosDesgloseDePedido(ClsGestorLN ObjGestCDesglose, ClsMostrarDatos objMostrarDatosD) {

	}
}
