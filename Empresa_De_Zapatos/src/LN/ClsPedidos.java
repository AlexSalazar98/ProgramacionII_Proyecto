package LN;

import java.util.Date;
import COMUN.ItfProperty;
import Excepciones.ClsExcepcionRuntime;

import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_ENTREGADO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;

/**
 * En esta clase generamos los objetos asignados a la entidad Pedido.
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsPedidos implements ItfProperty {

	/**
	 * Atributo para recoger el numero del pedido
	 */
	private int NumeroDePedido;
	/**
	 * Atributo para recoger la fecha en la que se ha hecho el pedido
	 */
	private Date FechaDePedido;
	/**
	 * Atributo para recoger la fecha en la que se tiene que entregar
	 */
	private Date FechaDeEntrega;
	/**
	 * Atributo para recoger el estado del pedido (Entregado o NO Entregado)
	 */
	private boolean Entregado;
	/**
	 * Atributo para recoger el numero del cliente (Herencia de la tabla clientes)
	 */
	private int NumeroDeCliente_Pedidos;
	/**
	 * Atributo para recoger nombre y apellido del cliente
	 */
	private String NombreYApelliosDelCliente;

	/**
	 * 
	 * Este seria el constructor de la clase Pedidos.
	 * 
	 * @param numeroDePedido            parametro numero de pedido.
	 * @param fechaDePedido             parametro fecha de pedido
	 * @param fechaDeEntrega            parametro fecha de entrega
	 * @param entregado                 parametro entregado
	 * @param nombreYApelliosDelCliente parametro nombre y apellidos del cliente
	 * @param numeroDeCliente_Pedidos   parametro numero de cliente en la tabla
	 *                                  pedidos
	 * 
	 */
	public ClsPedidos(int numeroDePedido, Date fechaDePedido, Date fechaDeEntrega, Boolean entregado,
			String nombreYApelliosDelCliente, int numeroDeCliente_Pedidos) {
		NumeroDePedido = numeroDePedido;
		FechaDePedido = fechaDePedido;
		FechaDeEntrega = fechaDeEntrega;
		Entregado = entregado;
		NumeroDeCliente_Pedidos = numeroDeCliente_Pedidos;
		NombreYApelliosDelCliente = nombreYApelliosDelCliente;
	}

	/**
	 * 
	 * Estos son lo metodos getters y setters.
	 * 
	 * @return nos genera unos returns.
	 * 
	 */

	public Date getFechaDePedido() {
		return FechaDePedido;
	}

	public int getNumeroDePedido() {
		return NumeroDePedido;
	}

	public void setNumeroDePedido(int numeroDePedido) {
		NumeroDePedido = numeroDePedido;
	}

	public void setFechaDePedido(Date fechaDePedido) {
		FechaDePedido = fechaDePedido;
	}

	public Date getFechaDeEntrega() {
		return FechaDeEntrega;
	}

	public void setFechaDeEntrega(Date fechaDeEntrega) {
		FechaDeEntrega = fechaDeEntrega;
	}

	public boolean getEntregado() {
		return Entregado;
	}

	public void setEntregado(Boolean entregado) {
		Entregado = entregado;
	}

	public String getNombreYApelliosDelCliente() {
		return NombreYApelliosDelCliente;
	}

	public void setNombreYApelliosDelCliente(String nombreYApelliosDelCliente) {
		NombreYApelliosDelCliente = nombreYApelliosDelCliente;
	}

	public int getNumeroDeCliente_Pedidos() {
		return NumeroDeCliente_Pedidos;
	}

	public void setNumeroDeCliente_Pedidos(int numeroDeCliente_Pedidos) {
		NumeroDeCliente_Pedidos = numeroDeCliente_Pedidos;
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE:
			return this.getNombreYApelliosDelCliente();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

	}

	@Override
	public Integer getIntegerProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO:
			return this.getNumeroDePedido();
		case PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO:
			return this.getNumeroDeCliente_Pedidos();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

	}

	@Override
	public Float getFloatProperty(String propiedad) {

		return null;
	}

	@Override
	public Double getDoubleProperty(String propiedad) {

		return null;
	}

	@Override
	public char getCharProperty(String propiedad) {

		return 0;
	}

	@Override
	public Date getDateProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO:
			return this.getFechaDePedido();
		case PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA:
			return this.getFechaDeEntrega();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

	}

	@Override
	public Boolean getBooleanProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_PEDIDOS_ENTREGADO:
			return this.getEntregado();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

	}

}
