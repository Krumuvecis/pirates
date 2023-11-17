package graphical.stubs.tradeTest.graphics;

import java.util.Objects;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.common.graphics.GraphicsUtils;

//
abstract class AbstractHorizontalPainter {
    private static final @NotNull Color DEFAULT_TEXT_COLOR = new Color(255, 220, 0, 180);
    private final @NotNull Color defaultTextColor;

    //
    AbstractHorizontalPainter(@Nullable Color defaultTextColor) {
        this.defaultTextColor = Objects.requireNonNullElse(defaultTextColor, DEFAULT_TEXT_COLOR);
    }

    //
    public abstract void draw(@NotNull Graphics g, int @NotNull [] drawOffset);

    //
    public abstract int getHeight();

    //
    public static int[] getShiftedOffset(int @NotNull [] offset, int vertical) {
        return new int[]{offset[0], offset[1] + vertical};
    }

    //
    public final void drawString(@NotNull Graphics g, @Nullable Color color,
                                 int @NotNull [] location, @Nullable String text) {
        @NotNull Color textColor = Objects.requireNonNullElse(color, defaultTextColor);
        @NotNull String nonNullText = Objects.requireNonNullElse(text, "");
        GraphicsUtils.drawString(g, textColor, location, nonNullText);
    }
}