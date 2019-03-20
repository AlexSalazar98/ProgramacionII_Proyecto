package LN;
/**
 * 
 *@author Alex Salazar
 *@author David Requeta
 *En esta clase generamos los objetos asignados a la entidad Pedido.
 *
 */

import java.util.Date;
import COMUN.ItfProperty;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_ENTREGADO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;

public class ClsPedidos implements ItfProperty {

	/**
	 * 
	 * Estos son los atributos de la entidad Pedidos.
	 * 
	 */
	private int NumeroDePedido;
	private Date FechaDePedido;
	private Date FechaDeEntrega;
	private int Entregado;
	private int NumeroDeCliente_Pedidos;
	private String NombreYApelliosDelCliente;

	/**
	 * 
	 * Este seria el constructor de la clase Pedidos.
	 * 
	 * @param fechaDePedido
	 * @param fechaDeEntrega
	 * @param entregado
	 * @param nombreYApelliosDelCliente
	 * @param numeroDeCliente_Pedidos
	 * 
	 */
	public ClsPedidos(int numeroDePedido, Date fechaDePedido, Date fechaDeEntrega, int entregado,
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
	 * @return
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

	public int getEntregado() {
		return Entregado;
	}

	public void setEntregado(int entregado) {
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
		}
		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO:
			return this.getNumeroDePedido();
		case PROPIEDAD_PEDIDOS_ENTREGADO:
			return this.getEntregado();
		case PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO:
			return this.getNumeroDeCliente_Pedidos();
		}
		return null;
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
		}
		return null;
	}

}
