package Comparadores_y_Comprobadores;

import java.util.Comparator;
import LN.ClsEnvios;

/**
 * Clase para comparar envios por ID
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsComparadorEnviosID implements Comparator<ClsEnvios> {

	/**
	 * Metodo para comparar el id de los Envios
	 */
	@Override
	public int compare(ClsEnvios ID0, ClsEnvios ID1) {

		/**
		 * Variables que recogen el NUmero de Envio para compararlos
		 */
		Integer a = ID0.getNumeroDeEnvio();
		Integer b = ID1.getNumeroDeEnvio();

		return a.compareTo(b);
	}

}
