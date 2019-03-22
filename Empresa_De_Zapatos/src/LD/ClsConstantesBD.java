package LD;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta Clase para almacenar todas las constantes que
 *         utilicemos a nivel de LP con base de datos.
 */

public class ClsConstantesBD {

	/**
	 * Constantes para la conexion.
	 */
	public static final String NOMBRE_DE_LA_BD = "mydb";
	public static final String NOMBRE_DEL_HOSTNAME = "localhost";
	public static final String PUERTO_BD = "3306";
	public static final String NOMBRE_DEL_USUARIO = "root";
	public static final String CONTRASEÑA_DE_LA_BD = "16dejuniode1998";
	public static final String RUTA_DE_LA_BD = "jdbc:mysql://" + NOMBRE_DEL_HOSTNAME + ":" + PUERTO_BD + "/"
			+ NOMBRE_DE_LA_BD + "?useTimezone=true&serverTimezone=GMT&useSSL=false";

	/**
	 * Constante para insert de Series.
	 */
	public static final String QUERY_PARA_INSERTAR_SERIES = "INSERT INTO `mydb`.`series`\r\n" + "(`NºDeSerie`,\r\n"
			+ "`Descripcion`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?);";

	/**
	 * Constante para Select de series.
	 */
	public static final String QUERY_PARA_SELECT_SERIES = "SELECT `series`.`NºDeSerie`,\r\n"
			+ "    `series`.`Descripcion`\r\n" + "FROM `mydb`.`series`;";

	/**
	 * Constante para Delete de series condicionado por el NºDeSerie.
	 */
	public static final String QUERY_PARA_DELETE_SERIES_POR_NºDESERIE = "DELETE FROM `mydb`.`series`\r\n"
			+ "	WHERE NºDeSerie = ?";
}