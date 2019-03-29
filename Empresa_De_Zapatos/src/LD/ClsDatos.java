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
	 * @param ObjGestorCSeries Parametro para acceder al gestor
	 * @param contador         parametro contador.
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
	public static void eliminarSeries(int NºDeSerie) throws SQLException {

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

}
