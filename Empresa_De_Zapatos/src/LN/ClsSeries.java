package LN;

/**
 * 
 * @author Alex Salazar, David Requeta.
 * @author David Requeta 
 * En esta clase vamos a recoger los atributos de la tabla series.
 *         
 */
public class ClsSeries {

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

}
