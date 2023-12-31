package models.coordinates;

import org.jetbrains.annotations.NotNull;

//
public class Orientation extends SpatialAngle implements CoordinateTripletInterface {
    private double roll;

    //
    public Orientation(double horizontalAngle, double verticalAngle, double roll) {
        super(horizontalAngle, verticalAngle);
        this.roll = roll;
    }

    //
    public Orientation(double @NotNull [] array) {
        this(array[0], array[1], array[2]);
    }

    //
    public double getRoll() {
        return roll;
    }

    //from interface
    @Override
    public double @NotNull [] getAsArray() {
        return new double[] {
                getHorizontal(),
                getVertical(),
                getRoll()
        };
    }

    //
    public void setRoll(double roll) {
        this.roll = roll;
        normalizeRoll();
    }

    private void normalizeRoll() {
        double fullCircle = 2 * Math.PI;
        while (roll >= fullCircle) {
            roll -= fullCircle;
        }
        while (roll < 0) {
            roll += fullCircle;
        }
    }

    //from interface
    @Override
    public void setFromArray(double @NotNull [] array) {
        setHorizontal(array[0]);
        setVertical(array[1]);
        setRoll(array[2]);
    }

    //
    public void increaseRoll(double delta) {
        setRoll(getRoll() + delta);
    }

    //
    public void increase(double deltaHorizontal, double deltaVertical, double deltaRoll) {
        increase(deltaHorizontal, deltaVertical);
        increaseRoll(deltaRoll);
    }
}