package LP;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_PRECIO;
import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_PRECIO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DNI_NIF;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DIRECCION;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_PROVINCIA;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_TELEFONO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_EMAIL;

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

	/**
	 * Metodo para sacar por consola las suelas
	 * 
	 * @param ObjGestorVS parametro para acceder a DameSuelas
	 */
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

	/**
	 * Metodo para sacar por consola Materiales
	 * 
	 * @param ObjGestorVM parametro para acceder a DameMateriales
	 */
	public static void VerMateriales(ClsGestorLN ObjGestorVM) {
		ArrayList<ItfProperty> Materiales;

		Materiales = ObjGestorVM.DameMateriales();

		System.out.println("MATERIALES RECUPERADOS");
		System.out.println("----------------------");
		for (ItfProperty a : Materiales) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_SUELAS_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_SUELAS_PRECIO));

		}

	}

	/**
	 * Metodo para sacar por consola herrajes
	 * 
	 * @param objGestorVH parametro para acceder a dame herrajes
	 */
	public static void VerHerrajes(ClsGestorLN objGestorVH) {
		ArrayList<ItfProperty> Herrajes;

		Herrajes = objGestorVH.DameHerrajes();

		System.out.println("HERRAJES RECUPERADOS");
		System.out.println("--------------------");

		for (ItfProperty a : Herrajes) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_MATERIALES_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_MATERIALES_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_MATERIALES_PRECIO));

		}
	}

	/**
	 * Metodo para sacar por consola Clientes
	 * 
	 * @param objGestorVC parametro para acceder a dame clientes
	 */
	public static void VerClientes(ClsGestorLN objGestorVC) {
		ArrayList<ItfProperty> Clientes;

		Clientes = objGestorVC.DameClientes();

		System.out.println("HERRAJES RECUPERADOS");
		System.out.println("--------------------");

		for (ItfProperty a : Clientes) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_DNI_NIF) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_DIRECCION) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_PROVINCIA) + " "
					+ a.getIntegerProperty(PROPIEDAD_CLIENTE_TELEFONO) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_EMAIL));

		}
	}
}
