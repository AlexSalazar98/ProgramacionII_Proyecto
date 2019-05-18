package Tablas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4;
import static COMUN.ClsConstantes.PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL;
import COMUN.ItfProperty;
import LN.ClsGestorLN;

/**
 * Clase para formar la tabla Desgloses
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsTablaDesgloses extends AbstractTableModel {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Array Desgloses
	 */
	ArrayList<ItfProperty> DesglosesRecuperados;

	private String[] NombreColumnas = { "Nº Desglose", "Serie", "Color", "Referencia Articulo", "Nº Pedido", "Nº Pie 5",
			"Nº Pie 6", "Nº Pie 7", "Nº Pie 8", "Nº Pie 9", "Nº Pie 0", "Nº Pie 1", "Nº Pie 2", "Nº Pie 3", "Nº Pie 4",
			"Cantidad Total", };
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaDesgloses(ArrayList<ItfProperty> Desgloses) {
		super();

		int filas = Desgloses.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Desgloses) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL), };
			data[cont] = a;
			cont++;
		}
	}

	public Object[][] setData(ClsGestorLN ObjGestor) {
		DesglosesRecuperados = ObjGestor.DameDesgloses();
		int filas = DesglosesRecuperados.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : DesglosesRecuperados) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_DESGLOSE),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_SERIE),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_COLOR),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_REFERENCIA_DEL_ARTICULO),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PEDIDO),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_5),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_6),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_7),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_8),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_9),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_0),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_1),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_2),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_3),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_NUMERO_DE_PIE_4),
					b.getIntegerProperty(PROPIEDAD_DESGLOSE_DE_PEDIDO_CANTIDAD_TOTAL), };
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
