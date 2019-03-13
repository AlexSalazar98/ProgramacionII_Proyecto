package LN;

/**
 * 
 *@author Alex Salazar
 *@author David Requeta 
 *En esta clase vamos a recoger los atributos de la tabla materiales.
 *         
 */

public class ClsMateriales extends ClsMateriasPrimas{

	/**
	 * 
	 * Este es el contructor de la entidad Materiales con herencia de la clase Materias Primas.
	 * @param referencia
	 * @param descripcion
	 * @param precio
	 * 
	 */
	public ClsMateriales(int referencia, String descripcion, double precio) {
		super(referencia, descripcion, precio);	
	}



}
