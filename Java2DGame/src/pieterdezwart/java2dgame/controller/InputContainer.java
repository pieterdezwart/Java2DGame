package pieterdezwart.java2dgame.controller;

import pieterdezwart.java2dgame.view.GamePanel;
import pieterdezwart.java2dgame.view.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Pieter on 8-10-2015.
 */
public class InputContainer {
    private MouseEvent mouseEvent;

    public InputContainer(View view)
    {
        view.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { mouseEvent = e ;}
        });
    }

    public MouseEvent getMouseEvent()
    {
        return mouseEvent;
    }

    public void clearMouseEvent()
    {
        mouseEvent = null;
    }

}
