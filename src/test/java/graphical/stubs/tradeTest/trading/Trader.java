package graphical.stubs.tradeTest.trading;

import org.jetbrains.annotations.NotNull;

//
public abstract class Trader extends NamedObject implements Updatable {
    //
    protected Trader(@NotNull String name) {
        super(name);
    }

    //
    @Override
    public void update(double timeInterval) {
        //TODO: finish this
    }

    //
    public static final class Trader1 extends Trader {
        private static final @NotNull String NAME = "Trader-1";

        //
        public Trader1() {
            super(NAME);
        }
    }
}