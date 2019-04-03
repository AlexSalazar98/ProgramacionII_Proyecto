package LN;

import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_REFERENCIA;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_PRECIO;

/**
 * En esta clase vamos a recoger los atributos de la tabla materiales.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 * 
 */

public class ClsMateriales extends ClsMateriasPrimas {

	/**
	 * 
	 * Este es el contructor de la entidad Materiales con herencia de la clase
	 * Materias Primas.
	 * 
	 * @param referencia  parametro referencia.
	 * @param descripcion parametro descripcion.
	 * @param precio      parametro precio.
	 * 
	 */
	public ClsMateriales(int referencia, String descripcion, double precio) {
		super(referencia, descripcion, precio);
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_MATERIALES_DESCRIPCION:
			return this.getDescripcion();
		}
		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_MATERIALES_REFERENCIA:
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
		case PROPIEDAD_MATERIALES_PRECIO:
			return this.getPrecio();

		}
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
