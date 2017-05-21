import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Frame extends JFrame{

    private Camp mCamp;

    private Controlador mCtrl= new Controlador();;

    private PanelLateral mPanelLateral;

    private static int WIDTHFRAME = 490;

    private static int HEIGHTFRAME = 540;

    public Frame ()  {
     setTitle("Air Hockey");
     this.setFocusable(true);
     this.setResizable(false);
     this.setLocationRelativeTo(null);
     setSize(WIDTHFRAME,HEIGHTFRAME);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     /* Layout */
     
     this.setLayout(new BorderLayout());     
     mCamp = new Camp(mCtrl);
     mPanelLateral = new PanelLateral(mCtrl);
     add(mCamp, BorderLayout.CENTER);
     add(mPanelLateral, BorderLayout.EAST);
     // Aparencia segun Sistema Operativo
     try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex) {

    }
     this.addKeyListener(mCtrl);
     this.setLocationRelativeTo(null); // Posicion: centro
     setVisible(true);

    try {
        mCamp.dibuja();
    } catch (Exception ex) {
        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
    }
     mCtrl.setControlador(this);
     
    }

    public Camp getCamp () {
        return mCamp;
    }


    public PanelLateral getPanel () {
        return mPanelLateral;
    }

    public static void main(String[] args) {
        Frame myFrame = new Frame();
    }

}

