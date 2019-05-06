package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import COMUN.ItfProperty;
import Comparadores_y_Comprobadores.ClsComparadorEnviosID;
import Comparadores_y_Comprobadores.ClsComparadorHerrajesID;
import Comparadores_y_Comprobadores.ClsComparadorMaterialesID;
import Comparadores_y_Comprobadores.ClsComparadorPorFechas;
import Comparadores_y_Comprobadores.ClsComparadorSeriesID;
import Comparadores_y_Comprobadores.ClsComparadorSuelasID;
import Excepciones.ClsBorrarExcepcion;
import LD.ClsDatos;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE;

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
	public boolean CrearSuelas(int Referencia_Suelas, String Descripcion_Suelas, Double Precio_Suelas)
			throws SQLException {
		/**
		 * Variable para confirmar
		 */
		boolean hecho = false;
		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsSuelas objSuelas;
		objSuelas = new ClsSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);
		/**
		 * Comprobamos que no exite el objeto y lo añadimos al Array y a la BD.
		 */
		if (!ExisteSuelas(objSuelas)) {
			hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeSuelas.add(objSuelas);
			/**
			 * Llamada a Insert suelas con paso de parametros.
			 */
			objDatos.conectarBD();
			objDatos.InsertarSuelas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);
			objDatos.desconectarBD();
		}

		return hecho;
	}

	/**
	 * Metodo para crear series.
	 * 
	 * @param NumeroDeSerie     parametro numero de serie
	 * @param Descripcion_Serie parametro descripcion de serie.
	 * @throws SQLException lanzamos excepcion
	 */
	public boolean CrearSerie(int NumeroDeSerie, String Descripcion_Serie) throws SQLException {

		/**
		 * comprobar que no se repite
		 */
		boolean hecho = false;
		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsSeries objSeries;
		objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Serie);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteSeries(objSeries)) {

			hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeSeries.add(objSeries);

			/**
			 * Llamada a introducir datos con paso de parametros.
			 */
			objDatos.conectarBD();
			objDatos.InsertarSerie(NumeroDeSerie, Descripcion_Serie);
			objDatos.desconectarBD();
		}

		return hecho;
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

		/**
		 * Instanciamos y crearmos el objeto
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
			objDatos.conectarBD();
			objDatos.InsertarPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado, NumeroDeCliente_Pedidos,
					NombreYApelliosDelCliente);
			objDatos.desconectarBD();
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
	public boolean CrearMateriales(int Referencia, String Descripcion, double Precio) throws SQLException {
		/**
		 * Variable para confirmar
		 */
		boolean Hecho = false;
		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsMateriales objMateriales;
		objMateriales = new ClsMateriales(Referencia, Descripcion, Precio);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteMateriales(objMateriales)) {
			Hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeMateriales.add(objMateriales);

			/**
			 * Mandamos los datos a LD para introducirlos en BD
			 */
			objDatos.conectarBD();
			objDatos.InsertarMateriales(Referencia, Descripcion, Precio);
			objDatos.desconectarBD();
		}
		return Hecho;
	}

	/**
	 * Metodo para crear Herrajes
	 * 
	 * @param Referencia  parametro referencia
	 * @param Descripcion parametro descripcion
	 * @param Precio      parametro precio
	 * @throws SQLException lanzamos excepcion
	 */
	public boolean CrearHerrajes(int Referencia, String Descripcion, double Precio) throws SQLException {
		/**
		 * Variable de confirmacion
		 */
		Boolean Hecho = false;
		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsHerrajes objHerrajes;
		objHerrajes = new ClsHerrajes(Referencia, Descripcion, Precio);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteHerrajes(objHerrajes)) {
			Hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeHerrajes.add(objHerrajes);

			/**
			 * Mandamos los datos a LD para introducir en BD.
			 */
			objDatos.conectarBD();
			objDatos.InsertarHerrajes(Referencia, Descripcion, Precio);
			objDatos.desconectarBD();
		}

		return Hecho;
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
	 * @return
	 * @throws SQLException lanza excepcion
	 */
	public boolean CrearEnvios(int NumeroDeEnvio, String NombreCliente, String DireccionDeEnvio,
			String PoblacionDeEnvio, int CPDeEnvio, String ProvinciaDeEnvio, int TelefonoDeEnvio,
			int NumeroDeCliente_Envio) throws SQLException {
		/**
		 * Variable de confirmacion
		 */
		Boolean Hecho = false;

		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsEnvios objEnvios;
		objEnvios = new ClsEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
				ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteEnvios(objEnvios)) {
			Hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeEnvios.add(objEnvios);
			/**
			 * Mandamos los datos a LD para introducir a BD
			 */
			objDatos.conectarBD();
			objDatos.InsertarEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio, CPDeEnvio,
					ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);
			objDatos.desconectarBD();
		}
		return Hecho;
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
	public boolean CrearClientes(int NumeroDeCliente, String NombreYApellidos, String DNI_NIF,
			String DireccionDeCliente, String Provincia, int Telefono, String Email) throws SQLException {
		/**
		 * Variable de confirmacion
		 */
		Boolean Hecho = false;
		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsClientes objClientes;
		objClientes = new ClsClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia,
				Telefono, Email);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteCliente(objClientes)) {
			Hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeClientes.add(objClientes);
			/**
			 * Mandamos los datos a LD para introducir a BD
			 */
			objDatos.conectarBD();
			objDatos.InsertarClientes(NumeroDeCliente, NombreYApellidos, DNI_NIF, DireccionDeCliente, Provincia,
					Telefono, Email);
			objDatos.desconectarBD();
		}
		return Hecho;
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
	 * @return
	 * @throws SQLException lanza excepcion
	 */
	public boolean CrearArticulos(int Referencia, int Serie, String Descripcion, int CantidadMaterial,
			int CantidadHerrajes, double Precio, int ReferenciaSuelas_Articulos) throws SQLException {

		boolean Hecho = false;

		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsArticulos objArticulos;
		objArticulos = new ClsArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
				ReferenciaSuelas_Articulos);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteArticulos(objArticulos)) {
			Hecho = true;
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeArticulos.add(objArticulos);
			/**
			 * Mandamos los datos a LD para introducir a BD
			 */
			objDatos.conectarBD();
			objDatos.InsertarArticulos(Referencia, Serie, Descripcion, CantidadMaterial, CantidadHerrajes, Precio,
					ReferenciaSuelas_Articulos);
			objDatos.desconectarBD();
		}
		return Hecho;
	}

	/**
	 * Metodo para crear Desgloses de Pedidos
	 * 
	 * @param NumeroDePedido        parametro numero de pedido
	 * @param ReferenciaDelArticulo parametro numero de referencia del articulo
	 * @param Serie                 parametro numero de serie
	 * @param Color                 parametro numero de color
	 * @param NumeroDePie5          parametro cantidad del numero 5
	 * @param NumeroDePie6          parametro cantidad del numero 6
	 * @param NumeroDePie7          parametro cantidad del numero 7
	 * @param NumeroDePie8          parametro cantidad del numero 8
	 * @param NumeroDePie9          parametro cantidad del numero 9
	 * @param NumeroDePie0          parametro cantidad del numero 0
	 * @param NumeroDePie1          parametro cantidad del numero 1
	 * @param NumeroDePie2          parametro cantidad del numero 2
	 * @param NumeroDePie3          parametro cantidad del numero 3
	 * @param NumeroDePie4          parametro cantidad del numero 4
	 * @param CantidadTotal         parametro de cantidad total de numeros.
	 * @param Pedidos_NPedido       parametro del numero de Pedido.
	 * @throws SQLException lanza excepcion.
	 */
	public void CrearDesgloseDePedido(int NumeroDePedido, int ReferenciaDelArticulo, int Serie, int Color,
			int NumeroDePie5, int NumeroDePie6, int NumeroDePie7, int NumeroDePie8, int NumeroDePie9, int NumeroDePie0,
			int NumeroDePie1, int NumeroDePie2, int NumeroDePie3, int NumeroDePie4, int CantidadTotal,
			int Pedidos_NPedido) throws SQLException {

		/**
		 * Instanciamos y crearmos el objeto
		 */
		ClsDesgloseDePedido objDesgloseDePedido;
		objDesgloseDePedido = new ClsDesgloseDePedido(NumeroDePedido, ReferenciaDelArticulo, Serie, Color, NumeroDePie5,
				NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1, NumeroDePie2,
				NumeroDePie3, NumeroDePie4, CantidadTotal, Pedidos_NPedido);

		/**
		 * Miramos que no se repitan los objetos y los añadimos al Array y al la BD.
		 */
		if (!ExisteDesglose(objDesgloseDePedido)) {
			/**
			 * Añadimos el objeto a el array.
			 */
			MiListaDeDesgloses.add(objDesgloseDePedido);
			/**
			 * Añadimos los datos a la BD
			 */
			objDatos.conectarBD();
			objDatos.InsertarDesglose(NumeroDePedido, ReferenciaDelArticulo, Serie, Color, NumeroDePie5, NumeroDePie6,
					NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0, NumeroDePie1, NumeroDePie2, NumeroDePie3,
					NumeroDePie4, CantidadTotal, Pedidos_NPedido);
			objDatos.desconectarBD();
		}

	}

	/**
	 * Metodo para comprobar que no existan dos objetos desglose iguales
	 * 
	 * @param Desglose objeto desglose
	 * @return nos dice si esta repetido o no.
	 */
	public boolean ExisteDesglose(ClsDesgloseDePedido Desglose) {

		/**
		 * Variable que determina resultado.
		 */
		boolean retorno = false;

		/**
		 * comprobacion a traves del metodo equals
		 */
		for (ClsDesgloseDePedido b : MiListaDeDesgloses) {
			if (b.equals(Desglose))
				/**
				 * devuelve true si se repiten.
				 */
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para generar objetos con los datos recuperados de la BD
	 * 
	 * @throws SQLException excepcion lanzada a tratar en LP
	 */
	public void ObjetosRecuperadosSerie() throws SQLException {

		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarSeries();

		/**
		 * recorremos los parametros del objeto
		 */
		while (Resultado.next()) {
			/**
			 * los guardamos en variables
			 */
			int NumeroDeSerie = Resultado.getInt("NDeSerie");
			String Descripcion_Series = Resultado.getString("Descripcion");
			/**
			 * generamos objeto del tipo de la clase
			 */
			ClsSeries objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Series);

			/**
			 * Añadimos el objeto al Array
			 */
			MiListaDeSeries.add(objSeries);

		}
		objDatos.desconectarBD();
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

		/**
		 * grabamos un array en otro y lo devolvemos
		 */
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

		/**
		 * Variable que determina el resultado
		 */
		boolean retorno = false;

		/**
		 * comprobacion a traves del metodo Equals
		 */
		for (ClsSeries b : MiListaDeSeries) {
			if (b.equals(Series))
				/**
				 * si se repiten devuelve true
				 */
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para borrar objetos Serie del Array y de la BD.
	 * 
	 * @param NDeSerie parametro para seleccionar que borrar.
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
			objDatos.conectarBD();
			objDatos.eliminarSeries(NDeSerie);
			objDatos.desconectarBD();
		}

		return hecho;
	}

	/**
	 * Metodo intermedio para recuperar suelas de BD.
	 * 
	 * @throws SQLException lanzamos la excepcion a LP.
	 */
	public void ObjetosRecuperadosSuelas() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarSuelas();

		/**
		 * obtenemos lo dato del objeto devuelto
		 */
		while (Resultado.next()) {
			/**
			 * guardamos los datos en variables
			 */
			int Referencia = Resultado.getInt("Referencia");
			String Descripcion = Resultado.getString("Descripcion");
			Double Precio = Resultado.getDouble("Precio");
			/**
			 * generamos un objeto del tipo de la clase
			 */
			ClsSuelas ObjSuelas = new ClsSuelas(Referencia, Descripcion, Precio);

			/**
			 * Añadimos el objetos al Array
			 */
			MiListaDeSuelas.add(ObjSuelas);

		}
		objDatos.desconectarBD();
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

		/**
		 * grabamos de un array a otro y lo devolvemos
		 */
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

		/**
		 * variable para determinar el proceso
		 */
		boolean retorno = false;

		/**
		 * comparamos a traves del metodo equals
		 */
		for (ClsMateriasPrimas b : MiListaDeSuelas) {
			if (b.equals(Suelas))
				/**
				 * si coinciden devolvemos true
				 */
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
			objDatos.conectarBD();
			objDatos.eliminarSuelas(Referencia);
			objDatos.desconectarBD();
		}

		return hecho;
	}

	/**
	 * Metodo intermedio para recuperar Materiales de BD
	 * 
	 * @throws SQLException lanzamos la excepcion a LP
	 */
	public void ObjetosRecuperadosMateriales() throws SQLException {
		objDatos.conectarBD();
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
			 * Añadimos el objetos al Array
			 */
			MiListaDeMateriales.add(ObjMateriales);

		}
		objDatos.desconectarBD();

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

		/**
		 * copiamos un array en otro y lo devolvemos
		 */
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

		/**
		 * Variable que determina el proceso.
		 */
		boolean retorno = false;

		/**
		 * comparamos a traves del metodo equals
		 */
		for (ClsMateriasPrimas b : MiListaDeMateriales) {
			if (b.equals(Materiales))
				/**
				 * si coinciden devolvemos un true
				 */
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
			objDatos.conectarBD();
			objDatos.eliminarMateriales(Referencia);
			objDatos.desconectarBD();
		}

		return hecho;

	}

	/**
	 * Metodo intermedio para recuperar objetos herraje de la BD
	 * 
	 * @throws SQLException lanzamos excepcion a LP
	 */
	public void ObjetosRecuperadosHerrajes() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarHerrajes();

		/**
		 * separamos los datos del objeto
		 */
		while (Resultado.next()) {
			/**
			 * los guardamos en variables
			 */
			int Referencia = Resultado.getInt("Referencia");
			String Descripcion = Resultado.getString("Descripcion");
			Double Precio = Resultado.getDouble("Precio");
			/**
			 * hacemos un objeto del tipo de la clase.
			 */
			ClsHerrajes ObjHerrajes = new ClsHerrajes(Referencia, Descripcion, Precio);

			/**
			 * Añadimos el objeto al Array
			 */
			MiListaDeHerrajes.add(ObjHerrajes);

		}
		objDatos.desconectarBD();
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

		/**
		 * Compiamos un array en el otro y lo devolvemos
		 */
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

		/**
		 * Variable para chequear el proceso
		 */
		boolean retorno = false;

		/**
		 * comparamos a traves del metodo equals
		 */
		for (ClsMateriasPrimas b : MiListaDeHerrajes) {
			if (b.equals(objHerrajes))
				/**
				 * Si coinciden devolvemos true
				 */
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
			objDatos.conectarBD();
			objDatos.eliminarHerrajes(Referencia);
			objDatos.desconectarBD();
		}

		return hecho;

	}

	public void ObjetosRecuperadosClientes() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarClientes();

		/**
		 * Optenemos los datos del objeto
		 */
		while (Resultado.next()) {
			/**
			 * los guardamos en variables
			 */
			int NDeClientes = Resultado.getInt("NCliente");
			String NombreYApellido = Resultado.getString("NombreYApellidos");
			String DNI_NIF = Resultado.getString("DNI_NIF");
			String DireccionDeClientes = Resultado.getString("DireccionDeCliente");
			String Provincia = Resultado.getString("Provincia");
			int Telefono = Resultado.getInt("Telefono");
			String Email = Resultado.getString("Email");
			/**
			 * Creamos un objeto del tipo de la clase
			 */
			ClsClientes objClientes = new ClsClientes(NDeClientes, NombreYApellido, DNI_NIF, DireccionDeClientes,
					Provincia, Telefono, Email);

			/**
			 * Añadimos el objeto al Array
			 */
			MiListaDeClientes.add(objClientes);

		}
		objDatos.desconectarBD();
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

		/**
		 * copiamos un array en el otro y lo devolvemos
		 */
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

		/**
		 * Variable para chequear el proceso
		 */
		boolean retorno = false;

		/**
		 * comprobamos a traves del metodo equals
		 */
		for (ClsClientes b : MiListaDeClientes) {
			if (b.equals(objClientes))
				/**
				 * Si estan repetido devolvemos un true
				 */
				return true;
		}
		return retorno;
	}

	/**
	 * Metopo para eliminar cliente de Array y BD
	 * 
	 * @param NCliente parametro de eliminacion
	 * @throws SQLException       lanzamos excepcion
	 * @throws ClsBorrarExcepcion excepcion de borrado.
	 * @return nos dice si se ha eliminado o no.
	 */
	public boolean EliminarClientesDeArray(int NCliente) throws SQLException, ClsBorrarExcepcion {

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
			if (MiListaDeClientes.get(userInd).getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO).equals(NCliente)) {
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
			objDatos.conectarBD();
			objDatos.eliminarClientes(NCliente);
			objDatos.desconectarBD();
		}

		return hecho;

	}

	public void ObjetosRecuperadosEnvios() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarEnvios();

		/**
		 * Obtenemos los datos del objeto
		 */
		while (Resultado.next()) {
			/**
			 * Los guardamos en variables
			 */
			int NumeroDeEnvio = Resultado.getInt("NEnvio");
			String NombreCliente = Resultado.getString("NombreCliente");
			String DireccionDeEnvio = Resultado.getString("DireccionDeEnvio");
			String PoblacionDeEnvio = Resultado.getString("PoblacionDeEnvio");
			int CPDeENVIO = Resultado.getInt("CPDeEnvio");
			String ProvinciaDeEnvio = Resultado.getString("ProvinciaDeEnvio");
			int TelefonoDeEnvio = Resultado.getInt("TelefonoDeEnvio");
			int NumeroDeCliente_Envio = Resultado.getInt("Clientes_NCliente");
			/**
			 * Creamos un objeto del tipo de la clase
			 */
			ClsEnvios objEnvios = new ClsEnvios(NumeroDeEnvio, NombreCliente, DireccionDeEnvio, PoblacionDeEnvio,
					CPDeENVIO, ProvinciaDeEnvio, TelefonoDeEnvio, NumeroDeCliente_Envio);

			/**
			 * Añadimos el objeto al Array
			 */
			MiListaDeEnvios.add(objEnvios);

		}
		objDatos.desconectarBD();
	}

	/**
	 * Metodo para devolver objetos Cliente
	 * 
	 * @return nos genera un return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ItfProperty> DameEnvios() {

		/**
		 * LLamamos al metodo de ordenacion que hemos generado
		 */
		Collections.sort(MiListaDeEnvios);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * Copiamos un array en el otro y lo devolvemos
		 */
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

		/**
		 * Variable que chequea el proceso
		 */
		boolean retorno = false;

		/**
		 * Comprobamos a traves del metodo equals
		 */
		for (ClsEnvios b : MiListaDeEnvios) {
			if (b.equals(objEnvios))
				/**
				 * Si coinciden devolvemos un true
				 */
				return true;
		}
		return retorno;
	}

	/**
	 * Metopo para eliminar cliente de Array y BD
	 * 
	 * @param NEnvio parametro por el cual borrar.
	 * @throws SQLException       lanzamos excepcion
	 * @throws ClsBorrarExcepcion excepcion para el borrado
	 * @return nos devuelve si lo ha hecho o no.
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
			MiListaDeEnvios.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.conectarBD();
			objDatos.eliminarEnvios(NEnvio);
			objDatos.desconectarBD();
		}

		return hecho;

	}

	public void ObjetosRecuperadosPedidos() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarPedidos();

		/**
		 * Obtenemos los datos del objeto
		 */
		while (Resultado.next()) {
			/**
			 * guardamos los datos en variables
			 */
			int NumeroDePedido = Resultado.getInt("NPedido");
			Date FechaDePedido = Resultado.getDate("Fecha_de_pedido");
			Date FechaDeEntrega = Resultado.getDate("Fecha_de_entrega");
			Boolean Entregado = Resultado.getBoolean("Entregado");
			int NumeroDeCliente_Pedidos = Resultado.getInt("Clientes_NCliente");
			String NombreYApelliosDelCliente = Resultado.getString("NombreYApellidos");
			/**
			 * Creamos un objeto del tipo de la clase
			 */
			ClsPedidos objPedido = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado,
					NombreYApelliosDelCliente, NumeroDeCliente_Pedidos);

			/**
			 * Añadimos el objeto al Array
			 */
			MiListaDePedidos.add(objPedido);

		}
		objDatos.desconectarBD();
	}

	public ArrayList<ItfProperty> DamePedidos() {

		/**
		 * Instanciamos y creamos un objeto del tipo que nos ordena el array
		 */
		ClsComparadorPorFechas comp = new ClsComparadorPorFechas();

		/**
		 * LLamamos al metodo que nos ordena pasandole el array a ordenar
		 */
		Collections.sort(MiListaDePedidos, comp);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * compiamos un array en el otro ya ordenado
		 */
		for (ClsPedidos a : MiListaDePedidos) {
			retorno.add(a);
		}

		return retorno;

	}

	public boolean ExistePedidos(ClsPedidos objPedidos) {

		/**
		 * Variable que chequea el proceso
		 */
		boolean retorno = false;

		/**
		 * Comprobamos a traves del metodo equals
		 */
		for (ClsPedidos b : MiListaDePedidos) {
			if (b.equals(objPedidos))
				/**
				 * Si coinciden nos devuelve un true
				 */
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
		int bound = MiListaDePedidos.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDePedidos.get(userInd).getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO).equals(NPedido)) {
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
			objDatos.conectarBD();
			objDatos.eliminarPedidos(NPedido);
			objDatos.desconectarBD();
		}

		return hecho;

	}

	public void ObjetosRecuperadosArticulos() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarArticulos();

		/**
		 * Obtenemos los datos del objeto
		 */
		while (Resultado.next()) {
			/**
			 * Los guardamos en variables
			 */
			int Referencia = Resultado.getInt("Referencia");
			int Serie = Resultado.getInt("Serie");
			String Descripcion = Resultado.getString("Descripcion");
			int CantidadMaterial = Resultado.getInt("CantidadMaterial");
			int CantidadHerraje = Resultado.getInt("CantidadHerraje");
			double Precio = Resultado.getDouble("Precio");
			int Suelas_Referencia = Resultado.getInt("Suelas_Referencia");
			/**
			 * Creamos un objeto del tipo de la clase
			 */
			ClsArticulos objArticulos = new ClsArticulos(Referencia, Serie, Descripcion, CantidadMaterial,
					CantidadHerraje, Precio, Suelas_Referencia);

			/**
			 * Añadimos el objeto al Array
			 */
			MiListaDeArticulos.add(objArticulos);

		}
		objDatos.desconectarBD();
	}

	public ArrayList<ItfProperty> DameArticulos() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * Copiamos un array en el otro y lo devolvemos
		 */
		for (ClsArticulos a : MiListaDeArticulos) {
			retorno.add(a);
		}

		return retorno;

	}

	public boolean ExisteArticulos(ClsArticulos Articulos) {

		/**
		 * Varaible que chequea el proceso
		 */
		boolean retorno = false;

		/**
		 * Comprobamos a traves del metodo equals
		 */
		for (ClsArticulos b : MiListaDeArticulos) {
			if (b.equals(Articulos))
				/**
				 * Si coinciden devolvemos un true
				 */
				return true;

		}

		return retorno;
	}

	/**
	 * Metodo para eliminar Articulos de Array y de BD
	 * 
	 * @param Referencia parametro por el cual borrar
	 * @return genera un return
	 * @throws SQLException       lanza excepcion de BD
	 * @throws ClsBorrarExcepcion lanza excepcion si no se ha borrado
	 */
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
			objDatos.conectarBD();
			objDatos.eliminarArticulos(Referencia);
			objDatos.desconectarBD();
		}

		return hecho;
	}

	/**
	 * Metodo para recuperar objetos desglose de BD
	 * 
	 * @throws SQLException lanza excepcion de BD
	 */
	public void ObjetosRecuperadosDesglose() throws SQLException {
		objDatos.conectarBD();
		/**
		 * Recogemos datos desde LD y consturimos objetos.
		 */
		ResultSet Resultado = objDatos.consultarDesglose();

		/**
		 * obtenemos lo datos del objeto
		 */
		while (Resultado.next()) {
			/**
			 * Guardamos los datos en variables
			 */
			int NumeroDePedido = Resultado.getInt("NPedidoD");
			int Serie = Resultado.getInt("Serie");
			int Color = Resultado.getInt("Color");
			int ReferenciaDelArticulo = Resultado.getInt("Articulos_Referencia");
			int NumeroDePie5 = Resultado.getInt("P5");
			int NumeroDePie6 = Resultado.getInt("P6");
			int NumeroDePie7 = Resultado.getInt("P7");
			int NumeroDePie8 = Resultado.getInt("P8");
			int NumeroDePie9 = Resultado.getInt("P9");
			int NumeroDePie0 = Resultado.getInt("P0");
			int NumeroDePie1 = Resultado.getInt("P1");
			int NumeroDePie2 = Resultado.getInt("P2");
			int NumeroDePie3 = Resultado.getInt("P3");
			int NumeroDePie4 = Resultado.getInt("P4");
			int NumeroDeCliente_Desglose = Resultado.getInt("Pedidos_NPedido");
			int CantidadTotal = Resultado.getInt("CantidadTotalPies");

			/**
			 * Generamos un objeto del tipo de la clase
			 */
			ClsDesgloseDePedido objDesgloseDePedido = new ClsDesgloseDePedido(NumeroDePedido, ReferenciaDelArticulo,
					Serie, Color, NumeroDePie5, NumeroDePie6, NumeroDePie7, NumeroDePie8, NumeroDePie9, NumeroDePie0,
					NumeroDePie1, NumeroDePie2, NumeroDePie3, NumeroDePie4, CantidadTotal, NumeroDeCliente_Desglose);

			/**
			 * Los añadimos al Array
			 */
			MiListaDeDesgloses.add(objDesgloseDePedido);

		}
		objDatos.desconectarBD();
	}

	/**
	 * Metodo para devolver el array de desglose
	 * 
	 * @return nos devuelve todo el array
	 */
	public ArrayList<ItfProperty> DameDesgloses() {

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * Copiamos un array en otro y lo devolvemos
		 */
		for (ClsDesgloseDePedido a : MiListaDeDesgloses) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Metodo para eliminar Desgloses de Array y de BD
	 * 
	 * @param NPedidoD parametro por el cual borramos
	 * @return nos devuelve un resultado
	 * @throws SQLException       lanza la excepcion de BD
	 * @throws ClsBorrarExcepcion lanza excepcion si no se ha podido hacer el
	 *                            borrado
	 */
	public boolean EliminarDesglosesDeArray(int NPedidoD) throws SQLException, ClsBorrarExcepcion {

		/**
		 * variable para saber si se ha hecho el borrado o no
		 */
		boolean hecho = true;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDeDesgloses.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDeDesgloses.get(userInd).getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE)
					.equals(NPedidoD)) {
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
			MiListaDeDesgloses.remove(index);
			/**
			 * mandamos borrar de la BD.
			 */
			objDatos.conectarBD();
			objDatos.eliminarDesglose(NPedidoD);
			objDatos.desconectarBD();
		}

		return hecho;
	}

	public boolean ActualizarEntregasDePedidos(int NPedido) throws SQLException {

		/**
		 * Variable para confirmar el proceso.
		 */
		boolean Hecho = false;
		/**
		 * variable a actualizar
		 */
		boolean Entregado = false;
		int NumeroDePedido = 0;
		Date FechaDePedido = null;
		Date FechaDeEntrega = null;
		int NumeroDeCliente_Pedidos = 0;
		String NombreYApelliosDelCliente = null;

		/**
		 * Variables para buscar la posicion de objeto en el array
		 */
		int index = -1;
		int bound = MiListaDePedidos.size();
		/**
		 * miramos en que posicion de Array se encuentra nuestro objeto buscado
		 */
		for (int userInd = 0; userInd < bound; userInd++) {
			if (MiListaDePedidos.get(userInd).getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO).equals(NPedido)) {
				index = userInd;
				break;
			}

		}

		/**
		 * si encontramos posicion del objeto en el array borramos si no devolvemos
		 * false
		 */
		if (index == -1) {
			Hecho = false;

		} else {
			Hecho = true;
			/**
			 * Obtenemos el objeto
			 */
			ClsPedidos PedidoActualizar = MiListaDePedidos.get(index);

			/**
			 * obtenemos los datos del objeto
			 */

			NumeroDePedido = PedidoActualizar.getNumeroDePedido();
			FechaDePedido = PedidoActualizar.getFechaDePedido();
			FechaDeEntrega = PedidoActualizar.getFechaDeEntrega();
			Entregado = PedidoActualizar.getEntregado();
			NumeroDeCliente_Pedidos = PedidoActualizar.getNumeroDeCliente_Pedidos();
			NombreYApelliosDelCliente = PedidoActualizar.getNombreYApelliosDelCliente();

			/**
			 * actualizamos el estado
			 */
			if (Entregado == false) {
				Entregado = true;
			} else {
				Entregado = false;
			}

			/**
			 * quitamos el objeto anterior del array
			 */
			MiListaDePedidos.remove(index);
			/**
			 * creamos objeto actualizado y lo añadimos al array
			 */
			ClsPedidos PedidoActualizado = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado,
					NombreYApelliosDelCliente, NumeroDeCliente_Pedidos);
			objDatos.conectarBD();
			objDatos.ActualizarPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado,
					NombreYApelliosDelCliente, NumeroDeCliente_Pedidos);
			objDatos.desconectarBD();
			MiListaDePedidos.add(PedidoActualizado);
		}

		return Hecho;
	}

	/**
	 * Oredena el Array de Series por IDs
	 * 
	 * @return devuelve el array ordenados
	 */
	public ArrayList<ItfProperty> OrdenaSeries() {

		/**
		 * Objeto comparador
		 */
		ClsComparadorSeriesID comp = new ClsComparadorSeriesID();

		/**
		 * funcion de ordenamiento (ArrayList, Patron)
		 */
		Collections.sort(MiListaDeSeries, comp);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * compiamos un array en el otro ya ordenado
		 */
		for (ClsSeries a : MiListaDeSeries) {
			retorno.add(a);
		}

		return retorno;

	}

	/**
	 * Oredena el Array de Herrajes por IDs
	 * 
	 * @return devuelve el array ordenado
	 */
	public ArrayList<ItfProperty> OrdenarHerrajes() {
		/**
		 * Objeto comparador
		 */
		ClsComparadorHerrajesID comp = new ClsComparadorHerrajesID();

		/**
		 * funcion de ordenamiento (ArrayList, Patron)
		 */
		Collections.sort(MiListaDeHerrajes, comp);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * compiamos un array en el otro ya ordenado
		 */
		for (ClsHerrajes a : MiListaDeHerrajes) {
			retorno.add(a);
		}

		return retorno;
	}

	/**
	 * Ordenar el array de Materiales por ID
	 * 
	 * @return nos lo devuelve ordenado
	 */
	public ArrayList<ItfProperty> OrdenarMateriales() {

		/**
		 * Objeto comparador
		 */
		ClsComparadorMaterialesID comp = new ClsComparadorMaterialesID();

		/**
		 * funcion de ordenamiento (ArrayList, Patron)
		 */
		Collections.sort(MiListaDeMateriales, comp);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * compiamos un array en el otro ya ordenado
		 */
		for (ClsMateriales a : MiListaDeMateriales) {
			retorno.add(a);
		}

		return retorno;
	}

	/**
	 * Metodo para ordenar suelas por ID
	 * 
	 * @return devuelve array ordenado
	 */
	public ArrayList<ItfProperty> OrdenarSuelas() {

		/**
		 * Objeto comparador
		 */
		ClsComparadorSuelasID comp = new ClsComparadorSuelasID();

		/**
		 * funcion de ordenamiento (ArrayList, Patron)
		 */
		Collections.sort(MiListaDeSuelas, comp);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * compiamos un array en el otro ya ordenado
		 */
		for (ClsSuelas a : MiListaDeSuelas) {
			retorno.add(a);
		}

		return retorno;
	}

	public ArrayList<ItfProperty> OrdenarEnvios() {

		/**
		 * Objeto comparador
		 */
		ClsComparadorEnviosID comp = new ClsComparadorEnviosID();

		/**
		 * Funcion de ordenamiento (ArrayList, Patron)
		 */
		Collections.sort(MiListaDeEnvios, comp);

		/**
		 * Generamos ArrayList De tipo ITF para recuperar las propiedades del objeto y
		 * pasarlas a ClsMostrarDatos para verlos por pantalla
		 */
		ArrayList<ItfProperty> retorno;
		retorno = new ArrayList<ItfProperty>();

		/**
		 * compiamos un array en el otro ya ordenado
		 */
		for (ClsEnvios a : MiListaDeEnvios) {
			retorno.add(a);
		}

		return retorno;
	}
}
