package LD;

/**
 * Clase para almacenar todas las constantes que utilicemos a nivel de LP con
 * base de datos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
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

	/**
	 * Constante para la INSERT de suelas.
	 */
	public static final String QUERY_PARA_INSERTAR_SUELAS = "INSERT INTO `mydb`.`suelas`\r\n" + "(`Referencia`,\r\n"
			+ "`Descripcion`,\r\n" + "`Precio`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?);";

	/**
	 * Consatnte para la SELECT de suelas.
	 */
	public static final String QUERY_PARA_SELECT_SUELAS = "SELECT `suelas`.`Referencia`,\r\n"
			+ "    `suelas`.`Descripcion`,\r\n" + "    `suelas`.`Precio`\r\n" + "FROM `mydb`.`suelas`;";

	/**
	 * Constante de DELETE para suelas por referencia.
	 */
	public static final String QUERY_PARA_DELETE_SUELAS_POR_REFERENCIA = "DELETE FROM `mydb`.`suelas`\r\n"
			+ "WHERE Referencia = ?;";

	/**
	 * Constante para INSERT materiales.
	 */
	public static final String QUERY_PARA_INSERTAR_MATERIALES = "INSERT INTO `mydb`.`materiales`\r\n"
			+ "(`Referencia`,\r\n" + "`Descripcion`,\r\n" + "`Precio`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n"
			+ "?);";

	/**
	 * Constantes para SELECT materiales.
	 */
	public static final String QUERY_PARA_SELECT_MATERIALES = "SELECT `materiales`.`Referencia`,\r\n"
			+ "    `materiales`.`Descripcion`,\r\n" + "    `materiales`.`Precio`\r\n" + "FROM `mydb`.`materiales`;";

	/**
	 * Constante para DELETE materiales por referencia.
	 */
	public static final String QUERY_PARA_DELETE_MATERIALES_POR_REFERENCIA = "DELETE FROM `mydb`.`materiales`\r\n"
			+ "WHERE Referencia = ?;";

	/**
	 * Constantes para INSERT herrajes.
	 */
	public static final String QUERY_PARA_INSERTAR_HERRAJES = "INSERT INTO `mydb`.`herrajes`\r\n" + "(`Referencia`,\r\n"
			+ "`Descripcion`,\r\n" + "`Precio`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?);";

	/**
	 * Constantes para la SELECT de herrajes.
	 */
	public static final String QUERY_PARA_SELECT_HERRAJES = "SELECT `herrajes`.`Referencia`,\r\n"
			+ "    `herrajes`.`Descripcion`,\r\n" + "    `herrajes`.`Precio`\r\n" + "FROM `mydb`.`herrajes`;";

	/**
	 * Constante de DELETE para herrajes por referencia.
	 */
	public static final String QUERY_PARA_DELETE_HERRAJES_POR_REFERENCIA = "DELETE FROM `mydb`.`herrajes`\r\n"
			+ "WHERE Referencia = ?;";
	/**
	 * Constantes para INSERT clientes.
	 */
	public static final String QUERY_PARA_INSERTAR_CLIENTES = "INSERT INTO `mydb`.`clientes`\r\n" + "(`NºCliente`,\r\n"
			+ "`NombreYApellidos`,\r\n" + "`DNI_NIF`,\r\n" + "`DirecciónDeCliente`,\r\n" + "`Provincia`,\r\n"
			+ "`Telefono`,\r\n" + "`Email`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n"
			+ "?,\r\n" + "?);";

	/**
	 * Constantes para la SELECT de clientes.
	 */
	public static final String QUERY_PARA_SELECT_CLIENTES = "SELECT `clientes`.`NºCliente`,\r\n"
			+ "    `clientes`.`NombreYApellidos`,\r\n" + "    `clientes`.`DNI_NIF`,\r\n"
			+ "    `clientes`.`DirecciónDeCliente`,\r\n" + "    `clientes`.`Provincia`,\r\n"
			+ "    `clientes`.`Telefono`,\r\n" + "    `clientes`.`Email`\r\n" + "FROM `mydb`.`clientes`;\r\n" + "";

	/**
	 * Constante de DELETE para clientes por DNI_NIF.
	 */
	public static final String QUERY_PARA_DELETE_CLIENTES_POR_DNI_NIF = "DELETE FROM `mydb`.`clientes`\r\n"
			+ "WHERE DNI_NIF = ?;\r\n" + "";
	/**
	 * Constantes para INSERT Envios.
	 */
	public static final String QUERY_PARA_INSERTAR_ENVIOS = "INSERT INTO `mydb`.`envios`\r\n" + "(`NºEnvio`,\r\n"
			+ "`NombreCliente`,\r\n" + "`DireccionDeEnvio`,\r\n" + "`PoblacionDeEnvio`,\r\n" + "`CPDeEnvio`,\r\n"
			+ "`ProvinciaDeEnvio`,\r\n" + "`TelefonoDeEnvio`)\r\n" + "VALUES\n" + "(?,\r\n" + "?,\r\n" + "?,\r\n"
			+ "?,\r\n" + "?,\r\n" + "?\r,\n" + "?\r,\n" + "?);";

	/**
	 * Constantes para la SELECT de Envios.
	 */
	public static final String QUERY_PARA_SELECT_ENVIOS = "SELECT * FROM mydb.envios;";

	/**
	 * Constante de DELETE para Envios por NºEnvio.
	 */
	public static final String QUERY_PARA_DELETE_ENVIOS_POR_NºENVIO = "DELETE FROM `mydb`.`envios`\n"
			+ "WHERE NºEnvio = ?;\r\n" + "";

	/**
	 * Constante para la INSERT de Pedido.
	 */
	public static final String QUERY_PARA_INSERTAR_PEDIDOS = "INSERT INTO `mydb`.`pedidos`\r\n" + "	(`NºPedido`,\r\n"
			+ "	`Fecha_de_pedido`,\r\n" + "	`Fecha_de_entrega`,\r\n" + "	`Entregado`,\r\n"
			+ "	`Clientes_NºCliente`,\r\n" + "	`NombreYApellidos`)\r\n" + "	VALUES\r\n" + "	(?,\r\n" + "	?,\r\n"
			+ "	?,\r\n" + "	?,\r\n" + "	?,\r\n" + "	?);";

	/**
	 * Constante para SELECT pedidos.
	 */
	public static final String QUERY_PARA_SELECT_PEDIDOS = "SELECT `pedidos`.`NºPedido`,\r\n"
			+ "    `pedidos`.`Fecha_de_pedido`,\r\n" + "    `pedidos`.`Fecha_de_entrega`,\r\n"
			+ "    `pedidos`.`Entregado`,\r\n" + "    `pedidos`.`Clientes_NºCliente`,\r\n"
			+ "    `pedidos`.`NombreYApellidos`\r\n" + "FROM `mydb`.`pedidos`;\r\n" + "";

	/**
	 * Constante para DELETE Pedidos.
	 */
	public static final String QUERY_PARA_DELETE_PEDIDOS_POR_NºPEDIDO = "DELETE FROM `mydb`.`pedidos`\r\n"
			+ "	WHERE NºEnvio = ?;";

}
