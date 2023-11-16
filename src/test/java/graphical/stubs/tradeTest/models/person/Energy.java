package graphical.stubs.tradeTest.models.person;

//
public final class Energy extends PassivelyDecayingValue {
    //
    Energy(double maxValue, double passiveDecayRate) {
        super(maxValue, passiveDecayRate);
    }

    //can remove?
    @Override
    public void update(double timeInterval) {
        super.update(timeInterval);
    }
}