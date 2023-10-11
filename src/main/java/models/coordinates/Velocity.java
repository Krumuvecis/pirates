package models.coordinates;

import org.jetbrains.annotations.NotNull;

//
public class Velocity extends SpatialAngle implements CoordinateTripletInterface {
    private double speed;

    //
    public Velocity(double horizontalAngle, double verticalAngle, double speed) {
        super(horizontalAngle, verticalAngle);
        this.speed = speed;
    }

    //
    public Velocity(@NotNull SpatialAngle direction, double speed) {
        this(direction.getHorizontal(), direction.getHorizontal(), speed);
    }

    //
    public Velocity(double @NotNull [] array) {
        this(array[0], array[1], array[2]);
    }

    //
    public double getSpeed() {
        return speed;
    }

    //
    @Override
    public double @NotNull [] getAsArray() {
        return new double[] {
                getHorizontal(),
                getVertical(),
                getSpeed()
        };
    }

    //
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //
    @Override
    public void setFromArray(double @NotNull [] array) {
        setHorizontal(array[0]);
        setVertical(array[1]);
        setSpeed(array[2]);
    }
}