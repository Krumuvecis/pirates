package graphical.oldClientTest.graphics;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphical.common.graphics.AbstractDrawPanel;

//
final class OnlyPanel extends AbstractDrawPanel {
    private static final @NotNull Color BACKGROUND = new Color(15, 30, 50);

    //
    OnlyPanel() {
        super(BACKGROUND);
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        drawLayout(g);
        drawLeftPanel(g);
        drawCentralPanel(g);
        drawRightPanel(g);
    }

    private void drawLayout(@NotNull Graphics g) {
        g.setColor(Color.yellow);
        int
                height = getHeight(),
                sep1 = DefaultLayout.LEFT_PANEL_WIDTH,
                sep2 = sep1 + DefaultLayout.CENTER_WIDTH;
        drawLayoutSeparator(g, sep1, height);
        drawLayoutSeparator(g, sep2, height);
    }

    private void drawLayoutSeparator(@NotNull Graphics g, int x, int height) {
        g.drawLine(x, 0, x, height);
    }

    private void drawLeftPanel(Graphics g) {
        int[] start = new int[] {0, 0};
        int[] offset = new int[] {5, 20};
        g.setColor(Color.yellow);
        g.drawString("window size: " + getWidth() + ", " + getHeight(),
                start[0] + offset[0],
                start[1] + offset[1]);
    }

    private void drawCentralPanel(@NotNull Graphics g) {
        int size = DefaultLayout.CENTER_WIDTH; //assumes square
        //TODO: add this
    }

    private void drawRightPanel(@NotNull Graphics g) {
        int[] start = new int[] {
                DefaultLayout.LEFT_PANEL_WIDTH + DefaultLayout.CENTER_WIDTH,
                0};
        int infoOffset = 400;
        ShipPainter.paint(g, start);
        ShipInfoPainter.paint(g, new int[] {
                start[0],
                start[1] + infoOffset});
    }
}