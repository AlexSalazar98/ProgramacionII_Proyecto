package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import LN.ClsGestorLN;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import static COMUN.ClsConstantes.PROPIEDAD_HERRAJES_REFERENCIA;

import java.awt.Font;
import javax.swing.SwingConstants;

import COMUN.ItfProperty;


/**
 * Internal Frame para introducir Herrajes
 * 
 * @author Alex Salazar
 * @author David Requeta
 */
public class ClsIFIntroducirHerrajes extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objetos
	 */
	private JTextField CasillaNHerraje;
	private JTextField CasillaDesHerraje;
	private JTextField CasillaPrecioHerraje;
	private JButton NHerrajeAuto, ConfirmarHerraje;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIH;
	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Series";
	private final String AUTOMATICO_BUTTON = "Boton para poner automatico el ID";

	/**
	 * Creamos el frame
	 * 
	 * @param ObjGestor recibimos el gestor
	 */
	public ClsIFIntroducirHerrajes(ClsGestorLN ObjGestor) {
		setResizable(false);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Introducir Herrajes");
		this.setBounds(0, 0, 600, 300);
		getContentPane().setLayout(new GridLayout(4, 3));

		Inicializar(ObjGestor);
	}

	/**
	 * Creamos lo objetos del frame
	 * 
	 * @param ObjGestor recibimos el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {
		JLabel TxtNHerraje = new JLabel("Numero de Herraje:");
		TxtNHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNHerraje.setEnabled(false);
		getContentPane().add(TxtNHerraje);

		CasillaNHerraje = new JTextField();
		CasillaNHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		CasillaNHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(CasillaNHerraje);
		CasillaNHerraje.setColumns(10);

		NHerrajeAuto = new JButton("N\u00BA Herraje Automatico");
		NHerrajeAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(NHerrajeAuto);
		NHerrajeAuto.addActionListener(this);
		NHerrajeAuto.setActionCommand(AUTOMATICO_BUTTON);

		JLabel TextDesHerraje = new JLabel("Descripcion:");
		TextDesHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		TextDesHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		TextDesHerraje.setEnabled(false);
		getContentPane().add(TextDesHerraje);

		CasillaDesHerraje = new JTextField();
		CasillaDesHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		CasillaDesHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(CasillaDesHerraje);
		CasillaDesHerraje.setColumns(10);

		JLabel Vacio1 = new JLabel("");
		Vacio1.setEnabled(false);
		getContentPane().add(Vacio1);

		JLabel TxtPrecioHerraje = new JLabel("Precio:");
		TxtPrecioHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtPrecioHerraje.setEnabled(false);
		TxtPrecioHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtPrecioHerraje);

		CasillaPrecioHerraje = new JTextField();
		CasillaPrecioHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		CasillaPrecioHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(CasillaPrecioHerraje);
		CasillaPrecioHerraje.setColumns(10);

		JLabel Vacio2 = new JLabel("");
		Vacio2.setEnabled(false);
		getContentPane().add(Vacio2);

		JLabel Vacio3 = new JLabel("");
		Vacio3.setEnabled(false);
		getContentPane().add(Vacio3);

		JLabel Vacio4 = new JLabel("");
		getContentPane().add(Vacio4);

		ConfirmarHerraje = new JButton("Confirmar Herraje");
		ConfirmarHerraje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ConfirmarHerraje.addActionListener(this);
		ConfirmarHerraje.setActionCommand(CONFIRMAR_BUTTON);
		getContentPane().add(ConfirmarHerraje);

		objGestorIFIH = ObjGestor;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case AUTOMATICO_BUTTON:
			ObtenerUltimoID();
			break;

		case CONFIRMAR_BUTTON:
			MandarAGestor();
			PonerVacio();
			break;

		default:
			break;
		}

	}

	/**
	 * Metodo para dejar vacios los huecos
	 */
	private void PonerVacio() {

		CasillaNHerraje.setText("");
		CasillaDesHerraje.setText("");
		CasillaPrecioHerraje.setText("");

	}

	/**
	 * Mandamos datos al gestor
	 */
	private void MandarAGestor() {

		int Ref = Integer.parseInt(CasillaNHerraje.getText());
		String Desc = CasillaDesHerraje.getText();
		Double Prec = Double.parseDouble(CasillaPrecioHerraje.getText());

		try {
			if (objGestorIFIH.CrearHerrajes(Ref, Desc, Prec)) {
				JOptionPane.showMessageDialog(null, "Herraje introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID del Herraje repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

	}

	/**
	 * Metodo para obtener automaticamente el siguiente ID.
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Herrajes = objGestorIFIH.OrdenarHerrajes();

		ItfProperty UltimoObjeto = Herrajes.get(Herrajes.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_HERRAJES_REFERENCIA);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		CasillaNHerraje.setText(IDActualizado);

	}
	
	

}
