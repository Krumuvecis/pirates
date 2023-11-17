package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;

import graphical.stubs.tradeTest.models.NamedObject;
import graphical.stubs.tradeTest.models.Updatable;

//
public abstract class AliveBeing extends NamedObject implements Updatable {
    private final @NotNull Energy energy;
    private final @NotNull Health health;

    //
    protected AliveBeing(@NotNull String name,
                         @NotNull Energy.EnergyInitialParameters energyParameters,
                         @NotNull Health.HealthInitialParameters healthParameters) {
        super(name);
        energy = new Energy(energyParameters);
        health = new Health(healthParameters, energy);
    }

    //
    @Override
    public void update(double timeInterval) throws UpdatableException {
        try {
            health.update(timeInterval);
        } catch (Health.NoHealthException e) {
            throw new DeathException(this);
        }
        energy.update(timeInterval);
        act(timeInterval);
    }

    //
    public abstract void act(double timeInterval);

    //
    public final @NotNull Energy getEnergy() {
        return energy;
    }

    //
    public final @NotNull Health getHealth() {
        return health;
    }
}