package Excepciones;

/**
 * Clase para generar una excepcion implicita
 * 
 * @author Alex Salazar
 * @author David Requeta
 */

public class ClsExcepcionRuntime extends RuntimeException {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje que mandamos en caso de excepcion.
	 */
	private final String MENSAJE;

	/**
	 * Generamos un mensaje en funcion de la propiedad pedida
	 * 
	 * @param propiedad parametro de propiedad
	 */
	public ClsExcepcionRuntime(String propiedad) {
		MENSAJE = "La propiedad pedida " + propiedad + " no existe";
	}

	/**
	 * Devolvemos el mansaje en caso de que salte la excepcion
	 */
	@Override
	public String getMessage() {
		return MENSAJE;
	}

}
