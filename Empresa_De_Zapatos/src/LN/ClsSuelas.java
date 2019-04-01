package LN;

import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_PRECIO;

/**
 * En esta clase vamos a recoger los atributos de la tabla suelas.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 * 
 */

public class ClsSuelas extends ClsMateriasPrimas {

	/**
	 * 
	 * Este es el constructor de la entidad suelas con herencia de la clase
	 * MateriasPrimas.
	 * 
	 * @param referencia  prametro referencia
	 * @param descripcion parametro descripcion
	 * @param precio      parametro precio
	 * 
	 */
	public ClsSuelas(int referencia, String descripcion, double precio) {
		super(referencia, descripcion, precio);
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_SUELAS_DESCRIPCION:
			return this.getDescripcion();
		}

		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_SUELAS_REFERENCIA:
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
		case PROPIEDAD_SUELAS_PRECIO:
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
