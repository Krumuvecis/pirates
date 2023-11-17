package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;

//
public abstract class Person extends AliveBeing {
    private static final Energy.EnergyInitialParameters DEFAULT_ENERGY_PARAMETERS = new Energy.EnergyInitialParameters(
            100, 10);
    private static final Health.HealthInitialParameters DEFAULT_HEALTH_PARAMETERS = new Health.HealthInitialParameters(
            100,
            0.8, 10,
            0.2, 10);

    //
    protected Person(@NotNull String name) {
        super(name, DEFAULT_ENERGY_PARAMETERS, DEFAULT_HEALTH_PARAMETERS);
    }
}