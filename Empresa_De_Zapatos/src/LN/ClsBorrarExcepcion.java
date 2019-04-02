package LN;

public class ClsBorrarExcepcion extends Exception{

	/**
	 * me añade esto que no se para que sirve
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje que mandamos en caso de excepcion.
	 */
	private final String MENSAJE = "El borrado no se ha podido realizar";
	
	@Override
	public String getMessage() {
		return MENSAJE;
	}

	
}
