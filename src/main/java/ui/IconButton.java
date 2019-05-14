package ui;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

public class IconButton extends Button {

    private PShape buttonShape;

    public IconButton(final PApplet processing, final Rectangle buttonSize) {
        super(processing, buttonSize);

    }

    public void setButtonShape(PShape buttonShape) {
        this.buttonShape = buttonShape;
    }

    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }

    @Override
    public void draw() {
        if (buttonShape != null) {
            processing.shape(buttonShape, buttonSize.x, buttonSize.y, buttonSize.width, buttonSize.height);
        }
    }

}
