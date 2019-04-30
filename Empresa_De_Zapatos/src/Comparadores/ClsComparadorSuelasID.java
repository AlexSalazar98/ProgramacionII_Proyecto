package Comparadores;

import java.util.Comparator;

import LN.ClsSuelas;

/**
 * Clase para comparar el ID de suelas
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsComparadorSuelasID implements Comparator<ClsSuelas> {

	@Override
	public int compare(ClsSuelas ID0, ClsSuelas ID1) {

		Integer a = ID0.getReferencia();
		Integer b = ID1.getReferencia();

		return a.compareTo(b);
	}

}
