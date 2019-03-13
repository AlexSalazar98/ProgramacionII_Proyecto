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
	private Date FechaDePedido;
	private Date FechaDeEntrega;
	private String Entregado;
	private String NombreYApelliosDelCliente;
	private int NumeroDeCliente_Pedidos;
	
	/**
	 * 
	 * Este seria el constructor de la clase Pedidos.
	 * @param fechaDePedido
	 * @param fechaDeEntrega
	 * @param entregado
	 * @param nombreYApelliosDelCliente
	 * @param numeroDeCliente_Pedidos
	 * 
	 */
	public ClsPedidos(Date fechaDePedido, Date fechaDeEntrega, String entregado, String nombreYApelliosDelCliente, int numeroDeCliente_Pedidos) {
		FechaDePedido = fechaDePedido;
		FechaDeEntrega = fechaDeEntrega;
		Entregado = entregado;
		NombreYApelliosDelCliente = nombreYApelliosDelCliente;
		NumeroDeCliente_Pedidos = numeroDeCliente_Pedidos;
	}

	/**
	 * 
	 * Estos son lo metodos getters y setters.
	 * @return
	 * 
	 */
	public Date getFechaDePedido() {
		return FechaDePedido;
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

	public String getEntregado() {
		return Entregado;
	}

	public void setEntregado(String entregado) {
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
