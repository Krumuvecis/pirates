package models.bodies.statics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.bodies.basic.ContainableBody;
import models.bodies.basic.BodyContainer;

//location only
public abstract class LocationBody extends ContainableBody implements LocationBodyInterface {
    private @NotNull Location location;

    //
    public LocationBody(BodyContainer<? extends ContainableBody> parent,
                        @NotNull Location location) {
        super(parent);
        this.location = location;
    }

    //
    @Override
    public final @NotNull Location getLocation() {
        return location;
    }

    //
    @Override
    public final void setLocation(@NotNull Location location) {
        this.location = location;
    }

    //
    @Override
    public final void translateBy(double deltaX, double deltaY, double deltaZ) {
        getLocation().increase(deltaX, deltaY, deltaZ);
    }
}