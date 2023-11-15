package models.bodies.dynamic;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Velocity;
import models.coordinates.LinearAcceleration;
import models.bodies.statics.LocationBodyInterface;

//
public interface VelocityBodyInterface extends LocationBodyInterface {
    //
    @NotNull Velocity getVelocity();

    //
    @NotNull LinearAcceleration getAcceleration();

    //
    void setVelocity(@NotNull Velocity velocity);

    //time in seconds
    void translate(double deltaTime);

    //time in seconds
    static void translate(@NotNull VelocityBodyInterface body, double deltaTime) {
        @NotNull Velocity velocity = body.getVelocity();
        @NotNull LinearAcceleration acceleration = body.getAcceleration();
        double
                v = velocity.getSpeed(),
                phi = velocity.getHorizontal(),
                theta = velocity.getVertical(),
                vxy = v * Math.cos(theta),
                vx = vxy * Math.cos(phi),
                vy = vxy * Math.sin(phi),
                vz = v * Math.sin(theta),
                deltaVx = acceleration.getX() * deltaTime,
                deltaVy = acceleration.getY() * deltaTime,
                deltaVz = acceleration.getZ() * deltaTime;
        body.translateBy(
                (vx + deltaVx / 2) * deltaTime,
                (vy + deltaVy / 2) * deltaTime,
                (vz + deltaVz / 2) * deltaTime);
        body.setVelocity(new Velocity(getRadialFromCartesian(
                vx + deltaVx,
                vy + deltaVy,
                vz + deltaVz
        )));
    }

    private static double @NotNull [] getRadialFromCartesian(double vx, double vy, double vz) {
        double vxy_squared = Math.pow(vx, 2) + Math.pow(vy, 2);
        return new double[] {
                getHorizontalAngle(vx, vy),
                getVerticalAngle(Math.sqrt(vxy_squared), vz),
                Math.sqrt(vxy_squared + Math.pow(vz, 2))
        };
    }

    //
    private static double getHorizontalAngle(double x, double y) {
        double
                angle = Math.atan(y / x),
                fullCircle = 2 * Math.PI;
        if (x < 0) {
            angle = angle + Math.PI;
        }
        while (angle >= fullCircle) {
            angle -= fullCircle;
        }
        while (angle < 0) {
            angle += fullCircle;
        }
        return angle;
    }

    private static double getVerticalAngle(double horizontalProjection, double verticalProjection) {
        return Math.atan(verticalProjection / horizontalProjection);
    }
}