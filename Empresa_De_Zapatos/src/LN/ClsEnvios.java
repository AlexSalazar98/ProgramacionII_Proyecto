package LN;

import COMUN.ItfProperty;
import Excepciones.ClsExcepcionRuntime;

import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NOMBRE_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_CPD_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO;

import java.util.Date;

import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO;

/**
 * En esta clase vamos a recoger los atributos de la tabla envios.
 * 
 * @author Alex Salazar
 * @author David Requeta
 * 
 */

@SuppressWarnings("rawtypes")
public class ClsEnvios implements ItfProperty, Comparable {

	/**
	 * Estos son los atributos de la tablas
	 */
	private int NumeroDeEnvio;
	private String NombreCliente;
	private String DireccionDeEnvio;
	private String PoblacionDeEnvio;
	private int CPDeEnvio;
	private String ProvinciaDeEnvio;
	private int TelefonoDeEnvio;
	private int NumeroDeCliente_Envio;

	/**
	 * Aqui generamos el constructor de la clase
	 * 
	 * @param numeroDeEnvio         parametro numero de envio
	 * @param nombreCliente         parametro nombre del cliente
	 * @param direccionDeEnvio      parametro direccion de envio
	 * @param poblacionDeEnvio      parametro poblacion de envio
	 * @param cPDeEnvio             parametro codigo postal de envio
	 * @param provinciaDeEnvio      parametro provincia de envio
	 * @param telefonoDeEnvio       parametro telefono de envio
	 * @param numeroDeCliente_Envio parametro numero de cliente.
	 */
	public ClsEnvios(int numeroDeEnvio, String nombreCliente, String direccionDeEnvio, String poblacionDeEnvio,
			int cPDeEnvio, String provinciaDeEnvio, int telefonoDeEnvio, int numeroDeCliente_Envio) {
		NumeroDeEnvio = numeroDeEnvio;
		NombreCliente = nombreCliente;
		DireccionDeEnvio = direccionDeEnvio;
		PoblacionDeEnvio = poblacionDeEnvio;
		CPDeEnvio = cPDeEnvio;
		ProvinciaDeEnvio = provinciaDeEnvio;
		TelefonoDeEnvio = telefonoDeEnvio;
		NumeroDeCliente_Envio = numeroDeCliente_Envio;
	}

	/**
	 * Ahora generamos los metodos getters y setters
	 * 
	 * @return nos genera unos returns
	 */
	public int getNumeroDeEnvio() {
		return NumeroDeEnvio;
	}

	public void setNumeroDeEnvio(int numeroDeEnvio) {
		NumeroDeEnvio = numeroDeEnvio;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public String getDireccionDeEnvio() {
		return DireccionDeEnvio;
	}

	public void setDireccionDeEnvio(String direccionDeEnvio) {
		DireccionDeEnvio = direccionDeEnvio;
	}

	public String getPoblacionDeEnvio() {
		return PoblacionDeEnvio;
	}

	public void setPoblacionDeEnvio(String poblacionDeEnvio) {
		PoblacionDeEnvio = poblacionDeEnvio;
	}

	public int getCPDeEnvio() {
		return CPDeEnvio;
	}

	public void setCPDeEnvio(int cPDeEnvio) {
		CPDeEnvio = cPDeEnvio;
	}

	public String getProvinciaDeEnvio() {
		return ProvinciaDeEnvio;
	}

	public void setProvinciaDeEnvio(String provinciaDeEnvio) {
		ProvinciaDeEnvio = provinciaDeEnvio;
	}

	public int getTelefonoDeEnvio() {
		return TelefonoDeEnvio;
	}

	public void setTelefonoDeEnvio(int telefonoDeEnvio) {
		TelefonoDeEnvio = telefonoDeEnvio;
	}

	public int getNumeroDeCliente_Envio() {
		return NumeroDeCliente_Envio;
	}

	public void setNumeroDeCliente_Envio(int numeroDeCliente_Envio) {
		NumeroDeCliente_Envio = numeroDeCliente_Envio;
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_ENVIOS_NOMBRE_CLIENTE:
			return this.getNombreCliente();
		case PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO:
			return this.getDireccionDeEnvio();
		case PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO:
			return this.getPoblacionDeEnvio();
		case PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO:
			return this.getProvinciaDeEnvio();

		default:
			throw new ClsExcepcionRuntime(propiedad);
		}
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO:
			return this.getNumeroDeEnvio();
		case PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO:
			return this.getTelefonoDeEnvio();
		case PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO:
			return this.getNumeroDeCliente_Envio();
		case PROPIEDAD_ENVIOS_CPD_DE_ENVIO:
			return this.getCPDeEnvio();

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
	 * Implementacion del metodo HashCode para comprobar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NumeroDeEnvio;
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
		ClsEnvios other = (ClsEnvios) obj;
		if (NumeroDeEnvio != other.NumeroDeEnvio)
			return false;
		return true;
	}

	/**
	 * Implementacion de metodo CompareTo para ordenar.
	 */
	@Override
	public int compareTo(Object arg0) {

		String Nombre;
		ClsEnvios objEnv;

		Nombre = NombreCliente;

		if (arg0 == null)
			throw new NullPointerException();
		if (arg0.getClass() != this.getClass())
			throw new ClassCastException();

		objEnv = (ClsEnvios) arg0;

		return Nombre.compareTo(objEnv.getNombreCliente());
	}

}
