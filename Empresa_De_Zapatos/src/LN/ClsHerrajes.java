package LN;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta 
 * En esta clase vamos a recoger los atributos de la tabla herrajes.
 *         
 */

public class ClsHerrajes extends ClsMateriasPrimas{

	/**
	 * Este es el constructor de la entidad Herrajes con herencia de la clase Materias Primas.
	 * @param referencia
	 * @param descripcion
	 * @param precio
	 * 
	 */
	public ClsHerrajes(int referencia, String descripcion, double precio) {
		super(referencia, descripcion, precio);
	}



}
