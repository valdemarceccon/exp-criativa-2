package ui;

import processing.core.PApplet;

import java.awt.*;

public class TextButton extends Button {

    private String text;

    public TextButton(PApplet processing, Rectangle buttonSize) {
        super(processing, buttonSize);
    }

    @Override
    public void draw() {
        if (text != null) {
//            processing.textFont(processing.createFont("Arial", 20));
            processing.textSize(20);
            float textWidth = processing.textWidth(text);
//            processing.fill(0xFFFFFF00);
            processing.textAlign(processing.CENTER);
            processing.fill(0xFF24a0ed);
            processing.rect(buttonSize.x, buttonSize.y, textWidth, buttonSize.height, 5);
            processing.fill(0xFFFFFFFF);
            processing.text(text, buttonSize.x, buttonSize.y + buttonSize.height/2 - 10, textWidth, buttonSize.height);
        }
    }

    public void setText(String text) {
        this.text = text;
    }
}
