package pieterdezwart.java2dgame.controller;

import pieterdezwart.java2dgame.model.Ball;
import pieterdezwart.java2dgame.view.View;

import java.util.ArrayList;

/**
 * Created by Pieter on 7-10-2015.
 */
public class Game implements Runnable {
    private View view;

    public static final int PWIDTH  = 800;	// game window width
    public static final int PHEIGHT = 600;	// game window height

    private boolean running = false;
    private Thread animator;

    public static ArrayList<Ball> unitList;    // temp ball list

    public Game()
    {
        unitList = new ArrayList<Ball>();

        unitList.add(new Ball());

        view = new View(unitList);

        startGame();
    }

    // initialise and start the thread
    private void startGame()
    {
        if (animator == null || !running) {
            animator = new Thread(this);
            animator.start();
        }
    }

    public void start() {
        new Thread(this).start();
    }


    @Override
    public void run()
    {
        boolean running = true;

        // game loop
        while ( running ) {
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
        for(Ball ball : unitList)
        {
           ball.move();
        }
    }
}
