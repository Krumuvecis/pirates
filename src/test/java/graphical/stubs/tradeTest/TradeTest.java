package graphical.stubs.tradeTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.stubs.tradeTest.trading.AbstractWorld;

import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;
import graphical.stubs.tradeTest.graphics.DrawPanel;

//
public final class TradeTest extends SimpleGraphicalTest {
    private static final int @NotNull [] WINDOW_SIZE = new int[] {1200, 700};
    private static final @NotNull String WINDOW_TITLE = "Trade test";
    private static final @NotNull AbstractWorld WORLD = new AbstractWorld.World();

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
        add(new DrawPanel(WORLD));
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