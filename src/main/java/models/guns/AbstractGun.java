package models.guns;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.bodies.statics.StaticBody;
import models.projectiles.AbstractProjectile;

//
public abstract class AbstractGun extends StaticBody {
    //
    public AbstractGun(@NotNull GunContainer parent,
                       @NotNull Location location, @NotNull Orientation orientation) {
        super(parent, location, orientation);
    }

    //
    public abstract double getMuzzleVelocity();

    //
    public abstract @NotNull AbstractProjectile getNewProjectile();

    //
    public void shoot() {
        ((GunContainer) getParent()).addProjectile(getNewProjectile());
    }
}