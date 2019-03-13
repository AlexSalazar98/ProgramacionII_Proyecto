package LP;

import java.util.Date;

import javax.sound.midi.Soundbank;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta Creamos un menu donde nos de las opciones de introducir
 *         los distintos tipos de datos que tenemos en nuestra base de datos.
 *
 */

public class ClsMenuIntroducirDatos {

	public static void MenuIntroducirDatos() {

		/**
		 * 
		 * Variable para guardar la opcion elegida por el usuario.
		 *
		 */
		int opcionIntroducir;

		/**
		 * 
		 * Mostramos al usuario las opciones que tiene para elegir a la hora de
		 * introducir datos.
		 *
		 */
		System.out.println("Elije la entidad donde desas introducir nuevos datos: ");
		System.out.println("1- Introducir datos de Suelas: \n" + "2- Introducir datos de Series: \n"
				+ "3- Introducir datos de Pedidos: \n" + "4- Introducir datos de Materiales: \n"
				+ "5- Introducir datos de Herrajes: \n" + "6- Introducir datos de Envios: \n"
				+ "7- Introducir datos de Clientes: \n" + "8- Introducir datos de Articulos: \n"
				+ "9- Introducir datos de Desglose de Pedido: \n" + "10- Regresar al Menu Principal: ");
		/**
		 * 
		 * Pedimos los datos que deseen introducir.
		 *
		 */
		opcionIntroducir = UtilidadesLP.leerEntero();
		do {

			switch (opcionIntroducir) {
			case 1:
				IntroducirDatosSuelas();
				break;

			case 2:
				IntroducirDatosSeries();
				break;

			case 3:
				IntroducirDatosPedidos();
				break;

			case 4:
				IntroducirDatosMateriales();
				break;

			case 5:
				IntroducirDatosHerrajes();
				break;

			case 6:

				IntroducirDatosEnvios();
				break;

			case 7:
				IntroducirDatosClientes();
				break;

			case 8:
				IntroducirDatosArticulos();
				break;

			case 9:
				IntroducirDatosDesgloseDePedido();
				break;

			case 10:
				ClsMenuPrincipal.MenuPrincipal();
				break;

			default:
				break;
			}

		} while (opcionIntroducir != 4);

	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Suelas.
	 *
	 */
	public static void IntroducirDatosSuelas() {

		/**
		 * variables para recoger los datos de la entidad Suela.
		 */
		int Referencia_Suelas;
		String Descripcion_Suelas;
		double Precio_Suelas;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el número de Referencia:");
		Referencia_Suelas = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Descripción:");
		Descripcion_Suelas = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Precio:");
		Precio_Suelas = UtilidadesLP.leerReal();

	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Series.
	 *
	 */
	public static void IntroducirDatosSeries() {

		/**
		 * variables para recoger los datos de la entidad Series.
		 */
		int NumeroDeSerie;
		String descripcion_Serie;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el Número de Serie:");
		NumeroDeSerie = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Descripción:");
		descripcion_Serie = UtilidadesLP.leerCadena();
	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Pedidos.
	 *
	 */
	public static void IntroducirDatosPedidos() {

		/**
		 * variables para recoger los datos de la entidad Pedidos.
		 */
		int NumeroDePedido;
		String FechaDePedido;
		String FechaDeEntrega;
		int Entregado;
		int NumeroDeCliente_Pedidos;
		String NombreYApelliosDelCliente;

		/**
		 * pedimos los datos.
		 */
		System.out.println("Introduzca el Número de Pedido:");
		NumeroDePedido = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Fecha del Pedido (Formato: 00-00-0000):");
		FechaDePedido = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la Fecha de Entrega (Formato: 00-00-00):");
		FechaDeEntrega = UtilidadesLP.leerCadena();
		System.out.print("Introduce 1 (Si) o 0 (No) para indicar si el pedido esta entregado o no:");
		Entregado = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el Numero de Cliente:");
		NumeroDeCliente_Pedidos = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el Nombre y los Apellidos del Cliente:");
		NombreYApelliosDelCliente = UtilidadesLP.leerCadena();

	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Materiales.
	 *
	 */
	public static void IntroducirDatosMateriales() {

		/**
		 * variables para recoger los datos de la entidad Materiales.
		 */
		int Referencia_Materiales;
		String Descripcion_Materiales;
		double Precio_Materiales;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el número de Referencia:");
		Referencia_Materiales = UtilidadesLP.leerEntero();
		System.out.print("Dame la Descripción:");
		Descripcion_Materiales = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Precio:");
		Precio_Materiales = UtilidadesLP.leerReal();

	}

	// Pedimos los datos a introducir en la entidad Herrajes.
	public static void IntroducirDatosHerrajes() {

		/**
		 * variables para recoger los datos de la entidad Herrajes.
		 */
		int Referencia_Herrajes;
		String Descripcion_Herrajes;
		double Precio_Herrajes;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el número de Referencia:");
		Referencia_Herrajes = UtilidadesLP.leerEntero();
		System.out.print("Dame la Descripción:");
		Descripcion_Herrajes = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Precio:");
		Precio_Herrajes = UtilidadesLP.leerReal();

	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Envios.
	 *
	 */
	public static void IntroducirDatosEnvios() {

	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Clientes.
	 *
	 */
	public static void IntroducirDatosClientes() {

	}

	/**
	 * 
	 * Pedimos los datos a introducir en la entidad Articulo
	 *
	 */
	public static void IntroducirDatosArticulos() {

	}

	/**
	 * 
	 * pedimos los datos a introducir en la entidad Desglose de Pedidos.
	 *
	 */
	public static void IntroducirDatosDesgloseDePedido() {

	}
}
