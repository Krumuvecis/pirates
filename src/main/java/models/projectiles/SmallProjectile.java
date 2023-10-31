package models.projectiles;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Velocity;
import models.bodies.basic.ContainableBody;
import models.bodies.basic.BodyContainer;

//
public final class SmallProjectile extends AbstractProjectile {
    private static final double SIZE = 0.1;

    //
    public SmallProjectile(BodyContainer<? extends ContainableBody> parent,
                           @NotNull Location location, @NotNull Velocity velocity) {
        super(parent, location, velocity);
    }

    //
    @Override
    public double getSize() {
        return SIZE;
    }
}