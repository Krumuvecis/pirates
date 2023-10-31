package graphical.graphicsTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.common.graphics.WindowConfig;
import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;

/**
 * A test for testing graphics.
 */
public class GraphicsTest extends SimpleGraphicalTest {
    private static final @NotNull String WINDOW_TITLE = "Testing graphics. This is a window title.";

    //main method of this test
    public static void main(String[] args) {
        new GraphicsTest();
    }

    /**
     * Creates a new test window.
     */
    private GraphicsTest() {
        super(WINDOW_TITLE);
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
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    @Override
    public void addPanels() {
        add(new DrawPanel());
    }
}