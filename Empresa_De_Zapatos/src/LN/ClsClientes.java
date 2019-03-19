package LN;

import COMUN.ItfProperty;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DNI_NIF;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DIRECCION;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_PROVINCIA;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_TELEFONO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_EMAIL;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta En esta clase vamos a recoger los atributos de la tabla
 *         clientes.
 * 
 */
public class ClsClientes implements ItfProperty {

	/**
	 * Estos son los atributos de la tabla.
	 */
	private int NumeroDeCliente;
	private String NombreYApellidos;
	private String DNI_NIF;
	private String DireccionDeCliente;
	private String Provincia;
	private int Telefono;
	private String Email;

	/**
	 * Aqui generamos el constructor de la clase
	 * 
	 * @param numeroDeCliente
	 * @param nombreYApellidos
	 * @param dNI_NIF
	 * @param direccionDeCliente
	 * @param provincia
	 * @param telefono
	 * @param email
	 */
	public ClsClientes(int numeroDeCliente, String nombreYApellidos, String dNI_NIF, String direccionDeCliente,
			String provincia, int telefono, String email) {
		NumeroDeCliente = numeroDeCliente;
		NombreYApellidos = nombreYApellidos;
		DNI_NIF = dNI_NIF;
		DireccionDeCliente = direccionDeCliente;
		Provincia = provincia;
		Telefono = telefono;
		Email = email;
	}

	/**
	 * Ahora generamos los metodos getters y setters
	 * 
	 * @return
	 */
	public int getNumeroDeCliente() {
		return NumeroDeCliente;
	}

	public void setNumeroDeCliente(int numeroDeCliente) {
		NumeroDeCliente = numeroDeCliente;
	}

	public String getNombreYApellidos() {
		return NombreYApellidos;
	}

	public void setNombreYApellidos(String nombreYApellidos) {
		NombreYApellidos = nombreYApellidos;
	}

	public String getDNI_NIF() {
		return DNI_NIF;
	}

	public void setDNI_NIF(String dNI_NIF) {
		DNI_NIF = dNI_NIF;
	}

	public String getDireccionDeCliente() {
		return DireccionDeCliente;
	}

	public void setDireccionDeCliente(String direccionDeCliente) {
		DireccionDeCliente = direccionDeCliente;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * Metodos implementados de ItfProperty.
	 */
	@Override
	public String getStringProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS:
			return this.getNombreYApellidos();
		case PROPIEDAD_CLIENTE_DNI_NIF:
			return this.getDNI_NIF();
		case PROPIEDAD_CLIENTE_DIRECCION:
			return this.getDireccionDeCliente();
		case PROPIEDAD_CLIENTE_PROVINCIA:
			return this.getProvincia();
		case PROPIEDAD_CLIENTE_EMAIL:
			return this.getEmail();
		}
		return null;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {

		switch (propiedad) {
		case PROPIEDAD_CLIENTE_NUMERO:
			return this.getNumeroDeCliente();
		case PROPIEDAD_CLIENTE_TELEFONO:
			return this.getTelefono();
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
