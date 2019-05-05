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

import static COMUN.ClsConstantes.PROPIEDAD_MATERIALES_REFERENCIA;

import java.awt.Font;
import javax.swing.SwingConstants;

import COMUN.ItfProperty;
import javax.swing.ImageIcon;


/**
 * Internar Frame para introducir Materiales
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsIFIntroducirMateriales extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objetos
	 */
	private JTextField CasillaNMaterial;
	private JTextField CasillaDesMaterial;
	private JTextField CasillaPrecioMaterial;
	private JButton NMaterialAuto, ConfirmarMaterial;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIM;
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
	public ClsIFIntroducirMateriales(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsIFIntroducirMateriales.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setResizable(false);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Introducir Materiales");
		this.setBounds(25, 25, 600, 300);
		getContentPane().setLayout(new GridLayout(4, 3));

		Inicializar(ObjGestor);
	}

	/**
	 * Creamos lo objetos del frame
	 * 
	 * @param ObjGestor recibimos el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {
		JLabel TxtNHerraje = new JLabel("Numero de Material:");
		TxtNHerraje.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNHerraje.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNHerraje.setEnabled(false);
		getContentPane().add(TxtNHerraje);

		CasillaNMaterial = new JTextField();
		CasillaNMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		CasillaNMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(CasillaNMaterial);
		CasillaNMaterial.setColumns(10);

		NMaterialAuto = new JButton("N\u00BA Material Automatico");
		NMaterialAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(NMaterialAuto);
		NMaterialAuto.addActionListener(this);
		NMaterialAuto.setActionCommand(AUTOMATICO_BUTTON);

		JLabel TextDesMaterial = new JLabel("Descripcion:");
		TextDesMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		TextDesMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		TextDesMaterial.setEnabled(false);
		getContentPane().add(TextDesMaterial);

		CasillaDesMaterial = new JTextField();
		CasillaDesMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		CasillaDesMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(CasillaDesMaterial);
		CasillaDesMaterial.setColumns(10);

		JLabel Vacio1 = new JLabel("");
		Vacio1.setEnabled(false);
		getContentPane().add(Vacio1);

		JLabel TxtPrecioMaterial = new JLabel("Precio:");
		TxtPrecioMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtPrecioMaterial.setEnabled(false);
		TxtPrecioMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtPrecioMaterial);

		CasillaPrecioMaterial = new JTextField();
		CasillaPrecioMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		CasillaPrecioMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(CasillaPrecioMaterial);
		CasillaPrecioMaterial.setColumns(10);

		JLabel Vacio2 = new JLabel("");
		Vacio2.setEnabled(false);
		getContentPane().add(Vacio2);

		JLabel Vacio3 = new JLabel("");
		Vacio3.setEnabled(false);
		getContentPane().add(Vacio3);

		JLabel Vacio4 = new JLabel("");
		getContentPane().add(Vacio4);

		ConfirmarMaterial = new JButton("Confirmar Material");
		ConfirmarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ConfirmarMaterial.addActionListener(this);
		ConfirmarMaterial.setActionCommand(CONFIRMAR_BUTTON);
		getContentPane().add(ConfirmarMaterial);

		objGestorIFIM = ObjGestor;

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

		CasillaNMaterial.setText("");
		CasillaDesMaterial.setText("");
		CasillaPrecioMaterial.setText("");

	}

	/**
	 * Mandamos datos al gestor
	 */
	private void MandarAGestor() {

		int Ref = Integer.parseInt(CasillaNMaterial.getText());
		String Desc = CasillaDesMaterial.getText();
		Double Prec = Double.parseDouble(CasillaPrecioMaterial.getText());

		try {
			if (objGestorIFIM.CrearMateriales(Ref, Desc, Prec)) {
				JOptionPane.showMessageDialog(null, "Material introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID del Material repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

	}

	/**
	 * Metodo para obtener automaticamente el siguiente ID.
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Materiales = objGestorIFIM.OrdenarMateriales();

		ItfProperty UltimoObjeto = Materiales.get(Materiales.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_MATERIALES_REFERENCIA);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		CasillaNMaterial.setText(IDActualizado);

	}

}
