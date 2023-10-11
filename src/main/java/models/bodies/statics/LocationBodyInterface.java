package models.bodies.statics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;

//
public interface LocationBodyInterface {
    //
    @NotNull Location getLocation();

    //
    void setLocation(@NotNull Location location);

    //
    void translateBy(double deltaX, double deltaY, double deltaZ);
}