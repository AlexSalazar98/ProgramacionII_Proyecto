package LN;
/**
 * 
 *@author Alex Salazar
 *@author David Requeta
 *En esta clase generamos los objetos asignados a la entidad Pedido.
 *
 */

import java.util.Date;

public class ClsPedidos {

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

}
