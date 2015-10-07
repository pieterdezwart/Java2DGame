package pieterdezwart.java2dgame.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pieter on 7-10-2015.
 */
public class GamePanel extends JPanel {
    private int width;
    private int height;

    // off screen rendering
    private Graphics dbg;
    private Image dbImage = null;

    public GamePanel(int PWIDTH, int PHEIGHT)
    {
        this.width = PWIDTH;
        this.height = PHEIGHT;

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));

        setFocusable(true);
        requestFocus();
    }

    // double buffering
    // draw the current frame to an image buffer
    public void render()
    {
        if (dbImage == null){ // create the buffer
            dbImage = createImage(width, height);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            }
            else
                dbg = dbImage.getGraphics( );
        }
    }

    // place dbImage onscreen from repaint request
    // use active rendering to put the buffered image on-screen
    public void paintScreen()
    {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null))
                g.drawImage(dbImage, 0, 0, null);
            g.dispose();
        }
        catch (Exception e)
        { System.out.println("Graphics context error: " + e);  }
    }

}
