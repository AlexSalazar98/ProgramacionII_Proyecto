package Comparadores_y_Comprobadores;

import java.util.Comparator;

import LN.ClsSeries;

/**
 * Clase para ordenar los IDs de Series
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsComparadorSeriesID implements Comparator<ClsSeries> {

	@Override
	public int compare(ClsSeries ID0, ClsSeries ID1) {

		Integer a = ID0.getNumeroDeSerie();
		Integer b = ID1.getNumeroDeSerie();

		return a.compareTo(b);
	}

}
