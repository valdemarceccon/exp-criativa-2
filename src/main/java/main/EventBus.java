package main;

import processing.event.MouseEvent;
import ui.Button;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EventBus {

    private List<MouseEventListener> mouseEvents;

    private static EventBus ourInstance = new EventBus();

    public static EventBus getInstance() {
        return ourInstance;
    }

    private EventBus() {
        mouseEvents = new LinkedList<>();
    }

    public void mouseReleased(MouseEvent event) {
        mouseEvents.forEach(mouseEventListener -> mouseEventListener.mouseReleased(event));
    }

    public void subscribe(MouseEventListener ... eventListener) {
        this.mouseEvents.addAll(Arrays.asList(eventListener));
    }

    public void unsubscribe(MouseEventListener ... eventListener) {
        Arrays.stream(eventListener).forEach(this.mouseEvents::remove);
    }
}
