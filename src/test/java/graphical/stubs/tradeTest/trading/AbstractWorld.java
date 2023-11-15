package graphical.stubs.tradeTest.trading;

import org.jetbrains.annotations.NotNull;

//
public abstract class AbstractWorld {
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