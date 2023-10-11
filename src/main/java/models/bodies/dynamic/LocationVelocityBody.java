package models.bodies.dynamic;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Velocity;
import models.bodies.basic.BodyContainer;
import models.bodies.basic.ContainableBody;
import models.bodies.statics.LocationBody;

//location + velocity, no orientation
public abstract class LocationVelocityBody extends LocationBody implements VelocityBodyInterface {
    private @NotNull Velocity velocity;

    //
    public LocationVelocityBody(BodyContainer<? extends ContainableBody> parent,
                                @NotNull Location location, @NotNull Velocity velocity) {
        super(parent, location);
        this.velocity = velocity;
    }

    //
    @Override
    public final @NotNull Velocity getVelocity() {
        return velocity;
    }

    //
    @Override
    public final void setVelocity(@NotNull Velocity velocity) {
        this.velocity = velocity;
    }

    //
    @Override
    public void translate(double deltaTime) {
        VelocityBodyInterface.translate(this, deltaTime);
    }
}