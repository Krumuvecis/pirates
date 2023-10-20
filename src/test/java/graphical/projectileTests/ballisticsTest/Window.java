package graphical.projectileTests.ballisticsTest;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Orientation;

import graphical.common.graphics.AbstractWindow;
import graphical.common.graphics.WindowConfig;
import graphical.common.Observer;
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
        addKeyListener(new KeyListener() { //TODO; finish this
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                @NotNull Observer observer = BallisticsTest.OBSERVER;
                @NotNull Orientation orientation = observer.getOrientation();
                double delta = 0.1;
                switch (e.getKeyChar()) {
                    case 'a', 'A' -> orientation.increase(delta, 0);
                    case 'd', 'D' -> orientation.increase(-delta, 0);
                    case 'w', 'W' -> orientation.increase(0, -delta);
                    case 's', 'S' -> orientation.increase(0, delta);
                    default -> {}
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
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