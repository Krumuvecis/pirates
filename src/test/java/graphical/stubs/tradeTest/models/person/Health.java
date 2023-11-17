package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;

//
public class Health extends PassivelyDecayingValue {
    private static final double DEFAULT_BASE_DECAY_RATE = 0;
    private final @NotNull Energy energy;
    private final double
            baseDecayRate,
            energyHealThreshold,
            energyHealRate,
            energyDamageThreshold,
            energyDamageRate;

    //
    protected Health(@NotNull HealthInitialParameters parameters, @NotNull Energy energy) {
        super(parameters.maxValue, DEFAULT_BASE_DECAY_RATE);
        baseDecayRate = DEFAULT_BASE_DECAY_RATE;
        this.energy = energy;
        this.energyHealThreshold = parameters.energyHealThreshold;
        this.energyHealRate = parameters.energyHealRate;
        this.energyDamageThreshold = parameters.energyDamageThreshold;
        this.energyDamageRate = parameters.energyDamageRate;
    }

    //
    @Override
    public final void update(double timeInterval) throws UpdatableException {
        setDecayRate(baseDecayRate);
        double relativeEnergy = energy.getRelativeValue();
        if (relativeEnergy > energyHealThreshold) {
            setDecayRate(-energyHealRate);
        }
        if (relativeEnergy < energyDamageThreshold) {
            setDecayRate(energyDamageRate);
        }
        try {
            super.update(timeInterval);
        } catch (LowerBoundExceededException ignored) {
            throw new NoHealthException();
        } catch (UpperBoundExceededException ignored) {
            //max health exceeded
        }
    }

    protected static class NoHealthException extends UpdatableException {
        protected NoHealthException() {
            super("No health exception.");
        }
    }

    //
    protected static final class HealthInitialParameters {
        final double
                maxValue,
                energyHealThreshold,
                energyHealRate,
                energyDamageThreshold,
                energyDamageRate;

        //
        HealthInitialParameters(double maxValue,
                                double energyHealThreshold, double energyHealRate,
                                double energyDamageThreshold, double energyDamageRate) {
            this.maxValue = maxValue;
            this.energyHealThreshold = energyHealThreshold;
            this.energyHealRate = energyHealRate;
            this.energyDamageThreshold = energyDamageThreshold;
            this.energyDamageRate = energyDamageRate;
        }
    }
}