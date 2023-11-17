package graphical.stubs.tradeTest.graphics;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphical.stubs.tradeTest.models.world.AbstractWorld;

import graphical.common.graphics.AbstractDrawPanel;

//
public class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50, 255),
            TEXT_COLOR = new Color(255, 220, 0, 180);
    private static final int @NotNull []
            TEXT_LOCATION = new int[] {30, 30},
            DRAW_OFFSET = new int[] {50, 50};
    private final @NotNull AbstractHorizontalPainter
            marketInfoPainter,
            traderPainter;

    //
    public DrawPanel(@NotNull AbstractWorld world) {
        super(BACKGROUND);
        marketInfoPainter = new MarketInfoPainter(world);
        traderPainter = new TraderPainter(world.getTradingArea());
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        ((TraderPainter) traderPainter).updateTraders(); //for easier calculations, unmodifiable list caching
        marketInfoPainter.draw(g, DRAW_OFFSET);
        int @NotNull [] traderPainterOffset = AbstractHorizontalPainter.getShiftedOffset(
                DRAW_OFFSET, marketInfoPainter.getHeight());
        traderPainter.draw(g, traderPainterOffset);
        drawString(g, TEXT_COLOR, TEXT_LOCATION, "Testing trading"); //removable
    }
}