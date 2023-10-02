package models.guns;

import org.jetbrains.annotations.NotNull;

import models.Coordinates;
import models.AbstractProjectile;
import models.ProjectileManager;

//
public final class SmallGun extends AbstractGun {
    private static final double MUZZLE_VELOCITY = 100;

    //
    public SmallGun(@NotNull Coordinates coordinates,
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
        return new AbstractProjectile.SmallProjectile(
                new Coordinates(getCoordinates()),
                getMuzzleVelocity());
    }
}