package models.guns;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.ProjectileManager;

//
public final class BigGun extends AbstractGun {
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