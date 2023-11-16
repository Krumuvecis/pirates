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
    public void update(double timeInterval) throws UpdatableException {
        checkBounds();
    }

    private void checkBounds() throws LowerBoundExceededException, UpperBoundExceededException {
        if (value < 0) {
            value = 0;
            throw new LowerBoundExceededException();
        }
        if (value > maxValue) {
            value = maxValue;
            throw new UpperBoundExceededException();
        }
    }

    //
    public static class LowerBoundExceededException extends UpdatableException {
        protected LowerBoundExceededException() {
            super("Lower bound exceeded.");
        }
    }

    //
    public static class UpperBoundExceededException extends UpdatableException {
        protected UpperBoundExceededException() {
            super("Upper bound exceeded.");
        }
    }
}