DrawSort sortPanel;
ControlPanel controlPanel;


public void setup() {
    size(1500, 900);
    final int sortAreaWidth = 1000;
    final int sortAreaHeight = 800;

    final int sortAreaX = this.width - sortAreaWidth;
    final int sortAreaY = this.height - sortAreaHeight;

    final Rectangle sortArea = new Rectangle(sortAreaX, sortAreaY, sortAreaWidth, sortAreaHeight);
    List<Integer> items = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
    LinkedList<Integer> shuffledItems = new LinkedList<Integer>(items);
    Collections.shuffle(shuffledItems);
    sortPanel = new DrawSort(this, shuffledItems, sortArea);
    controlPanel = new ControlPanel(this, sortPanel);

    frameRate(100);
}

public void mouseReleased(MouseEvent event) {
    EventBus.getInstance().mouseReleased(event);
}

public void draw() {
    background(0xFFFFFF00);
    sortPanel.drawNextStep();
    controlPanel.draw();
}
