package models;

import org.jetbrains.annotations.NotNull;

//
public abstract class AbstractGun {
    private final double @NotNull [] location;
    private double angle;
    private final @NotNull ProjectileManager projectileManager;

    //
    public AbstractGun(double @NotNull [] location, double angle,
                       @NotNull ProjectileManager projectileManager) {
        this.location = location;
        this.angle = angle;
        this.projectileManager = projectileManager;
    }

    //
    public double @NotNull [] getLocation() {
        return new double[] {location[0], location[1]};
    }

    //
    public double getAngle() {
        return angle;
    }

    //
    public void setAngle(double angle) {
        this.angle = angle;
    }

    //
    public abstract double getMuzzleVelocity();

    //
    public abstract @NotNull AbstractProjectile getNewProjectile();

    //
    public void shoot() {
        projectileManager.addProjectile(getNewProjectile());
        System.out.println("shooting");
    }

    //
    public static final class SmallGun extends AbstractGun {
        private static final double MUZZLE_VELOCITY = 100;

        //
        public SmallGun(double @NotNull [] location, double angle,
                        @NotNull ProjectileManager projectileManager) {
            super(location, angle, projectileManager);
        }

        //
        @Override
        public double getMuzzleVelocity() {
            return MUZZLE_VELOCITY;
        }

        //
        @Override
        public @NotNull AbstractProjectile getNewProjectile() {
            return new AbstractProjectile.SmallProjectile(getLocation(), getAngle(), getMuzzleVelocity());
        }
    }

    //
    public static final class BigGun extends AbstractGun {
        private static final double MUZZLE_VELOCITY = 150;

        //
        public BigGun(double @NotNull [] location, double angle,
                      @NotNull ProjectileManager projectileManager) {
            super(location, angle, projectileManager);
        }

        //
        @Override
        public double getMuzzleVelocity() {
            return MUZZLE_VELOCITY;
        }

        //
        @Override
        public @NotNull AbstractProjectile getNewProjectile() {
            return new AbstractProjectile.BigProjectile(getLocation(), getAngle(), getMuzzleVelocity());
        }
    }
}