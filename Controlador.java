import java.awt.Color;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
public class Controlador implements KeyListener,MouseListener {

    private int estatGame = 0, saque = 0;

    private Boolean choque1 = false;

    private Boolean choque2 = false;

    private boolean arriba1, abajo1, izquierda1, derecha1;
    
    private boolean arriba2, abajo2, izquierda2, derecha2;

    private Frame GUI;


    public void setControlador (Frame val) {
      this.GUI = val;
      this.start();
    }

    private void start(){
      long tiempoViejo = System.nanoTime();
      long tiempoNuevo;
      float dt;
          while (true) {
            
            tiempoNuevo = System.nanoTime();
            dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
            tiempoViejo = tiempoNuevo;
            if(estatGame==1){
            fisica(dt);
            }
            GUI.requestFocus();
            try {
                this.GUI.getCamp().dibuja();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                choque1 = false;
                choque2 = false;
           
        }
    }

   

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
       actualiza(e.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent e) {
        actualiza(e.getKeyCode(), false);
    }

    private void actualiza(int keyCode, boolean pressed) {
         switch (keyCode) {
                case KeyEvent.VK_UP:
                    arriba1 = pressed;
                    break;
                case KeyEvent.VK_DOWN:
                    abajo1 = pressed;
                    break;
                case KeyEvent.VK_LEFT:
                    izquierda1 = pressed;
                    break;
                case KeyEvent.VK_RIGHT:
                    derecha1 = pressed;
                    break;
                case KeyEvent.VK_W:
                    arriba2 = pressed;
                    break;
                case KeyEvent.VK_S:
                    abajo2 = pressed;
                    break;
                case KeyEvent.VK_A:
                    izquierda2 = pressed;
                    break;
                case KeyEvent.VK_D:
                    derecha2 = pressed;
                    break;
                    }
                }

    private void fisica(float dt) {//controlador
        float xd = GUI.getCamp().getDisc().getX();
        float yd = GUI.getCamp().getDisc().getY();
        float vxd = GUI.getCamp().getDisc().getVx();
        float vyd = GUI.getCamp().getDisc().getVy();

        float x1 = GUI.getCamp().getJugadors().get(0).getX();
        float y1 = GUI.getCamp().getJugadors().get(0).getY();
        float vx1 = GUI.getCamp().getJugadors().get(0).getVx();
        float vy1 = GUI.getCamp().getJugadors().get(0).getVy();

        float x2 = GUI.getCamp().getJugadors().get(1).getX();
        float y2 = GUI.getCamp().getJugadors().get(1).getY();
        float vx2 = GUI.getCamp().getJugadors().get(1).getVx();
        float vy2 = GUI.getCamp().getJugadors().get(1).getVy();

        int DIAMETROD = Disc.DIAMETERDISC;
        int ANCHO = Camp.WIDTHCAMP;
        int ALTO = Camp.HEIGHTCAMP;
        int ANCHOJ = Jugador.WIDTHJUGADOR;
        int ALTOJ = Jugador.HEIGHTJUGADOR;


        xd += vxd * dt;
        yd += vyd * dt;
        ////Rebote en paredes
        if (vxd < 0 && xd <= 0)
            vxd = -vxd - 50;//Definir porcentaje de reduccion de velocidad
        if (vxd > 0 && xd + DIAMETROD >= ANCHO)
            vxd = -vxd + 50;
        if (vyd < 0 && yd <= 0)
            vyd = -vyd - 50;
        if (vyd > 0 && yd + DIAMETROD >= ALTO)
            vyd = -vyd + 50;


        ////Golpeo jugador 1
        //////Esquina izquierda
        if(vxd <= 0 && vyd > 0 && yd < y1 - DIAMETROD + ALTOJ && yd >= y1 - DIAMETROD && xd < x1 + 10 - DIAMETROD/2 && xd >= x1 - DIAMETROD/2 && !choque1) {
            vxd = -500;
            vyd = -500;
            choque1 = true;
        }
        if(vxd > 0 && vyd > 0 && yd < y1 - DIAMETROD + ALTOJ && yd >= y1 - DIAMETROD && xd < x1 + 10 - DIAMETROD/2 && xd >= x1 - DIAMETROD/2 && !choque1) {
            vxd = 0;
            vyd = -500;
            choque1 = true;
        }
        //////Esquina derecha
        if(vxd < 0 && vyd > 0 && yd <= y1 - DIAMETROD + ALTOJ && yd > y1 - DIAMETROD && xd <= x1 + ANCHOJ - DIAMETROD/2 && xd > x1 + ANCHOJ - 10 - DIAMETROD/2 && !choque1) {
            vxd = 0;
            vyd = -500;
            choque1 = true;
        }
        if(vxd >= 0 && vyd > 0 && yd <= y1 - DIAMETROD + ALTOJ && yd > y1 - DIAMETROD && xd <= x1 + ANCHOJ - DIAMETROD/2 && xd > x1 + ANCHOJ - 10 - DIAMETROD/2 && !choque1) {
            vxd = 500;
            vyd = -500;
            choque1 = true;
        }
        //////Centro
        if(vxd < 0 && vyd > 0 && yd < y1 - DIAMETROD + ALTOJ && yd > y1 - DIAMETROD && xd <= x1 + ANCHOJ - 10 - DIAMETROD/2 && xd >= x1 +  10 - DIAMETROD/2 && !choque1) {
            vxd = -500;
            vyd = -500;
            choque1 = true;
        }
        if(vxd > 0 && vyd > 0 && yd < y1 - DIAMETROD + ALTOJ && yd > y1 - DIAMETROD && xd <= x1 + ANCHOJ - 10 - DIAMETROD/2 && xd >= x1 +  10 - DIAMETROD/2 && !choque1) {
            vxd = 500;
            vyd = -500;
            choque1 = true;
        }
        if(vxd == 0 && vyd > 0 && yd < y1 - DIAMETROD + ALTOJ && yd > y1 - DIAMETROD && xd <= x1 + ANCHOJ - 10 - DIAMETROD/2 && xd >= x1 +  10 - DIAMETROD/2 && !choque1) {
            vyd = -500;
            choque1 = true;
        }
        //////Colpeo por detras
        if(vyd < 0 && yd < y1 + ALTOJ && yd > y1 && xd >= x1 - DIAMETROD && xd <= x1 + ANCHOJ - DIAMETROD) {
            vyd = 500;
            choque1 = true;
        }
        ////Golpeo jugador 2
        //////Esquina izquierda
        if(vxd <= 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd < x2 + 10 - DIAMETROD/2 && xd >= x2 - DIAMETROD/2 && !choque2) {
            vxd = -500;
            vyd = 500;
            choque2 = true;
        }
        if(vxd > 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd < x2 + 10 - DIAMETROD/2 && xd >= x2 - DIAMETROD/2 && !choque2) {
            vxd = 0;
            vyd = 500;
            choque2 = true;
        }
        //////Esquina derecha
        if(vxd < 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd <= x2 + ANCHOJ - DIAMETROD/2 && xd > x2 + ANCHOJ - 10 - DIAMETROD/2 && !choque2) {
            vxd = 0;
            vyd = 500;
            choque2 = true;
        }
        if(vxd >= 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd <= x2 + ANCHOJ - DIAMETROD/2 && xd > x2 + ANCHOJ - 10 - DIAMETROD/2 && !choque2) {
            vxd = 500;
            vyd = 500;
            choque2 = true;
        }
        //////Centro
        if(vxd < 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd <= x2 + ANCHOJ - 10 - DIAMETROD/2 && xd >= x2 +  10 - DIAMETROD/2 && !choque2) {
            vxd = -500;
            vyd = 500;
            choque2 = true;
        }
        if(vxd > 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd <= x2 + ANCHOJ - 10 - DIAMETROD/2 && xd >= x2 +  10 - DIAMETROD/2 && !choque2) {
            vxd = 500;
            vyd = 500;
            choque2 = true;
        }
        if(vxd == 0 && vyd < 0 && yd < y2 + ALTOJ && yd >= y2 && xd <= x2 + ANCHOJ - 10 - DIAMETROD/2 && xd >= x2 +  10 - DIAMETROD/2 && !choque2) {
            vyd = 500;
            choque2 = true;
        }
        //////Colpeo por detras
        if(vyd > 0 && yd < y2 && yd >= y2 - DIAMETROD && xd >= x2 - DIAMETROD && xd <= x2 + ANCHOJ - DIAMETROD) {
            vyd = -500;
            choque2 = true;
        }
        //Fisica del jugador 1
        vx1 = 0;
        vy1 = 0;
        if (arriba1)
            vy1 = -300;
        if (abajo1)
            vy1 = 300;
        if (izquierda1)
            vx1 = -300;
        if (derecha1)
            vx1 = 300;
        
        this.GUI.getCamp().getJugadors().get(0).setX(limite(x1 + vx1 * dt, 0, ANCHO - ANCHOJ));
        this.GUI.getCamp().getJugadors().get(0).setY(limite(y1 + vy1 * dt, 343, ALTO - ALTOJ));
        this.GUI.getCamp().getJugadors().get(0).setVx(vx1);
        this.GUI.getCamp().getJugadors().get(0).setVy(vy1);
        
        //Fisica del jugador 2
        vx2 = 0;
        vy2 = 0;
        if (arriba2)
            vy2 = -300;
        if (abajo2)
            vy2 = 300;
        if (izquierda2)
            vx2 = -300;
        if (derecha2)
            vx2 = 300;

        this.GUI.getCamp().getJugadors().get(1).setX(limite(x2 + vx2 * dt, 0, ANCHO - ANCHOJ));
        this.GUI.getCamp().getJugadors().get(1).setY(limite(y2 + vy2 * dt, 0, 170 - ALTOJ));
        this.GUI.getCamp().getJugadors().get(1).setVx(vx2);
        this.GUI.getCamp().getJugadors().get(1).setVy(vy2);



        //Fisica del disco
        this.GUI.getCamp().getDisc().setX(xd);
        this.GUI.getCamp().getDisc().setY(yd);
        this.GUI.getCamp().getDisc().setVx(vxd);
        this.GUI.getCamp().getDisc().setVy(vyd);

        //Goles

        ////Portería 1
        if(xd + DIAMETROD/2 >= 142 && xd + DIAMETROD/2 <= 242 && yd >= ALTO - DIAMETROD) {
            GUI.getCamp().getJugadors().get(1).setGols(GUI.getCamp().getJugadors().get(1).getGols() + 1);
            if (GUI.getCamp().getJugadors().get(1).getGols() == 10) {
                GUI.getPanel().getLEstat().setForeground(Color.RED);
                GUI.getPanel().getLEstat().setText("ROJO GANA");
                try {
                    Thread.sleep(1000); // Paramos
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.resetGame(saque);
                estatGame = 0;
                GUI.getPanel().getBRe_Start().setText("Iniciar");
                GUI.getPanel().getBRe_Start().setEnabled(true);
                GUI.getPanel().getBResume().setEnabled(false);
                GUI.getPanel().getBStop().setEnabled(false);
            }
            else {
                GUI.getCamp().getDisc().setX(182);
                GUI.getCamp().getDisc().setY(246);
                GUI.getCamp().getDisc().setVx(200);
                GUI.getCamp().getDisc().setVy(200);
                GUI.getPanel().getLEstat().setForeground(Color.RED);
                GUI.getPanel().getLEstat().setText("¡¡¡GOL!!!");
                try {
                    Thread.sleep(1000); // Paramos
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        ////Portería 2
        if(xd + DIAMETROD/2 >= 142 && xd + DIAMETROD/2 <= 242 && yd <= 0) {
            GUI.getCamp().getJugadors().get(0).setGols(GUI.getCamp().getJugadors().get(0).getGols() + 1);
            if (GUI.getCamp().getJugadors().get(0).getGols() == 10) {
                GUI.getPanel().getLEstat().setForeground(Color.BLUE);
                GUI.getPanel().getLEstat().setText("AZUL GANA");
                try {
                    Thread.sleep(1000); // Paramos
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.resetGame(saque);
                estatGame = 0;
                GUI.getPanel().getBRe_Start().setText("Iniciar");
                GUI.getPanel().getBRe_Start().setEnabled(true);
                GUI.getPanel().getBResume().setEnabled(false);
                GUI.getPanel().getBStop().setEnabled(false);
            }
            else {
                GUI.getCamp().getDisc().setX(182);
                GUI.getCamp().getDisc().setY(246);
                GUI.getCamp().getDisc().setVx(-200);
                GUI.getCamp().getDisc().setVy(-200);
                GUI.getPanel().getLEstat().setForeground(Color.BLUE);
                GUI.getPanel().getLEstat().setText("¡¡¡GOL!!!");
                 try {
                    Thread.sleep(1000); // Paramos
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // Mostramos Marcador
        GUI.getPanel().getLMarcador().setText("Azul: "+GUI.getCamp().getJugadors().get(0).getGols() +" - Rojo: "+GUI.getCamp().getJugadors().get(1).getGols());
        GUI.getPanel().getLEstat().setText("");
     }
    
    private float limite(float valor, float min, float max) {
        if (valor > max)
            return max;
        if (valor < min)
            return min;
        return valor;
    }

    public int getEstatGame () {
        return estatGame;
    }

    public void setEstatGame (int val) {
        this.estatGame = val;
    }

    
    public void resetGame (int saque) {
        estatGame = 1;
        GUI.getCamp().getJugadors().get(0).setGols(0);
        GUI.getCamp().getJugadors().get(1).setGols(0);
        GUI.getCamp().getDisc().setX(182);
        GUI.getCamp().getDisc().setY(246);
        if (saque % 2 == 0) {
            GUI.getCamp().getDisc().setVx(500);
            GUI.getCamp().getDisc().setVy(500);
        }
        else {
            GUI.getCamp().getDisc().setVx(-500);
            GUI.getCamp().getDisc().setVy(-500);
        }
    }

    public void mouseClicked(MouseEvent e) {
        
        JButton button = (JButton) e.getComponent();
        String  name = button.getActionCommand();
        if(button.isEnabled()){
            if(name.equals("start")){
                if (GUI.getPanel().getBResume().isEnabled() == true)
                    saque++;
                resetGame(saque);
                if (GUI.getPanel().getBResume().isEnabled() == true) {
                    estatGame = 0;
                    GUI.getPanel().getBRe_Start().setText("Iniciar");
                    GUI.getPanel().getBResume().setEnabled(false);
                    GUI.getPanel().getBStop().setEnabled(false);
                }
                else {
                    GUI.getPanel().getBRe_Start().setEnabled(false);
                    GUI.getPanel().getBResume().setEnabled(false);
                    GUI.getPanel().getBStop().setEnabled(true);
                }
            } else if(name.equals("parar")){
                estatGame = 0;
                GUI.getPanel().getBStop().setEnabled(false);
                GUI.getPanel().getBRe_Start().setText("Reiniciar");
                GUI.getPanel().getBRe_Start().setEnabled(true);
                GUI.getPanel().getBResume().setEnabled(true);
            } else if(name.equals("renaudar")){
                estatGame = 1;
                GUI.getPanel().getBStop().setEnabled(true);
                GUI.getPanel().getBRe_Start().setText("Reiniciar");
                GUI.getPanel().getBRe_Start().setEnabled(false);
                GUI.getPanel().getBResume().setEnabled(false);
            }
        }
        
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
       
    }


}

