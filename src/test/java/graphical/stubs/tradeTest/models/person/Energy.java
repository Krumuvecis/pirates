package graphical.stubs.tradeTest.models.person;

//
public final class Energy extends PassivelyDecayingValue {
    //
    Energy(double maxValue, double passiveDecayRate) {
        super(maxValue, passiveDecayRate);
    }

    //
    @Override
    public void update(double timeInterval) throws UpdatableException {
        try {
            super.update(timeInterval);
        } catch (LowerBoundExceededException ignored) {
            //out of energy
        } catch (UpperBoundExceededException ignored) {
            //max energy exceeded
        }
    }
}