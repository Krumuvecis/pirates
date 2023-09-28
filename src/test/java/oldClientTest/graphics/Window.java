package oldClientTest.graphics;

import java.awt.Point;
import java.awt.Dimension;

import org.jetbrains.annotations.NotNull;

import common.graphics.AbstractWindow;
import common.graphics.WindowConfig;

//
public final class Window extends AbstractWindow {
    private static final @NotNull String WINDOW_TITLE = "Pirates, yarr!";

    //
    public Window() {
        super();
    }

    /**
     * Gets the initial window configuration.
     * This method is being called by constructor.
     *
     * @return WindowConfig instance. Null means default.
     */
    @Override
    public @NotNull WindowConfig initialWindowConfig() {
        return new ParticularWindowConfig();
    }

    /**
     * A string for the window title.
     * Intended for custom titles.
     * This method is being called by updateTitle().
     *
     * @return New string for window title. Null means default.
     */
    @Override
    public @NotNull String getNewTitleString() {
        return WINDOW_TITLE;
    }

    /**
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    @Override
    public void addPanels() {
        add(new OnlyPanel());
    }

    private static final class ParticularWindowConfig extends WindowConfig {
        private static final @NotNull Point WINDOW_INITIAL_LOCATION = new Point(100, 100);
        private static final @NotNull Dimension WINDOW_INITIAL_SIZE = new Dimension(
                DefaultLayout.getTotalWidth(),
                DefaultLayout.getTotalHeight());
        private static final int DEFAULT_CLOSE_OPERATION = DefaultWindowConfig.DEFAULT_CLOSE_OPERATION;

        //
        ParticularWindowConfig() {
            super(WINDOW_INITIAL_LOCATION, WINDOW_INITIAL_SIZE, DEFAULT_CLOSE_OPERATION);
        }
    }
}