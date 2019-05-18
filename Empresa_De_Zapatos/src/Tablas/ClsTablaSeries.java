package Tablas;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import COMUN.ItfProperty;
import LN.ClsGestorLN;

public class ClsTablaSeries extends AbstractTableModel {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Array Series
	 */
	ArrayList<ItfProperty> SeriesRecuperadas;

	private String[] NombreColumnas = { "Nº de Serie", "Descripción" };
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaSeries(ArrayList<ItfProperty> Series) {
		super();

		int filas = Series.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Series) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE),
					b.getStringProperty(PROPIEDAD_SERIES_DESCRIPCION), };
			data[cont] = a;
			cont++;
		}
	}

	public Object[][] setData(ClsGestorLN ObjGestor) {
		SeriesRecuperadas = ObjGestor.DameSeries();
		int filas = SeriesRecuperadas.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : SeriesRecuperadas) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE),
					b.getStringProperty(PROPIEDAD_SERIES_DESCRIPCION), };
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
