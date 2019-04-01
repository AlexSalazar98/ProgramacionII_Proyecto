package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_CLIENTES_POR_DNI_NIF;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_ENVIOS;
import static LD.ClsConstantesBD.QUERY_PARA_SELECT_ENVIOS;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_ENVIOS_POR_NºENVIO;

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

		Connection objConn = null;

		objConn = DriverManager.getConnection(RUTA_DE_LA_BD, NOMBRE_DEL_USUARIO, CONTRASEÑA_DE_LA_BD);

		return objConn;

	}

	/**
	 * Para hacer insert de Series
	 * 
	 * @param NºDeSerie   parametro para insert
	 * @param Descripcion parametro para insert
	 * @throws SQLException lanzamos excepciones a la capa LP
	 */
	public void InsertarSerie(int NºDeSerie, String Descripcion) throws SQLException {
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
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_SERIES);
			objSt.setInt(1, NºDeSerie);
			objSt.setString(2, Descripcion);

			// Ejecutamos la query que hemos preparado
			objSt.execute();

			System.out.println("Se ha insertado el registro correctamente");
			System.out.println("-----------------------------------------");

			// Cerramos el preparedStatement
			objSt.close();

			// Cerramos la conexión
			objConn.close();

		}

	}

	/**
	 * Para consultar Series.
	 * 
	 * @param contador parametro contador.
	 * @throws SQLException lanzamos excepciones hacia la capa LP
	 * 
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
	 * @param NºDeSerie parametro de condicion.
	 * @throws SQLException lanzamos excepciones hacia la capa LP
	 */
	public void eliminarSeries(int NºDeSerie) throws SQLException {

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
			objSt.setInt(1, NºDeSerie);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			System.out.println("Se ha eliminado el registro correctamente");
			System.out.println("-----------------------------------------");

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

			// Creamos las preparedstaments
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_SUELAS);
			objSt.setInt(1, Referencia);
			objSt.setString(2, Descripcion);
			objSt.setDouble(3, Precio);

			// Ejecutamos la query que hemos preparado
			objSt.execute();

			System.out.println("Se ha insertado el registro correctamente");
			System.out.println("-----------------------------------------");

			// Cerramos el preparedStatement
			objSt.close();

			// Cerramos la conexión
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
	 * @param NºDeSerie parametro por el cual eliminar
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarSuelas(int NºDeSerie) throws SQLException {

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
			objSt.setInt(1, NºDeSerie);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			System.out.println("Se ha eliminado el registro correctamente");
			System.out.println("-----------------------------------------");

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
			objSt.setInt(1, Referencia);
			objSt.setString(2, Descripcion);
			objSt.setDouble(3, Precio);

			// Ejecutamos la query que hemos preparado
			objSt.execute();

			System.out.println("Se ha insertado el registro correctamente");
			System.out.println("-----------------------------------------");

			// Cerramos el preparedStatement
			objSt.close();

			// Cerramos la conexión
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
			objSt.setInt(1, Referencia);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			System.out.println("Se ha eliminado el registro correctamente");
			System.out.println("-----------------------------------------");

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
			objSt.setInt(1, Referencia);
			objSt.setString(2, Descripcion);
			objSt.setDouble(3, Precio);

			// Ejecutamos la query que hemos preparado
			objSt.execute();

			System.out.println("Se ha insertado el registro correctamente");
			System.out.println("-----------------------------------------");

			// Cerramos el preparedStatement
			objSt.close();

			// Cerramos la conexión
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
	 * @param NºDeSerie parametro por el cual eliminar
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarHerrajes(int NºDeSerie) throws SQLException {

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
			objSt.setInt(1, NºDeSerie);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			System.out.println("Se ha eliminado el registro correctamente");
			System.out.println("-----------------------------------------");

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
	 * @param NºCliente          parametro recibido.
	 * @param NombreYApellidos   parametro recibido
	 * @param DNI_NIF            parametro recibido
	 * @param DireccionDeCliente parametro recibido
	 * @param Provincia          parametro recibido
	 * @param Telefono           parametro recibido
	 * @param Email              parametro recibido
	 * @throws SQLException lanzamos excepcion
	 */
	public void InsertarClientes(int NºCliente, String NombreYApellidos, String DNI_NIF, String DirecciónDeCliente,
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
			objSt.setInt(1, NºCliente);
			objSt.setString(2, NombreYApellidos);
			objSt.setString(3, DNI_NIF);
			objSt.setString(4, DirecciónDeCliente);
			objSt.setString(5, Provincia);
			objSt.setInt(6, Telefono);
			objSt.setString(7, Email);

			// Ejecutamos la query que hemos preparado
			objSt.execute();

			System.out.println("Se ha insertado el registro correctamente");
			System.out.println("-----------------------------------------");

			// Cerramos el preparedStatement
			objSt.close();

			// Cerramos la conexión
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
	 * @param DNI_NIF parametro de eliminacion
	 * @throws SQLException lanzamos excepcion
	 */
	public void eliminarClientes(String DNI_NIF) throws SQLException {

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
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_CLIENTES_POR_DNI_NIF);
			objSt.setString(3, DNI_NIF);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			System.out.println("Se ha eliminado el registro correctamente");
			System.out.println("-----------------------------------------");

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
	 * @param NºEnvio parametro recibido
	 * @param NombreCliente parametro recibido
	 * @param DireccionDeEnvio parametro recibido
	 * @param PoblacionDeEnvio parametro recibido
	 * @param CPDeEnvio parametro recibido
	 * @param ProvinciaDeEnvio parametro recibido
	 * @param TelefonoDeEnvio parametro recibido
	 * @throws SQLException lanzamos la excepcion
	 */
	public void InsertarEnvios(int NºEnvio, String NombreCliente, String DireccionDeEnvio, String PoblacionDeEnvio,
			String CPDeEnvio, String ProvinciaDeEnvio, int TelefonoDeEnvio, int Clientes_NºCliente) throws SQLException {
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
			objSt.setInt(1, NºEnvio);
			objSt.setString(2, NombreCliente);
			objSt.setString(3, DireccionDeEnvio);
			objSt.setString(4, PoblacionDeEnvio);
			objSt.setString(5, CPDeEnvio);
			objSt.setString(6, ProvinciaDeEnvio);
			objSt.setInt(7, TelefonoDeEnvio);
			objSt.setInt(8, Clientes_NºCliente);

			// Ejecutamos la query que hemos preparado
			objSt.execute();

			System.out.println("Se ha insertado el registro correctamente");
			System.out.println("-----------------------------------------");

			// Cerramos el preparedStatement
			objSt.close();

			// Cerramos la conexión
			objConn.close();

		}

	}

	/**
	 * Metodo para consultar Envios
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
	 * @param NºEnvio parametro recibido
	 * @throws SQLException lazamos la excepcion
	 */
	public void eliminarEnvios(int NºEnvio) throws SQLException {

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
			PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_ENVIOS_POR_NºENVIO);
			objSt.setInt(1, NºEnvio);

			/**
			 * Ejecutamos la query que hemos preparado
			 */
			objSt.execute();

			System.out.println("Se ha eliminado el registro correctamente");
			System.out.println("-----------------------------------------");

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
