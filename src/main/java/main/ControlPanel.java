package main;

import processing.core.PApplet;
import sorting.DrawSort;
import ui.IconButton;
import ui.Control;
import ui.TextButton;
import ui.ToggleButton;

import java.awt.*;

public class ControlPanel {
    private final PApplet processing;
    private final DrawSort sort;

    private IconButton increaseSpeed;
    private IconButton decreaseSpeed;
    private IconButton nextStep;
    private IconButton previousStep;
    private ToggleButton volumeButton;
    private ToggleButton playPauseButton;

    private boolean soundPlaying;
    private boolean sortPlaying;

    public ControlPanel(final PApplet processing, final DrawSort sort) {
        this.processing = processing;
        this.sort = sort;
        this.soundPlaying = false;
        this.sortPlaying = false;

        loadControl();
    }

    private void loadControl() {
        int index = 0;

        playPauseButton = new ToggleButton(processing, createRectangle(index++));

        playPauseButton.setButton1(processing.loadShape(Control.PLAY.getPath()), sort::play);
        playPauseButton.setButton2(processing.loadShape(Control.PAUSE.getPath()), sort::pause);

        previousStep = new IconButton(processing, createRectangle(index++));
        previousStep.setButtonShape(processing.loadShape(Control.PREVIOUS_STEP.getPath()));
        previousStep.setOnClick(sort::stepDown);

        decreaseSpeed = new IconButton(processing, createRectangle(index++));
        decreaseSpeed.setButtonShape(processing.loadShape(Control.DECREASE_SPEED.getPath()));
        decreaseSpeed.setOnClick(() -> {
            processing.frameRate(processing.frameRate - 10);
            if (processing.frameRate < 10) {
                processing.frameRate(10);
            }
        });

        increaseSpeed = new IconButton(processing, createRectangle(index++));
        increaseSpeed.setButtonShape(processing.loadShape(Control.INCREASE_SPEED.getPath()));
        increaseSpeed.setOnClick(() -> {
            processing.frameRate(processing.frameRate + 10);
            if (processing.frameRate > 100) {
                processing.frameRate(100);
            }
        });

        nextStep = new IconButton(processing, createRectangle(index++));
        nextStep.setButtonShape(processing.loadShape(Control.NEXT_STEP.getPath()));
        nextStep.setOnClick(sort::stepUp);

        volumeButton = new ToggleButton(processing, createRectangle(index++));

        volumeButton.setButton1(processing.loadShape(Control.UNMUTE.getPath()), sort::unmute);
        volumeButton.setButton2(processing.loadShape(Control.MUTE.getPath()), sort::mute);
    }

    public void draw() {
        playPauseButton.draw();
        increaseSpeed.draw();
        decreaseSpeed.draw();
        volumeButton.draw();
        nextStep.draw();
        previousStep.draw();

        TextButton b = new TextButton(processing, new Rectangle(400, 10, 100, 50));
        b.setText("Bubble sort");
        b.draw();
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

    public void mouseReleased() {
    }

    public boolean isSoundPlaying() {
        return soundPlaying;
    }

    public boolean isSortPlaying() {
        return sortPlaying;
    }
}
