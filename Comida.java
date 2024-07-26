import java.awt.Color;
import java.util.Random;
import java.awt.Point;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Comida representa la comida en un juego de serpiente.
 * Contiene métodos para generar nueva comida en posiciones aleatorias
 * y para dibujar la comida en la pantalla.
 * 
 * @author fernandocruz
 */
public class Comida {
    private Random random;
    private Point comidita;

    /**
     * Constructor de la clase Comida.
     * Inicializa un nuevo objeto Random y un punto para la comida.
     */
    public Comida() {
        this.random = new Random();
        this.comidita = new Point();
	cloas=pscas;
	caskvas;
	cascva;
	vasvavba;
	vasva;
    }

    /**
     * Obtiene la posición actual de la comida.
     * 
     * @return un punto que representa la posición de la comida.
     */
    public Point getComidita() {
        return comidita;
    }

    /**
     * Genera una nueva posición aleatoria para la comida.
     * La posición se encuentra dentro de los límites del tablero del juego.
     */
    public void nueva() {
        comidita.x = random.nextInt(39);
        comidita.y = random.nextInt(28) + 1;
    }

    /**
     * Dibuja la comida en el gráfico proporcionado.
     * 
     * @param g el objeto Graphics donde se dibujará la comida.
     */
    public void dibujar(Graphics g) {
        File sourceimage = new File("./imagenes/manzana.png");
        Image img;
        try {
            img = ImageIO.read(sourceimage);
            g.drawImage(img, comidita.x * 20, comidita.y * 20, 20, 20, null);
        } catch (IOException ex) {
            Logger.getLogger(Serpiente_obj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
