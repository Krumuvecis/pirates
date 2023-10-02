package models;

import org.jetbrains.annotations.NotNull;

//
public class Coordinates {
    private final double @NotNull [] location;
    private double angle;

    //
    public Coordinates(double @NotNull [] location, double angle) {
        this.location = location;
        this.angle = angle;
    }

    //
    public Coordinates(@NotNull Coordinates coordinates) {
        this(
                copyLocation(coordinates.getLocation()),
                coordinates.getAngle());
    }

    //
    public double[] getLocation() {
        return location;
    }

    //
    public double getAngle() {
        return angle;
    }

    //
    public void setAngle(double angle) {
        this.angle = angle;
    }

    private static double @NotNull [] copyLocation(double @NotNull [] location) {
        return new double[] {location[0], location[1]};
    }
}