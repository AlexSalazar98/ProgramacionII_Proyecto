package LN;

import COMUN.ItfProperty;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NOMBRE_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_CPD_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta En esta clase vamos a recoger los atributos de la tabla
 *         envios.
 * 
 */

public class ClsEnvios implements ItfProperty {

	/**
	 * Estos son los atributos de la tablas
	 */
	private int NumeroDeEnvio;
	private String NombreCliente;
	private String DireccionDeEnvio;
	private String PoblacionDeEnvio;
	private String CPDeEnvio;
	private String ProvinciaDeEnvio;
	private int TelefonoDeEnvio;
	private int NumeroDeCliente_Envio;

	/**
	 * Aqui generamos el constructor de la clase
	 * 
	 * @param numeroDeEnvio
	 * @param nombreCliente
	 * @param direccionDeEnvio
	 * @param poblacionDeEnvio
	 * @param cPDeEnvio
	 * @param provinciaDeEnvio
	 * @param telefonoDeEnvio
	 * @param numeroDeCliente_Envio
	 */
	public ClsEnvios(int numeroDeEnvio, String nombreCliente, String direccionDeEnvio, String poblacionDeEnvio,
			String cPDeEnvio, String provinciaDeEnvio, int telefonoDeEnvio, int numeroDeCliente_Envio) {
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
	 * @return
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

	public String getCPDeEnvio() {
		return CPDeEnvio;
	}

	public void setCPDeEnvio(String cPDeEnvio) {
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
		case PROPIEDAD_ENVIOS_CPD_DE_ENVIO:
			return this.getCPDeEnvio();
		case PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO:
			return this.getProvinciaDeEnvio();
		}
		return null;
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

}
