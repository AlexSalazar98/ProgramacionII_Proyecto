package Comparadores_y_Comprobadores;

import java.util.Comparator;

import LN.ClsPedidos;

/**
 * Clase para comparar por fechas de pedido, si no por fechas de entrega y si no
 * por nombre y apellidos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */

public class ClsComparadorPorFechas implements Comparator<ClsPedidos> {

	/**
	 * Metodo el cual primero compara fechas de pedido, luego fechas de entrega y
	 * por último nombres y apellidos de los clientes de la tabla pedidos
	 */
	@Override
	public int compare(ClsPedidos P0, ClsPedidos P1) {

		/**
		 * Recogemos las fechas de pedido.
		 */
		java.util.Date a = P0.getFechaDePedido();
		java.util.Date b = P1.getFechaDePedido();

		/**
		 * Recogemos las fechas de entrega.
		 */
		java.util.Date c = P0.getFechaDeEntrega();
		java.util.Date d = P1.getFechaDeEntrega();

		/**
		 * Recogemos nombre y apellido
		 */
		String e = P0.getNombreYApelliosDelCliente();
		String f = P1.getNombreYApelliosDelCliente();

		/**
		 * sin coinciden las fechas de pedido.
		 */
		if (a.equals(b)) {
			/**
			 * Compara las fechas de entrega
			 */
			c.compareTo(d);
			/**
			 * Si las fechas de entrega coinciden.
			 */
			if (a.equals(b) & c.equals(d)) {
				/**
				 * devuelve la comparacion por nombre.
				 */
				return e.compareTo(f);
				/**
				 * si no coinciden fechas de entrega.
				 */
			} else {
				/**
				 * devuelve ordenado por fechas de entrega
				 */
				return c.compareTo(d);
			}
			/**
			 * si no coinciden fechas de pedido
			 */
		} else {
			/**
			 * Devuelve ordenado por fechas de pedido.
			 */
			return a.compareTo(b);
		}
	}

}
