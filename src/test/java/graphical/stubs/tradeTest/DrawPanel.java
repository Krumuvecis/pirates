package graphical.stubs.tradeTest;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphical.common.graphics.AbstractDrawPanel;

//
public class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50, 255),
            TEXT_COLOR = new Color(255, 220, 0, 180);
    private static final int @NotNull []
            TEXT_LOCATION = new int[] {30, 30},
            DRAW_OFFSET = new int[] {50, 50};

    //
    public DrawPanel() {
        super(BACKGROUND);
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        drawString(g, TEXT_COLOR, TEXT_LOCATION, "Testing trading");
    }
}