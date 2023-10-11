package models.bodies.dynamic;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.coordinates.Velocity;
import models.bodies.basic.BodyContainer;
import models.bodies.basic.ContainableBody;
import models.bodies.statics.StaticBody;

//location + orientation + velocity
public abstract class NonRotatingBody extends StaticBody implements VelocityBodyInterface {
    private @NotNull Velocity velocity;

    //
    public NonRotatingBody(BodyContainer<? extends ContainableBody> parent,
                           @NotNull Location location, @NotNull Orientation orientation,
                           @NotNull Velocity velocity) {
        super(parent, location, orientation);
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