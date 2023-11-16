package graphical.stubs.tradeTest.models.person;

import graphical.stubs.tradeTest.models.Updatable;

//
public abstract class BoundedUpdatableValue implements Updatable {
    private final double maxValue;
    private double value;

    //
    protected BoundedUpdatableValue(double maxValue, double value) {
        this.maxValue = maxValue;
        this.value = value;
    }

    //
    public final double getMaxValue() {
        return maxValue;
    }

    //
    public final double getValue() {
        return value;
    }

    //
    public final double getRelativeValue() {
        return value / maxValue;
    }

    //
    public final void increaseValue(double delta) {
        value += delta;
    }

    //
    @Override
    public void update(double timeInterval) {
        checkBounds();
    }

    private void checkBounds() {
        if (value < 0) {
            value = 0;
        }
        if (value > maxValue) {
            value = maxValue;
        }
    }
}