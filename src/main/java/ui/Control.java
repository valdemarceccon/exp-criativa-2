package ui;

public enum Control {
    PLAY("control/play-button.svg"),
    PAUSE("control/pause.svg"),
    INCREASE_SPEED("control/fast-forward.svg"),
    DECREASE_SPEED("control/rewind.svg");

    private final String path;

    Control(final String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
