package Excepciones;

/**
 * Clase para generar la excepcion y el mensaje de error.
 * 
 * @author Alex Salazar
 * @author David Requeta
 */

public class ClsDNI_NIFValidoExcepcion extends Exception {

	/**
	 * Esto no se para que lo genera pero no lo usamos.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje que mandamos en caso de excepcion.
	 */
	private final String MENSAJE = "El DNI o NIF es incorrecto";

	/**
	 * Devolvemos el mansaje en caso de que salte la excepcion
	 */
	@Override
	public String getMessage() {
		return MENSAJE;
	}

}
