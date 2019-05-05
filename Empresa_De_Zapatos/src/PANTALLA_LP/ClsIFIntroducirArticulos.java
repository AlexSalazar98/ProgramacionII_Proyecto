package PANTALLA_LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

public class ClsIFIntroducirArticulos extends JInternalFrame implements ActionListener {
	public ClsIFIntroducirArticulos() {
		setTitle("Insertar Articulos");
		setFrameIcon(new ImageIcon(ClsIFIntroducirArticulos.class.getResource("/PANTALLA_LP/DEUSTO.png")));
	}

	/**
	 * No se que es
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
