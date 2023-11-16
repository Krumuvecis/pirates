package graphical.stubs.tradeTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.stubs.tradeTest.models.UpdatableUpdaterThread;
import graphical.stubs.tradeTest.models.world.AbstractWorld;

import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;
import graphical.stubs.tradeTest.graphics.DrawPanel;

//
public final class TradeTest extends SimpleGraphicalTest {
    private static final int @NotNull [] WINDOW_SIZE = new int[] {1200, 700};
    private static final @NotNull String WINDOW_TITLE = "Trade test";
    private static final @NotNull AbstractWorld WORLD = new AbstractWorld.World();
    private static final long WORLD_UPDATE_INTERVAL = 20;
    private final @NotNull UpdatableUpdaterThread worldUpdater;

    //
    public static void main(String[] args) {
        new TradeTest();
    }

    //launches a window
    public TradeTest() {
        super(WINDOW_TITLE, true);
        worldUpdater = new UpdatableUpdaterThread(WORLD, WORLD_UPDATE_INTERVAL);
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