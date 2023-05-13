import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author fernandocruz
 */
public class Serpiente_obj {
    private ArrayList<Point> cuerpo= new ArrayList<Point>();
    private int x,y;

    public Serpiente_obj() {
        cuerpo.add(new Point(20,15));
    }

    public ArrayList<Point> getCuerpo() {
        return cuerpo;
    }
    
    public void dibujo(Graphics g){
        for(int i=0;i<cuerpo.size();i++){
            Point p= cuerpo.get(i);
            if(i==0){
                File sourceimage = new File("./indice.png");
                Image img;
                try {
                    img = ImageIO.read(sourceimage);
                    g.drawImage(img,p.x*20, p.y*20,20,20, null);
                } catch (IOException ex) {
                    Logger.getLogger(Serpiente_obj.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                g.setColor(Color.GREEN);
                g.fillRect(p.x*20, p.y*20, 20, 20);
            }
                
        }
        
    }
    
    public void mover(){
        for(int i= cuerpo.size()-1;i>0;i--){
            cuerpo.get(i).setLocation(cuerpo.get(i-1));
        }
        cuerpo.get(0).x += x;
        cuerpo.get(0).y += y;
    }
    
    public void crecer(){
        cuerpo.add(new Point());
    }
    public void dir(String d){
        switch(d){
            case "A":
                x=0;
                y=-1;
                break;
            case "AB":
                x=0;
                y=1;
                break;
            case "I":
                x=-1;
                y=0;
                break;
            case "D":
                x=1;
                y=0;
                break;
                      
        }
        
    }
    
}
