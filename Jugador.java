import java.awt.Color;


public class Jugador extends Figura {

    private int gols = 0;

    private String name;

    public final static int WIDTHJUGADOR = 40;
    public final static int HEIGHTJUGADOR = 7;

    private Color ColorJugador;

    public Jugador (int x, int y, Controlador ctrl,Color col) {
        super(x,y);
        ColorJugador = col;

    }

    public Jugador (int x, int y, Controlador ctrl,Color col,String name) {
        super(x,y);
        ColorJugador = col;
        this.name = name;
    }

    public int getGols () {
        return gols;
    }

    public void setGols (int val) {
        this.gols = val;
    }

    public String getName () {
        return name;
    }

    public void setName (String val) {
        this.name = val;
    }

    public Color getColor(){
        return ColorJugador;
    }

    public void setColor(Color val){
        this.ColorJugador = val;
    }
}

