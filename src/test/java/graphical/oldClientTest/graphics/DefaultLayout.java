package graphical.oldClientTest.graphics;

//TODO: get rid of this
class DefaultLayout {
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