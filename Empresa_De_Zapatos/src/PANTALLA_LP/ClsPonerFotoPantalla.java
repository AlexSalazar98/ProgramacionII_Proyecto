package PANTALLA_LP;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 * Clase que extiende de JDesktopPane para crear objetos de ese tipo y pintalos
 * 
 * @author Alex Salazar
 * @author David Requeta
 *
 */
public class ClsPonerFotoPantalla extends JDesktopPane {

	/**
	 * No se para que sirve esto
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage imagen;
	private Image imagenEscalada;

	/**
	 * Metodo para poner una foto en el fondo del JDesktopPane
	 * 
	 * @param path recibe la ruta de la foto
	 */
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

	/**
	 * Escuchador para pintar la pantalla
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(imagenEscalada, 0, 0, this);
	}

}
