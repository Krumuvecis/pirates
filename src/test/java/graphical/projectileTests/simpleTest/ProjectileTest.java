package graphical.projectileTests.simpleTest;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.AbstractGun;
import models.guns.SmallGun;
import models.guns.BigGun;
import models.ChunkManager;

import graphical.common.graphics.WindowConfig;
import graphical.common.graphics.WindowUpdater;
import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;
import graphical.common.Observer;
import graphical.projectileTests.GunShooterThread;

//
public class ProjectileTest extends SimpleGraphicalTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    private static final double
            STRAIGHT_ANGLE = Math.PI / 2,
            GUN_ALTITUDE = 20,
            GUN_VERTICAL_ANGLE = Math.toRadians(30);
    protected static final @NotNull AbstractGun SMALL_GUN, BIG_GUN;
    private static final @NotNull String WINDOW_TITLE = "Projectile test";
    private static final @NotNull WindowConfig WINDOW_CONFIG = new WindowConfig(
            new Point(100, 100),
            new Dimension(1500, 500),
            WindowConstants.EXIT_ON_CLOSE);
    protected static final @NotNull Observer OBSERVER;

    static {
        CHUNK_MANAGER = new ChunkManager();
        SMALL_GUN = new SmallGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 0, GUN_ALTITUDE),
                new Orientation(0.5, GUN_VERTICAL_ANGLE, 0));
        BIG_GUN = new BigGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 300, GUN_ALTITUDE),
                new Orientation(0, GUN_VERTICAL_ANGLE, 0));
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
        super(WINDOW_TITLE);
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
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    @Override
    public void addPanels() {
        add(new DrawPanel());
    }
}