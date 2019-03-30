package LP;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_PRECIO;

import java.util.ArrayList;

import COMUN.ItfProperty;
import LN.ClsGestorLN;

/**
 * Esta clase sirve para mostrar los datos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 */
public class ClsMostrarDatos {

	/**
	 * Metodo para sacar por consola las series.
	 * 
	 * @param ObjGestorVS parametro para acceder al metodo DameSeries.
	 */
	public static void VerSeries(ClsGestorLN ObjGestorVS) {

		ArrayList<ItfProperty> Series;

		Series = ObjGestorVS.DameSeries();

		System.out.println("SERIES RECUPERADAS");
		System.out.println("-------------------");
		for (ItfProperty a : Series) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE) + " "
					+ a.getStringProperty(PROPIEDAD_SERIES_DESCRIPCION));

		}
	}

	public static void VerSuelas(ClsGestorLN ObjGestorVS) {

		ArrayList<ItfProperty> Suelas;

		Suelas = ObjGestorVS.DameSuelas();

		System.out.println("SUELAS RECUPERADAS");
		System.out.println("-------------------");
		for (ItfProperty a : Suelas) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_SUELAS_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_SUELAS_PRECIO));

		}
	}
}
