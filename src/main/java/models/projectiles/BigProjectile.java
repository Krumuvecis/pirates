package models.projectiles;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Velocity;
import models.bodies.basic.ContainableBody;
import models.bodies.basic.BodyContainer;

//
public final class BigProjectile extends AbstractProjectile {
    private static final double SIZE = 30;

    //
    public BigProjectile(BodyContainer<? extends ContainableBody> parent,
                         @NotNull Location location, @NotNull Velocity velocity) {
        super(parent, location, velocity);
    }

    //
    @Override
    public double getSize() {
        return SIZE;
    }
}