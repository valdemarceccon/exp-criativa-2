package ui;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

public class ToggleButton {
    private Button button1;
    private Button button2;
    private Button current;

    public ToggleButton(PApplet processing, Rectangle area) {
        this.button1 = new Button(processing, area);
        this.button2 = new Button(processing, area);
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
