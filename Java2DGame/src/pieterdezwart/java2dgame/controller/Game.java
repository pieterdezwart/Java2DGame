package pieterdezwart.java2dgame.controller;

import pieterdezwart.java2dgame.model.Ball;
import pieterdezwart.java2dgame.view.View;

import java.util.ArrayList;

/**
 * Created by Pieter on 7-10-2015.
 */
public class Game implements Runnable {
    private View view;

    public final int PWIDTH = 800;	// game window width
    public final int PHEIGHT = 600;	// game window height

    public ArrayList<Ball> unitList;    // temp ball list

    public Game()
    {
        view = new View(PWIDTH,PHEIGHT);
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

    }
}
