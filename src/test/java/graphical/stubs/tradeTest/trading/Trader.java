package graphical.stubs.tradeTest.trading;

import org.jetbrains.annotations.NotNull;

//
public abstract class Trader extends NamedObject {
    //
    protected Trader(@NotNull String name) {
        super(name);
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