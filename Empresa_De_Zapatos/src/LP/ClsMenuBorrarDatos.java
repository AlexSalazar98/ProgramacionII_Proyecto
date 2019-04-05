package LP;

import java.sql.SQLException;
import LN.ClsBorrarExcepcion;
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

	public static void MenuBorrarDatos(ClsGestorLN objGestorMB) {

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
				BorrarDatosPedidos(objGestorMB);
				break;

			case 4:
				BorrarDatosMateriales(objGestorMB);
				break;

			case 5:
				BorrarDatosHerrajes(objGestorMB);
				break;

			case 6:
				BorrarDatosEnvios(objGestorMB);
				break;

			case 7:
				BorrarDatosClientes(objGestorMB);
				break;

			case 8:
				BorrarDatosArticulos(objGestorMB);
				break;

			case 9:
				BorrarDatosDesgloseDePedido(objGestorMB);
				break;

			default:
				break;
			}

		} while (opcionBorrar != 10);
	}

	/**
	 * Pedimos los datos a Borrar en la entidad Suelas.
	 * 
	 * @param objGestorBSu objeto gestor
	 */
	public static void BorrarDatosSuelas(ClsGestorLN objGestorBSu) {

		/**
		 * Pedimos el numero de Suela que queremos eliminar
		 */
		System.out.println("Inserte el numero de Suela que desee eliminar:");
		/**
		 * Variable para recoger el numero de serie
		 */
		int Referencia = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			/**
			 * Llamamos al metodo borrar y le pasamos el parametro.
			 */
			if (objGestorBSu.EliminarSuelasDeArray(Referencia)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Pedimos los datos a Borrar en la entidad Series.
	 * 
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
		int NDeSerie = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			/**
			 * Llamamos al metodo borrar y le pasamos el parametro.
			 */
			if (objGestorBse.EliminarSeriesDeArray(NDeSerie)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Pedidos.
	 *
	 */
	public static void BorrarDatosPedidos(ClsGestorLN objGestorBP) {
		/**
		 * Pedimos el numero de pedido que se desee borrar.
		 */
		System.out.println("Inserte el numero de Pedido que desee borrar: ");
		/**
		 * Variable para recoger el numero de Pedido.
		 */
		int NPedido = UtilidadesLP.leerEntero();
		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			/**
			 * Llamamos al metodo borrar y le pasamos el parametro.
			 */
			if (objGestorBP.EliminarPedidosDeArray(NPedido)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Pedimos los datos a Borrar en la entidad Materiales.
	 * 
	 * @param objGestorBM objeto gestor
	 */
	public static void BorrarDatosMateriales(ClsGestorLN objGestorBM) {
		/**
		 * Pedimos el numero de Materiales que se quiera eliminar.
		 */
		System.out.println("Inserte el Numero de Referencia del Material que desee eliminar:");
		/**
		 * Variable para recoger el numero de Material
		 */
		int Referencia = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			/**
			 * Llamamos al metodo borrar y le pasamos el parametro.
			 */
			if (objGestorBM.EliminarMaterialesDeArray(Referencia)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Pedimos los datos a Borrar en la entidad Herrajes.
	 * 
	 * @param objGestorBH parametro para acceder al gestor.
	 */
	public static void BorrarDatosHerrajes(ClsGestorLN objGestorBH) {
		/**
		 * Pedimos el numero de Herrajes que se quiera eliminar.
		 */
		System.out.println("Inserte el numero de Referencia de herrajes que desee eliminar");
		/**
		 * Variable para recoger el numero de herraje.
		 */
		int Referencia = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			if (objGestorBH.EliminarHerrajesDeArray(Referencia)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Envios.
	 *
	 */
	public static void BorrarDatosEnvios(ClsGestorLN objGestorBE) {
		/**
		 * Pedimos el numero de Herrajes que se quiera eliminar.
		 */
		System.out.println("Inserte el numero de Envio que desee eliminar");
		/**
		 * Variable para recoger el numero de herraje.
		 */
		int NEnvio = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			if (objGestorBE.EliminarEnviosDeArray(NEnvio)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Pedimos los datos a Borrar en la entidad Clientes.
	 * 
	 * @param objGestorBC parametro para acceder a eliminar clientes de Array
	 */
	public static void BorrarDatosClientes(ClsGestorLN objGestorBC) {
		/**
		 * Pedimos el numero de Herrajes que se quiera eliminar.
		 */
		System.out.println("Inserte el Numero del Cliente que desee eliminar:");
		/**
		 * Variable para recoger el numero de herraje.
		 */
		int NCliente = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			if (objGestorBC.EliminarClientesDeArray(NCliente)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Pedimos datos a Borrar en la entidad Articulos
	 * 
	 * @param objGestorBA parametro para acceder a borrar articulos del array
	 */
	public static void BorrarDatosArticulos(ClsGestorLN objGestorBA) {
		/**
		 * Pedimos el numero de Herrajes que se quiera eliminar.
		 */
		System.out.println("Inserte la Referencia del Articulo que desee eliminar");
		/**
		 * Variable para recoger el numero de herraje.
		 */
		int Referencia = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			if (objGestorBA.EliminarArticulosDeArray(Referencia)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Pedimos los datos a Borrar en la entidad Desglose de Pedidos.
	 *
	 */
	public static void BorrarDatosDesgloseDePedido(ClsGestorLN objGestorBD) {
		/**
		 * Pedimos el numero de Herrajes que se quiera eliminar.
		 */
		System.out.println("Inserte el Numero de Desglose que desee eliminar");
		/**
		 * Variable para recoger el numero de herraje.
		 */
		int NPedidoD = UtilidadesLP.leerEntero();

		/**
		 * Rodeamos con TRY CATCH para tratar excepciones y sacar mensaje de aviso
		 */
		try {
			if (objGestorBD.EliminarDesglosesDeArray(NPedidoD)) {
				System.out.println("Registro eliminado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		} catch (ClsBorrarExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

}
