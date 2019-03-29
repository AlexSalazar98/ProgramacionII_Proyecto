package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import COMUN.ItfProperty;
import LD.ClsDatos;

/**
 * Clase de gestion entre LN y LP
 * 
 * @author Alex Salazar
 * @author David Requeta En esta clase relacionamos las clases de los paquetes
 *         LP Y LN.
 *
 */

public class ClsGestorLN {

	ClsDatos objDatos = new ClsDatos();

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
	// ArrayList<ClsSeries> MiListaDeSeriesRecuperadas;

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
		// MiListaDeSeriesRecuperadas = new ArrayList<ClsSeries>();
	}

	/**
	 * Metodo para crear objetos suela.
	 * 
	 * @param Referencia_Suelas  parametro referencia suelas
	 * @param Descripcion_Suelas parametro descripcion suelas
	 * @param Precio_Suelas      parametro precio suelas
	 * @throws SQLException 
	 */
	public void CrearSuelas(int Referencia_Suelas, String Descripcion_Suelas, Double Precio_Suelas) throws SQLException {
		/**
		 * Crearmos el objeto
		 */
		ClsSuelas objSuelas;
		objSuelas = new ClsSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);

		/**
		 * Añadimos el objeto a el array.
		 */
		MiListaDeMateriasPrimas.add(objSuelas);
		/**
		 * Llamada a Insert suelas con paso de parametros.
		 */
		objDatos.InsertarSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);

	}

	/**
	 * Metodo para crear series.
	 * 
	 * @param NumeroDeSerie     parametro numero de serie
	 * @param Descripcion_Serie parametro descripcion de serie.
	 * @throws SQLException
	 */
	public void CrearSerie(int NumeroDeSerie, String Descripcion_Serie) throws SQLException {
		/**
		 * Crearmos el objeto
		 */
		ClsSeries objSeries;
		objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Serie);

		/**
		 * Añadimos el objeto a el array.
		 */
		MiListaDeSeries.add(objSeries);

		/**
		 * Llamada a introducir datos con paso de parametros.
		 */
		objDatos.InsertarSerie(NumeroDeSerie, Descripcion_Serie);

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
		 * Añadimos el objeto a el array.
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
		 * Añadimos el objeto a el array.
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
		 * Añadimos el objeto a el array.
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
		 * Añadimos el objeto a el array.
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
		 * Añadimos el objeto a el array.
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
		 * Añadimos el objeto a el array.
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
	 * @param CantidadTotal            parametro de cantidad total de numeros.
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
		 * Añadimos el objeto a el array.
		 */
		MiListaDeDesgloses.add(objClsDesgloseDePedido);

	}

	/**
	 * Metodo para generar objetos con los datos recuperados de la BD
	 * 
	 * @param objDatosORS objetos creados
	 * @throws SQLException excepcion lanzada a tratar en LP
	 */
	public void ObjetosRecuperadosSerie() throws SQLException {

		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarSeries();
		try {
			while (Resultado.next()) {
				int NumeroDeSerie = Resultado.getInt("NºDeSerie");
				String Descripcion_Series = Resultado.getString("Descripcion");
				ClsSeries objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Series);
				/**
				 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
				 */
				if (!ExisteSeries(objSeries, MiListaDeSeries)) {
					MiListaDeSeries.add(objSeries);
				} else {
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para sacar por pantalla en LP los datos de series
	 * 
	 * @return genera un return.
	 */
	public ArrayList<ItfProperty> DameSeries() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsSeries a : MiListaDeSeries) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Metodo para comprobar si los Objetos Series estan repetidos o no en nuestro
	 * Array
	 * 
	 * @param Series          parametro serie
	 * @param MiListaDeSeries Arraylist
	 * @return nos devuelve true si esta repetido.
	 */
	public static boolean ExisteSeries(ClsSeries Series, ArrayList<ClsSeries> MiListaDeSeries) {

		boolean retorno = false;

		for (ClsSeries b : MiListaDeSeries) {
			if (b.equals(Series))
				return true;

		}

		return retorno;
	}

	public void ObjetosRecuperadosSuelas() throws SQLException {

		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarSuelas();
		try {
			while (Resultado.next()) {
				int Referencia = Resultado.getInt("Referencia");
				String Descripcion = Resultado.getString("Descripcion");
				Double Precio = Resultado.getDouble("Precio");
				ClsSuelas ObjSuelas = new ClsSuelas(Referencia, Descripcion, Precio);
				/**
				 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
				 */
				if (!ExisteMateriasPrimasS(ObjSuelas, MiListaDeMateriasPrimas)) {
					MiListaDeMateriasPrimas.add(ObjSuelas);
				} else {
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean ExisteMateriasPrimasS(ClsSuelas Suelas,
			ArrayList<ClsMateriasPrimas> MiListaDeMateriasPrimas) {

		boolean retorno = false;

		for (ClsMateriasPrimas b : MiListaDeMateriasPrimas) {
			if (b.equals(Suelas))
				return true;

		}

		return retorno;
	}

}
