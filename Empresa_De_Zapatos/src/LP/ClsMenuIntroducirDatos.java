package LP;
/**
 * 
 *@author Alex Salazar
 *@author David Requeta
 *Creamos un menu donde nos de las opciones de introducir los distintos tipos de datos que tenemos en nuestra base de datos.
 *
 */

public class ClsMenuIntroducirDatos {

	
	public static void MenuIntroducirDatos() {
		
		/**
		 * 
		 *Variable para guardar la opcion elegida por el usuario.
		 *
		 */
		int opcionIntroducir;
		
		/**
		 * 
		 *Mostramos al usuario las opciones que tiene para elegir a la hora de introducir datos.
		 *
		 */
		System.out.println("Elije la entidad donde desas introducir nuevos datos: ");
		System.out.println("1- Introducir datos de Suelas: \n"
				+ "2- Introducir datos de Series: \n"
				+ "3- Introducir datos de Pedidos: \n"
				+ "4- Introducir datos de Materiales: \n"
				+ "5- Introducir datos de Herrajes: \n"
				+ "6- Introducir datos de Envios: \n"
				+ "7- Introducir datos de Clientes: \n"
				+ "8- Introducir datos de Articulos: \n"
				+ "9- Introducir datos de Desglose de Pedido: \n"
				+ "10- Regresar al Menu Principal: ");
		/**
		 * 
		 *Pedimos los datos que deseen introducir.
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
	 *Pedimos los datos a introducir en la entidad Suelas.
	 *
	 */
	public static void IntroducirDatosSuelas() {
		
		
	}


	/**
	 * 
	 *Pedimos los datos a introducir en la entidad Series.
	 *
	 */
	public static void IntroducirDatosSeries() {
		
		
	}



	/**
	 * 
	 *Pedimos los datos a introducir en la entidad Pedidos.
	 *
	 */
	public static void IntroducirDatosPedidos() {
		
		
	}

	/**
	 * 
	 *Pedimos los datos a introducir en la entidad Materiales.
	 *
	 */
	public static void IntroducirDatosMateriales() {
		
		
	}

	//Pedimos los datos a introducir en la entidad Herrajes.
	public static void IntroducirDatosHerrajes() {
		
		
	}

	/**
	 * 
	 *Pedimos los datos a introducir en la entidad Envios.
	 *
	 */
	public static void IntroducirDatosEnvios() {
		
		
	}

	/**
	 * 
	 *Pedimos los datos a introducir en la entidad Clientes.
	 *
	 */
	public static void IntroducirDatosClientes() {
	
		
	}

	/**
	 * 
	 *Pedimos los datos a introducir en la entidad Articulo
	 *
	 */
	public static void IntroducirDatosArticulos() {
		
		
	}
	
	/**
	 * 
	 *pedimos los datos a introducir en la entidad Desglose de Pedidos.
	 *
	 */
	public static void IntroducirDatosDesgloseDePedido() {
		
		
	}
}
