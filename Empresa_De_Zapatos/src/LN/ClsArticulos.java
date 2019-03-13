package LN;
/**
 * 
 * @author Alex Salazar
 *@author David Requeta
 *Esta seria la clase donde generamos los objetos de la entidad Articulos.
 */
public class ClsArticulos {

	/**
	 * Estos son los atributos de la entidad Articulos.
	 */
	private int Referencia;
	private int Serie;
	private String Descripcion;
	private int CantidadMaterial;
	private int CantidadHerrajes;
	private double Precio;
	private int ReferenciaSuelas_Articulos;
	
	/**
	 * Este seria el constructor de la entidad Articulos.
	 * @param referencia
	 * @param serie
	 * @param descripcion
	 * @param cantidadMaterial
	 * @param cantidadHerrajes
	 * @param precio
	 * @param referenciaSuelas_Articulos
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
	 * @return
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

	public int getReferenciaSuelas_Desglose() {
		return ReferenciaSuelas_Articulos;
	}

	public void setReferenciaSuelas_Desglose(int referenciaSuelas_Desglose) {
		ReferenciaSuelas_Articulos = referenciaSuelas_Desglose;
	}

	
}
