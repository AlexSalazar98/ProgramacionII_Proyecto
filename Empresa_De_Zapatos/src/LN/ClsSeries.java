package LN;

import COMUN.ItfProperty;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_DESCRIPCION;


/**
 * 
 * @author Alex Salazar, David Requeta.
 * @author David Requeta En esta clase vamos a recoger los atributos de la tabla
 *         series.
 * 
 */
public class ClsSeries implements ItfProperty {

	/**
	 * 
	 * Estos son los atributos de la clase
	 * 
	 */
	private int NumeroDeSerie;
	private String Descripcion;

	/**
	 * 
	 * Aqui generamos el constructor de la clase
	 * 
	 * @param numeroDeSerie
	 * @param descripcion
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
	 * @return
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
		}
		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_SERIES_NUMERO_DE_SERIE:
			return this.getNumeroDeSerie();
		}
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
