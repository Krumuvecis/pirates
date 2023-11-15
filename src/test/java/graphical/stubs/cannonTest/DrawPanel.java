package graphical.stubs.cannonTest;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphical.common.graphics.AbstractDrawPanel;

//
final class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50, 255),
            TEXT_COLOR = new Color(255, 220, 0, 180);
    private static final int @NotNull [] TEXT_LOCATION = new int[] {100, 100};

    //
    DrawPanel() {
        super(BACKGROUND);
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        g.setColor(TEXT_COLOR);
        drawString(g, TEXT_COLOR, TEXT_LOCATION, "Testing cannons");
    }
}