package graphical.projectileTests.simpleTest;

import org.jetbrains.annotations.NotNull;

import models.ProjectileManager;
import models.guns.AbstractGun;
import models.guns.SmallGun;
import models.guns.BigGun;

import graphical.projectileTests.GunShooterThread;

//
public class ProjectileTest {
    protected static final @NotNull ProjectileManager PROJECTILE_MANAGER;
    protected static final @NotNull AbstractGun SMALL_GUN, BIG_GUN;

    static {
        PROJECTILE_MANAGER = new ProjectileManager();
        SMALL_GUN = new SmallGun(
                new Coordinates(new double[] {0, 0}, 0.5),
                PROJECTILE_MANAGER);
        BIG_GUN = new BigGun(
                new Coordinates(new double[] {0, 300}, 0),
                PROJECTILE_MANAGER);
    }

    //
    public static void main(String[] args) {
        new Window();
        new GunShooterThread(SMALL_GUN, 700);
        new GunShooterThread(BIG_GUN, 1200);
    }
}