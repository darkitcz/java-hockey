import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Camp extends JPanel {

    private Disc mDisc;

    private ArrayList<Jugador> mJugador;

    public final static int WIDTHCAMP = 384;

    public final static int HEIGHTCAMP = 512;
    
    public Camp (Controlador ctrl) {
        
        this.setSize(WIDTHCAMP, HEIGHTCAMP);
        mDisc = new Disc(182,246,ctrl);
        mDisc.setVx(500);
        mDisc.setVy(500);
        mJugador =  new ArrayList();
        mJugador.add(new Jugador(WIDTHCAMP/2 - Jugador.WIDTHJUGADOR/2,HEIGHTCAMP - Jugador.HEIGHTJUGADOR - 20,ctrl,Color.BLUE));
        mJugador.add(new Jugador(WIDTHCAMP/2 - Jugador.WIDTHJUGADOR/2,20,ctrl,Color.RED));
        mJugador.get(0).setGols(0);
        mJugador.get(1).setGols(0);
        
    }
    
    @Override
    public void paint( Graphics g ){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTHCAMP, HEIGHTCAMP);
        g.setColor(Color.YELLOW);
        g.fillOval(Math.round(mDisc.getX()), Math.round(mDisc.getY()), Disc.DIAMETERDISC, Disc.DIAMETERDISC);
        g.setColor(Color.GREEN);
        g.fillRect(142, 0, 100, 5);
        g.fillRect(142, 507, 100, 5);
        g.setColor(Color.BLACK);
        g.fillRect(0, 255, WIDTHCAMP, 2);
        g.fillRect(0, 170, WIDTHCAMP, 1);
        g.fillRect(0, 342, WIDTHCAMP, 1);
        g.setColor(mJugador.get(0).getColor());
        g.fillRect(Math.round(mJugador.get(0).getX()), Math.round(mJugador.get(0).getY()),Jugador.WIDTHJUGADOR,Jugador.HEIGHTJUGADOR);
        g.setColor(mJugador.get(1).getColor());
        g.fillRect(Math.round(mJugador.get(1).getX()), Math.round(mJugador.get(1).getY()),Jugador.WIDTHJUGADOR,Jugador.HEIGHTJUGADOR);
    }

   public void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, WIDTHCAMP, HEIGHTCAMP);
                }
            });
    }


    public Disc getDisc () {
        return mDisc;
    }

    public void setDisc (Disc val) {
        this.mDisc = val;
    }

    public ArrayList<Jugador> getJugadors () {
        return mJugador;
    }
}

