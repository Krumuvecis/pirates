package graphical.stubs.tradeTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;

//
public final class TradeTest extends SimpleGraphicalTest {
    private static final int @NotNull [] WINDOW_SIZE = new int[] {1200, 700};
    private static final @NotNull String WINDOW_TITLE = "Trade test";

    //
    public static void main(String[] args) {
        new TradeTest();
    }

    //launches a window
    public TradeTest() {
        super(WINDOW_TITLE, true);
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
    @Override
    public int @Nullable [] initialWindowLocation() {
        return null;
    }

    //
    @Override
    public int @Nullable [] initialWindowSize() {
        return WINDOW_SIZE;
    }
}