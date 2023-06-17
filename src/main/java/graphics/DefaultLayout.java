package graphics;

import java.awt.Point;

class DefaultLayout {
    protected static final Point
            DEFAULT_WINDOW_LOCATION = new Point(100, 100);
    protected static final int
            LEFT_PANEL_WIDTH = 200,
            CENTER_WIDTH = 600,
            RIGHT_SIDE_WIDTH = 500;

    protected static int getTotalWidth() {
        return LEFT_PANEL_WIDTH + CENTER_WIDTH + RIGHT_SIDE_WIDTH;
    }

    protected static int getTotalHeight() {
        return CENTER_WIDTH;
    }
}