package LN;

import java.util.Date;

/**
 * Clase de gestion entre LN y LP
 * @author Alex Salazar
 *@author David Requeta
 *En esta clase relacionamos las clases de los paquetes LP Y LN.
 *
 */

public class ClsGestorLN {

	/**
	 * Aqui generaremos todo en relacion al Gestor.
	 */
	public ClsGestorLN() {
		
	}

	/**
	 * Metodo para crear objetos suela.
	 * @param Referencia_Suelas
	 * @param Descripcion_Suelas
	 * @param Precio_Suelas
	 */
	public void CrearSuelas(int Referencia_Suelas, String Descripcion_Suelas, Double Precio_Suelas) {	
		
		ClsMateriasPrimas objSuelas;
		objSuelas = new ClsMateriasPrimas(Referencia_Suelas, Descripcion_Suelas, Precio_Suelas);
		
	}
	
	/**
	 * Metodo para crear series.
	 * @param NumeroDeSerie
	 * @param Descripcion_Serie
	 */
	public void CrearSerie(int NumeroDeSerie, String Descripcion_Serie) {
		
		ClsSeries objSeries;
		objSeries = new ClsSeries(NumeroDeSerie, Descripcion_Serie);
		
	}
	
	public void CrearPedidos(int NumeroDePedido, Date FechaDePedido, Date FechaDeEntrega, int Entregado, int NumeroDeCliente_Pedidos, String NombreYApelliosDelCliente) {
		
		ClsPedidos objPedido;
		objPedido = new ClsPedidos(NumeroDePedido, FechaDePedido, FechaDeEntrega, Entregado, NombreYApelliosDelCliente, NumeroDeCliente_Pedidos);
	}
	
	
}
