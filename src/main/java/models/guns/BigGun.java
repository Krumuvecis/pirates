package models.guns;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.SpatialAngle;
import models.coordinates.Orientation;
import models.coordinates.Velocity;
import models.projectiles.AbstractProjectile;
import models.projectiles.BigProjectile;

//
public class BigGun extends AbstractGun {
    private static final double MUZZLE_VELOCITY = 35;

    //
    public BigGun(@NotNull GunContainer parent,
                  @NotNull Location location, @NotNull Orientation orientation) {
        super(parent, location, orientation);
    }

    //
    @Override
    public final double getMuzzleVelocity() {
        return MUZZLE_VELOCITY;
    }

    //
    @Override
    public final @NotNull AbstractProjectile getNewProjectile() {
        @NotNull Orientation gunOrientation = getOrientation();
        @NotNull SpatialAngle gunDirection = new SpatialAngle(
                gunOrientation.getHorizontal(),
                gunOrientation.getVertical());
        return new BigProjectile(
                ((GunContainer) getParent()).getProjectileContainer(),
                new Location(getLocation().getAsArray()),
                new Velocity(gunDirection, getMuzzleVelocity()));
    }
}