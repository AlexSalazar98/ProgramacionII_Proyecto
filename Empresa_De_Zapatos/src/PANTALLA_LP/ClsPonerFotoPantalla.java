package PANTALLA_LP;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class ClsPonerFotoPantalla extends JDesktopPane {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage imagen;
	private Image imagenEscalada;

	public ClsPonerFotoPantalla(String path) {

		try {
			imagen = ImageIO.read(new File(path));
			Image newimage = imagen.getScaledInstance(1366, 710, Image.SCALE_SMOOTH);
			imagenEscalada = newimage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(imagenEscalada, 0, 0, this);
	}

}
