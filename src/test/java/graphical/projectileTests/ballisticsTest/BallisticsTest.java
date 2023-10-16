package graphical.projectileTests.ballisticsTest;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.AbstractGun;
import models.guns.SmallGun;
import models.ChunkManager;

import graphical.projectileTests.GunShooterThread;

//
public class BallisticsTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    protected static final @NotNull AbstractGun GUN;
    private static final double
            HORIZONTAL_ANGLE = Math.toRadians(0),
            VERTICAL_ANGLE = Math.toRadians(45);

    static {
        CHUNK_MANAGER = new ChunkManager();
        GUN = new SmallGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 0, 0),
                new Orientation(HORIZONTAL_ANGLE, VERTICAL_ANGLE, 0));
    }

    //
    public static void main(String[] args) {
        new Window();
        new GunShooterThread(GUN, 700);
    }
}