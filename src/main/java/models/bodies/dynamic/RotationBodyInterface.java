package models.bodies.dynamic;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Rotation;

//
public interface RotationBodyInterface {
    //
    @NotNull Rotation getRotation();

    //
    void setRotation(@NotNull Rotation rotation);

    //
    void rotate(double deltaTime);

    //time in seconds
    static void rotate(RotationBodyInterface body, double deltaTime) {
        //TODO: finish this
    }
}