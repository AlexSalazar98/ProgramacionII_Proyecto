package Comparadores_y_Comprobadores;

import java.util.Comparator;

import LN.ClsPedidos;

/**
 * Clase para comparar pedidos por ID
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsComparadorPedidosID implements Comparator<ClsPedidos>{

	@Override
	public int compare(ClsPedidos ID0, ClsPedidos ID1) {
		
		Integer a = ID0.getNumeroDePedido();
		Integer b = ID1.getNumeroDePedido();
		
		return a.compareTo(b);
	}

}
