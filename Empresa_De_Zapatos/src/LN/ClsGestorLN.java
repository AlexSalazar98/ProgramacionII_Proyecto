package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import COMUN.ItfProperty;
import LD.ClsDatos;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DNI_NIF;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA;

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
	ArrayList<ClsPedidos> MiListaDePedidos;
	ArrayList<ClsSeries> MiListaDeSeries;
	ArrayList<ClsSuelas> MiListaDeSuelas;
	ArrayList<ClsHerrajes> MiListaDeHerrajes;
	ArrayList<ClsMateriales> MiListaDeMateriales;

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
		MiListaDePedidos = new ArrayList<ClsPedidos>();
		MiListaDeSeries = new ArrayList<ClsSeries>();
		MiListaDeSuelas = new ArrayList<ClsSuelas>();
		MiListaDeHerrajes = new ArrayList<ClsHerrajes>();
		MiListaDeMateriales = new ArrayList<ClsMateriales>();

	}

	/**
	 * Metodo para crear objetos suela.
	 * 
	 * @param Referencia_Suelas  parametro referencia suelas
	 * @param Descripcion_Suelas parametro descripcion suelas
	 * @param Precio_Suelas      parametro precio suelas
	 * @throws SQLException lanzamos excepcion.
	 */
	public void CrearSuelas(int Referencia_Suelas, String Descripcion_Suelas, Double Precio_Suelas)
			throws SQLException {
		/**
		 * Crearmos el objeto
		 */
		ClsSuelas objSuelas;
		objSuelas = new ClsSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);
		/**
		 * Comprobamos que no exite el objeto y lo añadimos al Array y a la BD.
		 */
		if (!ExisteSuelas(objSuelas)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeSuelas.add(objSuelas);
			/**
			 * Llamada a Insert suelas con paso de parametros.
			 */
			objDatos.InsertarSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);
		}
	}

	/**
	 * Metodo para crear series.
	 * 
	 * @param NumeroDeSerie     parametro numero de serie
	 * @param Descripcion_Serie parametro descripcion de serie.
	 * @throws SQLException lanzamos excepcion
	 */
	public void CrearSerie(int NumeroDeSerie, String Descripcion_Serie) throws SQLException {
		/**
		 * Crearmos el objeto
		 */
		ClsSeries objSeries;
		objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Serie);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteSeries(objSeries)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeSeries.add(objSeries);

			/**
			 * Llamada a introducir datos con paso de parametros.
			 */
			objDatos.InsertarSerie(NumeroDeSerie, Descripcion_Serie);
		}

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
	 * @throws SQLException lanzamos excepcion.
	 */
	public void CrearPedidos(int NumeroDePedido, Date FechaDePedido, Date FechaDeEntrega, Boolean Entregado,
			int NumeroDeCliente_Pedidos, String NombreYApelliosDelCliente) throws SQLException {

		java.sql.Date Fecha_de_pedido = new java.sql.Date(FechaDeEntrega.getTime());
		java.sql.Date Fecha_de_entrega = new java.sql.Date(FechaDeEntrega.getTime());
		/**
		 * 
		 * /** Crearmos el objeto
		 */
		ClsPedidos objPedido;
		objPedido = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado, NombreYApelliosDelCliente,
				NumeroDeCliente_Pedidos);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExistePedidos(objPedido)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDePedidos.add(objPedido);

			/**
			 * Llamada a introducir datos con paso de parametros
			 */
			objDatos.InsertarPedidos(NumeroDePedido, Fecha_de_pedido, Fecha_de_entrega, Entregado,
					NumeroDeCliente_Pedidos, NombreYApelliosDelCliente);
		}
	}

	/**
	 * Metodo para crear Materiales.
	 * 
	 * @param Referencia  parametro referencia
	 * @param Descripcion parametro descripcion
	 * @param Precio      parametro precio
	 * @throws SQLException lanzamos la excepcion
	 */
	public void CrearMateriales(int Referencia, String Descripcion, double Precio) throws SQLException {
		/**
		 * Crearmos el objeto
		 */
		ClsMateriales objMateriales;
		objMateriales = new ClsMateriales(Referencia, Descripcion, Precio);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteMateriales(objMateriales)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeMateriales.add(objMateriales);

			/**
			 * Mandamos los datos a LD para introducirlos en BD
			 */
			objDatos.InsertarMateriales(Referencia, Descripcion, Precio);
		}
	}

	/**
	 * Metodo para crear Herrajes
	 * 
	 * @param Referencia  parametro referencia
	 * @param Descripcion parametro descripcion
	 * @param Precio      parametro precio
	 * @throws SQLException lanzamos excepcion
	 */
	public void CrearHerrajes(int Referencia, String Descripcion, double Precio) throws SQLException {
		/**
		 * Crearmos el objeto
		 */
		ClsHerrajes objHerrajes;
		objHerrajes = new ClsHerrajes(Referencia, Descripcion, Precio);

		if (!ExisteHerrajes(objHerrajes)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeHerrajes.add(objHerrajes);

			/**
			 * Mandamos los datos a LD para introducir en BD.
			 */
			objDatos.InsertarHerrajes(Referencia, Descripcion, Precio);
		}
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
	 * @throws SQLException lanza excepcion
	 */
	public void CrearEnvios(int NumeroDeEnvio, String NombreCliente, String DireccionDeEnvio, String PoblacionDeEnvio,
			int CPDeEnvio, String ProvinciaDeEnvio, int TelefonoDeEnvio, int NumeroDeCliente_Envio)
			throws SQLException {

		/**
		 * Crearmos el objeto
		 */
		ClsEnvios objEnvios;
		objEnvios = new ClsEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
				ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);

		if (!ExisteEnvios(objEnvios)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeEnvios.add(objEnvios);
			/**
			 * Mandamos los datos a LD para introducir a BD
			 */
			objDatos.InsertarEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
					ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);
		}
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
	 * @throws SQLException mandamos la excepcion a LP
	 */
	public void CrearClientes(int NumeroDeCliente, String NombreYApellidos, String DNI_NIF, String DireccionDeCliente,
			String Provincia, int Telefono, String Email) throws SQLException {

		/**
		 * Crearmos el objeto
		 */
		ClsClientes objClientes;
		objClientes = new ClsClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia,
				Telefono, Email);

		if (!ExisteCliente(objClientes)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeClientes.add(objClientes);
			/**
			 * Mandamos los datos a LD para introducir a BD
			 */
			objDatos.InsertarClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia,
					Telefono, Email);
		}
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
	 * @throws SQLException 
	 */
	public void CrearArticulos(int Referencia, int Serie, String Descripcion, int CantidadMaterial,
			int CantidadHerrajes, double Precio, int ReferenciaSuelas_Articulos) throws SQLException {

		/**
		 * Crearmos el objeto
		 */
		ClsArticulos objArticulos;
		objArticulos = new ClsArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
				ReferenciaSuelas_Articulos);

		if (!ExisteArticulos(objArticulos)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeArticulos.add(objArticulos);
			/**
			 * Mandamos los datos a LD para introducir a BD
			 */
			objDatos.InsertarArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
					ReferenciaSuelas_Articulos);
		}
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
	 * @throws SQLException excepcion lanzada a tratar en LP
	 */
	public void ObjetosRecuperadosSerie() throws SQLException {

		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarSeries();

		while (Resultado.next()) {
			int NumeroDeSerie = Resultado.getInt("NDeSerie");
			String Descripcion_Series = Resultado.getString("Descripcion");
			ClsSeries objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Series);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeSeries.add(objSeries);

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
	 * @param Series parametro serie
	 * @return nos devuelve true si esta repetido.
	 */
	public boolean ExisteSeries(ClsSeries Series) {

		boolean retorno = false;

		for (ClsSeries b : MiListaDeSeries) {
			if (b.equals(Series))
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para borrar objetos Serie del Array y de la BD.
	 * 
	 * @param NºDeSerie parametro para seleccionar que borrar.
	 * @throws SQLException lanzamos la excepcion.
	 * @return nos genera un return para saber si se ha realizado el borrado o no
	 * @throws ClsBorrarExcepcion excepcion en caso de que falle el borrado
	 */
	public boolean EliminarSeriesDeArray(int NDeSerie) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeSeries.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeSeries.get(userInd).getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE).equals(NDeSerie)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {
			/**
			 * borramos del array
			 */
			MiListaDeSeries.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarSeries(NDeSerie);
		}

		return hecho;
	}

	/**
	 * Metodo intermedio para recuperar suelas de BD.
	 * 
	 * @throws SQLException lanzamos la excepcion a LP.
	 */
	public void ObjetosRecuperadosSuelas() throws SQLException {

		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarSuelas();

		while (Resultado.next()) {
			int Referencia = Resultado.getInt("Referencia");
			String Descripcion = Resultado.getString("Descripcion");
			Double Precio = Resultado.getDouble("Precio");
			ClsSuelas ObjSuelas = new ClsSuelas(Referencia, Descripcion, Precio);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeSuelas.add(ObjSuelas);

		}

	}

	/**
	 * Metodo para devolver suelas cuando las pidan
	 * 
	 * @return genera un return a la capa LP
	 */
	public ArrayList<ItfProperty> DameSuelas() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsSuelas a : MiListaDeSuelas) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Metodo para comprobar que no haya suelas repetidas
	 * 
	 * @param Suelas parametro suelas
	 * @return devuelve si o no en funcion de si esta repetido o no.
	 */
	public boolean ExisteSuelas(ClsSuelas Suelas) {

		boolean retorno = false;

		for (ClsMateriasPrimas b : MiListaDeSuelas) {
			if (b.equals(Suelas))
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para borrar objetos Suelas del Array y de la BD.
	 * 
	 * @param Referencia parametro para selecionar que borrar
	 * @throws SQLException       lanzamos la excepcion
	 * @throws ClsBorrarExcepcion excepcion por si no se realiza bien el borrado
	 * @return nos dice si se ha eliminado o no.
	 */
	public boolean EliminarSuelasDeArray(int Referencia) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeSuelas.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeSuelas.get(userInd).getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA).equals(Referencia)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {

			/**
			 * borramos del array
			 */
			MiListaDeSuelas.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarSuelas(Referencia);
		}

		return hecho;
	}

	/**
	 * Metodo intermedio para recuperar Materiales de BD
	 * 
	 * @throws SQLException lanzamos la excepcion a LP
	 */
	public void ObjetosRecuperadosMateriales() throws SQLException {
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarMateriales();

		while (Resultado.next()) {
			int Referencia = Resultado.getInt("Referencia");
			String Descripcion = Resultado.getString("Descripcion");
			Double Precio = Resultado.getDouble("Precio");
			ClsMateriales ObjMateriales = new ClsMateriales(Referencia, Descripcion, Precio);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeMateriales.add(ObjMateriales);

		}

	}

	/**
	 * Metodo para devolver materiales cuando nos los pidan.
	 * 
	 * @return genera un return.
	 */
	public ArrayList<ItfProperty> DameMateriales() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsMateriales a : MiListaDeMateriales) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Para comprobar que no haya objetos materiales repetidos
	 * 
	 * @param Materiales parametro a comprobar
	 * @return devuelve si esta repetido o no.
	 */
	public boolean ExisteMateriales(ClsMateriales Materiales) {

		boolean retorno = false;

		for (ClsMateriasPrimas b : MiListaDeMateriales) {
			if (b.equals(Materiales))
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para eliminar materiales del array y de bd
	 * 
	 * @param Referencia parametro por el cual borrar
	 * @throws SQLException       lanzamos la excepcion a LP
	 * @throws ClsBorrarExcepcion excepcion por si no se realiza el borrado
	 * @return nos dice si se ha eliminado o no
	 */
	public boolean EliminarMaterialesDeArray(int Referencia) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeMateriales.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeMateriales.get(userInd).getIntegerProperty(PROPIEDAD_MATERIALES_REFERENCIA)
					.equals(Referencia)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {

			/**
			 * borramos del array
			 */
			MiListaDeMateriales.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarMateriales(Referencia);
		}

		return hecho;

	}

	/**
	 * Metodo intermedio para recuperar objetos herraje de la BD
	 * 
	 * @throws SQLException lanzamos excepcion a LP
	 */
	public void ObjetosRecuperadosHerrajes() throws SQLException {
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarHerrajes();

		while (Resultado.next()) {
			int Referencia = Resultado.getInt("Referencia");
			String Descripcion = Resultado.getString("Descripcion");
			Double Precio = Resultado.getDouble("Precio");
			ClsHerrajes ObjHerrajes = new ClsHerrajes(Referencia, Descripcion, Precio);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeHerrajes.add(ObjHerrajes);

		}

	}

	/**
	 * Metodo para devolver los objetos Herrajes
	 * 
	 * @return genera un return
	 */
	public ArrayList<ItfProperty> DameHerrajes() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsHerrajes a : MiListaDeHerrajes) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Metodo para comprobar que no se dupliquen los objetos herrajes introducidos
	 * 
	 * @param objHerrajes parametro a comprobar
	 * @return nos dice si esta repetido o no
	 */
	public boolean ExisteHerrajes(ClsHerrajes objHerrajes) {

		boolean retorno = false;

		for (ClsMateriasPrimas b : MiListaDeHerrajes) {
			if (b.equals(objHerrajes))
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para eliminar Herrajes por referencia de los Arrays y de BD.
	 * 
	 * @param Referencia parametro para buscar.
	 * @throws SQLException       lanzamos la excepcion a LP.
	 * @throws ClsBorrarExcepcion excepcion para el borrado
	 * @return nos dice si se ha eliminado o no.
	 */
	public boolean EliminarHerrajesDeArray(int Referencia) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeHerrajes.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeHerrajes.get(userInd).getIntegerProperty(PROPIEDAD_HERRAJES_REFERENCIA).equals(Referencia)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {

			/**
			 * borramos del array
			 */
			MiListaDeHerrajes.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarHerrajes(Referencia);
		}

		return hecho;

	}

	public void ObjetosRecuperadosClientes() throws SQLException {
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarClientes();

		while (Resultado.next()) {
			int NDeClientes = Resultado.getInt("NCliente");
			String NombreYApellido = Resultado.getString("NombreYApellidos");
			String DNI_NIF = Resultado.getString("DNI_NIF");
			String DireccionDeClientes = Resultado.getString("DireccionDeCliente");
			String Provincia = Resultado.getString("Provincia");
			int Telefono = Resultado.getInt("Telefono");
			String Email = Resultado.getString("Email");
			ClsClientes objClientes = new ClsClientes(NDeClientes, NombreYApellido, DNI_NIF, DireccionDeClientes,
					Provincia, Telefono, Email);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeClientes.add(objClientes);

		}

	}

	/**
	 * Metodo para devolver objetos Cliente
	 * 
	 * @return nos genera un return
	 */
	public ArrayList<ItfProperty> DameClientes() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsClientes a : MiListaDeClientes) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Metodo para comprobar que no se repite clientes.
	 * 
	 * @param objClientes parametro recibido
	 * @return nos dice si esta repetido o no.
	 */
	public boolean ExisteCliente(ClsClientes objClientes) {

		boolean retorno = false;
		for (ClsClientes b : MiListaDeClientes) {
			if (b.equals(objClientes))
				return true;
		}
		return retorno;
	}

	/**
	 * Metopo para eliminar cliente de Array y BD
	 * 
	 * @param DNI_NIF parametro de eliminacion
	 * @throws SQLException       lanzamos excepcion
	 * @throws ClsBorrarExcepcion excepcion de borrado.
	 * @return nos dice si se ha eliminado o no.
	 */
	public boolean EliminarClientesDeArray(String DNI_NIF) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeClientes.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeClientes.get(userInd).getStringProperty(PROPIEDAD_CLIENTE_DNI_NIF).equals(DNI_NIF)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {

			/**
			 * borramos del array
			 */
			MiListaDeClientes.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarClientes(DNI_NIF);
		}

		return hecho;

	}

	public void ObjetosRecuperadosEnvios() throws SQLException {
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarEnvios();

		while (Resultado.next()) {
			int NumeroDeEnvio = Resultado.getInt("NEnvio");
			String NombreCliente = Resultado.getString("NombreCliente");
			String DireccionDeEnvio = Resultado.getString("DireccionDeEnvio");
			String PoblacionDeEnvio = Resultado.getString("PoblacionDeEnvio");
			int CPDeENVIO = Resultado.getInt("CPDeEnvio");
			String ProvinciaDeEnvio = Resultado.getString("ProvinciaDeEnvio");
			int TelefonoDeEnvio = Resultado.getInt("TelefonoDeEnvio");
			int NumeroDeCliente_Envio = Resultado.getInt("Clientes_NCliente");
			ClsEnvios objEnvios = new ClsEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio,
					CPDeENVIO, ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeEnvios.add(objEnvios);

		}

	}

	/**
	 * Metodo para devolver objetos Cliente
	 * 
	 * @return nos genera un return
	 */
	public ArrayList<ItfProperty> DameEnvios() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsEnvios a : MiListaDeEnvios) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Metodo para comprobar que no se repite clientes.
	 * 
	 * @param objEnvios objeto a comparar.
	 * @return nos dice si esta repetido o no.
	 */
	public boolean ExisteEnvios(ClsEnvios objEnvios) {

		boolean retorno = false;
		for (ClsEnvios b : MiListaDeEnvios) {
			if (b.equals(objEnvios))
				return true;
		}
		return retorno;
	}

	/**
	 * Metopo para eliminar cliente de Array y BD
	 * 
	 * @param NºEnvio parametro por el cual borrar.
	 * @throws SQLException       lanzamos excepcion
	 * @throws ClsBorrarExcepcion excepcion para el borrado
	 */
	public boolean EliminarEnviosDeArray(int NEnvio) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeEnvios.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeEnvios.get(userInd).getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO).equals(NEnvio)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {

			/**
			 * borramos del array
			 */
			MiListaDeClientes.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarEnvios(NEnvio);
		}

		return hecho;

	}

	public void ObjetosRecuperadosPedidos() throws SQLException {
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarPedidos();

		while (Resultado.next()) {
			int NumeroDePedido = Resultado.getInt("NPedido");
			Date FechaDePedido = Resultado.getDate("Fecha_de_pedido");
			Date FechaDeEntrega = Resultado.getDate("Fecha_de_entrega");
			Boolean Entregado = Resultado.getBoolean("Entregado");
			int NumeroDeCliente_Pedidos = Resultado.getInt("Clientes_NCliente");
			String NombreYApelliosDelCliente = Resultado.getString("NombreYApellidos");
			ClsPedidos objPedido = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado,
					NombreYApelliosDelCliente, NumeroDeCliente_Pedidos);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDePedidos.add(objPedido);

		}

	}

	public ArrayList<ItfProperty> DamePedidos() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsPedidos a : MiListaDePedidos) {
			retorno.add(a);
		}

		return retorno;

	}

	public boolean ExistePedidos(ClsPedidos objPedidos) {

		boolean retorno = false;
		for (ClsPedidos b : MiListaDePedidos) {
			if (b.equals(objPedidos))
				return true;
		}
		return retorno;
	}

	public boolean EliminarPedidosDeArray(int NPedido) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeClientes.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeClientes.get(userInd).getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO).equals(NPedido)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {

			/**
			 * borramos del array
			 */
			MiListaDePedidos.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarPedidos(NPedido);
		}

		return hecho;

	}

	
	public void ObjetosRecuperadosArticulos() throws SQLException {

		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarArticulos();

		while (Resultado.next()) {
			int Referencia = Resultado.getInt("Referencia");
			int Serie = Resultado.getInt("Serie");
			String Descripcion = Resultado.getString("Descripcion");
			int CantidadMaterial = Resultado.getInt("CantidadMaterial");
			int CantidadHerraje = Resultado.getInt("CantidadHerraje");
			double Precio = Resultado.getDouble("Precio");
			int Suelas_Referencia = Resultado.getInt("Suelas_Referencia");
			ClsArticulos objArticulos = new ClsArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerraje,
					Precio, Suelas_Referencia);
			/**
			 * Aseguramos que esos objetos no esta repetidos y los añadimos al Array
			 */

			MiListaDeArticulos.add(objArticulos);

		}

	}

	
	public ArrayList<ItfProperty> DameArticulos() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		for (ClsArticulos a : MiListaDeArticulos) {
			retorno.add(a);
		}

		return retorno;

	}

	
	public boolean ExisteArticulos(ClsArticulos Articulos) {

		boolean retorno = false;

		for (ClsArticulos b : MiListaDeArticulos) {
			if (b.equals(Articulos))
				return true;

		}

		return retorno;
	}

	
	public boolean EliminarArticulosDeArray(int Referencia) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeArticulos.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeArticulos.get(userInd).getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA).equals(Referencia)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			hecho = false;
			throw new ClsBorrarExcepcion();
		} else {
			/**
			 * borramos del array
			 */
			MiListaDeArticulos.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.eliminarArticulos(Referencia);
		}

		return hecho;
	}
}
