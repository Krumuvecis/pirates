package graphical.stubs.cannonTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;

/**
 * A test for testing cannons.
 */
public class CannonTest extends SimpleGraphicalTest {
    private static final int @NotNull [] WINDOW_SIZE = new int[] {1500, 500};
    private static final @NotNull String WINDOW_TITLE = "Cannon test";

    //main method of this test
    public static void main(String[] args) {
        new CannonTest();
    }

    /**
     * Creates a new window.
     */
    private CannonTest() {
        super(WINDOW_TITLE, false);
    }

    //
    @Override
    public int @Nullable [] initialWindowLocation() {
        return null;
    }

    //
    @Override
    public int @Nullable [] initialWindowSize() {
        return WINDOW_SIZE;
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