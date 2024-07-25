import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * La clase Serpiente representa el juego de la serpiente.
 * Extiende JFrame e implementa KeyListener para manejar la entrada del teclado.
 * 
 * @author fernandocruz
 */
public class Serpiente extends JFrame implements KeyListener {
    
    private int tamx = 800, tamy = 600, puntos, temp = 100;
    private Serpiente_obj serp;
    private Comida com;
    private long finali;

    /**
     * Constructor de la clase Serpiente.
     * Configura la ventana del juego y inicia el bucle principal del juego.
     */
    public Serpiente() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(tamx, tamy);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.createBufferStrategy(2);
        this.addKeyListener(this);
        
        inicio();
        while (true) {
            juego();
            duerme();
        }
    }

    /**
     * Inicializa el juego creando una nueva serpiente y comida, y resetea los puntos.
     */
    private void inicio() {
        serp = new Serpiente_obj();
        serp.crecer();
        com = new Comida();
        com.nueva();
        puntos = 0;
    }

    /**
     * Ejecuta una iteración del juego, moviendo la serpiente, verificando choques y dibujando.
     */
    private void juego() {
        serp.mover();
        verChoque();
        dibujar();
    }

    /**
     * Pausa el juego temporalmente.
     */
    private void duerme() {
        finali = System.currentTimeMillis() + temp;
        while (System.currentTimeMillis() < finali) {
            // Pausa
        }
    }

    /**
     * Dibuja el estado actual del juego.
     */
    private void dibujar() {
        BufferStrategy bf = this.getBufferStrategy();
        Graphics g = null;

        try {
            g = bf.getDrawGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, tamx, tamy);

            com.dibujar(g);
            serp.dibujo(g);
            mostrar(g);
        } finally {
            if (g != null) {
                g.dispose();
            }
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Muestra el puntaje actual en la pantalla.
     * 
     * @param g el objeto Graphics donde se dibujará el puntaje.
     */
    private void mostrar(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Puntaje: " + puntos, 20, 50);
    }

    /**
     * Verifica si ha habido colisiones con la comida o con los bordes del tablero.
     */
    private void verChoque() {
        if (serp.getCuerpo().get(0).equals(com.getComidita())) {
            com.nueva();
            serp.crecer();
            puntos += 10;
        }

        if (serp.getCuerpo().get(0).x < 0 || serp.getCuerpo().get(0).x > 39 ||
            serp.getCuerpo().get(0).y < 1 || serp.getCuerpo().get(0).y > 29) {
            inicio();
        }

        for (int i = 1; i < serp.getCuerpo().size(); i++) {
            if (serp.getCuerpo().get(0).equals(serp.getCuerpo().get(i)) && serp.getCuerpo().size() > 2) {
                inicio();
            }
        }
    }

    /**
     * Método principal que inicia el juego.
     * 
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        new Serpiente();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int tecla = ke.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                serp.dir("A");
                break;
            case KeyEvent.VK_DOWN:
                serp.dir("AB");
                break;
            case KeyEvent.VK_LEFT:
                serp.dir("I");
                break;
            case KeyEvent.VK_RIGHT:
                serp.dir("D");
                break;
            case KeyEvent.VK_E:
                System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // No implementado
    }
}
