package LP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import LN.ClsGestorLN;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta Creamos un menu donde nos de las opciones de introducir
 *         los distintos tipos de datos que tenemos en nuestra base de datos.
 *
 */

public class ClsMenuIntroducirDatos {

	public static void MenuIntroducirDatos(ClsGestorLN objGestorMI) throws ParseException {

		/**
		 * 
		 * Variable para guardar la opcion elegida por el usuario.
		 *
		 */
		int opcionIntroducir;

		do {
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
			switch (opcionIntroducir) {
			case 1:
				IntroducirDatosSuelas(objGestorMI);
				break;

			case 2:
				IntroducirDatosSeries(objGestorMI);
				break;

			case 3:
				IntroducirDatosPedidos(objGestorMI);
				break;

			case 4:
				IntroducirDatosMateriales(objGestorMI);
				break;

			case 5:
				IntroducirDatosHerrajes(objGestorMI);
				break;

			case 6:

				IntroducirDatosEnvios(objGestorMI);
				break;

			case 7:
				IntroducirDatosClientes(objGestorMI);
				break;

			case 8:
				IntroducirDatosArticulos(objGestorMI);
				break;

			case 9:
				IntroducirDatosDesgloseDePedido(objGestorMI);
				break;

			default:
				break;
			}

		} while (opcionIntroducir != 10);

	}

	/**
	 * Pedimos los datos a introducir en la entidad Suelas.
	 * 
	 * @param objGSuelas objeto suelas
	 */
	public static void IntroducirDatosSuelas(ClsGestorLN objGSuelas) {

		/**
		 * variables para recoger los datos de la entidad Suela.
		 */
		int Referencia_Suelas;
		String Descripcion_Suelas;
		double Precio_Suelas;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el n�mero de Referencia:");
		Referencia_Suelas = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Descripci�n:");
		Descripcion_Suelas = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Precio:");
		Precio_Suelas = UtilidadesLP.leerReal();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGSuelas.CrearSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);

	}

	/**
	 * Pedimos los datos a introducir en la entidad Series.
	 * 
	 * @param objGSeries objeto series
	 */
	public static void IntroducirDatosSeries(ClsGestorLN objGSeries) {

		/**
		 * variables para recoger los datos de la entidad Series.
		 */
		int NumeroDeSerie;
		String descripcion_Serie;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el N�mero de Serie:");
		NumeroDeSerie = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Descripci�n:");
		descripcion_Serie = UtilidadesLP.leerCadena();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGSeries.CrearSerie(NumeroDeSerie, descripcion_Serie);
	}

	/**
	 * Pedimos los datos a introducir en la entidad Pedidos.
	 * 
	 * @param objGPedidos objeto pedidos
	 * @throws ParseException para el parseo
	 */
	public static void IntroducirDatosPedidos(ClsGestorLN objGPedidos) throws ParseException {

		/**
		 * variables para recoger los datos de la entidad Pedidos.
		 */
		int NumeroDePedido;
		String fechaDePedido;
		String fechaDeEntrega;
		int comprobar;
		Boolean Entregado;
		int NumeroDeCliente_Pedidos;
		String NombreYApelliosDelCliente;

		/**
		 * Para formatear las fechas
		 */
		SimpleDateFormat miFormato = new SimpleDateFormat("dd-mm-yyyy");
		// DateFormat miFormato = DateFormat.getDateInstance(DateFormat.MEDIUM);
		/**
		 * pedimos los datos.
		 */
		System.out.println("Introduzca el N�mero de Pedido:");
		NumeroDePedido = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Fecha del Pedido (Formato: 00-00-0000):");
		fechaDePedido = UtilidadesLP.leerCadena();
		/**
		 * Pasamos de String a date y eliminamos el parseo. (para las excepciones hemos
		 * a�adido throws ParseException
		 */
		Date FechaDePedido = miFormato.parse(fechaDePedido);
		// System.out.println(miFormato.format(FechaDePedido)); ----> Para formatear a
		// la salida.
		System.out.print("Introduzca la Fecha de Entrega (Formato: 00-00-0000):");
		fechaDeEntrega = UtilidadesLP.leerCadena();
		/**
		 * Pasamos de String a date y eliminamos el parseo. (para las excepciones hemos
		 * a�adido throws ParseException
		 */
		Date FechaDeEntrega = miFormato.parse(fechaDeEntrega);
		System.out.print("Introduce 1 (Si) o 0 (No) para indicar si el pedido esta entregado o no:");
		comprobar = UtilidadesLP.leerEntero();
		if (comprobar == 1) {
			Entregado = true;

		} else {
			Entregado = false;
		}
		System.out.print("Introduzca el Numero de Cliente:");
		NumeroDeCliente_Pedidos = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el Nombre y los Apellidos del Cliente:");
		NombreYApelliosDelCliente = UtilidadesLP.leerCadena();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGPedidos.CrearPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado, NumeroDeCliente_Pedidos,
				NombreYApelliosDelCliente);

	}

	/**
	 * Pedimos los datos a introducir en la entidad Materiales. *
	 * 
	 * @param objGMateriales objeto materiales
	 */
	public static void IntroducirDatosMateriales(ClsGestorLN objGMateriales) {

		/**
		 * variables para recoger los datos de la entidad Materiales.
		 */
		int Referencia_Materiales;
		String Descripcion_Materiales;
		double Precio_Materiales;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el n�mero de Referencia:");
		Referencia_Materiales = UtilidadesLP.leerEntero();
		System.out.print("Dame la Descripci�n:");
		Descripcion_Materiales = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Precio:");
		Precio_Materiales = UtilidadesLP.leerReal();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGMateriales.CrearMateriales(Referencia_Materiales, Descripcion_Materiales, Precio_Materiales);

	}

	/**
	 * Pedimos los datos a introducir en la entidad Herrajes. *
	 * 
	 * @param objGHerrajes objeto herrajes
	 */
	public static void IntroducirDatosHerrajes(ClsGestorLN objGHerrajes) {

		/**
		 * variables para recoger los datos de la entidad Herrajes.
		 */
		int Referencia_Herrajes;
		String Descripcion_Herrajes;
		double Precio_Herrajes;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el n�mero de Referencia:");
		Referencia_Herrajes = UtilidadesLP.leerEntero();
		System.out.print("Dame la Descripci�n:");
		Descripcion_Herrajes = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Precio:");
		Precio_Herrajes = UtilidadesLP.leerReal();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGHerrajes.CrearHerrajes(Referencia_Herrajes, Descripcion_Herrajes, Precio_Herrajes);

	}

	/**
	 * Pedimos los datos a introducir en la entidad Envios.
	 * 
	 * @param objGEnvios objeto envios
	 */
	public static void IntroducirDatosEnvios(ClsGestorLN objGEnvios) {

		/**
		 * variables para recoger los datos de la entidad Envios.
		 */
		int NumeroDeEnvio;
		String NombreCliente;
		String DireccionDeEnvio;
		String PoblacionDeEnvio;
		String CPDeEnvio;
		String ProvinciaDeEnvio;
		int TelefonoDeEnvio;
		int NumeroDeCliente_Envio;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el N�mero de Envio:");
		NumeroDeEnvio = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el Nombre del Cliente:");
		NombreCliente = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la Direccion de Envio:");
		DireccionDeEnvio = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la Poblaci�n de Envio:");
		PoblacionDeEnvio = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el Codigo Postal de Envio:");
		CPDeEnvio = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la Provincia de Envio:");
		ProvinciaDeEnvio = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el N�mero de telefono de Envio:");
		TelefonoDeEnvio = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el N�mero de Cliente:");
		NumeroDeCliente_Envio = UtilidadesLP.leerEntero();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGEnvios.CrearEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
				ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);
	}

	/**
	 * Pedimos los datos a introducir en la entidad Clientes.
	 * 
	 * @param objGClientes objeto clientes
	 */
	public static void IntroducirDatosClientes(ClsGestorLN objGClientes) {

		/**
		 * variables para recoger los datos de la entidad Clientes.
		 */
		int NumeroDeCliente;
		String NombreYApellidos;
		String DNI_NIF;
		String DireccionDeCliente;
		String Provincia;
		int Telefono;
		String Email;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca N�mero de Cliente:");
		NumeroDeCliente = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el Nombre y los Apellidos del cliente:");
		NombreYApellidos = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el DNI/NIF del cliente:");
		DNI_NIF = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la direcci�n del cliente:");
		DireccionDeCliente = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la provincia del cliente:");
		Provincia = UtilidadesLP.leerCadena();
		System.out.print("Introduzca el n�mero de telefono del cliente:");
		Telefono = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el email del cliente:");
		Email = UtilidadesLP.leerCadena();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGClientes.CrearClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia, Telefono,
				Email);

	}

	/**
	 * Pedimos los datos a introducir en la entidad Articulo
	 * 
	 * @param objGArticulos objeto articulos
	 */
	public static void IntroducirDatosArticulos(ClsGestorLN objGArticulos) {

		/**
		 * variables para recoger los datos de la entidad Articulos.
		 */
		int Referencia;
		int Serie;
		String Descripcion;
		int CantidadMaterial;
		int CantidadHerrajes;
		double Precio;
		int ReferenciaSuelas_Articulos;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el n�mero de referencia del art�culo:");
		Referencia = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el numero de la serie:");
		Serie = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la descripci�n del articulo:");
		Descripcion = UtilidadesLP.leerCadena();
		System.out.print("Introduzca la cantidad de material:");
		CantidadMaterial = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de herraje");
		CantidadHerrajes = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el precio del art�culo");
		Precio = UtilidadesLP.leerReal();
		System.out.print("Introduzca el n�mero de referencia de la suelas:");
		ReferenciaSuelas_Articulos = UtilidadesLP.leerEntero();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGArticulos.CrearArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
				ReferenciaSuelas_Articulos);

	}

	/**
	 * pedimos los datos a introducir en la entidad Desglose de Pedidos.
	 * 
	 * @param objGDesgloseDePedido objeto desglose de pedido
	 */
	public static void IntroducirDatosDesgloseDePedido(ClsGestorLN objGDesgloseDePedido) {

		/**
		 * variables para recoger los datos de la entidad Desglose de Pedido.
		 */
		int NumeroDePedido;
		int ReferenciaDelArticulo;
		int Serie;
		int Color;
		int NumeroDePie5;
		int NumeroDePie6;
		int NumeroDePie7;
		int NumeroDePie8;
		int NumeroDePie9;
		int NumeroDePie0;
		int NumeroDePie1;
		int NumeroDePie2;
		int NumeroDePie3;
		int NumeroDePie4;
		int CantidadTotal;
		int NumeroDeCliente_Desglose;

		/**
		 * pedimos los datos.
		 */
		System.out.print("Introduzca el N�mero de Pedido:");
		NumeroDePedido = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la Referencia del Art�culo:");
		ReferenciaDelArticulo = UtilidadesLP.leerEntero();
		System.out.print("Introduzca ");
		Serie = UtilidadesLP.leerEntero();
		System.out.print("Introduzca el N�mero del Color:");
		Color = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 5:");
		NumeroDePie5 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 6:");
		NumeroDePie6 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 7:");
		NumeroDePie7 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 8:");
		NumeroDePie8 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 9:");
		NumeroDePie9 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 0:");
		NumeroDePie0 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 1:");
		NumeroDePie1 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 2:");
		NumeroDePie2 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 3:");
		NumeroDePie3 = UtilidadesLP.leerEntero();
		System.out.print("Introduzca la cantidad de pares de zapatos del N�mero 4:");
		NumeroDePie4 = UtilidadesLP.leerEntero();
		CantidadTotal = NumeroDePie0 + NumeroDePie1 + NumeroDePie2 + NumeroDePie3 + NumeroDePie4 + NumeroDePie5
				+ NumeroDePie6 + NumeroDePie7 + NumeroDePie8 + NumeroDePie9;
		System.out.print("Introduzca el N�mero del Cliente:");
		NumeroDeCliente_Desglose = UtilidadesLP.leerEntero();

		/**
		 * Pasamos los parametros para generer el objeto
		 */
		objGDesgloseDePedido.CrearDesgloseDePedido(NumeroDePedido, ReferenciaDelArticulo, Serie, Color, NumeroDePie5,
				NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1, NumeroDePie2,
				NumeroDePie3, NumeroDePie4, CantidadTotal, NumeroDeCliente_Desglose);

	}
}
