package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import LN.ClsGestorLN;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Clase para sacar tabla con ciertos atributos de pedidos y otros de desgloses
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsPedidosMasDesglose extends JInternalFrame implements ActionListener {

	/**
	 * No se para que sirve esto.
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	private JLabel TxtBuscador, TxtFechaI, TxtFechaF;
	private JButton BotonExportar;
	private JDateChooser dateChooser, dateChooser_1;
	private JScrollPane scrollPane;

	public ClsPedidosMasDesglose(ClsGestorLN ObjGestor) {

		setFrameIcon(new ImageIcon(ClsPedidosMasDesglose.class.getResource("/PANTALLA_LP/DEUSTO.png")));
		setTitle("Infome de producci\u00F3n");
		setBounds(200, 200, 741, 302);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);

		Inicializar();
	}

	private void Inicializar() {

		TxtBuscador = new JLabel("Buscador por fechas");
		TxtBuscador.setEnabled(false);
		TxtBuscador.setHorizontalAlignment(SwingConstants.CENTER);
		TxtBuscador.setFont(new Font("Tahoma", Font.BOLD, 20));
		TxtBuscador.setBounds(10, 11, 708, 25);
		getContentPane().add(TxtBuscador);

		BotonExportar = new JButton("Exportar");
		BotonExportar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonExportar.setBounds(629, 242, 89, 23);
		getContentPane().add(BotonExportar);

		TxtFechaI = new JLabel("Fecha de inicio:");
		TxtFechaI.setEnabled(false);
		TxtFechaI.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtFechaI.setBounds(161, 47, 116, 25);
		getContentPane().add(TxtFechaI);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(287, 47, 90, 20);
		getContentPane().add(dateChooser);

		TxtFechaF = new JLabel("Fecha final:");
		TxtFechaF.setFont(new Font("Tahoma", Font.BOLD, 15));
		TxtFechaF.setEnabled(false);
		TxtFechaF.setBounds(387, 47, 89, 25);
		getContentPane().add(TxtFechaF);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(486, 47, 89, 20);
		getContentPane().add(dateChooser_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 708, 146);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\ud83d\udd0e");
		btnNewButton.setBounds(675, 42, 43, 25);
		getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
