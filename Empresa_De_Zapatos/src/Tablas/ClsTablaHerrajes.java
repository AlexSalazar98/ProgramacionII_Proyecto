package Tablas;



import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_PRECIO;
import COMUN.ItfProperty;
import LN.ClsGestorLN;

/**
 * Clase para formar la tabla Herrajes
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsTablaHerrajes extends AbstractTableModel {
	

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Array Herrajes
	 */
	ArrayList<ItfProperty> HerrajesRecuperados;

	private String[] NombreColumnas = { "Referencia", "Descripción" , "Precio"};
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaHerrajes(ArrayList<ItfProperty> Herrajes) {
		super();

		int filas = Herrajes.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Herrajes) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_HERRAJES_REFERENCIA),
					b.getStringProperty(PROPIEDAD_HERRAJES_DESCRIPCION),
					b.getDoubleProperty(PROPIEDAD_HERRAJES_PRECIO),};
			data[cont] = a;
			cont++;
		}
	}

	public Object[][] setData(ClsGestorLN ObjGestor) {
		HerrajesRecuperados = ObjGestor.DameHerrajes();
		int filas =HerrajesRecuperados.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : HerrajesRecuperados) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_HERRAJES_REFERENCIA),
					b.getStringProperty(PROPIEDAD_HERRAJES_DESCRIPCION),
					b.getDoubleProperty(PROPIEDAD_HERRAJES_PRECIO),};
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
