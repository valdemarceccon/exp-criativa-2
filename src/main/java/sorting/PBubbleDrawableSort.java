package sorting;

import processing.core.PApplet;
import processing.sound.AudioSample;

import java.awt.*;
import java.util.Random;

public class PBubbleDrawableSort implements DrawableSort {

    private final PApplet processing;
    private final int[] items;
    private final Rectangle drawableBounds;

    public PBubbleDrawableSort(final PApplet processing, final int[] items, final Rectangle drawableBounds) {
        this.processing = processing;
        this.items = items;
        this.drawableBounds = drawableBounds;
        shuffle();
    }

    @Override
    public void drawNextStep() {

        processing.background(255);

        drawBorder();

        draw();

        nextStep();
    }

    private void drawBorder() {
        processing.stroke(0);
        processing.rect(drawableBounds.x, drawableBounds.y, drawableBounds.x + drawableBounds.width, drawableBounds.y + drawableBounds.height);
    }

    private void draw() {
        processing.stroke(0,0,255);
        for (int index = 0, itemsLength = items.length; index < itemsLength; index++) {
            int item = items[index];
            processing.line(index + drawableBounds.x, processing.height + drawableBounds.y, index + drawableBounds.x, processing.height - item + drawableBounds.y);
        }



        float[] sample = new float[items.length];

        for (int i = 0; i < sample.length; i++) {
            sample[i] = PApplet.sin(processing.TWO_PI*i/items.length);
        }

        // TODO valdemar: This playback is really poorly done. Research a better way.
        // Create the audiosample based on the data, set framerate to play 200 oscillations/second
        AudioSample audioSample = new AudioSample(processing, sample, 200 * sample.length);

        // Play the sample in a loop (but don't make it too loud)
        audioSample.amp(0.2f);
        audioSample.play();
    }

    private void nextStep() {

        for (int index = 0, itemsLength = items.length; index < itemsLength - 1; index++) {
            int item = items[index];
            int proxItem = items[index + 1];
            if (item > proxItem) {
                swap(index + 1, index);
            }
        }

    }

    private void shuffle() {
        final Random random = new Random();

        for (int index = 0, length = items.length; index < length; index++) {
            final int randomIndex = random.nextInt(length);
            swap(index, randomIndex);
        }

    }

    private void swap(final int idxA, final int idxB) {
        final int valorA = items[idxA];
        final int valorB = items[idxB];
        items[idxA] = valorB;
        items[idxB] = valorA;
    }

    @Override
    public void drawPreviousStep() {

    }
}
