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
        health = new Health.DefaultHealthModel(DEFAULT_MAX_HEALTH, energy);
    }

    //
    @Override
    public void update(double timeInterval) {
        health.update(timeInterval);
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