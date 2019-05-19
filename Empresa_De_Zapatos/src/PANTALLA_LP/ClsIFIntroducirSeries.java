package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import COMUN.ItfProperty;
import LN.ClsGestorLN;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import javax.swing.ImageIcon;

/**
 * 
 * @author Alex Salazar
 * @author David Requeta InternalFrame para introducir datos de Series
 *
 */
public class ClsIFIntroducirSeries extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Para tener el Gestor
	 */
	private ClsGestorLN objGestorIFIS;
	/**
	 * constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Series";
	private final String AUTOMATICO_BUTTON = "Boton para poner automatico el ID";

	/**
	 * Instanciamos objetos
	 */
	JPanel Panel;
	JLabel NSerie, Descripcion;
	JButton NSAutomatico, Confirmar;
	private JTextField INSerie;
	private JTextField Desc;
	private int NDS;

	/**
	 * Constructor
	 * 
	 * @param ObjGestor recibe objeto gestor
	 */
	public ClsIFIntroducirSeries(ClsGestorLN ObjGestor) {
		setFrameIcon(new ImageIcon(ClsIFIntroducirSeries.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Introducir Series");
		this.setBounds(50, 50, 600, 300);
		getContentPane().setLayout(new GridLayout(3, 3));

		Panel = new JPanel();
		this.setClosable(true);
		this.setResizable(false);
		this.setIconifiable(true);
		this.setMaximizable(true);
		Inicializar(ObjGestor);
	}

	/**
	 * Metodo para inicializar objetos
	 * 
	 * @param ObjGestor recibe objeto gesotr
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {
		NSerie = new JLabel("Numero De Serie:");
		NSerie.setEnabled(false);
		NSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
		NSerie.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(NSerie);

		INSerie = new JTextField();
		INSerie.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(INSerie);
		INSerie.setColumns(10);

		NSAutomatico = new JButton("N\u00BA Serie Automatico");
		NSAutomatico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(NSAutomatico);
		NSAutomatico.addActionListener(this);
		NSAutomatico.setActionCommand(AUTOMATICO_BUTTON);

		Descripcion = new JLabel("Descripci\u00F3n:");
		Descripcion.setEnabled(false);
		Descripcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Descripcion);

		Desc = new JTextField();
		Desc.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Desc);
		Desc.setColumns(10);

		JLabel Vacio1 = new JLabel("");
		getContentPane().add(Vacio1);

		JLabel Vacio2 = new JLabel("");
		getContentPane().add(Vacio2);

		JLabel Vacio3 = new JLabel("");
		getContentPane().add(Vacio3);

		Confirmar = new JButton("Confirmar Serie");
		Confirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(Confirmar);
		Confirmar.addActionListener(this);
		Confirmar.setActionCommand(CONFIRMAR_BUTTON);
		objGestorIFIS = ObjGestor;

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
			NDS = Integer.parseInt(INSerie.getText());
		} catch (Exception e) {
			comprobado = false;
			JOptionPane.showMessageDialog(null, "Numero de Serie incorrecto o vacio");
		}

		if (Desc.getText().equals("")) {
			comprobado = false;
			JOptionPane.showMessageDialog(null, "La descripción no puede estar vacia");
		}

		if (comprobado) {
			MandarAlGestor();
			PonerVacio();
		}
	}

	/**
	 * Metodo para poner automatico el siguiente ID
	 */
	private void ObtenerUltimoID() {

		ArrayList<ItfProperty> Series = objGestorIFIS.OrdenaSeries();

		ItfProperty UltimoObjeto = Series.get(Series.size() - 1);

		int mostrar = UltimoObjeto.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE);

		int IDActualizadoINT = mostrar + 1;

		String IDActualizado = Integer.toString(IDActualizadoINT);

		INSerie.setText(IDActualizado);
	}

	/**
	 * Metodo para mandar al Gestor los datos recogidos por pantalla
	 */
	private void MandarAlGestor() {

		String Des = Desc.getText();
		try {
			if (objGestorIFIS.CrearSerie(NDS, Des)) {
				JOptionPane.showMessageDialog(null, "Serie introducida Correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID de la Serie repetido!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

	}

	/**
	 * Metodo para poner campos vacios
	 */
	private void PonerVacio() {

		INSerie.setText("");
		Desc.setText("");

	}
}
