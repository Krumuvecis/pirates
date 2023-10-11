package models.guns;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.bodies.basic.ContainableBody;
import models.bodies.basic.BodyContainer;
import models.bodies.statics.StaticBody;
import models.AbstractProjectile;
import models.ProjectileManager;

//
public abstract class AbstractGun extends StaticBody {
    private final @NotNull ProjectileManager projectileManager;

    //
    public AbstractGun(BodyContainer<? extends ContainableBody> parent,
                       @NotNull Location location, @NotNull Orientation orientation) {
        super(parent, location, orientation);
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