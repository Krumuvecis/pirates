package graphical.stubs.tradeTest.models.person;

//
public abstract class PassivelyDecayingValue extends BoundedUpdatableValue {
    private double decayRate; //per second

    //
    protected PassivelyDecayingValue(double maxValue, double decayRate) {
        super(maxValue, maxValue);
        this.decayRate = decayRate;
    }

    //
    @Override
    public void update(double timeInterval) throws UpdatableException {
        applyDecay(timeInterval);
        super.update(timeInterval);
    }

    //
    public final double getDecayRate() {
        return decayRate;
    }

    //
    public final void setDecayRate(double decayRate) {
        this.decayRate = decayRate;
    }

    private void applyDecay(double timeInterval) {
        increaseValue(-decayRate * timeInterval);
    }
}