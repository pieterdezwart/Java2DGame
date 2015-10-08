package pieterdezwart.java2dgame.controller;

import pieterdezwart.java2dgame.model.Ball;
import pieterdezwart.java2dgame.view.View;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Pieter on 7-10-2015.
 */
public class Game implements Runnable {
    private View view;
    private InputContainer inputContainer;

    public static final int PWIDTH  = 800;	// game window width
    public static final int PHEIGHT = 600;	// game window height

    private boolean running = false;
    public static boolean gameOver = false;
    private Thread animator;

    public static ArrayList<Ball> unitList;    // temp ball list

    public static int SCORE = 0;
    public static int BULLETS = 5;

    public Game()
    {
        unitList = new ArrayList<Ball>();

        unitList.add(new Ball());

        view = new View(unitList);

        inputContainer = new InputContainer(view);

        startGame();
    }

    // initialise and start the thread
    private void startGame()
    {
        gameOver = false;

        if (animator == null || !running) {
            animator = new Thread(this);
            animator.start();
        }
    }

    @Override
    public void run()
    {
        boolean running = true;

        // game loop
        while ( running ) {
            processInput();
            update();

            view.render();  // render the screen

            try {
                Thread.sleep(20);
            }
            catch (Exception e) {}
        }

        System.exit(0);
    }

    public void update()
    {
        if(gameOver == false)
        {
            for (Ball ball : unitList) {
                ball.move();
            }

            if (BULLETS == 0) {
                gameOver = true;
                view.drawFinished();
            }
        }
    }

    public void stopGame()
    {
        inputContainer.clearMouseEvent(); // clear the input

        System.out.println("test");

        gameOver = false;

        SCORE = 0;
        BULLETS = 5;
    }

    // process all the mouse input events
    private void processInput() {

        if( inputContainer.getMouseEvent() != null) {

                // gets last mouse input from inputContainer
                MouseEvent e = inputContainer.getMouseEvent();

            if (!gameOver) {

                System.out.println("Clicked at: x:" + e.getX() + " y:" + e.getY());
                BULLETS -= 1; // subtract a bullet

                inputContainer.clearMouseEvent(); // clear the input

                for (Ball ball : unitList) {
                    if (ball.hit(e.getX(), e.getY())) {   // was mouse press near the head?
                        //gameOver = true;
                        // hack together a score
                        SCORE += 100;

                        System.out.println("Hit!");
                    }
                }

            }
            else
            {
                stopGame();
            }

        }
    }
}
