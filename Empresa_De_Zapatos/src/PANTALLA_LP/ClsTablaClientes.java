package PANTALLA_LP;

import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DIRECCION;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_DNI_NIF;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_EMAIL;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_NUMERO;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_PROVINCIA;
import static COMUN.ClsConstantes.PROPIEDAD_CLIENTE_TELEFONO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import COMUN.ItfProperty;


public class ClsTablaClientes extends AbstractTableModel {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;

	private String[] NombreColumnas = { "Numero de Cliente", "Nombre y Apellido", "DNI o NIF", "Direccion", "Provincia",
			"Telefono", "Email" };
	Object[][] data;

	/**
	 * 
	 */
	public ClsTablaClientes(ArrayList<ItfProperty> Clientes) {
		super();

		int filas = Clientes.size();
		int cont;
		data = new Object[filas][];
		cont = 0;

		for (ItfProperty b : Clientes) {
			Object[] a = { b.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_DNI_NIF) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_DIRECCION) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_PROVINCIA) + " "
					+ b.getIntegerProperty(PROPIEDAD_CLIENTE_TELEFONO) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_EMAIL), };
			data[cont] = a;
			cont++;
		}
	}
	
	
	public void setData(ArrayList<ItfProperty> Clientes) 
    {
    	int filas = Clientes.size();
		int cont;
		data=new Object[filas][];
		cont=0;
		
		
		for (ItfProperty b: Clientes)
		{
			Object[]a={b.getIntegerProperty(PROPIEDAD_CLIENTE_NUMERO) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_NOMBRE_Y_APELLIDOS) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_DNI_NIF) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_DIRECCION) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_PROVINCIA) + " "
					+ b.getIntegerProperty(PROPIEDAD_CLIENTE_TELEFONO) + " "
					+ b.getStringProperty(PROPIEDAD_CLIENTE_EMAIL),};
			data[cont]=a;
			cont++;
		}
    }

	 public int getColumnCount() 
	    {
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
	     * JTable uses this method to determine the default renderer/
	     * editor for each cell.  If we didn't implement this method,
	     * then the last column would contain text ("true"/"false"),
	     * rather than a check box.
	     */
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }

	    /*
	     * Don't need to implement this method unless your table's
	     * editable.
	     */
	    public boolean isCellEditable(int row, int col) {
	       
	            return false;
	       
	    }


}
