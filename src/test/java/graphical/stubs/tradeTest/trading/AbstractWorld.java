package graphical.stubs.tradeTest.trading;

import org.jetbrains.annotations.NotNull;

//
public abstract class AbstractWorld implements Updatable {
    private static final @NotNull TradingArea TRADING_AREA = new TradingArea.Area1();
    private final @NotNull TradingArea tradingArea;

    //
    protected AbstractWorld() {
        tradingArea = TRADING_AREA;
    }

    //
    public final @NotNull TradingArea getTradingArea() {
        return tradingArea;
    }


    public final void update(double timeInterval) {
        tradingArea.update(timeInterval);
        //TODO: finish this
    }

    //
    public static class World extends AbstractWorld {
        //
        public World() {
            super();
            getTradingArea().addTrader(generateTrader1());
        }

        private static @NotNull Trader generateTrader1() {
            return new Trader.Trader1();
        }
    }
}