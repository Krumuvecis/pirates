package graphical.stubs.tradeTest.trading;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

//
public abstract class TradingArea extends NamedObject implements Updatable {
    private final @NotNull List<@NotNull Trader> traders;

    //
    protected TradingArea(@NotNull String name) {
        super(name);
        traders = new ArrayList<>();
    }

    //
    public final void addTrader(@NotNull Trader trader) {
        traders.add(trader);
    }

    //for displaying purposes
    public final @NotNull List<@NotNull Trader> getTraders() {
        return Collections.unmodifiableList(traders);
    }

    //time in seconds
    @Override
    public final void update(double timeInterval) {
        updateEnvironment(timeInterval);
        updateTraders(timeInterval);
    }

    private void updateEnvironment(double timeInterval) {
        //TODO: finish this
    }

    private void updateTraders(double timeInterval) {
        for(Trader trader : traders) {
            trader.update(timeInterval);
        }
    }

    //
    public static final class Area1 extends TradingArea {
        private static final @NotNull String NAME = "Trading area 1";

        //
        public Area1() {
            super(NAME);
        }
    }
}