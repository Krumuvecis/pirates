package graphical.stubs.tradeTest.models.world;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import graphical.stubs.tradeTest.models.Updatable;
import graphical.stubs.tradeTest.models.NamedObject;
import graphical.stubs.tradeTest.models.person.DeathException;
import graphical.stubs.tradeTest.models.person.Trader;

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
        try {
            updateEnvironment(timeInterval);
            updateTraders(timeInterval);
        } catch (UpdatableException e) {
            System.err.println("Unhandled exception while updating trading area.");
            throw new RuntimeException(e);
        }
    }

    private void updateEnvironment(double timeInterval) {
        //TODO: finish this
    }

    private void updateTraders(double timeInterval) throws UpdatableException {
        for(int i = 0; i < traders.size(); i++) {
            @NotNull Trader trader = traders.get(i);
            try {
                trader.update(timeInterval);
            } catch (DeathException ignored) {
                //this trader is dead
                //TODO: finish this
            }
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