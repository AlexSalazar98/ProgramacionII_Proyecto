package LN;

import COMUN.ItfProperty;
import Excepciones.ClsExcepcionRuntime;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_DESCRIPCION;

/**
 * En esta clase vamos a recoger los atributos de la tabla series.
 * 
 * @author Alex Salazar, David Requeta.
 * @author David Requeta
 * 
 * 
 */
public class ClsSeries implements ItfProperty {

	/**
	 * Atributo para recoger el numero de la serie
	 */
	private int NumeroDeSerie;
	/**
	 * Atributo para recoger la descripcion
	 */
	private String Descripcion;

	/**
	 * 
	 * Aqui generamos el constructor de la clase
	 * 
	 * @param numeroDeSerie parametro numero de serie
	 * @param descripcion   parametro descripcion
	 * 
	 */
	public ClsSeries(int numeroDeSerie, String descripcion) {
		NumeroDeSerie = numeroDeSerie;
		Descripcion = descripcion;
	}

	/**
	 * 
	 * Ahora generamos los metodos getters y setters
	 * 
	 * @return nos genera unos return.
	 * 
	 */
	public int getNumeroDeSerie() {
		return NumeroDeSerie;
	}

	public void setNumeroDeSerie(int numeroDeSerie) {
		NumeroDeSerie = numeroDeSerie;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_SERIES_DESCRIPCION:
			return this.getDescripcion();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_SERIES_NUMERO_DE_SERIE:
			return this.getNumeroDeSerie();

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

	/**
	 * Anadidos metodos hashCode e Equals para las comparaciones de datos.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NumeroDeSerie;
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
		ClsSeries other = (ClsSeries) obj;
		if (NumeroDeSerie != other.NumeroDeSerie)
			return false;
		return true;
	}

}
