package pieterdezwart.java2dgame.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pieter on 7-10-2015.
 */
public class View extends JFrame {
    private GamePanel gamePanel;

    public View(int PWIDTH, int PHEIGHT)
    {
        Container c = getContentPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when closed
        setLocationByPlatform(true); 				    // Position frame at platform preference

        gamePanel = new GamePanel(PWIDTH, PHEIGHT);
        c.add(gamePanel);

        pack();
        setVisible(true);
    }

    public void render()
    {
        gamePanel.render(); // render to a buffer
        gamePanel.paintScreen();  // paint from the buffer
    }
}
