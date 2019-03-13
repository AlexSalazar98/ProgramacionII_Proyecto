package LN;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta 
 * En esta clase vamos a recoger los atributos de la tabla envios.
 *         
 */

public class ClsEnvios {

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
	 *  Aqui generamos el constructor de la clase
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
	
	
}
