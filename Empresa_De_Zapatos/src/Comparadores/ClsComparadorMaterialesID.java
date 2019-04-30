package Comparadores;

import java.util.Comparator;
import LN.ClsMateriales;

/**
 * Clase para comparar Materiales por ID
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsComparadorMaterialesID implements Comparator<ClsMateriales> {

	@Override
	public int compare(ClsMateriales ID0, ClsMateriales ID1) {

		Integer a = ID0.getReferencia();
		Integer b = ID1.getReferencia();

		return a.compareTo(b);
	}

}
