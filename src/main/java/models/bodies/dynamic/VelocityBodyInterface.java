package models.bodies.dynamic;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Velocity;
import models.bodies.statics.LocationBodyInterface;

//
public interface VelocityBodyInterface extends LocationBodyInterface {
    //
    @NotNull Velocity getVelocity();

    //
    void setVelocity(@NotNull Velocity velocity);

    //
    void translate(double deltaTime);

    static void translate(@NotNull VelocityBodyInterface body, double deltaTime) {
        @NotNull Velocity velocity = body.getVelocity();
        double
                v = velocity.getSpeed(),
                phi = velocity.getHorizontal(),
                theta = velocity.getVertical(),
                vxy = v * Math.cos(theta),
                vz = v * Math.sin(theta),
                vx = vxy * Math.cos(phi),
                vy = vxy * Math.sin(phi);
        body.translateBy(vx * deltaTime, vy * deltaTime, vz * deltaTime);
    }
}