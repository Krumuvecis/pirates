package graphical.stubs.tradeTest.graphics;

import java.util.Objects;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.stubs.tradeTest.trading.AbstractWorld;

import graphical.common.graphics.GraphicsUtils;
import graphical.common.graphics.AbstractDrawPanel;

//
public class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50, 255),
            TEXT_COLOR = new Color(255, 220, 0, 180);
    private static final int @NotNull []
            TEXT_LOCATION = new int[] {30, 30},
            DRAW_OFFSET = new int[] {50, 50};
    private final @NotNull AbstractWorld world;
    private final @NotNull AbstractHorizontalPainter
            marketInfoPainter,
            traderPainter;

    //
    public DrawPanel(@NotNull AbstractWorld world) {
        super(BACKGROUND);
        this.world = world;
        marketInfoPainter = new MarketInfoPainter(world);
        traderPainter = new TraderPainter(world);
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        marketInfoPainter.draw(g, DRAW_OFFSET);

        int @NotNull [] traderPainterOffset = AbstractHorizontalPainter.getShiftedOffset(
                DRAW_OFFSET, marketInfoPainter.getHeight());
        traderPainter.draw(g, traderPainterOffset);

        drawString(g, TEXT_COLOR, TEXT_LOCATION, "Testing trading");
    }

    //
    private static abstract class AbstractHorizontalPainter {
        private static final @NotNull Color DEFAULT_TEXT_COLOR = new Color(255, 220, 0, 180);
        private final @NotNull Color defaultTextColor;

        //
        AbstractHorizontalPainter(@Nullable Color defaultTextColor) {
            this.defaultTextColor = Objects.requireNonNullElse(defaultTextColor, DEFAULT_TEXT_COLOR);
        }

        //
        public abstract void draw(Graphics g, int[] drawOffset);

        //
        public abstract int getHeight();

        //
        public static int[] getShiftedOffset(int[] offset, int vertical) {
            return new int[] {offset[0], offset[1] + vertical};
        }

        //
        public final void drawString(@NotNull Graphics g, @Nullable Color color,
                                     int @NotNull [] location, @Nullable String text) {
            @NotNull Color textColor = Objects.requireNonNullElse(color, defaultTextColor);
            @NotNull String nonNullText = Objects.requireNonNullElse(text, "");
            GraphicsUtils.drawString(g, textColor, location, nonNullText);
        }
    }

    //
    private static class MarketInfoPainter extends AbstractHorizontalPainter {
        private static final int HEIGHT = 100;
        private final @NotNull AbstractWorld world;

        //
        protected MarketInfoPainter(@NotNull AbstractWorld world) {
            super(null);
            this.world = world;
        }

        //
        @Override
        public void draw(Graphics g, int[] drawOffset) {
            drawString(g, null, drawOffset, "Market info:");
        }

        //
        @Override
        public int getHeight() {
            return HEIGHT;
        }
    }

    //
    private static class TraderPainter extends AbstractHorizontalPainter {
        private static final int HEIGHT = 100;
        private final @NotNull AbstractWorld world;

        //
        protected TraderPainter(@NotNull AbstractWorld world) {
            super(null);
            this.world = world;
        }

        //
        @Override
        public void draw(Graphics g, int[] drawOffset) {
            drawString(g, null, drawOffset, "Trader info:");
        }

        //
        @Override
        public int getHeight() {
            return HEIGHT;
        }
    }
}