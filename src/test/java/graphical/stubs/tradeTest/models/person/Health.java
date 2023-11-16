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
    Health(double maxValue, @NotNull Energy energy,
           double energyHealThreshold, double energyHealRate,
           double energyDamageThreshold, double energyDamageRate) {
        super(maxValue, DEFAULT_BASE_DECAY_RATE);
        baseDecayRate = DEFAULT_BASE_DECAY_RATE;
        this.energy = energy;
        this.energyHealThreshold = energyHealThreshold;
        this.energyHealRate = energyHealRate;
        this.energyDamageThreshold = energyDamageThreshold;
        this.energyDamageRate = energyDamageRate;
    }

    //
    @Override
    public final void update(double timeInterval) {
        setDecayRate(baseDecayRate);
        double relativeEnergy = energy.getRelativeValue();
        if (relativeEnergy > energyHealThreshold) {
            setDecayRate(-energyHealRate);
        }
        if (relativeEnergy < energyDamageThreshold) {
            setDecayRate(energyDamageRate);
        }
        super.update(timeInterval);
    }

    //
    protected static final class DefaultHealthModel extends Health {
        private static final double
                ENERGY_HEAL_THRESHOLD = 0.8,
                ENERGY_HEAL_RATE = 10,
                ENERGY_DAMAGE_THRESHOLD = 0.2,
                ENERGY_DAMAGE_RATE = 10;

        //
        DefaultHealthModel(double maxValue, @NotNull Energy energy) {
            super(maxValue, energy,
                    ENERGY_HEAL_THRESHOLD, ENERGY_HEAL_RATE,
                    ENERGY_DAMAGE_THRESHOLD, ENERGY_DAMAGE_RATE);
        }
    }
}