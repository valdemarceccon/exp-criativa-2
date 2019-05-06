package main;

import processing.core.PApplet;
import processing.core.PImage;
import sorting.DrawableSort;
import sorting.PBubbleDrawableSort;

import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainPApplet extends PApplet {

    private DrawableSort bubbleSort;
    private PImage playButton;

    @Override
    public void settings() {
        size(1500, 900);
    }

    @Override
    public void setup() {
        final Rectangle drawableArea = new Rectangle(width - 1000, height - 800, 1000, 800);
        java.util.List<Integer> items = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        bubbleSort = new PBubbleDrawableSort(this, items, drawableArea);

        frameRate(100);
    }

    @Override
    public void draw() {
        bubbleSort.drawNextStep();
    }
}
