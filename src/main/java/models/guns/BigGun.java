package models.guns;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.ProjectileManager;

//
public final class BigGun extends AbstractGun {
    private static final double MUZZLE_VELOCITY = 150;

    //
    public BigGun(@NotNull Coordinates coordinates,
                  @NotNull ProjectileManager projectileManager) {
        super(coordinates, projectileManager);
    }

    //
    @Override
    public double getMuzzleVelocity() {
        return MUZZLE_VELOCITY;
    }

    //
    @Override
    public @NotNull AbstractProjectile getNewProjectile() {
        return new AbstractProjectile.BigProjectile(
                new Coordinates(getCoordinates()),
                getMuzzleVelocity());
    }
}