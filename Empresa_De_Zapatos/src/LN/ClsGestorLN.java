package LN;

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
	 * Aqui generaremos todo en relacion al Gestor.
	 */
	public ClsGestorLN() {

	}

	/**
	 * Metodo para crear objetos suela.
	 * 
	 * @param Referencia_Suelas
	 * @param Descripcion_Suelas
	 * @param Precio_Suelas
	 */
	public void CrearSuelas(int Referencia_Suelas, String Descripcion_Suelas, Double Precio_Suelas) {
		/**
		 * Crearmos el objeto
		 */
		ClsSuelas objSuelas;
		objSuelas = new ClsSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);

	}

	/**
	 * Metodo para crear series.
	 * 
	 * @param NumeroDeSerie
	 * @param Descripcion_Serie
	 */
	public void CrearSerie(int NumeroDeSerie, String Descripcion_Serie) {
		/**
		 * Crearmos el objeto
		 */
		ClsSeries objSeries;
		objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Serie);

	}

	/**
	 * Metodo para crear Pedidos.
	 * 
	 * @param NumeroDePedido
	 * @param FechaDePedido
	 * @param FechaDeEntrega
	 * @param Entregado
	 * @param NumeroDeCliente_Pedidos
	 * @param NombreYApelliosDelCliente
	 */
	public void CrearPedidos(int NumeroDePedido, Date FechaDePedido, Date FechaDeEntrega, int Entregado,
			int NumeroDeCliente_Pedidos, String NombreYApelliosDelCliente) {
		/**
		 * Crearmos el objeto
		 */
		ClsPedidos objPedido;
		objPedido = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado, NombreYApelliosDelCliente,
				NumeroDeCliente_Pedidos);
	}

	/**
	 * Metodo para crear Materiales.
	 * 
	 * @param Referencia
	 * @param Descripcion
	 * @param Precio
	 */
	public void CrearMateriales(int Referencia, String Descripcion, double Precio) {
		/**
		 * Crearmos el objeto
		 */
		ClsMateriales objMateriales;
		objMateriales = new ClsMateriales(Referencia, Descripcion, Precio);

	}

	/**
	 * Metodo para crear Herrajes
	 * 
	 * @param Referencia
	 * @param Descripcion
	 * @param Precio
	 */
	public void CrearHerrajes(int Referencia, String Descripcion, double Precio) {
		/**
		 * Crearmos el objeto
		 */
		ClsHerrajes objHerrajes;
		objHerrajes = new ClsHerrajes(Referencia, Descripcion, Precio);

	}

	/**
	 * Metodo para crear Envios.
	 * 
	 * @param NumeroDeEnvio
	 * @param NombreCliente
	 * @param DireccionDeEnvio
	 * @param PoblacionDeEnvio
	 * @param CPDeEnvio
	 * @param ProvinciaDeEnvio
	 * @param TelefonoDeEnvio
	 * @param NumeroDeCliente_Envio
	 */
	public void CrearEnvios(int NumeroDeEnvio, String NombreCliente, String DireccionDeEnvio, String PoblacionDeEnvio,
			String CPDeEnvio, String ProvinciaDeEnvio, int TelefonoDeEnvio, int NumeroDeCliente_Envio) {

		/**
		 * Crearmos el objeto
		 */
		ClsEnvios objEnvios;
		objEnvios = new ClsEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
				ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);

	}

	/**
	 * Metodo para crear Clientes.
	 * 
	 * @param NumeroDeCliente
	 * @param NombreYApellidos
	 * @param DNI_NIF
	 * @param DireccionDeCliente
	 * @param Provincia
	 * @param Telefono
	 * @param Email
	 */
	public void CrearClientes(int NumeroDeCliente, String NombreYApellidos, String DNI_NIF, String DireccionDeCliente,
			String Provincia, int Telefono, String Email) {

		/**
		 * Crearmos el objeto
		 */
		ClsClientes objClientes;
		objClientes = new ClsClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia,
				Telefono, Email);

	}

	/**
	 * Metodo para crear Articulos.
	 * 
	 * @param Referencia
	 * @param Serie
	 * @param Descripcion
	 * @param CantidadMaterial
	 * @param CantidadHerrajes
	 * @param Precio
	 * @param ReferenciaSuelas_Articulos
	 */
	public void CrearArticulos(int Referencia, int Serie, String Descripcion, int CantidadMaterial,
			int CantidadHerrajes, double Precio, int ReferenciaSuelas_Articulos) {

		/**
		 * Crearmos el objeto
		 */
		ClsArticulos objArticulos;
		objArticulos = new ClsArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
				ReferenciaSuelas_Articulos);

	}

	public void CrearDesgloseDePedido(int NumeroDePedido, int ReferenciaDelArticulo, int Serie, int Color,
			int NumeroDePie5, int NumeroDePie6, int NumeroDePie7, int NumeroDePie8, int NumeroDePie9, int NumeroDePie0,
			int NumeroDePie1, int NumeroDePie2, int NumeroDePie3, int NumeroDePie4, int NumeroDeCliente_Desglose) {

		/**
		 * Crearmos el objeto
		 */
		ClsDesgloseDePedido objClsDesgloseDePedido;
		objClsDesgloseDePedido = new ClsDesgloseDePedido(NumeroDePedido, ReferenciaDelArticulo, Serie, Color,
				NumeroDePie5, NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1,
				NumeroDePie2, NumeroDePie3, NumeroDePie4, NumeroDeCliente_Desglose);

	}

}
