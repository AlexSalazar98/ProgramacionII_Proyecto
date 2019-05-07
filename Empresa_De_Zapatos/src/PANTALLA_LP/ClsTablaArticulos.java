package PANTALLA_LP;

import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_PRECIO;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_REFERENCIA_SUELAS;
import static COMUN.ClsConstantes.PROPIEDAD_ARTICULO_SERIE;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import COMUN.ItfProperty;

/**
 * Clase para crear tablas de articulos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsTablaArticulos extends AbstractTableModel {
	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;

	private String[] NombreColumnas = { "Referencia", "Nº Serie", "Descripcion", "Cantidad Material", "Cantidad Herrajes",
			"Precio", "Ref. Suela" };
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaArticulos(ArrayList<ItfProperty> Articulos) {
		super();

		int filas = Articulos.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Articulos) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_SERIE), 
					b.getStringProperty(PROPIEDAD_ARTICULO_DESCRIPCION),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES),
					b.getDoubleProperty(PROPIEDAD_ARTICULO_PRECIO),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA_SUELAS), };
			data[cont] = a;
			cont++;
		}
	}

	public void setData(ArrayList<ItfProperty> Articulos) {
		int filas = Articulos.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Articulos) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_SERIE), b.getStringProperty(PROPIEDAD_ARTICULO_DESCRIPCION),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_MATERIAL),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_CANTIDAD_DE_HERRAJES),
					b.getDoubleProperty(PROPIEDAD_ARTICULO_PRECIO),
					b.getIntegerProperty(PROPIEDAD_ARTICULO_REFERENCIA_SUELAS), };
			data[cont] = a;
			cont++;
		}
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
