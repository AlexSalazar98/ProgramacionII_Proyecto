package LN;
/**
 * 
 * @author Alex Salazar
 *@author David Requeta
 *Esta clase recoge y crea los objetos para la entidad Desglose De Pedido.
 */

public class ClsDesgloseDePedido {
	
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
	private int NumeroDeCliente_Desglose;
	
	
	/**
	 * Este es el constructor de la clase Desglose De Pedidos.
	 * @param numeroDePedido
	 * @param referenciaDelArticulo
	 * @param serie
	 * @param color
	 * @param numeroDePie5
	 * @param numeroDePie6
	 * @param numeroDePie7
	 * @param numeroDePie8
	 * @param numeroDePie9
	 * @param numeroDePie0
	 * @param numeroDePie1
	 * @param numeroDePie2
	 * @param numeroDePie3
	 * @param numeroDePie4
	 * @param numeroDeCliente_Desglose
	 */
	public ClsDesgloseDePedido(int numeroDePedido, int referenciaDelArticulo, int serie, int color, int numeroDePie5,
			int numeroDePie6, int numeroDePie7, int numeroDePie8, int numeroDePie9, int numeroDePie0, int numeroDePie1,
			int numeroDePie2, int numeroDePie3, int numeroDePie4, int numeroDeCliente_Desglose ) {
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
		NumeroDeCliente_Desglose = numeroDeCliente_Desglose;
	}


	/**
	 * Estos son los metodos getters y setters.
	 * @return
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


	public int getNumeroDeCliente_Desglose() {
		return NumeroDeCliente_Desglose;
	}


	public void setNumeroDeCliente_Desglose(int numeroDeCliente_Desglose) {
		NumeroDeCliente_Desglose = numeroDeCliente_Desglose;
	}

	
}
