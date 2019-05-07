package PANTALLA_LP;

import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_ENTREGADO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO;
import static COMUN.ClsConstantes.PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import COMUN.ItfProperty;

/**
 * Clase para crear tabla de Pedidos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsTablaPedidos extends AbstractTableModel {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;

	private String[] NombreColumnas = { "Nº de Pedido", "Fecha de Pedido", "Fecha de Pedido", "Estado", "Nombre y Apellidos Cliente",
			"Nº Cliente"};
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaPedidos(ArrayList<ItfProperty> Pedidos) {
		super();

		SimpleDateFormat MiFormato = new SimpleDateFormat("dd-MM-yyyy");
		String Entregado;
		int filas = Pedidos.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Pedidos) {

			if (b.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO)) {
				Entregado = "Entregado";
			} else {
				Entregado = "No entregado";
			}

			Object[] a = { b.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO),
					MiFormato.format(b.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO)),
					MiFormato.format(b.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA)), Entregado,
					b.getStringProperty(PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE),
					b.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO), };
			data[cont] = a;
			cont++;
		}
	}

	public void setData(ArrayList<ItfProperty> Pedidos) {

		SimpleDateFormat MiFormato = new SimpleDateFormat("dd-MM-yyyy");
		String Entregado;
		int filas = Pedidos.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Pedidos) {

			if (b.getBooleanProperty(PROPIEDAD_PEDIDOS_ENTREGADO)) {
				Entregado = "Entregado";
			} else {
				Entregado = "No entregado";
			}

			Object[] a = { b.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_PEDIDO),
					MiFormato.format(b.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_PEDIDO)),
					MiFormato.format(b.getDateProperty(PROPIEDAD_PEDIDOS_FECHA_DE_ENTREGA)), Entregado,
					b.getStringProperty(PROPIEDAD_PEDIDOS_NOMBRE_Y_APELLIDOS_DEL_CLIENTE),
					b.getIntegerProperty(PROPIEDAD_PEDIDOS_NUMERO_DE_CLIENTE_PEDIDO), };
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
