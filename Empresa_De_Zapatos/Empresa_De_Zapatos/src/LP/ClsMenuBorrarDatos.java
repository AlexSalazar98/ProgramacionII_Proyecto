package LP;

import java.text.ParseException;

/**
 * @author Alex Salazar
 * @author David Requeta
 * Creamos un menu donde podamos borrar los datos de nuestra base de datos.
 * 
 */
public class ClsMenuBorrarDatos {

	

	public static void MenuBorrarDatos() throws ParseException {
		
		/**
		 * 
		 *Variable para guardar la opcion elegida por el usuario.
		 *
		 */
				int opcionBorrar;

				/**
				 * 
				 * Mostramos al usuario las opciones que tiene para elegir a la hora de Borrar datos.
				 * 
				 */
				System.out.println("Elije la entidad de la que deseas Borrar datos: ");
				System.out.println("1- Borrar datos de Suelas: \n" 
				+ "2- Borrar datos de Series: \n"
				+ "3- Borrar datos de Pedidos: \n" 
				+ "4- Borrar datos de Materiales: \n"
				+ "5- Borrar datos de Herrajes: \n" 
				+ "6- Borrar datos de Envios: \n"
				+ "7- Borrar datos de Clientes: \n" 
				+ "8- Borrar datos de Articulos: \n"
				+ "9- Borrar datos de Desglose de Pedido: \n" 
				+ "10- Regresar al Menu Principal: ");
				
				/**
				 * 
				 *Pedimos los datos que deseen introducir.
				 *
				 */
				opcionBorrar = UtilidadesLP.leerEntero();
				do {

					switch (opcionBorrar) {
					case 1:
						BorrarDatosSuelas();
						break;

					case 2:
						BorrarDatosSeries();
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

					case 10:
						ClsMenuPrincipal.MenuPrincipal();
						break;

					default:
						break;
					}

				} while (opcionBorrar != 4);
	}
	
	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Suelas.
	 *
	 */
	public static void BorrarDatosSuelas() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Series.
	 *
	 */
	public static void BorrarDatosSeries() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Pedidos.
	 *
	 */
	public static void BorrarDatosPedidos() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Materiales.
	 *
	 */
	public static void BorrarDatosMateriales() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Herrajes.
	 *
	 */
	public static void BorrarDatosHerrajes() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Envios.
	 *
	 */
	public static void BorrarDatosEnvios() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Clientes.
	 *
	 */
	public static void BorrarDatosClientes() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Articulo
	 *
	 */
	public static void BorrarDatosArticulos() {

	}

	/**
	 * 
	 *Pedimos los datos a Borrar en la entidad Desglose de Pedidos.
	 *
	 */
	public static void BorrarDatosDesgloseDePedido() {

	}
}
