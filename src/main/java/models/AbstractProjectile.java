package models;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Velocity;
import models.bodies.basic.BodyContainer;
import models.bodies.basic.ContainableBody;
import models.bodies.dynamic.LocationVelocityBody;

//
public abstract class AbstractProjectile extends LocationVelocityBody {
    //
    public AbstractProjectile(BodyContainer<? extends ContainableBody> parent,
                              @NotNull Location location, @NotNull Velocity velocity) {
        super(parent, location, velocity);
    }

    //
    public abstract double getSize();

    //
    public static final class SmallProjectile extends AbstractProjectile {
        private static final double SIZE = 10;

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

    //
    public static final class BigProjectile extends AbstractProjectile {
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
}