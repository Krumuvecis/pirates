package graphical.projectileTests.ballisticsTest;

import org.jetbrains.annotations.NotNull;

import models.ProjectileManager;
import models.guns.AbstractGun;
import models.guns.SmallGun;

import graphical.projectileTests.GunShooterThread;

//
public class BallisticsTest {
    protected static final @NotNull ProjectileManager PROJECTILE_MANAGER;
    protected static final @NotNull AbstractGun GUN;
    private static final double ANGLE = Math.toRadians(0);

    static {
        PROJECTILE_MANAGER = new ProjectileManager();
        GUN = new SmallGun(
                new Coordinates(new double[] {0, 0}, ANGLE),
                PROJECTILE_MANAGER);
    }

    //
    public static void main(String[] args) {
        new Window();
        new GunShooterThread(GUN, 700);
    }
}