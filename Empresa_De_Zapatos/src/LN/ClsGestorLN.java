package LN;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase de gestion entre LN y LP
 * 
 * @author Alex Salazar
 * @author David Requeta En esta clase relacionamos las clases de los paquetes
 *         LP Y LN.
 *
 */

public class ClsGestorLN {

	/**
	 * Instanciamos los Arrays donde guardar los objetos.
	 */
	ArrayList<ClsArticulos> MiListaDeArticulos;
	ArrayList<ClsClientes> MiListaDeClientes;
	ArrayList<ClsDesgloseDePedido> MiListaDeDesgloses;
	ArrayList<ClsEnvios> MiListaDeEnvios;
	ArrayList<ClsMateriasPrimas> MiListaDeMateriasPrimas;
	ArrayList<ClsPedidos> MiListaDePedidos;
	ArrayList<ClsSeries> MiListaDeSeries;

	/**
	 * Aqui generaremos todo en relacion al Gestor.
	 */
	public ClsGestorLN() {

		/**
		 * Inicializamos los Arrays.
		 */
		MiListaDeArticulos = new ArrayList<ClsArticulos>();
		MiListaDeClientes = new ArrayList<ClsClientes>();
		MiListaDeDesgloses = new ArrayList<ClsDesgloseDePedido>();
		MiListaDeEnvios = new ArrayList<ClsEnvios>();
		MiListaDeMateriasPrimas = new ArrayList<ClsMateriasPrimas>();
		MiListaDePedidos = new ArrayList<ClsPedidos>();
		MiListaDeSeries = new ArrayList<ClsSeries>();
	}

	/**
	 * Metodo para crear objetos suela.
	 * 
	 * @param Referencia_Suelas  parametro referencia suelas
	 * @param Descripcion_Suelas parametro descripcion suelas
	 * @param Precio_Suelas      parametro precio suelas
	 */
	public void CrearSuelas(int Referencia_Suelas, String Descripcion_Suelas, Double Precio_Suelas) {
		/**
		 * Crearmos el objeto
		 */
		ClsSuelas objSuelas;
		objSuelas = new ClsSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeMateriasPrimas.add(objSuelas);

	}

	/**
	 * Metodo para crear series.
	 * 
	 * @param NumeroDeSerie     parametro numero de serie
	 * @param Descripcion_Serie parametro descripcion de serie.
	 */
	public void CrearSerie(int NumeroDeSerie, String Descripcion_Serie) {
		/**
		 * Crearmos el objeto
		 */
		ClsSeries objSeries;
		objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Serie);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeSeries.add(objSeries);

	}

	/**
	 * Metodo para crear Pedidos.
	 * 
	 * @param NumeroDePedido            parametro numero de pedido
	 * @param FechaDePedido             parametro fecha de pedido
	 * @param FechaDeEntrega            parametro fecha de entrega
	 * @param Entregado                 parametro entregado
	 * @param NumeroDeCliente_Pedidos   parametro numero de cliente
	 * @param NombreYApelliosDelCliente parametro nombre y apellidos del cliente
	 */
	public void CrearPedidos(int NumeroDePedido, Date FechaDePedido, Date FechaDeEntrega, Boolean Entregado,
			int NumeroDeCliente_Pedidos, String NombreYApelliosDelCliente) {
		/**
		 * Crearmos el objeto
		 */
		ClsPedidos objPedido;
		objPedido = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado, NombreYApelliosDelCliente,
				NumeroDeCliente_Pedidos);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDePedidos.add(objPedido);
	}

	/**
	 * Metodo para crear Materiales.
	 * 
	 * @param Referencia  parametro referencia
	 * @param Descripcion parametro descripcion
	 * @param Precio      parametro precio
	 */
	public void CrearMateriales(int Referencia, String Descripcion, double Precio) {
		/**
		 * Crearmos el objeto
		 */
		ClsMateriales objMateriales;
		objMateriales = new ClsMateriales(Referencia, Descripcion, Precio);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeMateriasPrimas.add(objMateriales);

	}

	/**
	 * Metodo para crear Herrajes
	 * 
	 * @param Referencia  parametro referencia
	 * @param Descripcion parametro descripcion
	 * @param Precio      parametro precio
	 */
	public void CrearHerrajes(int Referencia, String Descripcion, double Precio) {
		/**
		 * Crearmos el objeto
		 */
		ClsHerrajes objHerrajes;
		objHerrajes = new ClsHerrajes(Referencia, Descripcion, Precio);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeMateriasPrimas.add(objHerrajes);

	}

	/**
	 * Metodo para crear Envios.
	 * 
	 * @param NumeroDeEnvio         parametro numero de envio
	 * @param NombreCliente         parametro nombre de cliente
	 * @param DireccionDeEnvio      parametro direccion de envio
	 * @param PoblacionDeEnvio      parametro poblacion de envio
	 * @param CPDeEnvio             parametro codigo postal de envio
	 * @param ProvinciaDeEnvio      parametro provincia de envio
	 * @param TelefonoDeEnvio       parametro telefonon de envio
	 * @param NumeroDeCliente_Envio parametro numero de cliente
	 */
	public void CrearEnvios(int NumeroDeEnvio, String NombreCliente, String DireccionDeEnvio, String PoblacionDeEnvio,
			String CPDeEnvio, String ProvinciaDeEnvio, int TelefonoDeEnvio, int NumeroDeCliente_Envio) {

		/**
		 * Crearmos el objeto
		 */
		ClsEnvios objEnvios;
		objEnvios = new ClsEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
				ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeEnvios.add(objEnvios);
	}

	/**
	 * Metodo para crear Clientes.
	 * 
	 * @param NumeroDeCliente    parametro numero del cliente
	 * @param NombreYApellidos   parametro nombre y apellidos del cliente
	 * @param DNI_NIF            parametro dni o nif del cliente
	 * @param DireccionDeCliente parametro direccion del cliente
	 * @param Provincia          parametro provincia
	 * @param Telefono           parametro telefono
	 * @param Email              parametro email
	 */
	public void CrearClientes(int NumeroDeCliente, String NombreYApellidos, String DNI_NIF, String DireccionDeCliente,
			String Provincia, int Telefono, String Email) {

		/**
		 * Crearmos el objeto
		 */
		ClsClientes objClientes;
		objClientes = new ClsClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia,
				Telefono, Email);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeClientes.add(objClientes);

	}

	/**
	 * Metodo para crear Articulos.
	 * 
	 * @param Referencia                 parametro referencia
	 * @param Serie                      parametro serie
	 * @param Descripcion                parametro descripcion
	 * @param CantidadMaterial           parametro cantidad de material
	 * @param CantidadHerrajes           parametro cantidad de herrajes
	 * @param Precio                     parametro precio
	 * @param ReferenciaSuelas_Articulos parametro referencia de la suela
	 */
	public void CrearArticulos(int Referencia, int Serie, String Descripcion, int CantidadMaterial,
			int CantidadHerrajes, double Precio, int ReferenciaSuelas_Articulos) {

		/**
		 * Crearmos el objeto
		 */
		ClsArticulos objArticulos;
		objArticulos = new ClsArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
				ReferenciaSuelas_Articulos);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeArticulos.add(objArticulos);

	}

	/**
	 * Metodo para crear Desgloses de Pedidos
	 * 
	 * @param NumeroDePedido           parametro numero de pedido
	 * @param ReferenciaDelArticulo    parametro numero de referencia del articulo
	 * @param Serie                    parametro numero de serie
	 * @param Color                    parametro numero de color
	 * @param NumeroDePie5             parametro cantidad del numero 5
	 * @param NumeroDePie6             parametro cantidad del numero 6
	 * @param NumeroDePie7             parametro cantidad del numero 7
	 * @param NumeroDePie8             parametro cantidad del numero 8
	 * @param NumeroDePie9             parametro cantidad del numero 9
	 * @param NumeroDePie0             parametro cantidad del numero 0
	 * @param NumeroDePie1             parametro cantidad del numero 1
	 * @param NumeroDePie2             parametro cantidad del numero 2
	 * @param NumeroDePie3             parametro cantidad del numero 3
	 * @param NumeroDePie4             parametro cantidad del numero 4
	 * @param NumeroDeCliente_Desglose parametro del numero del cliente.
	 */
	public void CrearDesgloseDePedido(int NumeroDePedido, int ReferenciaDelArticulo, int Serie, int Color,
			int NumeroDePie5, int NumeroDePie6, int NumeroDePie7, int NumeroDePie8, int NumeroDePie9, int NumeroDePie0,
			int NumeroDePie1, int NumeroDePie2, int NumeroDePie3, int NumeroDePie4, int CantidadTotal,
			int NumeroDeCliente_Desglose) {

		/**
		 * Crearmos el objeto
		 */
		ClsDesgloseDePedido objClsDesgloseDePedido;
		objClsDesgloseDePedido = new ClsDesgloseDePedido(NumeroDePedido, ReferenciaDelArticulo, Serie, Color,
				NumeroDePie5, NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1,
				NumeroDePie2, NumeroDePie3, NumeroDePie4, CantidadTotal, NumeroDeCliente_Desglose);

		/**
		 * A�adimos el objeto a el array.
		 */
		MiListaDeDesgloses.add(objClsDesgloseDePedido);

	}

}
