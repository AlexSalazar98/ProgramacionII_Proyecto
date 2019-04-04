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
	public static final String QUERY_PARA_INSERTAR_SERIES = "INSERT INTO `mydb`.`series`\r\n" + "(`NDeSerie`,\r\n"
			+ "`Descripcion`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?);";

	/**
	 * Constante para Select de series.
	 */
	public static final String QUERY_PARA_SELECT_SERIES = "SELECT `series`.`NDeSerie`,\r\n"
			+ "    `series`.`Descripcion`\r\n" + "FROM `mydb`.`series`;";

	/**
	 * Constante para Delete de series condicionado por el NºDeSerie.
	 */
	public static final String QUERY_PARA_DELETE_SERIES_POR_NºDESERIE = "DELETE FROM `mydb`.`series`\r\n"
			+ "	WHERE NDeSerie = ?";

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
	public static final String QUERY_PARA_INSERTAR_CLIENTES = "INSERT INTO `mydb`.`clientes`\r\n" + "(`NCliente`,\r\n"
			+ "`NombreYApellidos`,\r\n" + "`DNI_NIF`,\r\n" + "`DireccionDeCliente`,\r\n" + "`Provincia`,\r\n"
			+ "`Telefono`,\r\n" + "`Email`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n"
			+ "?,\r\n" + "?);";

	/**
	 * Constantes para la SELECT de clientes.
	 */
	public static final String QUERY_PARA_SELECT_CLIENTES = "SELECT `clientes`.`NCliente`,\r\n"
			+ "    `clientes`.`NombreYApellidos`,\r\n" + "    `clientes`.`DNI_NIF`,\r\n"
			+ "    `clientes`.`DireccionDeCliente`,\r\n" + "    `clientes`.`Provincia`,\r\n"
			+ "    `clientes`.`Telefono`,\r\n" + "    `clientes`.`Email`\r\n" + "FROM `mydb`.`clientes`;\r\n" + "";

	/**
	 * Constante de DELETE para clientes por DNI_NIF.
	 */
	public static final String QUERY_PARA_DELETE_CLIENTES_POR_NUMERO_DE_CLIENTE = "DELETE FROM `mydb`.`clientes`\r\n"
			+ "WHERE NCliente = ?;";
	/**
	 * Constantes para INSERT Envios.
	 */
	public static final String QUERY_PARA_INSERTAR_ENVIOS = "INSERT INTO `mydb`.`envios`\r\n" + "(`NEnvio`,\r\n"
			+ "`NombreCliente`,\r\n" + "`DireccionDeEnvio`,\r\n" + "`PoblacionDeEnvio`,\r\n" + "`CPDeEnvio`,\r\n"
			+ "`ProvinciaDeEnvio`,\r\n" + "`TelefonoDeEnvio`,\r\n" + "`Clientes_NCliente`)\r\n" + "VALUES\r\n"
			+ "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?);";

	/**
	 * Constantes para la SELECT de Envios.
	 */
	public static final String QUERY_PARA_SELECT_ENVIOS = "SELECT * FROM mydb.envios;";

	/**
	 * Constante de DELETE para Envios por NºEnvio.
	 */
	public static final String QUERY_PARA_DELETE_ENVIOS_POR_NUMERO_DE_ENVIO = "DELETE FROM `mydb`.`envios`\n"
			+ "WHERE NEnvio = ?;\r\n" + "";

	/**
	 * Constante para la INSERT de Pedido.
	 */
	public static final String QUERY_PARA_INSERTAR_PEDIDOS = "INSERT INTO `mydb`.`pedidos`\r\n" + "	(`NPedido`,\r\n"
			+ "	`Fecha_de_pedido`,\r\n" + "	`Fecha_de_entrega`,\r\n" + "	`Entregado`,\r\n"
			+ "	`Clientes_NCliente`,\r\n" + "	`NombreYApellidos`)\r\n" + "	VALUES\r\n" + "	(?,\r\n" + "	?,\r\n"
			+ "	?,\r\n" + "	?,\r\n" + "	?,\r\n" + "	?);";

	/**
	 * Constante para SELECT pedidos.
	 */
	public static final String QUERY_PARA_SELECT_PEDIDOS = "SELECT `pedidos`.`NPedido`,\r\n"
			+ "    `pedidos`.`Fecha_de_pedido`,\r\n" + "    `pedidos`.`Fecha_de_entrega`,\r\n"
			+ "    `pedidos`.`Entregado`,\r\n" + "    `pedidos`.`Clientes_NCliente`,\r\n"
			+ "    `pedidos`.`NombreYApellidos`\r\n" + "FROM `mydb`.`pedidos`;\r\n" + "";

	/**
	 * Constante para DELETE Pedidos.
	 */
	public static final String QUERY_PARA_DELETE_PEDIDOS_POR_NUMERO_DE_PEDIDO = "DELETE FROM `mydb`.`pedidos`\r\n"
			+ "WHERE NPedido = ?;";

	/**
	 * Constante para la INSERT de Articulos.
	 */
	public static final String QUERY_PARA_INSERTAR_ARTICULOS = "INSERT INTO `mydb`.`articulos`\r\n"
			+ "(`Referencia`,\r\n" + "`Serie`,\r\n" + "`Descripcion`,\r\n" + "`CantidadMaterial`,\r\n"
			+ "`CantidadHerraje`,\r\n" + "`Precio`,\r\n" + "`Suelas_Referencia`)\r\n" + "VALUES\r\n" + "(?,\r\n"
			+ "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?);";

	/**
	 * Constante para SELECT Articulos.
	 */
	public static final String QUERY_PARA_SELECT_ARTICULOS = "SELECT `articulos`.`Referencia`,\r\n"
			+ "    `articulos`.`Serie`,\r\n" + "    `articulos`.`Descripcion`,\r\n"
			+ "    `articulos`.`CantidadMaterial`,\r\n" + "    `articulos`.`CantidadHerraje`,\r\n"
			+ "    `articulos`.`Precio`,\r\n" + "    `articulos`.`Suelas_Referencia`\r\n"
			+ "FROM `mydb`.`articulos`;\r\n" + "";

	/**
	 * Constante para DELETE Articulos.
	 */
	public static final String QUERY_PARA_DELETE_ARTICULOS_POR_REFERENCIA = "DELETE FROM `mydb`.`articulos`\r\n"
			+ "WHERE Referencia = ?;";

	/**
	 * Constante para INSERT de desglose de pedidos.
	 */
	public static final String QUERY_PARA_INSERTAR_DE_DESGLOSE_DE_PEDIDO = "INSERT INTO `mydb`.`desglosedepedidos`\r\n"
			+ "(`NPedidoD`,\r\n" + "`Serie`,\r\n" + "`Color`,\r\n" + "`Articulos_Referencia`,\r\n"
			+ "`Pedidos_Clientes_NCliente`,\r\n" + "`5`,\r\n" + "`6`,\r\n" + "`7`,\r\n" + "`8`,\r\n" + "`9`,\r\n"
			+ "`0`,\r\n" + "`1`,\r\n" + "`2`,\r\n" + "`3`,\r\n" + "`4`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n"
			+ "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n"
			+ "?,\r\n" + "?,\r\n" + "?,\r\n" + "?);";

	/**
	 * Constante para SELECT de desglose de pedidos.
	 */
	public static final String QUERY_PARA_SELECT_DESGLOSE_DE_PEDIDOS = "SELECT `desglosedepedidos`.`NPedidoD`,\r\n"
			+ "    `desglosedepedidos`.`Serie`,\r\n" + "    `desglosedepedidos`.`Color`,\r\n"
			+ "    `desglosedepedidos`.`Articulos_Referencia`,\r\n"
			+ "    `desglosedepedidos`.`Pedidos_Clientes_NCliente`,\r\n" + "    `desglosedepedidos`.`P5`,\r\n"
			+ "    `desglosedepedidos`.`P6`,\r\n" + "    `desglosedepedidos`.`P7`,\r\n"
			+ "    `desglosedepedidos`.`P8`,\r\n" + "    `desglosedepedidos`.`P9`,\r\n"
			+ "    `desglosedepedidos`.`P0`,\r\n" + "    `desglosedepedidos`.`P1`,\r\n"
			+ "    `desglosedepedidos`.`P2`,\r\n" + "    `desglosedepedidos`.`P3`,\r\n"
			+ "    `desglosedepedidos`.`P4`,\r\n" + "    `desglosedepedidos`.`CantidadTotalPies`\r\n"
			+ "FROM `mydb`.`desglosedepedidos`;";

	/**
	 * Constante para DELETE desglose de pedido por numero de Pedido Desglose.
	 */
	public static final String QUERY_PARA_DELETE_DESGLOSE_DE_PEDIDO_POR_NUMERO_DE_PEDIDO_DESGLOSE = "DELETE FROM `mydb`.`desglosedepedidos`\r\n"
			+ "WHERE NPedidoD = ?;";

}
