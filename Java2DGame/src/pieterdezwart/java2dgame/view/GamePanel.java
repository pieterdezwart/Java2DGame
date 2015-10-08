package pieterdezwart.java2dgame.view;

import pieterdezwart.java2dgame.model.Ball;

import pieterdezwart.java2dgame.controller.Game;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pieter on 7-10-2015.
 */
public class GamePanel extends JPanel {
    private int width;
    private int height;

    // off screen rendering
    private Graphics dbg;
    private Image dbImage = null;

    private Font font;
    private FontMetrics metrics;


    public GamePanel()
    {
        // set up message font
        font = new Font("SansSerif", Font.BOLD, 24);
        metrics = this.getFontMetrics(font);

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(Game.PWIDTH, Game.PHEIGHT));

        setFocusable(true);
        requestFocus();
    }

    // double buffering
    // draw the current frame to an image buffer
    public void render()
    {
        if (dbImage == null){ // create the buffer
            dbImage = createImage(Game.PWIDTH, Game.PHEIGHT);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            }
            else
                dbg = dbImage.getGraphics( );
        }

        // clear the background
        dbg.setColor(Color.cyan);
        dbg.fillRect(0, 0, Game.PWIDTH, Game.PHEIGHT);

        drawScore(Game.SCORE);

        for(Ball ball : Game.unitList) {
            drawBall(ball.getX(), ball.getY(), ball.getRadius());
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

    public void drawBall(float ballX, float ballY, float ballRadius)
    {
        dbg.setColor(Color.RED);
        dbg.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                (int) (2 * ballRadius), (int) (2 * ballRadius));
    }

    public void drawScore(int score)
    {
        dbg.setColor(Color.blue);
        dbg.setFont(font);

        dbg.drawString("Score: " + score, 20, 25);
        //dbg.drawString("Ball Position: " + ball.getX() + ", " + ball.getY(), 20, 50);
    }

}
