package graphical.projectileTest;

import ThreadAbstraction.AbstractUpdater;

import models.ProjectileManager;
import models.AbstractGun;

//
public class ProjectileTest {
    protected static final ProjectileManager PROJECTILE_MANAGER;
    protected static final AbstractGun SMALL_GUN, BIG_GUN;

    static {
        PROJECTILE_MANAGER = new ProjectileManager();
        SMALL_GUN = new AbstractGun.SmallGun(new double[] {0, 0}, 0.5, PROJECTILE_MANAGER);
        BIG_GUN = new AbstractGun.BigGun(new double[] {0, 300}, 0, PROJECTILE_MANAGER);
    }

    //
    public static void main(String[] args) {
        new Window();
        new GunShooterThread(SMALL_GUN, 700);
        new GunShooterThread(BIG_GUN, 1200);
    }

    //
    private static class GunShooterThread extends AbstractUpdater {
        private final AbstractGun gun;

        //
        GunShooterThread(AbstractGun gun, long interval) {
            super(interval);
            this.gun = gun;
            this.start();
        }

        //
        @Override
        public void update() {
            gun.shoot();
        }
    }
}