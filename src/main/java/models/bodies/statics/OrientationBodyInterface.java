package models.bodies.statics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Orientation;

//
public interface OrientationBodyInterface {
    //
    @NotNull Orientation getOrientation();

    //
    void setOrientation(@NotNull Orientation orientation);

    //
    void rotateBy(double deltaHorizontal, double deltaVertical, double deltaRoll);
}