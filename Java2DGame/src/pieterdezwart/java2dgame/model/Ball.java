package pieterdezwart.java2dgame.model;

import java.awt.*;

/**
 * Created by Pieter on 7-10-2015.
 */
public class Ball {
    private int pWidth, pHeight;   // panel dimensions

    // Ball's properties
    private float ballRadius = 20; // Ball's radius
    private float ballX = ballRadius + 200; // Ball's center (x, y) start position
    private float ballY = ballRadius + 200;
    private float ballSpeedX = 3;   // Ball's speed for x and y
    private float ballSpeedY = 2;


    public Ball(int pW, int pH)
    {
        pWidth = pW;
        pHeight = pH;
    }

    public boolean hit(int x, int y)
    {
        if( (Math.abs( ballX + ballRadius - x) <= 2*ballRadius) &&
                (Math.abs( ballY + ballRadius - y) <= 2*ballRadius) )
            return true;
        else
            return false;
    }

    public void move()
    {
        // Calculate the ball's new position
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Check if the ball moves over the bounds
        // If so, adjust the position and speed.
        if (ballX - ballRadius < 0) {
            ballSpeedX = -ballSpeedX; // Reflect along normal
            ballX = ballRadius; // Re-position the ball at the edge
        } else if (ballX + ballRadius > pWidth) {
            ballSpeedX = -ballSpeedX;
            ballX = pWidth - ballRadius;
        }
        // May cross both x and y bounds
        if (ballY - ballRadius < 0) {
            ballSpeedY = -ballSpeedY;
            ballY = ballRadius;
        } else if (ballY + ballRadius > pHeight) {
            ballSpeedY = -ballSpeedY;
            ballY = pHeight - ballRadius;
        }

    }

    // draw the ball
    public void draw(Graphics g) {
        // Draw the ball
        g.setColor(Color.RED);
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                (int)(2 * ballRadius), (int)(2 * ballRadius));

    }

    public float getX()
    { return ballX; }

    public float getY()
    { return ballY; }
}
