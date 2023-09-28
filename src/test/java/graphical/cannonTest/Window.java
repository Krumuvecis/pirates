package graphical.cannonTest;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import graphical.common.graphics.WindowConfig;
import graphical.common.graphics.AbstractWindow;

/**
 * A window for testing cannons.
 */
final class Window extends AbstractWindow {
    private static final @NotNull String WINDOW_TITLE = "Cannon test";
    private static final @NotNull WindowConfig WINDOW_CONFIG = new WindowConfig(
            new Point(100, 100),
            new Dimension(1500, 500),
            WindowConstants.EXIT_ON_CLOSE);

    /**
     * Creates a new window.
     */
    Window() {
        super();
    }

    /**
     * Gets the initial window configuration.
     * This method is being called from constructor.
     *
     * @return WindowConfig instance. Null means default.
     */
    @Override
    public @NotNull WindowConfig initialWindowConfig() {
        return WINDOW_CONFIG;
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
        add(new DrawPanel());
    }
}