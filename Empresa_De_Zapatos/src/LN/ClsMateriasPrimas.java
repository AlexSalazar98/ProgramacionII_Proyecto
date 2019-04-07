package LN;

import COMUN.ItfProperty;

/**
 * Esta clase nos da los atributos padre para las herencias de las clases
 * "Materiales, Herrajes, Suelas".
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 *
 */
public abstract class ClsMateriasPrimas implements ItfProperty {

	/**
	 * 
	 * Estos son los atributos comunes.
	 * 
	 */
	private int Referencia;
	private String Descripcion;
	private double Precio;

	/**
	 * 
	 * Este seria el constructor de la clase.
	 * 
	 * @param referencia  prametro referencia
	 * @param descripcion parametro descripcion
	 * @param precio      parametro precio
	 * 
	 */
	public ClsMateriasPrimas(int referencia, String descripcion, double precio) {
		super();
		Referencia = referencia;
		Descripcion = descripcion;
		Precio = precio;
	}

	/**
	 * 
	 * A partir de aqui tendriamos los metodos getters y setters.
	 * 
	 * @return nos genera un return
	 * 
	 */
	public int getReferencia() {
		return Referencia;
	}

	public void setReferencia(int referencia) {
		Referencia = referencia;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	/**
	 * Metodos HashCode y equals implementados para el chequeo de objetos repetidoss
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Referencia;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClsMateriasPrimas other = (ClsMateriasPrimas) obj;
		if (Referencia != other.Referencia)
			return false;
		return true;
	}

}
