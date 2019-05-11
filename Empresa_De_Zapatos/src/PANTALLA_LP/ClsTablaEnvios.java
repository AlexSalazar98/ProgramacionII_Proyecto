package PANTALLA_LP;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NOMBRE_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_CPD_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO;
import static COMUN.ClsConstantes.PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO;
import COMUN.ItfProperty;
import LN.ClsGestorLN;

/**
 * Clase para formar la tabla Envios
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsTablaEnvios extends AbstractTableModel {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Array Envios
	 */
	ArrayList<ItfProperty> EnviosRecuperados;

	private String[] NombreColumnas = { "Nº Envio", "Nombre Cliente", "Direccion Envio", "Poblacion Envio",
			"CP Envio", "Provincia Envio", "Telefono Envio", "Nº Cliente Envio" };
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaEnvios(ArrayList<ItfProperty> Envios) {
		super();

		int filas = Envios.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Envios) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO),
					b.getStringProperty(PROPIEDAD_ENVIOS_NOMBRE_CLIENTE),
					b.getStringProperty(PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO),
					b.getStringProperty(PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO),
					b.getIntegerProperty(PROPIEDAD_ENVIOS_CPD_DE_ENVIO),
					b.getStringProperty(PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO),
					b.getIntegerProperty(PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO),
					b.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO),};
			data[cont] = a;
			cont++;
		}
	}

	public Object[][] setData(ClsGestorLN ObjGestor) {
		EnviosRecuperados = ObjGestor.DameEnvios();
		int filas =EnviosRecuperados.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : EnviosRecuperados) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_ENVIO),
					b.getStringProperty(PROPIEDAD_ENVIOS_NOMBRE_CLIENTE),
					b.getStringProperty(PROPIEDAD_ENVIOS_DIRECCION_DE_ENVIO),
					b.getStringProperty(PROPIEDAD_ENVIOS_POBLACION_DE_ENVIO),
					b.getIntegerProperty(PROPIEDAD_ENVIOS_CPD_DE_ENVIO),
					b.getStringProperty(PROPIEDAD_ENVIOS_PROVINCIA_DE_ENVIO),
					b.getIntegerProperty(PROPIEDAD_ENVIOS_TELEFONO_DE_ENVIO),
					b.getIntegerProperty(PROPIEDAD_ENVIOS_NUMERO_DE_CLIENTE_ENVIO),};
			data[cont] = a;
			cont++;
		}

		return data;
	}

	public int getColumnCount() {
		return NombreColumnas.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return NombreColumnas[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for each
	 * cell. If we didn't implement this method, then the last column would contain
	 * text ("true"/"false"), rather than a check box.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {

		return false;

	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void setValueAt(Object value, int row, int col) {

		data[row][col] = value;
		fireTableCellUpdated(row, col);

	}

}
