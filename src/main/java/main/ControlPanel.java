package main;

import processing.core.PApplet;
import sorting.DrawSort;
import ui.Button;
import ui.Control;

import java.awt.*;

public class ControlPanel {
    private final PApplet processing;
    private final DrawSort sort;

    private Button play;
    private Button pause;
    private Button increaseSpeed;
    private Button decreaseSpeed;

    public ControlPanel(final PApplet processing, final DrawSort sort) {
        this.processing = processing;
        this.sort = sort;

        loadControl();
    }

    private void loadControl() {
        int index = 0;
        play = new Button(processing, createRectangle(index++));
        play.setButtonShape(processing.loadShape(Control.PLAY.getPath()));
        play.setOnClick(() -> {
            sort.play();
        });
        pause = new Button(processing, createRectangle(index++));
        pause.setButtonShape(processing.loadShape(Control.PAUSE.getPath()));
        pause.setOnClick(() -> {
            sort.pause();
        });
        decreaseSpeed = new Button(processing, createRectangle(index++));
        decreaseSpeed.setButtonShape(processing.loadShape(Control.DECREASE_SPEED.getPath()));
        decreaseSpeed.setOnClick(() -> {
            processing.frameRate(processing.frameRate - 10);
            if (processing.frameRate < 10) {
                processing.frameRate(10);
            }
        });

        increaseSpeed = new Button(processing, createRectangle(index++));
        increaseSpeed.setButtonShape(processing.loadShape(Control.INCREASE_SPEED.getPath()));
        increaseSpeed.setOnClick(() -> {
            processing.frameRate(processing.frameRate + 10);
            if (processing.frameRate > 100) {
                processing.frameRate(100);
            }
        });
    }

    public void draw() {
        play.draw();
        pause.draw();
        increaseSpeed.draw();
        decreaseSpeed.draw();
    }


    private Rectangle createRectangle(int index) {
        final int w = 50;
        final int h = 50;
        int gap = 10;
        final int originX = 10;
        final int originY = 10;

        final int xOffset = index * w + gap * index;
        final int yOffset = 0;

        return new Rectangle(originX + xOffset, originY + yOffset, w, h);
    }
}
