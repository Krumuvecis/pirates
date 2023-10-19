package graphical.projectileTests.simpleTest;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.AbstractGun;
import models.guns.SmallGun;
import models.guns.BigGun;
import models.ChunkManager;

import graphical.projectileTests.GunShooterThread;

//
public class ProjectileTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    private static final double GUN_ALTITUDE = 20;
    protected static final @NotNull AbstractGun SMALL_GUN, BIG_GUN;

    static {
        CHUNK_MANAGER = new ChunkManager();
        SMALL_GUN = new SmallGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 0, GUN_ALTITUDE),
                new Orientation(0.5, 0, 0));
        BIG_GUN = new BigGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 300, GUN_ALTITUDE),
                new Orientation(0, 0, 0));
    }

    //
    public static void main(String[] args) {
        new Window();
        new GunShooterThread(SMALL_GUN, 700);
        new GunShooterThread(BIG_GUN, 1200);
    }
}