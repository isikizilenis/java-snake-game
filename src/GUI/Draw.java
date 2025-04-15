package GUI;

import Game.Snake;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    Point point;

    protected void paintComponent(Graphics gui){
        super.paintComponent(gui);
        Graphics2D g2D = (Graphics2D) gui;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        gui.setColor(Color.LIGHT_GRAY);
        gui.fillRect(0, 0, Gui.width, Gui.height);

        //Draw Snake Tails
        gui.setColor(new Color(35, 165, 35));
        for(int i=0; i< Snake.tails.size(); i++){
            point = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            gui.fillRect(point.x, point.y, 32, 32);
        }

        //Draw Snake Head
        gui.setColor(new Color(4, 98, 4));
        point = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        gui.fillRect(point.x, point.y, 32, 32);

        //Draw PickUp
        gui.setColor(new Color(204, 51, 0));
        point = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        gui.fillRect(point.x, point.y, 32, 32);

        //Draw Grid
        gui.setColor(Color.GRAY);
        for(int row=0; row<16; row++){
            for(int col=0; col<16; col++){
                gui.drawRect(row*32 + Gui.xoff, col*32 + Gui.yoff, 32, 32);
            }
        }

        //Draw Border
        gui.setColor(Color.BLACK);                                      // schwarzer Rand
        gui.drawRect(Gui.xoff, Gui.yoff, 512, 512);        // für ein 16x16 großes Feld

        repaint();
    }

}
