package models.coordinates;

import org.jetbrains.annotations.NotNull;

//
public class LinearAcceleration implements CoordinateTripletInterface {
    private double ax, ay, az;

    //
    public LinearAcceleration(double ax, double ay, double az) {
        this.ax = ax;
        this.ay = ay;
        this.az = az;
    }

    //
    public double getX() {
        return ax;
    }

    //
    public double getY() {
        return ay;
    }

    //
    public double getZ() {
        return az;
    }

    //
    @Override
    public double @NotNull [] getAsArray() {
        return new double[] {getX(), getY(), getZ()};
    }

    public void setX(double x) {
        this.ax = x;
    }

    public void setY(double y) {
        this.ay = y;
    }

    //
    public void setZ(double z) {
        this.az = z;
    }

    //
    @Override
    public void setFromArray(double @NotNull [] array) {
        setX(array[0]);
        setY(array[1]);
        setZ(array[2]);
    }
}