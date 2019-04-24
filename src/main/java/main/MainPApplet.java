package main;

import processing.core.PApplet;
import sorting.DrawableSort;
import sorting.PBubbleDrawableSort;

import java.awt.*;
import java.util.stream.IntStream;

public class MainPApplet extends PApplet {

    private DrawableSort bubbleSort;

    @Override
    public void settings() {
        size(1500, 800);
    }

    @Override
    public void setup() {
        final Rectangle drawableArea = new Rectangle(width - 800, height - 800, 800, 800);
        int[] items = IntStream.rangeClosed(1, drawableArea.width).toArray();
        bubbleSort = new PBubbleDrawableSort(this, items, drawableArea);
    }

    @Override
    public void draw() {
        bubbleSort.drawNextStep();
    }
}
