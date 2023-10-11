package models.bodies.statics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.bodies.basic.BodyContainer;
import models.bodies.basic.ContainableBody;

//
public abstract class StaticBody extends LocationBody implements OrientationBodyInterface {
    private Orientation orientation;

    //
    public StaticBody(BodyContainer<? extends ContainableBody> parent,
                      Location location, Orientation orientation) {
        super(parent, location);
        setOrientation(orientation);
    }

    //
    @Override
    public final @NotNull Orientation getOrientation() {
        return orientation;
    }

    //
    @Override
    public final void setOrientation(@NotNull Orientation orientation) {
        this.orientation = orientation;
    }

    //
    @Override
    public final void rotateBy(double deltaHorizontal, double deltaVertical, double deltaRoll) {
        getOrientation().increase(deltaHorizontal, deltaVertical, deltaRoll);
    }
}