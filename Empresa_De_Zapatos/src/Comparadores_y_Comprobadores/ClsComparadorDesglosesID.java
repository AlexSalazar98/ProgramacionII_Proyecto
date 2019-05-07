package Comparadores_y_Comprobadores;

import java.util.Comparator;

import LN.ClsDesgloseDePedido;

/**
 * Clase para comparar desgloses por id
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsComparadorDesglosesID implements Comparator<ClsDesgloseDePedido> {

	@Override
	public int compare(ClsDesgloseDePedido ID0, ClsDesgloseDePedido Id1) {

		Integer a = ID0.getNumeroDePedido();
		Integer b = Id1.getNumeroDePedido();

		return a.compareTo(b);
	}

}
