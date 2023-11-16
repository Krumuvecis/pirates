package graphical.stubs.tradeTest.models.world;

import org.jetbrains.annotations.NotNull;

import graphical.stubs.tradeTest.models.Updatable;
import graphical.stubs.tradeTest.models.person.Trader;

//
public abstract class AbstractWorld implements Updatable {
    private static final @NotNull TradingArea TRADING_AREA = new TradingArea.Area1();
    private final @NotNull TradingArea tradingArea;
    private double age; //world age in seconds

    //
    protected AbstractWorld() {
        tradingArea = TRADING_AREA;
        age = 0;
    }

    //
    public final @NotNull TradingArea getTradingArea() {
        return tradingArea;
    }

    //time in seconds
    public final double getAge() {
        return age;
    }

    //
    public final int @NotNull [] getAgeHMS() {
        int
                secondsInMinute = 60,
                minutesInHour = 60,
                secondsInHour = secondsInMinute * minutesInHour,
                totalWholeSeconds = (int) Math.floor(age),
                hours = Math.floorDiv(totalWholeSeconds, secondsInHour),
                hoursAsSeconds = hours * secondsInHour,
                remainderSecondsAfterHours = totalWholeSeconds - hoursAsSeconds,
                minutes = Math.floorDiv(remainderSecondsAfterHours, secondsInMinute),
                minutesAsSeconds = minutes * secondsInMinute,
                seconds = remainderSecondsAfterHours - minutesAsSeconds;
        return new int[] {
                hours,
                minutes,
                seconds
        };
    }

    //
    public void addTrader(@NotNull Trader trader) {
        tradingArea.addTrader(trader);
    }

    //time in seconds
    public final void update(double timeInterval) {
        updateAge(timeInterval);
        updateTradingArea(timeInterval);
    }

    private void updateAge(double timeInterval) {
        age += timeInterval;
        if (age < 0) {
            throw new RuntimeException("World age exceeded Double.MAX_VALUE");
        }
    }

    private void updateTradingArea(double timeInterval) {
        tradingArea.update(timeInterval);
    }

    //a world instance
    public static class World extends AbstractWorld {
        //
        public World() {
            super();
            addTrader(generateTrader1());
            addTrader(generateTrader2());
        }

        private static @NotNull Trader generateTrader1() {
            return new Trader.Trader1();
        }

        private static @NotNull Trader generateTrader2() {
            return new Trader.Trader2();
        }
    }
}