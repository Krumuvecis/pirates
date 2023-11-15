package models.coordinates;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class Location implements CoordinateTripletInterface {
    private double x, y, z;

    //
    public Location(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //
    public Location(double @NotNull [] array) {
        this(array[0], array[1], array[2]);
    }

    /**
     * Gets x.
     *
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return y.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets z.
     *
     * @return z.
     */
    public double getZ() {
        return z;
    }

    //
    @Override
    public double @NotNull [] getAsArray() {
        return new double[] {
                getX(),
                getY(),
                getZ()
        };
    }

    //
    public void setX(double x) {
        this.x = x;
    }

    //
    public void setY(double y) {
        this.y = y;
    }

    //
    public void setZ(double z) {
        this.z = z;
    }

    //
    @Override
    public void setFromArray(double @NotNull [] array) {
        setX(array[0]);
        setY(array[1]);
        setY(array[2]);
    }

    /**
     * Increase x by delta.
     *
     * @param delta delta.
     */
    public void increaseX(double delta) {
        setX(getX() + delta);
    }

    /**
     * Increase y by delta.
     *
     * @param delta delta.
     */
    public void increaseY(double delta) {
        setY(getY() + delta);
    }

    /**
     * Increase z by delta.
     *
     * @param delta delta.
     */
    public void increaseZ(double delta) {
        setZ(getZ() + delta);
    }

    //
    public void increase(double deltaX, double deltaY, double deltaZ) {
        increaseX(deltaX);
        increaseY(deltaY);
        increaseZ(deltaZ);
    }
}