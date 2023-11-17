package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;

//
public class Energy extends PassivelyDecayingValue {
    //
    protected Energy(@NotNull EnergyInitialParameters parameters) {
        super(parameters.maxValue, parameters.passiveDecayRate);
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

    //
    protected static final class EnergyInitialParameters {
        final double
                maxValue,
                passiveDecayRate;

        //
        EnergyInitialParameters(double maxValue, double passiveDecayRate) {
            this.maxValue = maxValue;
            this.passiveDecayRate = passiveDecayRate;
        }
    }
}