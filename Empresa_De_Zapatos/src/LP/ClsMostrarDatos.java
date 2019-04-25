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
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL;
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
	 * @param ObjGestorVSe parametro para acceder al metodo DameSeries.
	 */
	public void VerSeries(ClsGestorLN ObjGestorVSe) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Series;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Series = ObjGestorVSe.DameSeries();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("SERIES RECUPERADAS");
		System.out.println("-------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Series) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE) + " "
					+ a.getStringProperty(PROPIEDAD_SERIES_DESCRIPCION));

		}
		System.out.println("-------------------");
	}

	/**
	 * Metodo para sacar por consola las suelas
	 * 
	 * @param ObjGestorVS parametro para acceder a DameSuelas
	 */
	public void VerSuelas(ClsGestorLN ObjGestorVS) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Suelas;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Suelas = ObjGestorVS.DameSuelas();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("SUELAS RECUPERADAS");
		System.out.println("-------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Suelas) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_SUELAS_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_SUELAS_PRECIO));

		}
		System.out.println("-------------------");
	}

	/**
	 * Metodo para sacar por consola Materiales
	 * 
	 * @param ObjGestorVM parametro para acceder a DameMateriales
	 */
	public void VerMateriales(ClsGestorLN ObjGestorVM) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Materiales;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Materiales = ObjGestorVM.DameMateriales();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("MATERIALES RECUPERADOS");
		System.out.println("----------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Materiales) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_MATERIALES_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_MATERIALES_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_MATERIALES_PRECIO));

		}
		System.out.println("-------------------");

	}

	/**
	 * Metodo para sacar por consola herrajes
	 * 
	 * @param objGestorVH parametro para acceder a dame herrajes
	 */
	public void VerHerrajes(ClsGestorLN objGestorVH) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Herrajes;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Herrajes = objGestorVH.DameHerrajes();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("HERRAJES RECUPERADOS");
		System.out.println("--------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Herrajes) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_MATERIALES_REFERENCIA) + " "
					+ a.getStringProperty(PROPIEDAD_MATERIALES_DESCRIPCION) + " "
					+ a.getDoubleProperty(PROPIEDAD_MATERIALES_PRECIO));

		}
		System.out.println("-------------------");
	}

	/**
	 * Metodo para sacar por consola Clientes
	 * 
	 * @param objGestorVC parametro para acceder a dame clientes
	 */
	public void VerClientes(ClsGestorLN objGestorVC) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Clientes;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Clientes = objGestorVC.DameClientes();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("CLIENTES RECUPERADOS");
		System.out.println("--------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Clientes) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_DNI_NIF) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_DIRECCION) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_PROVINCIA) + " "
					+ a.getIntegerProperty(PROPIEDAD_CLIENTE_TELEFONO) + " "
					+ a.getStringProperty(PROPIEDAD_CLIENTE_EMAIL));

		}
		System.out.println("-------------------");
	}

	/**
	 * Metodo sacar por consola Pedidos
	 * 
	 * @param objGestorVP objeto para acceder a DamePedidos
	 */
	public void VerPedidos(ClsGestorLN objGestorVP) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Pedidos;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Pedidos = objGestorVP.DamePedidos();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("PEDIDOS RECUPERADOS");
		System.out.println("--------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Pedidos) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO) + " "
					+ a.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO) + " "
					+ a.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA) + " "
					+ a.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO) + " "
					+ a.getStringProperty(PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE) + " "
					+ a.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO));

		}
		System.out.println("-------------------");
	}

	/**
	 * Metodo sacar por consola Envios
	 * 
	 * @param objGestorVE objeto para acceder a DameEnvios
	 */
	public void VerEnvios(ClsGestorLN objGestorVE) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Envios;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Envios = objGestorVE.DameEnvios();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("ENVIOS RECUPERADOS");
		System.out.println("--------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
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
		System.out.println("-------------------");
	}

	/**
	 * Metodo sacar por consola Articulos
	 * 
	 * @param objGestorVA objeto para acceder a DameArticulos.
	 */
	public void VerArticulos(ClsGestorLN objGestorVA) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Articulos;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Articulos = objGestorVA.DameArticulos();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("ARTICULOS RECUPERADOS");
		System.out.println("--------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Articulos) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_SERIE) + " "
					+ a.getStringProperty(PROPIEDAD_ARTICULO_DESCRIPCION) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES) + " "
					+ a.getDoubleProperty(PROPIEDAD_ARTICULO_PRECIO) + " "
					+ a.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA_SUELAS));
		}
		System.out.println("-------------------");
	}

	public void VerDesgloses(ClsGestorLN objGestorVD) {

		/**
		 * Insatnciamos un Array de tipo ITF
		 */
		ArrayList<ItfProperty> Desgloses;

		/**
		 * Recogemos los objetos del Array de la clase y los pasamos al de ITF
		 */
		Desgloses = objGestorVD.DameDesgloses();

		/**
		 * Mostramos mensaje a partir del cual va e salir la informacion obtenida
		 */
		System.out.println("DESGLOSES RECUPERADOS");
		System.out.println("---------------------");

		/**
		 * obtenemos cada propiedad de cada uno de los objetos y los sacamos por
		 * pantalla
		 */
		for (ItfProperty a : Desgloses) {

			System.out.println(a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL) + " "
					+ a.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO));
		}
		System.out.println("-------------------");
	}
}
