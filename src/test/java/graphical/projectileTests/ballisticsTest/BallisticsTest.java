package graphical.projectileTests.ballisticsTest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.AbstractGun;
import models.guns.SmallGun;
import models.ChunkManager;

import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;
import graphical.common.Observer;
import graphical.projectileTests.GunShooterThread;

//
public class BallisticsTest extends SimpleGraphicalTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    private static final @NotNull String WINDOW_TITLE = "Ballistics test";
    protected static final @NotNull Observer OBSERVER = new Observer(
            new Location(0, 0, 0),
            new Orientation(Math.toRadians(290), Math.toRadians(-30), 0));
    protected static final @NotNull AbstractGun GUN;
    private static final double
            GUN_ALTITUDE = 15,
            HORIZONTAL_ANGLE = Math.toRadians(0),
            VERTICAL_ANGLE = Math.toRadians(45);

    static {
        CHUNK_MANAGER = new ChunkManager();
        GUN = new SmallGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 0, GUN_ALTITUDE),
                new Orientation(HORIZONTAL_ANGLE, VERTICAL_ANGLE, 0));
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
        return new int[] {1400, 600};
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