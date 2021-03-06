package LN;

import COMUN.ItfProperty;
import Excepciones.ClsExcepcionRuntime;

import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_SERIE;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_PRECIO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA_SUELAS;

/**
 * Esta seria la clase donde generamos los objetos de la entidad Articulos.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 */
public class ClsArticulos implements ItfProperty {

	/**
	 * Atributo para recoger la referencia
	 */
	private int Referencia;
	/**
	 * Atributo para recoger el numero de serie
	 */
	private int Serie;
	/**
	 * Atributo para recoger la descripcion
	 */
	private String Descripcion;
	/**
	 * Atributo para recoger la cantidad de materiales
	 */
	private int CantidadMaterial;
	/*
	 * Atributo para recoger la cantidad de herrajes
	 */
	private int CantidadHerrajes;
	/**
	 * Atributo para recoger el precio
	 */
	private double Precio;
	/**
	 * Atributo heredado de la tabla suelas (Referencia de la suela)
	 */
	private int ReferenciaSuelas_Articulos;

	/**
	 * Este seria el constructor de la entidad Articulos.
	 * 
	 * @param referencia                 parametro referencia
	 * @param serie                      parametro serie
	 * @param descripcion                parametro descripcion
	 * @param cantidadMaterial           parametro cantidad de material
	 * @param cantidadHerrajes           parametro cantidad de herrajes
	 * @param precio                     parametro precio
	 * @param referenciaSuelas_Articulos parametro referencia de la suela
	 */
	public ClsArticulos(int referencia, int serie, String descripcion, int cantidadMaterial, int cantidadHerrajes,
			double precio, int referenciaSuelas_Articulos) {
		Referencia = referencia;
		Serie = serie;
		Descripcion = descripcion;
		CantidadMaterial = cantidadMaterial;
		CantidadHerrajes = cantidadHerrajes;
		Precio = precio;
		ReferenciaSuelas_Articulos = referenciaSuelas_Articulos;
	}

	/**
	 * Estos serian los metodos getters y setters de la clase.
	 * 
	 * @return nos genera unos returns
	 */
	public int getReferencia() {
		return Referencia;
	}

	public void setReferencia(int referencia) {
		Referencia = referencia;
	}

	public int getSerie() {
		return Serie;
	}

	public void setSerie(int serie) {
		Serie = serie;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getCantidadMaterial() {
		return CantidadMaterial;
	}

	public void setCantidadMaterial(int cantidadMaterial) {
		CantidadMaterial = cantidadMaterial;
	}

	public int getCantidadHerrajes() {
		return CantidadHerrajes;
	}

	public void setCantidadHerrajes(int cantidadHerrajes) {
		CantidadHerrajes = cantidadHerrajes;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getReferenciaSuelas_Articulo() {
		return ReferenciaSuelas_Articulos;
	}

	public void setReferenciaSuelas_Articulo(int referenciaSuelas_Articulo) {
		ReferenciaSuelas_Articulos = referenciaSuelas_Articulo;
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_ARTICULO_DESCRIPCION:
			return this.getDescripcion();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

	}

	@Override
	public Integer getIntegerProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_ARTICULO_REFERENCIA:
			return this.getReferencia();
		case PROPIEDAD_ARTICULO_SERIE:
			return this.getSerie();
		case PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL:
			return this.getCantidadMaterial();
		case PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES:
			return this.getCantidadHerrajes();
		case PROPIEDAD_ARTICULO_REFERENCIA_SUELAS:
			return this.getReferenciaSuelas_Articulo();

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

		switch (propiedad) {
		case PROPIEDAD_ARTICULO_PRECIO:
			return this.getPrecio();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}

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
	 * Implementacion del metodo HashCode para comprobar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Referencia;
		return result;
	}

	/**
	 * Implementacion de metodo Equals para comprobar.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClsArticulos other = (ClsArticulos) obj;
		if (Referencia != other.Referencia)
			return false;
		return true;
	}

}
