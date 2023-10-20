package models.coordinates;

//
public class SpatialAngle {
    private double horizontal, vertical;

    //
    public SpatialAngle(double horizontal, double vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
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
        normalizeHorizontal();
    }

    private void normalizeHorizontal() {
        double fullCircle = 2 * Math.PI;
        while (getHorizontal() >= fullCircle) {
            increaseHorizontal(-fullCircle);
        }
        while (getHorizontal() < 0) {
            increaseHorizontal(fullCircle);
        }
    }

    //
    public void setVertical(double vertical) {
        this.vertical = vertical;
        normalizeVertical();
    }

    //TODO: finish this; incorporate roll component
    private void normalizeVertical() {
        double
                halfCircle = Math.PI,
                fullCircle = 2 * halfCircle;
        while (getVertical() >= halfCircle) {
            increaseVertical(-fullCircle);
        }
        while (getVertical() < -halfCircle) {
            increaseVertical(fullCircle);
        }
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