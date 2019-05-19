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

import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;

import java.awt.Font;
import javax.swing.SwingConstants;

import COMUN.ItfProperty;
import javax.swing.ImageIcon;

/**
 * Internar Frame para introducir Suelas
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsIFIntroducirSuelas extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objetos
	 */
	private JTextField CasillaNSuela;
	private JTextField CasillaDesSuela;
	private JTextField CasillaPrecioSuela;
	private JButton NSuelaAuto, ConfirmarSuela;
	private int Ref;
	private Double Prec;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIM;
	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Suelas";
	private final String AUTOMATICO_BUTTON = "Boton para poner automatico el ID";

	/**
	 * Creamos el frame
	 * 
	 * @param ObjGestor recibimos el gestor
	 */
	public ClsIFIntroducirSuelas(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsIFIntroducirSuelas.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setResizable(false);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Introducir Suelas");
		this.setBounds(75, 75, 600, 300);
		getContentPane().setLayout(new GridLayout(4, 3));

		Inicializar(ObjGestor);
	}

	/**
	 * Creamos lo objetos del frame
	 * 
	 * @param ObjGestor recibimos el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {
		JLabel TxtNSuelas = new JLabel("Numero de Suela:");
		TxtNSuelas.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNSuelas.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNSuelas.setEnabled(false);
		getContentPane().add(TxtNSuelas);

		CasillaNSuela = new JTextField();
		CasillaNSuela.setFont(new Font("Tahoma", Font.BOLD, 15));
		CasillaNSuela.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(CasillaNSuela);
		CasillaNSuela.setColumns(10);

		NSuelaAuto = new JButton("N\u00BA Suela Automatico");
		NSuelaAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(NSuelaAuto);
		NSuelaAuto.addActionListener(this);
		NSuelaAuto.setActionCommand(AUTOMATICO_BUTTON);

		JLabel TextDesSuela = new JLabel("Descripcion:");
		TextDesSuela.setHorizontalAlignment(SwingConstants.CENTER);
		TextDesSuela.setFont(new Font("Tahoma", Font.BOLD, 15));
		TextDesSuela.setEnabled(false);
		getContentPane().add(TextDesSuela);

		CasillaDesSuela = new JTextField();
		CasillaDesSuela.setFont(new Font("Tahoma", Font.BOLD, 15));
		CasillaDesSuela.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(CasillaDesSuela);
		CasillaDesSuela.setColumns(10);

		JLabel Vacio1 = new JLabel("");
		Vacio1.setEnabled(false);
		getContentPane().add(Vacio1);

		JLabel TxtPrecioSuela = new JLabel("Precio:");
		TxtPrecioSuela.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtPrecioSuela.setEnabled(false);
		TxtPrecioSuela.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TxtPrecioSuela);

		CasillaPrecioSuela = new JTextField();
		CasillaPrecioSuela.setHorizontalAlignment(SwingConstants.CENTER);
		CasillaPrecioSuela.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(CasillaPrecioSuela);
		CasillaPrecioSuela.setColumns(10);

		JLabel Vacio2 = new JLabel("");
		Vacio2.setEnabled(false);
		getContentPane().add(Vacio2);

		JLabel Vacio3 = new JLabel("");
		Vacio3.setEnabled(false);
		getContentPane().add(Vacio3);

		JLabel Vacio4 = new JLabel("");
		getContentPane().add(Vacio4);

		ConfirmarSuela = new JButton("Confirmar Suela");
		ConfirmarSuela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ConfirmarSuela.addActionListener(this);
		ConfirmarSuela.setActionCommand(CONFIRMAR_BUTTON);
		getContentPane().add(ConfirmarSuela);

		objGestorIFIM = ObjGestor;

	}

	/**
	 * Escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case AUTOMATICO_BUTTON:
			ObtenerUltimoID();
			break;

		case CONFIRMAR_BUTTON:
			Comprobar();
			break;

		default:
			break;
		}

	}

	/**
	 * Metodo para comprobar que los valores introducidos son adecuados
	 */
	private void Comprobar() {

		boolean comprobado = true;

		try {
			Ref = Integer.parseInt(CasillaNSuela.getText());
		} catch (Exception e) {
			comprobado = false;
			JOptionPane.showMessageDialog(null, "Numero de Suela incorrecto o vacio");
		}

		if (!CasillaPrecioSuela.getText().equals("")) {
			try {
				Prec = Double.parseDouble(CasillaPrecioSuela.getText());
			} catch (Exception e) {
				comprobado = false;
				JOptionPane.showMessageDialog(null, "El precio no puede ser texto");
			}
		}
		if (CasillaDesSuela.getText().equals("")) {
			comprobado = false;
			JOptionPane.showMessageDialog(null, "La descripción no puede estar vacia");
		}

		if (comprobado) {
			MandarAGestor();
			PonerVacio();
		}
	}

	/**
	 * Metodo para dejar vacios los huecos
	 */
	private void PonerVacio() {

		CasillaNSuela.setText("");
		CasillaDesSuela.setText("");
		CasillaPrecioSuela.setText("");

	}

	/**
	 * Mandamos datos al gestor
	 */
	private void MandarAGestor() {

		String Desc = CasillaDesSuela.getText();

		try {
			if (objGestorIFIM.CrearSuelas(Ref, Desc, Prec)) {
				JOptionPane.showMessageDialog(null, "Suela introducida correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID de la Suela repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

	}

	/**
	 * Metodo para obtener automaticamente el siguiente ID.
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Suelas = objGestorIFIM.OrdenarSuelas();

		ItfProperty UltimoObjeto = Suelas.get(Suelas.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		CasillaNSuela.setText(IDActualizado);

	}

}
