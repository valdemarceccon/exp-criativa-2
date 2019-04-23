package main;

import processing.core.PApplet;
import processing.sound.AudioSample;

public class MainPApplet extends PApplet {
    @Override
    public void settings() {
        size(1500, 800);
    }

    @Override
    public void setup() {
        AudioSample as = new AudioSample(this, 500);
        smooth();
    }

    @Override
    public void draw() {
        new Teste(this);
    }
}
