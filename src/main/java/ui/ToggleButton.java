package ui;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

public class ToggleButton {
    private IconButton button1;
    private IconButton button2;
    private IconButton current;

    public ToggleButton(PApplet processing, Rectangle area) {
        this.button1 = new IconButton(processing, area);
        this.button2 = new IconButton(processing, area);
        this.current = button1;
    }

    public void setButton1(PShape shape, Runnable run) {
        button1.setButtonShape(shape);
        button1.setOnClick(() -> {
            toggle();
            run.run();
        });
    }

    private void toggle() {
        current = current == button1 ? button2 : button1;
    }

    public void setButton2(PShape shape, Runnable run) {
        button2.setButtonShape(shape);
        button2.setOnClick(() -> {
            toggle();
            run.run();
        });
    }

    public void draw() {

        current.draw();
    }


}
