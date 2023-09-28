package graphicsTest;

import org.jetbrains.annotations.Nullable;

import common.graphics.WindowConfig;
import common.graphics.AbstractWindow;

/**
 * A test window for testing graphics.
 */
final class TestWindow extends AbstractWindow {
    private static final String WINDOW_TITLE = "Testing graphics. This is a window title."; //Pirates, yarr!

    /**
     * Creates a new test window.
     */
    TestWindow() {
        super();
    }

    /**
     * Gets the initial window configuration.
     * This method is being called from constructor.
     *
     * @return WindowConfig instance. Null means default.
     */
    @SuppressWarnings({"DataFlowIssue", "RedundantSuppression"})
    @Override
    public @Nullable WindowConfig initialWindowConfig() {
        return null;
    }

    /**
     * A string for the window title.
     * Intended for custom titles.
     * This method is being called by updateTitle().
     *
     * @return New string for window title. Null means default.
     */
    @SuppressWarnings({"DataFlowIssue", "RedundantSuppression"})
    @Override
    public @Nullable String getNewTitleString() {
        return WINDOW_TITLE;
    }

    /**
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    @Override
    public void addPanels() {
        //
    }
}