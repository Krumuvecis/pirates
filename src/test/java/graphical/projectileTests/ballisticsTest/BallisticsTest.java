package graphical.projectileTests.ballisticsTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.AbstractGun;
import models.ChunkManager;

import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;
import graphical.common.Observer;
import graphical.projectileTests.GunShooterThread;

//
public class BallisticsTest extends SimpleGraphicalTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    private static final int @NotNull [] WINDOW_SIZE = new int[] {1400, 600};
    private static final @NotNull String WINDOW_TITLE = "Ballistics test";
    protected static final @NotNull Observer OBSERVER = new Observer(
            new Location(0, 0, 0),
            new Orientation(Math.toRadians(290), Math.toRadians(-30), 0));
    protected static final @NotNull AbstractGun GUN;

    static {
        CHUNK_MANAGER = new ChunkManager();
        GUN = new TestGun(CHUNK_MANAGER.getGunContainer());
    }

    //
    public static void main(String[] args) {
        new GunShooterThread(GUN, 700);
        new BallisticsTest();
    }

    /**
     * Creates a new window.
     */
    private BallisticsTest() {
        super(WINDOW_TITLE, true);
        addKeyListener(new MyKeyListener(OBSERVER));
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