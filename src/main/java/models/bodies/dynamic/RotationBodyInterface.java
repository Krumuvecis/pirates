package models.bodies.dynamic;

import models.coordinates.Rotation;
import org.jetbrains.annotations.NotNull;

//
public interface RotationBodyInterface {
    //
    @NotNull Rotation getRotation();

    //
    void setRotation(@NotNull Rotation rotation);

    //
    void rotate(double deltaTime);

    //
    static void rotate(RotationBodyInterface body, double deltaTime) {
        //TODO: finish this
    }
}