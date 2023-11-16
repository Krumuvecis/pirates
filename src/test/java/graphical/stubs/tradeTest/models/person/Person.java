package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;

import graphical.stubs.tradeTest.models.Updatable;
import graphical.stubs.tradeTest.models.NamedObject;

//
public abstract class Person extends NamedObject implements Updatable {
    private static final double
            DEFAULT_MAX_ENERGY = 100,
            DEFAULT_ENERGY_DRAIN = 10,
            DEFAULT_MAX_HEALTH = 100;
    private final @NotNull Energy energy;
    private final @NotNull Health health;

    //
    protected Person(@NotNull String name) {
        super(name);
        energy = new Energy(DEFAULT_MAX_ENERGY, DEFAULT_ENERGY_DRAIN);
        health = new Health(DEFAULT_MAX_HEALTH);
    }

    //
    @Override
    public void update(double timeInterval) {
        health.update(timeInterval);
        energy.update(timeInterval);
        //TODO: finish this
    }

    //
    public final @NotNull Energy getEnergy() {
        return energy;
    }

    //
    public final @NotNull Health getHealth() {
        return health;
    }

    //
    public static abstract class BoundedUpdatableValue implements Updatable {
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

    //
    public static final class Health extends BoundedUpdatableValue {
        //
        Health(double maxValue) {
            super(maxValue, maxValue);
        }

        //
        @Override
        public void update(double timeInterval) {
            //TODO: finish this
            super.update(timeInterval);
        }
    }

    //
    public static final class Energy extends BoundedUpdatableValue {
        private double passiveDrain; //per second

        //
        Energy(double maxValue, double passiveDrain) {
            super(maxValue, maxValue);
            this.passiveDrain = passiveDrain;
        }

        //
        @Override
        public void update(double timeInterval) {
            applyPassiveDrain(timeInterval);
            super.update(timeInterval);
        }

        //
        public double getPassiveDrain() {
            return passiveDrain;
        }

        //
        public void setPassiveDrain(double passiveDrain) {
            this.passiveDrain = passiveDrain;
        }

        private void applyPassiveDrain(double timeInterval) {
            increaseValue(-passiveDrain * timeInterval);
        }
    }
}