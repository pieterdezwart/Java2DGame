package pieterdezwart.java2dgame.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import pieterdezwart.java2dgame.controller.Game;
import pieterdezwart.java2dgame.model.Ball;

/**
 * Created by Pieter on 7-10-2015.
 */
public class View extends JFrame {
    private GamePanel gamePanel;

    public View(ArrayList<Ball> unitList)
    {
        Container c = getContentPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when closed
        setLocationByPlatform(true); 				    // Position frame at platform preference

        gamePanel = new GamePanel();
        c.add(gamePanel);

        pack();
        setVisible(true);
    }

    public void render()
    {
        gamePanel.render(); // render to a buffer
        gamePanel.paintScreen();  // paint from the buffer
    }

    public void drawFinished()
    {
        gamePanel.drawFinished();
    }
}
