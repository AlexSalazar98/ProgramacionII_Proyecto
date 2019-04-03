package LN;

import COMUN.ItfProperty;
import Excepciones.ClsExcepcionRuntime;

import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_CLIENTE;

/**
 * Esta clase recoge y crea los objetos para la entidad Desglose De Pedido.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 */

public class ClsDesgloseDePedido implements ItfProperty {

	/**
	 * Estos son los atributos.
	 */
	private int NumeroDePedido;
	private int ReferenciaDelArticulo;
	private int Serie;
	private int Color;
	private int NumeroDePie5;
	private int NumeroDePie6;
	private int NumeroDePie7;
	private int NumeroDePie8;
	private int NumeroDePie9;
	private int NumeroDePie0;
	private int NumeroDePie1;
	private int NumeroDePie2;
	private int NumeroDePie3;
	private int NumeroDePie4;
	private int CantidadTotal;
	private int NumeroDeCliente_Desglose;

	/**
	 * Este es el constructor de la clase Desglose De Pedidos.
	 * 
	 * @param numeroDePedido           parametro numero de pedido
	 * @param referenciaDelArticulo    parametro numero de referencia del articulo
	 * @param serie                    parametro numero de serie
	 * @param color                    parametro numero de color
	 * @param numeroDePie5             parametro cantidad del numero 5
	 * @param numeroDePie6             parametro cantidad del numero 6
	 * @param numeroDePie7             parametro cantidad del numero 7
	 * @param numeroDePie8             parametro cantidad del numero 8
	 * @param numeroDePie9             parametro cantidad del numero 9
	 * @param numeroDePie0             parametro cantidad del numero 0
	 * @param numeroDePie1             parametro cantidad del numero 1
	 * @param numeroDePie2             parametro cantidad del numero 2
	 * @param numeroDePie3             parametro cantidad del numero 3
	 * @param numeroDePie4             parametro cantidad del numero 4
	 * @param cantidadTotal            parametro cantidad total
	 * @param numeroDeCliente_Desglose parametro del numero del cliente.
	 */
	public ClsDesgloseDePedido(int numeroDePedido, int referenciaDelArticulo, int serie, int color, int numeroDePie5,
			int numeroDePie6, int numeroDePie7, int numeroDePie8, int numeroDePie9, int numeroDePie0, int numeroDePie1,
			int numeroDePie2, int numeroDePie3, int numeroDePie4, int cantidadTotal, int numeroDeCliente_Desglose) {
		NumeroDePedido = numeroDePedido;
		ReferenciaDelArticulo = referenciaDelArticulo;
		Serie = serie;
		Color = color;
		NumeroDePie5 = numeroDePie5;
		NumeroDePie6 = numeroDePie6;
		NumeroDePie7 = numeroDePie7;
		NumeroDePie8 = numeroDePie8;
		NumeroDePie9 = numeroDePie9;
		NumeroDePie0 = numeroDePie0;
		NumeroDePie1 = numeroDePie1;
		NumeroDePie2 = numeroDePie2;
		NumeroDePie3 = numeroDePie3;
		NumeroDePie4 = numeroDePie4;
		CantidadTotal = cantidadTotal;
		NumeroDeCliente_Desglose = numeroDeCliente_Desglose;
	}

	/**
	 * Estos son los metodos getters y setters.
	 * 
	 * @return nos genera unos returns
	 */
	public int getNumeroDePedido() {
		return NumeroDePedido;
	}

	public void setNumeroDePedido(int numeroDePedido) {
		NumeroDePedido = numeroDePedido;
	}

	public int getReferenciaDelArticulo() {
		return ReferenciaDelArticulo;
	}

	public void setReferenciaDelArticulo(int referenciaDelArticulo) {
		ReferenciaDelArticulo = referenciaDelArticulo;
	}

	public int getSerie() {
		return Serie;
	}

	public void setSerie(int serie) {
		Serie = serie;
	}

	public int getColor() {
		return Color;
	}

	public void setColor(int color) {
		Color = color;
	}

	public int getNumeroDePie5() {
		return NumeroDePie5;
	}

	public void setNumeroDePie5(int numeroDePie5) {
		NumeroDePie5 = numeroDePie5;
	}

	public int getNumeroDePie6() {
		return NumeroDePie6;
	}

	public void setNumeroDePie6(int numeroDePie6) {
		NumeroDePie6 = numeroDePie6;
	}

	public int getNumeroDePie7() {
		return NumeroDePie7;
	}

	public void setNumeroDePie7(int numeroDePie7) {
		NumeroDePie7 = numeroDePie7;
	}

	public int getNumeroDePie8() {
		return NumeroDePie8;
	}

	public void setNumeroDePie8(int numeroDePie8) {
		NumeroDePie8 = numeroDePie8;
	}

	public int getNumeroDePie9() {
		return NumeroDePie9;
	}

	public void setNumeroDePie9(int numeroDePie9) {
		NumeroDePie9 = numeroDePie9;
	}

	public int getNumeroDePie0() {
		return NumeroDePie0;
	}

	public void setNumeroDePie0(int numeroDePie0) {
		NumeroDePie0 = numeroDePie0;
	}

	public int getNumeroDePie1() {
		return NumeroDePie1;
	}

	public void setNumeroDePie1(int numeroDePie1) {
		NumeroDePie1 = numeroDePie1;
	}

	public int getNumeroDePie2() {
		return NumeroDePie2;
	}

	public void setNumeroDePie2(int numeroDePie2) {
		NumeroDePie2 = numeroDePie2;
	}

	public int getNumeroDePie3() {
		return NumeroDePie3;
	}

	public void setNumeroDePie3(int numeroDePie3) {
		NumeroDePie3 = numeroDePie3;
	}

	public int getNumeroDePie4() {
		return NumeroDePie4;
	}

	public void setNumeroDePie4(int numeroDePie4) {
		NumeroDePie4 = numeroDePie4;
	}

	public int getCantidadTotal() {
		return CantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		CantidadTotal = cantidadTotal;
	}

	public int getNumeroDeCliente_Desglose() {
		return NumeroDeCliente_Desglose;
	}

	public void setNumeroDeCliente_Desglose(int numeroDeCliente_Desglose) {
		NumeroDeCliente_Desglose = numeroDeCliente_Desglose;
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */

	@Override
	public String getStringProperty(String propiedad) {

		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO:
			return this.getNumeroDePedido();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO:
			return this.getReferenciaDelArticulo();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE:
			return this.getSerie();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR:
			return this.getColor();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5:
			return this.getNumeroDePie5();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6:
			return this.getNumeroDePie6();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7:
			return this.getNumeroDePie7();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8:
			return this.getNumeroDePie8();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9:
			return this.getNumeroDePie9();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0:
			return this.getNumeroDePie0();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1:
			return this.getNumeroDePie1();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2:
			return this.getNumeroDePie2();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3:
			return this.getNumeroDePie3();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4:
			return this.getNumeroDePie4();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL:
			return this.getCantidadTotal();
		case PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_CLIENTE:
			return this.getNumeroDeCliente_Desglose();

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

		return null;
	}

	@Override
	public Boolean getBooleanProperty(String propiedad) {

		return null;
	}

}
