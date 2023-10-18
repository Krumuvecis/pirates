package models.projectiles;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Velocity;
import models.coordinates.LinearAcceleration;
import models.bodies.basic.BodyContainer;
import models.bodies.basic.ContainableBody;
import models.bodies.dynamic.LocationVelocityBody;

//
public abstract class AbstractProjectile extends LocationVelocityBody {
    private static final @NotNull LinearAcceleration DEFAULT_ACCELERATION = new LinearAcceleration(-3.7, 0.3, 0);

    //
    public AbstractProjectile(BodyContainer<? extends ContainableBody> parent,
                              @NotNull Location location, @NotNull Velocity velocity) {
        super(parent, location, velocity);
    }

    //
    @Override
    public @NotNull LinearAcceleration getAcceleration() {
        return DEFAULT_ACCELERATION;
    }

    //
    public abstract double getSize();
}