package ui;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

public class Button {

    private final PApplet processing;
    private final PShape buttonShape;

    public Button(final PApplet processing, final PShape buttonShape) {
        this.processing = processing;
        this.buttonShape = buttonShape;
    }
}
