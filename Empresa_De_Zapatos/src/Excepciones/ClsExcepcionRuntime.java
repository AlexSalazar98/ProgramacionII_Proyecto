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

	public ClsExcepcionRuntime(String propiedad) {
		MENSAJE = "La propiedad pedida " + propiedad + " no existe";
	}

	@Override
	public String getMessage() {
		return MENSAJE;
	}

}
