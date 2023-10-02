package graphical.projectileTests.ballisticsTest;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import graphical.common.graphics.AbstractWindow;
import graphical.common.graphics.WindowConfig;
import graphical.projectileTests.WindowUpdater;

/**
 * A window for testing projectiles' ballistics.
 */
final class Window extends AbstractWindow {
    private static final @NotNull String WINDOW_TITLE = "Ballistics test";
    private static final @NotNull WindowConfig WINDOW_CONFIG = new WindowConfig(
            new Point(100, 100),
            new Dimension(1400, 600),
            WindowConstants.EXIT_ON_CLOSE);

    /**
     * Creates a new window.
     */
    Window() {
        super();
        new WindowUpdater(this);
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