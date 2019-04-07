package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static LD.ClsConstantesBD.RUTA_DE_LA_BD;
import static LD.ClsConstantesBD.NOMBRE_DEL_USUARIO;
import static LD.ClsConstantesBD.CONTRASEÑA_DE_LA_BD;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_SERIES;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_SERIES;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_SERIES_POR_NºDESERIE;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_SUELAS;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_SUELAS;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_SUELAS_POR_REFERENCIA;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_MATERIALES;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_MATERIALES;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_MATERIALES_POR_REFERENCIA;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_HERRAJES;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_HERRAJES;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_HERRAJES_POR_REFERENCIA;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_CLIENTES;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_CLIENTES;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_CLIENTES_POR_NUMERO_DE_CLIENTE;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_ENVIOS;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_ENVIOS;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_ENVIOS_POR_NUMERO_DE_ENVIO;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_PEDIDOS;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_PEDIDOS;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_PEDIDOS_POR_NUMERO_DE_PEDIDO;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_ARTICULOS;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_ARTICULOS;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_ARTICULOS_POR_REFERENCIA;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_DE_DESGLOSE_DE_PEDIDO;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_DESGLOSE_DE_PEDIDOS;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_DESGLOSE_DE_PEDIDO_POR_NUMERO_DE_PEDIDO_DESGLOSE;

/**
 * Clase para hacer todos los tramites con la Base de Datos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 *
 */

public class ClsDatos {

	/**
	 * Constructor vacio de ClsDatos.
	 */
	public ClsDatos() {
	}

	/**
	 * Para generar la conexion con BD
	 * 
	 * @return tiene return
	 * @throws SQLException lanzamos excepciones a la capa LP
	 */
	public Connection conectarBD() throws SQLException {

		/**
		 * objeto conecxio
		 */
		Connection objConn = null;

		/**
		 * Realizamos la conexio
		 */
		objConn = DriverManager.getConnection(RUTA_DE_LA_BD, NOMBRE_DEL_USUARIO, CONTRASEÑA_DE_LA_BD);

		return objConn;

	}

	/**
	 * Para hacer insert de Series
	 * 
	 * @param NDeSerie    parametro para insert
	 * @param Descripcion parametro para insert
	 * @throws SQLException lanzamos excepciones a la capa LP
	 */
	public void InsertarSerie(int NDeSerie, String Descripcion) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_SERIES);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, NDeSerie);
			objSt.setString(2, Descripcion);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Para consultar Series.
	 * 
	 * @throws SQLException lanzamos excepciones hacia la capa LP
	 * @return nos devuelve los datos.
	 */

	public ResultSet consultarSeries() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperacion de datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_SERIES);
			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}

		return null;
	}

	/**
	 * Para hacer delete en Series
	 * 
	 * @param NDeSerie parametro de condicion.
	 * @throws SQLException lanzamos excepciones hacia la capa LP
	 */
	public void eliminarSeries(int NDeSerie) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_SERIES_POR_NºDESERIE);
			/**
			 * Dato por el cual borramos
			 */
			objSt.setInt(1, NDeSerie);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para insertar suelas
	 * 
	 * @param Referencia  parametro de suelas
	 * @param Descripcion parametro de suelas
	 * @param Precio      parametro de suelas
	 * @throws SQLException lanzamos excepciones
	 */
	public void InsertarSuelas(int Referencia, String Descripcion, Double Precio) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_SUELAS);
			/**
			 * Datos a guardar
			 */
			objSt.setInt(1, Referencia);
			objSt.setString(2, Descripcion);
			objSt.setDouble(3, Precio);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Para consultar suelas
	 * 
	 * @return devolvemos datos
	 * @throws SQLException mandamos excepxiones a tratar.
	 */
	public ResultSet consultarSuelas() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperacion de datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_SUELAS);

			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}

		return null;
	}

	/**
	 * Para eliminar suelas por numero de serie
	 * 
	 * @param NDeSerie parametro por el cual eliminar
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarSuelas(int NDeSerie) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_SUELAS_POR_REFERENCIA);
			/**
			 * Dato por el cual borramos
			 */
			objSt.setInt(1, NDeSerie);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * para insertar materiales
	 * 
	 * @param Referencia  parametro a insertar
	 * @param Descripcion parametro a insertar
	 * @param Precio      parametro a insertar
	 * @throws SQLException lanzamos excepciones
	 */
	public void InsertarMateriales(int Referencia, String Descripcion, Double Precio) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_MATERIALES);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, Referencia);
			objSt.setString(2, Descripcion);
			objSt.setDouble(3, Precio);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * para consultar materiales
	 * 
	 * @return genera un return con los datos obtenidos de BD
	 * @throws SQLException lanzamos excepciones
	 */
	public ResultSet consultarMateriales() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_MATERIALES);

			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}

		return null;
	}

	/**
	 * Para eliminar materiales por referencia
	 * 
	 * @param Referencia parametro por el cual borramos
	 * @throws SQLException Lanzamos excepciones
	 */

	public void eliminarMateriales(int Referencia) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_MATERIALES_POR_REFERENCIA);
			/**
			 * Dato por el cual borramos
			 */
			objSt.setInt(1, Referencia);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para insertar herrajes
	 * 
	 * @param Referencia  parametro de herrajes
	 * @param Descripcion parametro de herrajes
	 * @param Precio      parametro de herrajes
	 * @throws SQLException lanzamos excepciones
	 */
	public void InsertarHerrajes(int Referencia, String Descripcion, Double Precio) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_HERRAJES);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, Referencia);
			objSt.setString(2, Descripcion);
			objSt.setDouble(3, Precio);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Para consultar herrajes
	 * 
	 * @return devolvemos datos
	 * @throws SQLException mandamos excepxiones a tratar.
	 */
	public ResultSet consultarHerrajes() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_HERRAJES);

			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}

		return null;
	}

	/**
	 * Para eliminar herrajes por numero de serie
	 * 
	 * @param NDeSerie parametro por el cual eliminar
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarHerrajes(int NDeSerie) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_HERRAJES_POR_REFERENCIA);
			/**
			 * Parametro por el cual borramos
			 */
			objSt.setInt(1, NDeSerie);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para insertar clientes en BD
	 * 
	 * @param NCliente           parametro recibido.
	 * @param NombreYApellidos   parametro recibido
	 * @param DNI_NIF            parametro recibido
	 * @param DireccionDeCliente parametro recibido
	 * @param Provincia          parametro recibido
	 * @param Telefono           parametro recibido
	 * @param Email              parametro recibido
	 * @throws SQLException lanzamos excepcion
	 */
	public void InsertarClientes(int NCliente, String NombreYApellidos, String DNI_NIF, String DireccionDeCliente,
			String Provincia, int Telefono, String Email) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_CLIENTES);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, NCliente);
			objSt.setString(2, NombreYApellidos);
			objSt.setString(3, DNI_NIF);
			objSt.setString(4, DireccionDeCliente);
			objSt.setString(5, Provincia);
			objSt.setInt(6, Telefono);
			objSt.setString(7, Email);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/*
			 * Cerramos el preparedStatement
			 * 
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para consultar clientes
	 * 
	 * @return nos devuelve parametros
	 * @throws SQLException lanzamos excepcion
	 */
	public ResultSet consultarClientes() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_CLIENTES);
			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}
		return null;
	}

	/**
	 * Metodo para eliminar clientes de BD
	 * 
	 * @param NCliente parametro de eliminacion
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarClientes(int NCliente) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_CLIENTES_POR_NUMERO_DE_CLIENTE);
			/**
			 * Dato por el cual borramos
			 */
			objSt.setInt(1, NCliente);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para insertar Envios en BD
	 * 
	 * @param NEnvio            parametro recibido
	 * @param NombreCliente     parametro recibido
	 * @param DireccionDeEnvio  parametro recibido
	 * @param PoblacionDeEnvio  parametro recibido
	 * @param CPDeEnvio         parametro recibido
	 * @param ProvinciaDeEnvio  parametro recibido
	 * @param TelefonoDeEnvio   parametro recibido
	 * @param Clientes_NCliente parametro recibido
	 * @throws SQLException lanzamos la excepcion
	 */
	public void InsertarEnvios(int NEnvio, String NombreCliente, String DireccionDeEnvio, String PoblacionDeEnvio,
			int CPDeEnvio, String ProvinciaDeEnvio, int TelefonoDeEnvio, int Clientes_NCliente) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_ENVIOS);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, NEnvio);
			objSt.setString(2, NombreCliente);
			objSt.setString(3, DireccionDeEnvio);
			objSt.setString(4, PoblacionDeEnvio);
			objSt.setInt(5, CPDeEnvio);
			objSt.setString(6, ProvinciaDeEnvio);
			objSt.setInt(7, TelefonoDeEnvio);
			objSt.setInt(8, Clientes_NCliente);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para consultar Envios
	 * 
	 * @return nos devuelve parametros
	 * @throws SQLException lanza la excepcion
	 */
	public ResultSet consultarEnvios() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_ENVIOS);
			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}
		return null;
	}

	/**
	 * Metodo para eliminar Envios de BD
	 * 
	 * @param NEnvio parametro recibido
	 * @throws SQLException lazamos la excepcion
	 */
	public void eliminarEnvios(int NEnvio) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_ENVIOS_POR_NUMERO_DE_ENVIO);
			/**
			 * Parametro por el cual borramos
			 */
			objSt.setInt(1, NEnvio);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para insertar pedidos en BD
	 * 
	 * @param NPedido           parametro recibido
	 * @param FechaDePedido     parametro recibido
	 * @param FechaDeEntrega    parametro recibido
	 * @param Entregado         parametro recibido
	 * @param Clientes_NCliente parametro recibido
	 * @param NombreYApellidos  parametro recibido
	 * @throws SQLException lanzamos excepcion.
	 */
	public void InsertarPedidos(int NPedido, Date FechaDePedido, Date FechaDeEntrega, Boolean Entregado,
			int Clientes_NCliente, String NombreYApellidos) throws SQLException {

		/**
		 * Traspaso de fechas de util.Date a long y despues a sql.Date
		 */
		java.sql.Date Fecha_de_pedido = new java.sql.Date(FechaDePedido.getTime());
		java.sql.Date Fecha_de_entrega = new java.sql.Date(FechaDeEntrega.getTime());
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_PEDIDOS);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, NPedido);
			objSt.setDate(2, (java.sql.Date) Fecha_de_pedido);
			objSt.setDate(3, (java.sql.Date) Fecha_de_entrega);
			objSt.setBoolean(4, Entregado);
			objSt.setInt(5, Clientes_NCliente);
			objSt.setString(6, NombreYApellidos);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para consultar pedidos en BD
	 * 
	 * @return nos devuelve los datos
	 * @throws SQLException lanzamos excepcion
	 */
	public ResultSet consultarPedidos() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_PEDIDOS);
			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}
		return null;
	}

	/**
	 * Metodo para eliminar pedidos en la BD
	 * 
	 * @param NPedido parametro recibido
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarPedidos(int NPedido) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_PEDIDOS_POR_NUMERO_DE_PEDIDO);
			/**
			 * Parametro por el cual borramos
			 */
			objSt.setInt(1, NPedido);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para introducir Articulos en la BD
	 * 
	 * @param Referencia                 parametro recibido
	 * @param Serie                      parametro recibido
	 * @param Descripcion                parametro recibido
	 * @param CantidadMaterial           parametro recibido
	 * @param CantidadHerrajes           parametro recibido
	 * @param Precio                     parametro recibido
	 * @param ReferenciaSuelas_Articulos parametro recibido
	 * @throws SQLException lanzamos excpcion.
	 */
	public void InsertarArticulos(int Referencia, int Serie, String Descripcion, int CantidadMaterial,
			int CantidadHerrajes, double Precio, int ReferenciaSuelas_Articulos) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_ARTICULOS);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, Referencia);
			objSt.setInt(2, Serie);
			objSt.setString(3, Descripcion);
			objSt.setInt(4, CantidadMaterial);
			objSt.setInt(5, CantidadHerrajes);
			objSt.setDouble(6, Precio);
			objSt.setInt(7, ReferenciaSuelas_Articulos);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para consultar datos en la BD
	 * 
	 * @return nos devuelve los datos
	 * @throws SQLException lanzamos excepcion
	 */
	public ResultSet consultarArticulos() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_ARTICULOS);
			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}
		return null;
	}

	/**
	 * Metodo para eliminar Articulos de la BD
	 * 
	 * @param Referencia parametro recibido
	 * @throws SQLException lanzamos expcion
	 */
	public void eliminarArticulos(int Referencia) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_ARTICULOS_POR_REFERENCIA);
			/**
			 * Parametro por el cual borramos
			 */
			objSt.setInt(1, Referencia);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * 
	 * Metodo para insertar desgloses de pedido
	 * 
	 * @param NPedidoD                  parametro numero de pedido
	 * @param Articulos_Referencia      parametro numero de referencia del articulo
	 * @param Serie                     parametro numero de serie
	 * @param Color                     parametro numero de color
	 * @param P5                        parametro cantidad del numero 5
	 * @param P6                        parametro cantidad del numero 6
	 * @param P7                        parametro cantidad del numero 7
	 * @param P8                        parametro cantidad del numero 8
	 * @param P9                        parametro cantidad del numero 9
	 * @param P0                        parametro cantidad del numero 0
	 * @param P1                        parametro cantidad del numero 1
	 * @param P2                        parametro cantidad del numero 2
	 * @param P3                        parametro cantidad del numero 3
	 * @param P4                        parametro cantidad del numero 4
	 * @param CantidadTotalPies         parametro de cantidad total de numeros.
	 * @param Pedidos_Clientes_NCliente parametro del numero del cliente.
	 * @throws SQLException lanza excepcion
	 */
	public void InsertarDesglose(int NPedidoD, int Articulos_Referencia, int Serie, int Color, int P5, int P6, int P7,
			int P8, int P9, int P0, int P1, int P2, int P3, int P4, int CantidadTotalPies,
			int Pedidos_Clientes_NCliente) throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_DE_DESGLOSE_DE_PEDIDO);
			/**
			 * Datos a insertar
			 */
			objSt.setInt(1, NPedidoD);
			objSt.setInt(2, Serie);
			objSt.setInt(3, Color);
			objSt.setInt(4, Articulos_Referencia);
			objSt.setInt(5, Pedidos_Clientes_NCliente);
			objSt.setInt(6, P5);
			objSt.setInt(7, P6);
			objSt.setInt(8, P7);
			objSt.setInt(9, P8);
			objSt.setInt(10, P9);
			objSt.setInt(11, P0);
			objSt.setInt(12, P1);
			objSt.setInt(13, P2);
			objSt.setInt(14, P3);
			objSt.setInt(15, P4);
			objSt.setInt(16, CantidadTotalPies);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}

	/**
	 * Metodo para consultar desgloses de pedidos en la BD
	 * 
	 * @return nos devuelve los datos
	 * @throws SQLException lanza excepcion
	 */
	public ResultSet consultarDesglose() throws SQLException {
		/**
		 * Instancias el metodo que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método y te devuelve una conexión
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		ResultSet rs = null;

		if (objConn != null) {
			/**
			 * Preparamos la consulta
			 */
			Statement st = objConn.createStatement();
			/**
			 * Proceso de recuperar datos
			 */
			rs = st.executeQuery(QUERY_PARA_SELECT_DESGLOSE_DE_PEDIDOS);
			if (rs.isBeforeFirst()) {
				return rs;
			}
			while (rs.next()) {

				return rs;

			}

			/**
			 * Cerramos el resulset
			 * 
			 */
			rs.close();
			/**
			 * Cerramos el statement
			 * 
			 */
			st.close();
			/**
			 * Cerramos la conexión
			 * 
			 */
			objConn.close();

		}
		return null;
	}

	/**
	 * Metodo para eliminar Desgloses de Pedido de la BD
	 * 
	 * @param NPedidosD parametro por el cual borrar
	 * @throws SQLException lanza excepcion
	 */
	public void eliminarDesglose(int NPedidosD) throws SQLException {

		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al método que tiene la clase y te devuelve una conexión
		 */
		Connection objConn = SQL.conectarBD();

		if (objConn != null) {

			/**
			 * Creamos las preparedstaments
			 */
			PreparedStatement objSt = objConn
					.prepareStatement(QUERY_PARA_DELETE_DESGLOSE_DE_PEDIDO_POR_NUMERO_DE_PEDIDO_DESGLOSE);
			/**
			 * Parametro por el cual borramos
			 */
			objSt.setInt(1, NPedidosD);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			/**
			 * Cerramos el preparedStatement
			 */
			objSt.close();

			/**
			 * Cerramos la conexión
			 */
			objConn.close();

		}

	}
}
