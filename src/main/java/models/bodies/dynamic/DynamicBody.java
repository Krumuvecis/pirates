package models.bodies.dynamic;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.coordinates.Velocity;
import models.coordinates.Rotation;
import models.bodies.basic.BodyContainer;
import models.bodies.basic.ContainableBody;

//
public class DynamicBody extends NonRotatingBody implements RotationBodyInterface {
    private @NotNull Rotation rotation;

    //
    public DynamicBody(BodyContainer<? extends ContainableBody> parent,
                       @NotNull Location location, @NotNull Orientation orientation,
                       @NotNull Velocity velocity, @NotNull Rotation rotation) {
        super(parent, location, orientation, velocity);
        this.rotation = rotation;
    }

    //
    @Override
    public final @NotNull Rotation getRotation() {
        return rotation;
    }

    //
    @Override
    public final void setRotation(@NotNull Rotation rotation) {
        this.rotation = rotation;
    }

    //
    @Override
    public void rotate(double deltaTime) {
        RotationBodyInterface.rotate(this, deltaTime);
    }
}