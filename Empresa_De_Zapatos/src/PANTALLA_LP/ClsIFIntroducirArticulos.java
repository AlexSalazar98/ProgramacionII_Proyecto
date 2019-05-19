package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import COMUN.ItfProperty;
import LN.ClsGestorLN;

import static COMUN.ClsConstantes.PROPIEDAD_SERIES_NUMERO_DE_SERIE;
import static COMUN.ClsConstantes.PROPIEDAD_SERIES_DESCRIPCION;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_REFERENCIA;
import static COMUN.ClsConstantes.PROPIEDAD_SUELAS_DESCRIPCION;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase de InternalFrame para insertar Articulos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsIFIntroducirArticulos extends JInternalFrame implements ActionListener {

	/**
	 * No se que es.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * objetos de la clase
	 */
	private ClsGestorLN objGestorIFIA;
	private JTextField RecogerNArticulo;
	JLabel TxtNArticulo;
	private JTextField RecogerDesc;
	private JTextField RecogerCMaterial;
	private JTextField RecogerCHerrajes;
	private JTextField RecogerPArt;
	private JLabel TxtSerie, TxtDescripcion, TxtSuelasRef, TxtCMaterial, TxtCHerrajes, TxtPrecioArt;
	private JButton ConfirmarBoton;
	private JComboBox<Integer> SeleccionarSerie, SeleccionarNSuelas;
	private JScrollPane scrollPane;
	private JTextArea Descripciones;
	private JLabel TxtDescripciones;
	private JButton BotonVDSerie;
	private JButton BotonVDSuela;
	private JLabel foto;
	private int NArticulo = 0, CMaterial = 0, CHerrajes = 0;
	private Double PrecioArt;

	/**
	 * Constantes para el ActionLisener
	 */
	private final String CONFIRMAR_BUTTON = "Boton de confirmar Cliente";
	private final String VER_DESCRIPCION_SERIE_BUTTON = "Boton de ver descripcion de Serie";
	private final String VER_DESCRIPCION_SUELA_BUTTON = "Boton de ver descripcion de Suela";

	/**
	 * Arrays para los Combobox
	 */
	private ArrayList<ItfProperty> Series;
	private ArrayList<ItfProperty> Suelas;

	/**
	 * Constructor recibe el Gestor
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	public ClsIFIntroducirArticulos(ClsGestorLN ObjGestor) {
		setClosable(true);
		setIconifiable(true);
		setTitle("Insertar Articulos");
		setFrameIcon(new ImageIcon(ClsIFIntroducirArticulos.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		getContentPane().setLayout(null);
		this.setBounds(125, 125, 747, 370);

		Inicializar(ObjGestor);

	}

	/**
	 * metodo para inicializar los objetos
	 * 
	 * @param ObjGestor recibe el gestor
	 */
	private void Inicializar(ClsGestorLN ObjGestor) {

		objGestorIFIA = ObjGestor;
		CargarArrays();

		TxtNArticulo = new JLabel("N\u00BA de Art\u00EDculo*:");
		TxtNArticulo.setEnabled(false);
		TxtNArticulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtNArticulo.setHorizontalAlignment(SwingConstants.LEFT);
		TxtNArticulo.setBounds(10, 21, 120, 27);
		getContentPane().add(TxtNArticulo);

		RecogerNArticulo = new JTextField();
		RecogerNArticulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerNArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerNArticulo.setBounds(140, 26, 86, 20);
		getContentPane().add(RecogerNArticulo);
		RecogerNArticulo.setColumns(10);

		TxtSerie = new JLabel("N\u00BA de Serie:");
		TxtSerie.setEnabled(false);
		TxtSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtSerie.setHorizontalAlignment(SwingConstants.LEFT);
		TxtSerie.setBounds(10, 59, 101, 27);
		getContentPane().add(TxtSerie);

		SeleccionarSerie = new JComboBox<Integer>();
		SeleccionarSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SeleccionarSerie.setBounds(121, 59, 86, 22);
		getContentPane().add(SeleccionarSerie);

		TxtDescripcion = new JLabel("Descripci\u00F3n del Art\u00EDculo*: ");
		TxtDescripcion.setEnabled(false);
		TxtDescripcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		TxtDescripcion.setBounds(10, 104, 197, 24);
		getContentPane().add(TxtDescripcion);

		RecogerDesc = new JTextField();
		RecogerDesc.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerDesc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerDesc.setBounds(217, 106, 160, 20);
		getContentPane().add(RecogerDesc);
		RecogerDesc.setColumns(10);

		TxtSuelasRef = new JLabel("N\u00BA de Suela:");
		TxtSuelasRef.setEnabled(false);
		TxtSuelasRef.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtSuelasRef.setBounds(239, 60, 110, 24);
		getContentPane().add(TxtSuelasRef);

		SeleccionarNSuelas = new JComboBox<Integer>();
		SeleccionarNSuelas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SeleccionarNSuelas.setBounds(348, 61, 74, 22);
		getContentPane().add(SeleccionarNSuelas);

		TxtCMaterial = new JLabel("Cantidad de Material*:");
		TxtCMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		TxtCMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtCMaterial.setEnabled(false);
		TxtCMaterial.setBounds(10, 152, 170, 20);
		getContentPane().add(TxtCMaterial);

		RecogerCMaterial = new JTextField();
		RecogerCMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerCMaterial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerCMaterial.setBounds(44, 183, 86, 20);
		getContentPane().add(RecogerCMaterial);
		RecogerCMaterial.setColumns(10);

		TxtCHerrajes = new JLabel("Cantidad de Herrajes*:");
		TxtCHerrajes.setHorizontalAlignment(SwingConstants.CENTER);
		TxtCHerrajes.setEnabled(false);
		TxtCHerrajes.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtCHerrajes.setBounds(217, 152, 184, 20);
		getContentPane().add(TxtCHerrajes);

		RecogerCHerrajes = new JTextField();
		RecogerCHerrajes.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerCHerrajes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerCHerrajes.setBounds(263, 183, 86, 20);
		getContentPane().add(RecogerCHerrajes);
		RecogerCHerrajes.setColumns(10);

		TxtPrecioArt = new JLabel("Precio del Art\u00EDculo:");
		TxtPrecioArt.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtPrecioArt.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPrecioArt.setEnabled(false);
		TxtPrecioArt.setBounds(21, 231, 151, 20);
		getContentPane().add(TxtPrecioArt);

		RecogerPArt = new JTextField();
		RecogerPArt.setHorizontalAlignment(SwingConstants.CENTER);
		RecogerPArt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RecogerPArt.setBounds(182, 231, 101, 20);
		getContentPane().add(RecogerPArt);
		RecogerPArt.setColumns(10);

		ConfirmarBoton = new JButton("Confirmar Art\u00EDculo");
		ConfirmarBoton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ConfirmarBoton.setBounds(570, 306, 151, 23);
		getContentPane().add(ConfirmarBoton);
		ConfirmarBoton.addActionListener(this);
		ConfirmarBoton.setActionCommand(CONFIRMAR_BUTTON);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(426, 257, 295, 37);
		getContentPane().add(scrollPane);

		Descripciones = new JTextArea();
		Descripciones.setEnabled(false);
		Descripciones.setEditable(false);
		scrollPane.setViewportView(Descripciones);

		TxtDescripciones = new JLabel("DESCRIPCI\u00D3N:");
		TxtDescripciones.setHorizontalAlignment(SwingConstants.CENTER);
		TxtDescripciones.setEnabled(false);
		TxtDescripciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtDescripciones.setBounds(426, 235, 295, 19);
		getContentPane().add(TxtDescripciones);

		BotonVDSerie = new JButton("Descripci\u00F3n Serie");
		BotonVDSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonVDSerie.setBounds(426, 207, 141, 23);
		getContentPane().add(BotonVDSerie);
		BotonVDSerie.addActionListener(this);
		BotonVDSerie.setActionCommand(VER_DESCRIPCION_SERIE_BUTTON);

		BotonVDSuela = new JButton("Descripcion Suela");
		BotonVDSuela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonVDSuela.setBounds(577, 207, 144, 23);
		getContentPane().add(BotonVDSuela);
		BotonVDSuela.addActionListener(this);
		BotonVDSuela.setActionCommand(VER_DESCRIPCION_SUELA_BUTTON);

		foto = new JLabel("");
		foto.setIcon(new ImageIcon(ClsIFIntroducirArticulos.class.getResource("/PANTALLA_LP/ZAPATO.png")));
		foto.setBounds(497, 11, 160, 185);
		getContentPane().add(foto);

		JLabel TxtInfor = new JLabel("Los campos con * son obligatorios");
		TxtInfor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TxtInfor.setEnabled(false);
		TxtInfor.setBounds(10, 306, 197, 20);
		getContentPane().add(TxtInfor);

		for (ItfProperty a : Series) {

			SeleccionarSerie.addItem(a.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE));

		}

		for (ItfProperty a : Suelas) {

			SeleccionarNSuelas.addItem(a.getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA));

		}

	}

	/**
	 * Metodo para obtener los datos de los arrays
	 * 
	 */
	private void CargarArrays() {

		Series = objGestorIFIA.DameSeries();
		Suelas = objGestorIFIA.DameSuelas();

	}

	/**
	 * Escuchador
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case VER_DESCRIPCION_SERIE_BUTTON:
			CargarDescripcionSerie();
			break;

		case VER_DESCRIPCION_SUELA_BUTTON:
			CargarDescripcionSuela();
			break;

		case CONFIRMAR_BUTTON:
			if (!RecogerNArticulo.getText().equals("") && !RecogerDesc.getText().equals("")
					&& !RecogerCHerrajes.getText().equals("") && !RecogerCMaterial.getText().equals("")) {
				Comporobar();
				PonerVacio();
			} else {
				String MENSAJE = "Rellene los campos obligatorios";
				JOptionPane.showMessageDialog(null, MENSAJE, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			break;
		}

	}

	/**
	 * Metodo para poner campos vacios
	 */
	private void PonerVacio() {

		RecogerNArticulo.setText("");
		RecogerDesc.setText("");
		RecogerCMaterial.setText("");
		RecogerCHerrajes.setText("");
		RecogerPArt.setText("");

	}

	/**
	 * Metodo para carga la descripcion de serie
	 */
	private void CargarDescripcionSerie() {
		ItfProperty ObjetoSeleccionado;

		for (ItfProperty a : Series) {
			if (a.getIntegerProperty(PROPIEDAD_SERIES_NUMERO_DE_SERIE).equals(SeleccionarSerie.getSelectedItem())) {
				ObjetoSeleccionado = a;
				String Descripcion = ObjetoSeleccionado.getStringProperty(PROPIEDAD_SERIES_DESCRIPCION);
				Descripciones.setText(Descripcion);
			}
		}
	}

	/**
	 * Metodo para carga la descripcion de suela
	 */
	private void CargarDescripcionSuela() {
		ItfProperty ObjetoSeleccionado;

		for (ItfProperty a : Suelas) {
			if (a.getIntegerProperty(PROPIEDAD_SUELAS_REFERENCIA).equals(SeleccionarNSuelas.getSelectedItem())) {
				ObjetoSeleccionado = a;
				String Descripcion = ObjetoSeleccionado.getStringProperty(PROPIEDAD_SUELAS_DESCRIPCION);
				Descripciones.setText(Descripcion);
			}
		}
	}

	/**
	 * Metodo para comprobar que los valores introducidos son adecuados
	 */
	private void Comporobar() {

		boolean comprobado = false;

		try {
			NArticulo = Integer.parseInt(RecogerNArticulo.getText());
			comprobado = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce un numero entero en Articulos");
		}

		try {
			CMaterial = Integer.parseInt(RecogerCMaterial.getText());
			comprobado = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce un numero entero en Cantidad de Material");
		}
		try {
			CHerrajes = Integer.parseInt(RecogerCHerrajes.getText());
			comprobado = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce un numero entero en Cantidad de Herrajes");
		}

		if (!RecogerPArt.getText().equals("")) {
			try {
				PrecioArt = Double.parseDouble(RecogerPArt.getText());
				comprobado = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Introduce un numero con decimales en Precio");
			}
		}
		if (comprobado) {
			MandarAGestor();
		}

	}

	/**
	 * Metodo para mandar los datos al gestor
	 */
	private void MandarAGestor() {

		int NSerie = Integer.parseInt(SeleccionarSerie.getSelectedItem().toString());
		int NSuela = Integer.parseInt(SeleccionarNSuelas.getSelectedItem().toString());
		String Descripcion = RecogerDesc.getText();

		try {
			if (objGestorIFIA.CrearArticulos(NArticulo, NSerie, Descripcion, CMaterial, CHerrajes, PrecioArt, NSuela)) {
				JOptionPane.showMessageDialog(null, "Articulo introducido correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ID del Articulo repetido!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el insert: " + e);
		}

	}
}
