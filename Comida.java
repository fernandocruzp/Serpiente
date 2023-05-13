import java.awt.Color;
import java.util.Random;
import java.awt.Point;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
/**
 *
 * @author fernandocruz
 */
public class Comida {
    private Random random;
    private Point comidita;

    public Comida() {
        this.random = new Random();
        this.comidita = new Point();
    }
    
    public Point getComidita() {
        return comidita;
    }
    
    public void nueva(){
        comidita.x=random.nextInt(39);
        comidita.y=random.nextInt(28)+1;
    }
    
    public void dibujar(Graphics g){
	File sourceimage = new File("manzana.png");
        Image img;
        try {
            img = ImageIO.read(sourceimage);
            g.drawImage(img,comidita.x*20, comidita.y*20,20,20, null);
        } catch (IOException ex) {
            //Logger.getLogger(Serpiente_obj.class.getName()).log(Level.SEVERE, null, ex);
        }
        //g.setColor(Color.RED);
        //g.fillOval(comidita.x*20, comidita.y*20, 20, 20);
    }
    
    

    
    
    
    
    
}
