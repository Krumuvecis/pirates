package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;

//
public abstract class Trader extends Person {
    //
    protected Trader(@NotNull String name) {
        super(name);
    }

    //
    @Override
    public void update(double timeInterval) {
        super.update(timeInterval);
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

    //
    public static final class Trader2 extends Trader {
        private static final @NotNull String NAME = "Trader-2";

        //
        public Trader2() {
            super(NAME);
        }
    }
}