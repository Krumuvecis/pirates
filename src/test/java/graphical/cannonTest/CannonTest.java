package graphical.cannonTest;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import graphical.common.graphics.WindowConfig;
import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;

/**
 * A test for testing cannons.
 */
public class CannonTest extends SimpleGraphicalTest {
    private static final @NotNull String WINDOW_TITLE = "Cannon test";
    private static final @NotNull WindowConfig WINDOW_CONFIG = new WindowConfig(
            new Point(100, 100),
            new Dimension(1500, 500),
            WindowConstants.EXIT_ON_CLOSE);

    //main method of this test
    public static void main(String[] args) {
        new CannonTest();
    }

    /**
     * Creates a new window.
     */
    private CannonTest() {
        super(WINDOW_TITLE);
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
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    @Override
    public void addPanels() {
        add(new DrawPanel());
    }
}