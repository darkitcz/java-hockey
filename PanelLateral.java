import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
public class PanelLateral extends JPanel {

    private JButton bRe_Start;

    private JButton bStop;

    private JButton bResume;

    private JTextField lMarcador;

    private JTextField lEstat;

    public PanelLateral (Controlador ctrl) {
        bRe_Start = new JButton();
        bStop = new JButton();
        bResume = new JButton();

        lMarcador = new JTextField();
        lEstat = new JTextField();

        bRe_Start.setText("Iniciar");
        bRe_Start.setActionCommand("start");
        bRe_Start.addMouseListener(ctrl);

        bStop.setText("Pausa");
        bStop.setActionCommand("parar");
        bStop.setEnabled(false);
        bStop.addMouseListener(ctrl);
        

        bResume.setText("Renaudar");
        bResume.setActionCommand("renaudar");
        bResume.setEnabled(false);
        bResume.addMouseListener(ctrl);
       

        lMarcador.setEditable(false);
        lMarcador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lMarcador.setText("Marcador");
        

        lEstat.setEditable(false);
        lEstat.setFont(new Font("Monospaced", Font.BOLD, 15));
        lEstat.setBackground(Color.LIGHT_GRAY);
        lEstat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        
      

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRe_Start)
                    .addComponent(bStop)
                    .addComponent(bResume))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lMarcador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(lEstat, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lMarcador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lEstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(bRe_Start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bResume)
                .addContainerGap(333, Short.MAX_VALUE))
        );
    }

        public JButton getBRe_Start () {
        return bRe_Start;
    }

    public JButton getBResume () {
        return bResume;
    }

    public JButton getBStop () {
        return bStop;
    }

    public JTextField getLEstat () {
        return lEstat;
    }

    public JTextField getLMarcador () {
        return lMarcador;
    }
}

