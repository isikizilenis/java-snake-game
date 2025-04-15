package GUI;

import Clocks.GameClock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static Actions.Collision.logger;

public class StartGUI extends JFrame implements ActionListener
{
    JLabel greeting_text;
    JButton noob;
    JButton easy;
    JButton medium;
    JButton hard;
    JButton asian;
    JPanel panel;


    public StartGUI(){
        this.setTitle("Willkommen zu Snake!");
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        greeting_text = new JLabel("     Bitte wähle eine Schwierigkeit!      ");

        //Fünf Buttons werden erstellt
        noob = new JButton("Noob");
        easy = new JButton("Easy");
        medium = new JButton ("Medium");
        hard = new JButton ("Hard");
        asian = new JButton("Asian");

        //Buttons werden dem Listener zugeordnet
        noob.addActionListener(this);
        easy.addActionListener(this);
        medium.addActionListener(this);
        hard.addActionListener(this);
        asian.addActionListener(this);

        //Buttons werden dem JPanel hinzugefügt
        panel.add(greeting_text);
        panel.add(noob);
        panel.add(easy);
        panel.add(medium);
        panel.add(hard);
        panel.add(asian);

        //JLabel wird dem Panel hinzugefügt
        this.add(panel);

        logger.log(System.Logger.Level.INFO, "Application is running...");
    }

    public void actionPerformed (ActionEvent actioneevent){

        if(actioneevent.getSource() == this.easy){
            this.dispose();
            Gui g = new Gui();
            GameClock clock = new GameClock();
            g.create();
            clock.setSleepvar(230);
            clock.setRunning(true);
            logger.log(System.Logger.Level.INFO, "Game started with difficulty: "+actioneevent.getActionCommand());
            logger.log(System.Logger.Level.INFO, "Set sleepvar to: "+clock.getSleepvar());
            clock.start();
        }
        else if(actioneevent.getSource() == this.medium){
            this.dispose();
            Gui g = new Gui();
            GameClock clock = new GameClock();
            g.create();
            clock.setSleepvar(125);
            clock.setRunning(true);
            logger.log(System.Logger.Level.INFO, "Game started with difficulty: "+actioneevent.getActionCommand());
            logger.log(System.Logger.Level.INFO, "Set sleepvar to: "+clock.getSleepvar());
            clock.start();
        }
        else if (actioneevent.getSource() == this.hard){
            this.dispose();
            Gui g = new Gui();
            GameClock clock = new GameClock();
            g.create();
            clock.setSleepvar(85);
            clock.setRunning(true);
            logger.log(System.Logger.Level.INFO, "Game started with difficulty: "+actioneevent.getActionCommand());
            logger.log(System.Logger.Level.INFO, "Set sleepvar to: "+clock.getSleepvar());
            clock.start();
        }
        else if(actioneevent.getSource() == this.asian){
            this.dispose();
            Gui g = new Gui();
            GameClock clock = new GameClock();
            g.create();
            clock.setSleepvar(20);
            clock.setRunning(true);
            logger.log(System.Logger.Level.INFO, "Game started with difficulty: "+actioneevent.getActionCommand());
            logger.log(System.Logger.Level.INFO, "Set sleepvar to: "+clock.getSleepvar());
            clock.start();
        }
        else if (actioneevent.getSource() == this.noob){
            this.dispose();
            Gui g = new Gui();
            GameClock clock = new GameClock();
            g.create();
            clock.setSleepvar(500);
            clock.setRunning(true);
            logger.log(System.Logger.Level.INFO, "Game started with difficulty: "+actioneevent.getActionCommand());
            logger.log(System.Logger.Level.INFO, "Set sleepvar to: "+clock.getSleepvar());
            clock.start();
        }
    }
}