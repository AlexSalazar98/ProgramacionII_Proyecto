package Excepciones;

/**
 * Clase para excepcion en caso de que el borrado de BD no se ejecute.
 * 
 * @author Alex Salazar
 * @author David Requeta
 */
public class ClsBorrarExcepcion extends Exception {

	/**
	 * me añade esto que no se para que sirve
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje que mandamos en caso de excepcion.
	 */
	private final String MENSAJE = "El borrado no se ha podido realizar";

	/**
	 * Devolvemos el mansaje en caso de que salte la excepcion
	 */
	@Override
	public String getMessage() {
		return MENSAJE;
	}

}
