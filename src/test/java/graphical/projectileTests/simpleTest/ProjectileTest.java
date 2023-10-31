package graphical.projectileTests.simpleTest;

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
public class ProjectileTest extends SimpleGraphicalTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    private static final double STRAIGHT_ANGLE = Math.PI / 2;
    protected static final @NotNull AbstractGun SMALL_GUN, BIG_GUN;
    private static final int @NotNull [] WINDOW_SIZE = new int[] {1500, 500};
    private static final @NotNull String WINDOW_TITLE = "Projectile test";
    protected static final @NotNull Observer OBSERVER;

    static {
        CHUNK_MANAGER = new ChunkManager();
        SMALL_GUN = new TestGuns.TestGun_small(CHUNK_MANAGER.getGunContainer());
        BIG_GUN = new TestGuns.TestGun_big(CHUNK_MANAGER.getGunContainer());
        OBSERVER = new Observer(
                new Location(0, 0, 0),
                new Orientation(
                        3 * STRAIGHT_ANGLE,
                        -1 * STRAIGHT_ANGLE,
                        0));
    }

    //main method of this test
    public static void main(String[] args) {
        new GunShooterThread(SMALL_GUN, 700);
        new GunShooterThread(BIG_GUN, 1200);
        new ProjectileTest();
    }

    private ProjectileTest() {
        super(WINDOW_TITLE, true);
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