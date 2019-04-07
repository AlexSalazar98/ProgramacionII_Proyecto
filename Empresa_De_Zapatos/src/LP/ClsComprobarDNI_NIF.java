package LP;

import Excepciones.ClsDNI_NIFValidoExcepcion;

/**
 * Clase para comprobar DNI o NIF y crear excepcion explicita
 * 
 * @author Alex Salazar
 * @author David Requeta
 */

public class ClsComprobarDNI_NIF {

	/**
	 * Constructor de la clase comprobarDNI_NIF
	 */
	public ClsComprobarDNI_NIF() {
	}

	/**
	 * Metodo para comprobar DNI o NIF
	 * 
	 * @param DNI_NIF parametro recivido
	 * @return nos dice si es valido o no
	 * @throws ClsDNI_NIFValidoExcepcion excepcion generada por nosotros
	 */
	public boolean ComprobarDNI_NIF(String DNI_NIF) throws ClsDNI_NIFValidoExcepcion {

		/**
		 * Variables para el chequeo de DNI o NIF
		 */
		char PrimeraPosicion = DNI_NIF.charAt(0);
		String numeroNIF = "";
		boolean correcto = true;
		/**
		 * Si el largo del NIF es diferente a 9, acaba el método.
		 */
		if (DNI_NIF.length() != 9) {
			throw new ClsDNI_NIFValidoExcepcion();
		}

		/**
		 * Comprobamos que sea DNI o NIF y si es nif cambiamos su primera letra por el
		 * valor correspondiente.
		 * 
		 */
		if (PrimeraPosicion == 'X' | PrimeraPosicion == 'Y' | PrimeraPosicion == 'Z') {

			/**
			 * Seleccionamos los digitos del DNI o NIF
			 */
			numeroNIF = DNI_NIF.substring(0, DNI_NIF.length() - 1);

			/**
			 * Cambiamos la primera letra por valor
			 */
			numeroNIF = numeroNIF.replace("X", "0").replace("Y", "1").replace("Z", "2");
		} else {
			/**
			 * Seleccionamos los digitos del DNI o NIF
			 */
			numeroNIF = DNI_NIF.substring(0, DNI_NIF.length() - 1);
		}

		/**
		 * Secuencia de las letras del DNI o NIF en su posicion concreta-
		 */
		String secuenciaLetrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";

		char letraNIF = DNI_NIF.charAt(8);
		/**
		 * Dividimos el numero del DNI o NIF y nos quedamos con el resto
		 */
		int i = Integer.parseInt(numeroNIF) % 23;

		/**
		 * Comprueba que la letra del DNI y NIF coincidan con el patron de letras dados
		 */
		if (letraNIF != secuenciaLetrasNIF.charAt(i)) {
			correcto = false;
			/**
			 * Lanza una nueva excepcion
			 */
			throw new ClsDNI_NIFValidoExcepcion();

		}
		return correcto;
	}

}
