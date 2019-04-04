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
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_ENTREGADO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NOMBRE_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_CPD_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_PRECIO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA_SUELAS;
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
	 * Constructor de la clase MostrarDatos
	 */
	public ClsMostrarDatos() {
	}

	/**
	 * Metodo para sacar por consola las series.
	 * 
	 * @param ObjGestorVS parametro para acceder al metodo DameSeries.
	 */
	public void VerSeries(ClsGestorLN ObjGestorVS) {

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
	public void VerSuelas(ClsGestorLN ObjGestorVS) {

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
	public void VerMateriales(ClsGestorLN ObjGestorVM) {
		ArrayList<ItfProperty> Materiales;

		Materiales = ObjGestorVM.DameMateriales();

		System.out.println("MATERIALES RECUPERADOS");
		System.out.println("----------------------");
		for (ItfProperty a : Materiales) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_MATERIALES_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_MATERIALES_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_MATERIALES_PRECIO));

		}

	}

	/**
	 * Metodo para sacar por consola herrajes
	 * 
	 * @param objGestorVH parametro para acceder a dame herrajes
	 */
	public void VerHerrajes(ClsGestorLN objGestorVH) {
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
	public void VerClientes(ClsGestorLN objGestorVC) {
		ArrayList<ItfProperty> Clientes;

		Clientes = objGestorVC.DameClientes();

		System.out.println("CLIENTES RECUPERADOS");
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

	/**
	 * Metodo sacar por consola Pedidos
	 * 
	 * @param objGestorVP
	 */
	public void VerPedidos(ClsGestorLN objGestorVP) {
		ArrayList<ItfProperty> Pedidos;

		Pedidos = objGestorVP.DamePedidos();

		System.out.println("PEDIDOS RECUPERADOS");
		System.out.println("--------------------");

		for (ItfProperty a : Pedidos) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO) + " "
					+ a.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO) + " "
					+ a.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA) + " "
					+ a.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO) + " "
					+ a.getStringProperty(PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE) + " "
					+ a.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO));

		}
	}

	/**
	 * Metodo sacar por consola Envios
	 * 
	 * @param objGestorVP
	 */
	public void VerEnvios(ClsGestorLN objGestorVP) {
		ArrayList<ItfProperty> Envios;

		Envios = objGestorVP.DameEnvios();

		System.out.println("ENVIOS RECUPERADOS");
		System.out.println("--------------------");

		for (ItfProperty a : Envios) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO) + " "
					+ a.getStringProperty(PROPIEDAD_ENVIOS_NOMBRE_CLIENTE) + " "
					+ a.getStringProperty(PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO) + " "
					+ a.getStringProperty(PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO) + " "
					+ a.getIntegerProperty(PROPIEDAD_ENVIOS_CPD_DE_ENVIO) + " "
					+ a.getStringProperty(PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO) + " "
					+ a.getIntegerProperty(PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO) + " "
					+ a.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO));

		}
	}

	/**
	 * Metodo sacar por consola Articulos
	 * 
	 * @param objGestorVA
	 */
	public void VerArticulos(ClsGestorLN objGestorVA) {
		ArrayList<ItfProperty> Articulos;

		Articulos = objGestorVA.DameArticulos();

		System.out.println("ARTICULOS RECUPERADOS");
		System.out.println("--------------------");

		for (ItfProperty a : Articulos) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_SERIE) + " "
					+ a.getStringProperty(PROPIEDAD_ARTICULO_DESCRIPCION) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES) + " "
					+ a.getDoubleProperty(PROPIEDAD_ARTICULO_PRECIO) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA_SUELAS));
		}
	}
}
