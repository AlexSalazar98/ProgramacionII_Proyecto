package LN;

import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_PRECIO;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta En esta clase vamos a recoger los atributos de la tabla
 *         herrajes.
 * 
 */

public class ClsHerrajes extends ClsMateriasPrimas {

	/**
	 * Este es el constructor de la entidad Herrajes con herencia de la clase
	 * Materias Primas.
	 * 
	 * @param referencia
	 * @param descripcion
	 * @param precio
	 * 
	 */
	public ClsHerrajes(int referencia, String descripcion, double precio) {
		super(referencia, descripcion, precio);
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_HERRAJES_DESCRIPCION:
			return this.getDescripcion();
		}
		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_HERRAJES_REFERENCIA:
			return this.getReferencia();
		}
		return null;
	}

	@Override
	public Float getFloatProperty(String propiedad) {

		return null;
	}

	@Override
	public Double getDoubleProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_HERRAJES_PRECIO:
			return this.getPrecio();
		}
		return null;
	}

	@Override
	public char getCharProperty(String propiedad) {

		return 0;
	}

}
