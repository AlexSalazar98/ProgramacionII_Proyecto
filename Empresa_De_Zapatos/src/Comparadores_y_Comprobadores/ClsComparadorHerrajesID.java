package Comparadores_y_Comprobadores;

import java.util.Comparator;
import LN.ClsHerrajes;

/**
 * Clase para comparar los IDs de los herrajes
 * 
 * @author Alex Salazar
 * @author David Requeta
 */
public class ClsComparadorHerrajesID implements Comparator<ClsHerrajes> {

	/**
	 * Metodo para comparar la Referencia de los Herrajes
	 */
	@Override
	public int compare(ClsHerrajes ID0, ClsHerrajes ID1) {

		/**
		 * Variables que recogen la Referencia para compararlos
		 */
		Integer a = ID0.getReferencia();
		Integer b = ID1.getReferencia();

		return a.compareTo(b);
	}

}
