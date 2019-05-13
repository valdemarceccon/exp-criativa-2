package main;

import processing.core.PApplet;
import sorting.DrawSort;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainPApplet extends PApplet {

    private DrawSort bubbleSort;
    private ControlPanel controlPanel;


    @Override
    public void settings() {
        size(1500, 900);
    }

    @Override
    public void setup() {
        final int sortAreaWidth = 1000;
        final int sortAreaX = this.width - sortAreaWidth;
        final int sortAreaHeight = 800;
        final int sortAreaY = this.height - sortAreaHeight;
        final Rectangle sortArea = new Rectangle(sortAreaX, sortAreaY, sortAreaWidth, sortAreaHeight);
        List<Integer> items = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        bubbleSort = new DrawSort(this, items, sortArea);
        controlPanel = new ControlPanel(this, bubbleSort);

        frameRate(100);
    }



    @Override
    public void draw() {
        background(0xFFFFFF00);
        bubbleSort.drawNextStep();
        controlPanel.draw();
    }
}
