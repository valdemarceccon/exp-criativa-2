package ui;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

public class Button {

    private final PApplet processing;
    private final Rectangle buttonSize;

    private PShape buttonShape;
    private Runnable onClick;

    public Button(final PApplet processing, final Rectangle buttonSize) {
        this.processing = processing;
        this.buttonSize = buttonSize;

        this.onClick = () -> {
        };
    }

    public void setButtonShape(PShape buttonShape) {
        this.buttonShape = buttonShape;
    }

    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }

    public void draw() {
        if (processing.mousePressed) {
            processing.mouseClicked();
            executeEventIfOnBounds();
        }

        if (buttonShape != null) {
            processing.shape(buttonShape, buttonSize.x, buttonSize.y, buttonSize.width, buttonSize.height);
        }
    }

    private boolean isMouseOver() {
        int x1 = buttonSize.x;
        int y1 = buttonSize.y;
        int x2 = x1 + buttonSize.width;
        int y2 = y1 + buttonSize.height;
        return isBetween(x1, processing.mouseX, x2) && isBetween(y1, processing.mouseY, y2);
    }

    private void executeEventIfOnBounds() {
        if (isMouseOver()) {
            onClick.run();
        }
    }

    private boolean isBetween(int val1, int val2, int val3) {
        return val2 >= val1 && val2 <= val3;
    }
}
