package graphical.stubs.tradeTest.graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import utils.TimeUtils;

import graphical.stubs.tradeTest.models.world.AbstractWorld;

//
class MarketInfoPainter extends AbstractHorizontalPainter {
    private static final int
            LINE_HEIGHT = 15,
            TOTAL_LINES = 5; // for estimating total height
    private final @NotNull AbstractWorld world;

    //
    protected MarketInfoPainter(@NotNull AbstractWorld world) {
        super(null);
        this.world = world;
    }

    //
    @Override
    public void draw(@NotNull Graphics g, int @NotNull [] drawOffset) {
        int @NotNull [] worldAge = TimeUtils.getHMSFromSeconds(world.getAge());
        @NotNull java.util.List<@Nullable String> lines = new ArrayList<>() {{
            add("Market info:");
            add("World age: " + worldAge[0] + " h " + worldAge[1] + " m " + worldAge[2] + " s");
            add("Trader count: " + world.getTradingArea().getTraders().size());
        }};
        drawLines(g, null, drawOffset, lines);
    }

    @SuppressWarnings("SameParameterValue")
    private void drawLines(@NotNull Graphics g, @Nullable Color color,
                           int @NotNull [] drawOffset, @NotNull List<@Nullable String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            @Nullable String line = lines.get(i);
            if (line != null) {
                int @NotNull [] drawLocation = new int[]{
                        drawOffset[0],
                        drawOffset[1] + LINE_HEIGHT * (i + 1)};
                drawString(g, color, drawLocation, line);
            }
        }
    }

    //
    @Override
    public int getHeight() {
        return LINE_HEIGHT * TOTAL_LINES;
    }
}