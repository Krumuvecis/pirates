package models.guns;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.ProjectileManager;

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
    }
}