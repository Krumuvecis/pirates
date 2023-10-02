package graphical.projectileTest;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayType;
import delayCalculator.delayOptions.DelayOptions;
import ThreadAbstraction.AbstractUpdater;

import graphical.common.graphics.WindowConfig;
import graphical.common.graphics.AbstractWindow;

/**
 * A window for testing projectiles.
 */
final class Window extends AbstractWindow {
    private static final @NotNull String WINDOW_TITLE = "Projectile test";
    private static final @NotNull WindowConfig WINDOW_CONFIG = new WindowConfig(
            new Point(100, 100),
            new Dimension(1500, 500),
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

    //
    private static final class WindowUpdater extends AbstractUpdater {
        private static final int FRAME_RATE = 60;
        private final Window window;

        //
        WindowUpdater(Window window) {
            super(new DelayOptions(DelayType.FPS, FRAME_RATE));
            this.window = window;
            this.start();
        }

        //
        @Override
        public void update() {
            window.repaint();
        }
    }
}