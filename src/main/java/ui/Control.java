package ui;

public enum Control {
    PLAY("control/svg/play-2.svg"),
    PAUSE("control/svg/pause-2.svg"),
    NEXT_STEP("control/svg/skip-2.svg"),
    PREVIOUS_STEP("control/svg/previous-2.svg"),
    INCREASE_SPEED("control/svg/fast-forward-2.svg"),
    DECREASE_SPEED("control/svg/backward.svg"),
    MUTE("control/svg/mute.svg"),
    UNMUTE("control/svg/unmute.svg");

    private final String path;

    Control(final String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
