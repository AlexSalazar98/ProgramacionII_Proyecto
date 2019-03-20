/**
 * 
 */
package COMUN;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author javier.cerro
 * Interfaz para la independencia entre la LN y la LP.
 */
public interface ItfProperty 
{
	
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo String.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return genera return
	 */
	String 	getStringProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Integer.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return genera return
	 */
	Integer getIntegerProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Float.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return genera return
	 */
	Float 	getFloatProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Double.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return genera return
	 */
	Double	getDoubleProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo char.
	 * @param propiedad nombre de la propiedad a devolver del objeto.
	 * @return genera return 
	 */
	char	getCharProperty		(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Date.
	 * Implementado por nosotros para el uso de fechas.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return genera return
	 */
	Date	getDateProperty		(String propiedad);

	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Boolean.
	 * Implementado por nosotros para el uso de fechas.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return genera return
	 */
	Boolean		getBooleanProperty 		(String propiedad);
}
