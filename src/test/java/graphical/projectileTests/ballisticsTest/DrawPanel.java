package graphical.projectileTests.ballisticsTest;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.guns.AbstractGun;

import graphical.common.graphics.AbstractDrawPanel;
import graphical.projectileTests.ProjectilePainter;

import static graphical.projectileTests.ballisticsTest.BallisticsTest.*;

//
final class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50),
            TEXT_COLOR = new Color(240, 200, 20);
    private static final int @NotNull []
            TEXT_LOCATION = new int[] {30, 30},
            DRAW_OFFSET = new int[] {50, 50};

    //
    DrawPanel() {
        super(BACKGROUND);
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        g.setColor(TEXT_COLOR);
        drawGun(g, DRAW_OFFSET, GUN);
        ProjectilePainter.drawProjectiles(g, DRAW_OFFSET, PROJECTILE_MANAGER.getProjectiles());
        drawString(g, TEXT_LOCATION, "Testing projectiles' ballistics");
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawGun(@NotNull Graphics g, int @NotNull [] offset,
                                @NotNull AbstractGun gun) {
        g.setColor(Color.cyan);
        double @NotNull []
                drawSize = new double[] {10, 10},
                actualLocation = gun.getCoordinates().getLocation(),
                drawLocation = new double[] {
                        actualLocation[0] - drawSize[0] / 2 + offset[0],
                        actualLocation[1] - drawSize[1] / 2 + offset[1]};
        g.drawOval((int) drawLocation[0], (int) drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawString(@NotNull Graphics g,
                                   int @NotNull [] location,
                                   @NotNull String text) {
        g.drawString(text, location[0], location[1]);
    }
}