package GUI;


import Actions.Collision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverGUI extends JFrame implements ActionListener {

    JPanel panel;
    JLabel lostText_collideSelf;
    JLabel lostText_collideWall;

    JLabel label;
    JButton restart;

    public GameOverGUI(){
        this.setTitle("GAME OVER!");
        this.setSize(200, 110);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.lostText_collideWall = new JLabel("Du bist gegen die Wand gelaufen.");
        this.lostText_collideSelf = new JLabel("Du bist gegen dich selbst gelaufen.");

        panel = new JPanel();
        panel.setBackground(new Color(0xC74545));
        panel.setLayout(new FlowLayout());

        restart = new JButton("Nochmal");
        restart.addActionListener(this);

        label = new JLabel("<html>Du hast verloren!<br>Deine Punktzahl ist: "+Collision.getPickupCounter()+"</html");

        /*
        if(Collision.){
            panel.add(lostText_collideWall);
        }
        else if(){
            panel.add(lostText_collideSelf);
        }
        */



        panel.add(label);
        panel.add(restart);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent actionevent){
        if(actionevent.getSource() == this.restart){
            this.dispose();
            Gui.jframe.dispose();
            StartGUI g = new StartGUI();
            g.setVisible(true);
        }
    }
}
