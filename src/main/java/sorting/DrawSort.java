package sorting;

import processing.core.PApplet;
import processing.sound.SinOsc;
import processing.sound.SqrOsc;

import java.awt.*;

public class DrawSort {

    private final PApplet processing;
    private final Rectangle drawableBounds;
    private final SqrOsc sinOsc;
    private int borderColor;
    private StepCapableSort sort;
    private boolean paused = true;
    private int stepDisplayed = 0;


    public DrawSort(final PApplet processing, final java.util.List<Integer> items, final Rectangle drawableBounds) {
        this.processing = processing;
        this.drawableBounds = drawableBounds;
        sinOsc = new SqrOsc(processing);
        sinOsc.freq(0);
        initDefaultValues();
        sort = new StepCapableBubbleSort(items);
    }

    private void initDefaultValues() {
        this.borderColor = 0x000000;
    }

    public void drawNextStep() {
        processing.background(255);
        drawBorder();
        draw();
        nextStep();
    }

    private void drawBorder() {
        processing.stroke(this.borderColor);
        processing.fill(255);
        drawOffSettedRectangle(0, 0, drawableBounds.width, drawableBounds.height);
    }

    private void draw() {
        processing.stroke(0, 0, 255);

        for (int itemIndex = 0, itemsLength = sort.lastStep().size(); itemIndex < itemsLength; itemIndex++) {
            int xScale = drawableBounds.width / itemsLength;
            int yScale = drawableBounds.height / itemsLength;
            int width = drawableBounds.width / itemsLength;
            int item = getStepValue(itemIndex) * yScale;
            highlightRectangle(itemIndex);
            drawOffSettedRectangle(itemIndex * xScale, drawableBounds.height - item, width, item);
        }

        playSound();
    }

    private Integer getStepValue(int itemIndex) {
        if (paused) return sort.currentStep().get(itemIndex);
        return sort.lastStep().get(itemIndex);
    }

    private void playSound() {
        if (!sort.highlights().isEmpty()) {
            Integer indexToPlay = sort.highlights().get(0);
            float mappedValue = processing.map(indexToPlay, 1, 100, 100, 1000);
            this.sinOsc.freq(mappedValue);
        }
    }

    private void highlightRectangle(Integer index) {
        processing.fill(0, 255, 0);
        if (sort.highlights().contains(index))
            processing.fill(255, 0, 0);
    }

    private void drawOffSettedRectangle(int originX, int originY, int width, int height) {
        int x1Offset = drawableBounds.x + originX;
        int y1Offset = drawableBounds.y + originY;
        processing.rect(x1Offset, y1Offset, width, height);
    }

    private void nextStep() {
        if (!paused)
            sort.executeNextStep();
    }

    public void drawPreviousStep() {

    }

    public void pause() {
        this.paused = true;
    }

    public void play() {
        System.out.println("chamou do botao play");
        this.paused = false;
    }

    public void mute() {
        this.sinOsc.stop();
    }

    public void unmute() {
        System.out.println("chamou do unmute");
        this.sinOsc.play();
    }

    public void stepDown() {
        pause();
        sort.executePreviousStep();
    }

    public void stepUp() {
        pause();
        sort.executeNextStep();
    }
}
