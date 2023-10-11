package models.coordinates;

//
public class SpatialAngle {
    private double horizontal, vertical;

    //
    public SpatialAngle(double horizontal, double vertical) {
        setHorizontal(horizontal);
        setVertical(vertical);
    }

    //
    public double getHorizontal() {
        return horizontal;
    }

    //
    public double getVertical() {
        return vertical;
    }

    //
    public void setHorizontal(double horizontal) {
        this.horizontal = horizontal;
    }

    //
    public void setVertical(double vertical) {
        this.vertical = vertical;
    }

    //
    public void increaseHorizontal(double delta) {
        setHorizontal(getHorizontal() + delta);
    }

    //
    public void increaseVertical(double delta) {
        setVertical(getVertical() + delta);
    }

    //
    public void increase(double deltaHorizontal, double deltaVertical) {
        increaseHorizontal(deltaHorizontal);
        increaseVertical(deltaVertical);
    }
}