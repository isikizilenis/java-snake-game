package GUI;


import Actions.KeyHandler;
import javax.swing.*;

public class Gui {

    public static JFrame jframe;
    public static int width = 800, height = 600;                //Fenstervariablen
    public static int xoff = 130, yoff = 20;                    //Spielfeldvariablen
    public void create(){
        jframe = new JFrame("Snake");
        jframe.setSize(width, height);                          // Größe der GUI
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit-Mechanismus, wenn man auf das rote x drückt
        jframe.setLocationRelativeTo(null);                     // damit GUI relativ in der Mitte spawnt
        jframe.setLayout(null);                                 // für Buttons auf bestimmten Positionen sollten Buttons auf null gesetzt sein.
        jframe.setResizable(false);                             // damit es nicht skalierbar und unsauber ist.
        jframe.addKeyListener(new KeyHandler());

        Draw d = new Draw();
        d.setBounds(0, 0, width, height);                 //geht jetzt von links oben nach rechts unten
        d.setVisible(true);
        jframe.add(d);

        jframe.requestFocus();                                  //für Fokus auf Tastaturinput, denn jFrame kann das nur mit requestFocus()
        jframe.setVisible(true);
    }

}
