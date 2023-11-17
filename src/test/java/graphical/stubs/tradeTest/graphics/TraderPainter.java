package graphical.stubs.tradeTest.graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.stubs.tradeTest.models.person.Energy;
import graphical.stubs.tradeTest.models.person.Health;
import graphical.stubs.tradeTest.models.person.Person;
import graphical.stubs.tradeTest.models.person.Trader;
import graphical.stubs.tradeTest.models.world.TradingArea;

//
class TraderPainter extends AbstractHorizontalPainter {
    private static final int
            LINE_HEIGHT = 15,
            LINES_PER_TRADER = 6,
            SINGLE_TRADER_INFO_HEIGHT = LINE_HEIGHT * LINES_PER_TRADER;

    private final @NotNull TradingArea tradingArea;
    private @NotNull List<@NotNull Trader> traders;

    //
    protected TraderPainter(@NotNull TradingArea tradingArea) {
        super(null);
        this.tradingArea = tradingArea;
        traders = tradingArea.getTraders();
    }

    //
    void updateTraders() {
        traders = tradingArea.getTraders();
    }

    //
    @Override
    public void draw(@NotNull Graphics g, int @NotNull [] drawOffset) {
        drawString(g, null, drawOffset, "Trader info:");
        for (int i = 0; i < traders.size(); i++) {
            int @NotNull [] traderDrawLocation = getShiftedOffset(
                    drawOffset,
                    SINGLE_TRADER_INFO_HEIGHT * i);
            @NotNull Trader trader = traders.get(i);
            drawSingleTraderInfo(g, traderDrawLocation, trader);
        }
    }

    private void drawSingleTraderInfo(@NotNull Graphics g, int @NotNull [] drawOffset,
                                      @NotNull Trader trader) {
        drawSingleTraderInfoLines(g, drawOffset, new ArrayList<>() {{
            add(trader.getName());
            @NotNull Health health = trader.getHealth();
            add("Health: " + ((int) health.getValue()) + " / " + ((int) health.getMaxValue()));
            @NotNull Energy energy = trader.getEnergy();
            add("Energy: " + ((int) energy.getValue()) + " / " + ((int) energy.getMaxValue()));
            @Nullable Person.PersonAction action = trader.getAction();
            @NotNull String
                    actionTitle = Person.PersonAction.IDLE_TITLE,
                    actionDescription = Person.PersonAction.IDLE_DESCRIPTION;
            if (action != null) {
                actionTitle = action.getTitle();
                actionDescription = action.getDescription();
                if (action instanceof Person.TimedAction) {
                    actionDescription += ", remaining time: "
                            + (((int) (((Person.TimedAction) action).getRemainingTime() * 10)) / 10.0)
                            + " s";
                }
            }
            add("Action: " + actionTitle + " - " + actionDescription);
        }});
    }

    private void drawSingleTraderInfoLines(@NotNull Graphics g, int @NotNull [] drawOffset,
                                           @NotNull List<@Nullable String> infoLines) {
        for (int i = 0; i < infoLines.size(); i++) {
            int @NotNull [] drawLocation = getShiftedOffset(drawOffset, (i + 1) * LINE_HEIGHT);
            drawString(g, null, drawLocation, infoLines.get(i));
        }
    }

    //
    @Override
    public int getHeight() {
        return SINGLE_TRADER_INFO_HEIGHT * traders.size();
    }
}