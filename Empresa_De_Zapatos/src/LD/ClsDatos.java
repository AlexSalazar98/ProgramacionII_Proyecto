package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import LN.ClsGestorLN;

import static LD.ClsConstantesBD.RUTA_DE_LA_BD;
import static LD.ClsConstantesBD.NOMBRE_DEL_USUARIO;
import static LD.ClsConstantesBD.CONTRASE�A_DE_LA_BD;
import static LD.ClsConstantesBD.QUERY_PARA_INSERTAR_SERIES;
import static LD.ClsConstantesBD.QUERY_PARA_SELEC_SERIES;
import static LD.ClsConstantesBD.QUERY_PARA_DELETE_SERIES_POR_N�DESERIE;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta Clase para hacer todos los tramites con la Base de
 *         Datos.
 *
 */

public class ClsDatos {

	/**
	 * Para generar la conexion con BD
	 * 
	 * @return tiene return
	 */
	public Connection conectarBD() {

		Connection objConn = null;

		try {

			objConn = DriverManager.getConnection(RUTA_DE_LA_BD, NOMBRE_DEL_USUARIO, CONTRASE�A_DE_LA_BD);

		} catch (SQLException e) {
			System.out.println("Ha fallado la conexi�n" + e);
		}

		return objConn;

	}

	/**
	 * Para hacer inserte de Series
	 * 
	 * @param N�DeSerie   parametro para insert
	 * @param Descripcion parametro para insert
	 */
	public static void InsertarSerie(int N�DeSerie, String Descripcion) {
		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();
		/**
		 * Llamas al m�todo que tiene la clase y te devuelve una conexi�n
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		try {
			if (objConn != null) {

				// Creamos las preparedstaments
				PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_INSERTAR_SERIES);
				objSt.setInt(1, N�DeSerie);
				objSt.setString(2, Descripcion);

				// Ejecutamos la query que hemos preparado
				objSt.execute();

				System.out.println("Se ha insertado el registro correctamente");
				System.out.println("-----------------------------------------");

				// Cerramos el preparedStatement
				objSt.close();

				// Cerramos la conexi�n
				objConn.close();

			} else {
				System.out.println("No existe conexi�n");
			}

		} catch (SQLException e) {
			System.out.println("No se ha podido realizar el insert: " + e);
		}

	}

	/**
	 * Para consultar Series.
	 */
	public static void consultarSeries() {
		/**
		 * Instancias la clase que hemos creado anteriormente
		 */
		ClsDatos SQL = new ClsDatos();

		/**
		 * Llamas al m�todo que tiene la clase y te devuelve una conexi�n
		 * 
		 */
		Connection objConn = SQL.conectarBD();

		try {
			if (objConn != null) {
				/**
				 * Preparamos la consulta
				 */
				Statement st = objConn.createStatement();
				ResultSet rs = st.executeQuery(QUERY_PARA_SELEC_SERIES);

				System.out.println("SERIES RECUPERADAS");
				System.out.println("-------------------");

				/**
				 * Recorremos el resultado, mientras haya registros para leer, y escribimos el
				 * resultado en pantalla.
				 * 
				 */
				while (rs.next()) {
					//System.out.println(rs.getInt("N�DeSerie") + " " + rs.getString("Descripcion"));
					int NumeroDeSerie = rs.getInt("N�DeSerie");
					String Descripcion_Serie = rs.getString("Descripcion");
					ClsGestorLN.ObjetosRecuperadosSerie(NumeroDeSerie, Descripcion_Serie);
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
				 * Cerramos la conexi�n
				 * 
				 */
				objConn.close();

			} else {
				System.out.println("No existe conexi�n");
			}

		} catch (SQLException e) {
			System.out.println("Ha fallado la consulta: " + e);
		}
	}

	public static void eliminarSeries(int N�DeSerie) {

		// Instancias la clase que hemos creado anteriormente
		ClsDatos SQL = new ClsDatos();

		// Llamas al m�todo que tiene la clase y te devuelve una conexi�n
		Connection objConn = SQL.conectarBD();

		try {
			if (objConn != null) {

				// Creamos las preparedstaments
				PreparedStatement objSt = objConn.prepareStatement(QUERY_PARA_DELETE_SERIES_POR_N�DESERIE);
				objSt.setInt(1, N�DeSerie);

				// Ejecutamos la query que hemos preparado
				objSt.execute();

				System.out.println("Se ha eliminado el registro correctamente");
				System.out.println("-----------------------------------------");

				// Cerramos el preparedStatement
				objSt.close();

				// Cerramos la conexi�n
				objConn.close();

			} else {
				System.out.println("No existe conexi�n");
			}

		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el registro: " + e);
		}
	}

}
