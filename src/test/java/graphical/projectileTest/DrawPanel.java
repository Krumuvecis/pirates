package graphical.projectileTest;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.AbstractGun;

import graphical.common.graphics.AbstractDrawPanel;

import static graphical.projectileTest.ProjectileTest.*;

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
        drawGun(g, DRAW_OFFSET, SMALL_GUN);
        drawGun(g, DRAW_OFFSET, BIG_GUN);
        drawProjectiles(g, DRAW_OFFSET, PROJECTILE_MANAGER.getProjectiles());
        drawString(g, TEXT_LOCATION, "Testing projectiles");
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawGun(@NotNull Graphics g, int @NotNull [] offset,
                                @NotNull AbstractGun gun) {
        g.setColor(Color.cyan);
        double @NotNull []
                drawSize = new double[] {10, 10},
                actualLocation = gun.getLocation(),
                drawLocation = new double[] {
                        actualLocation[0] - drawSize[0] / 2 + offset[0],
                        actualLocation[1] - drawSize[1] / 2 + offset[1]};
        g.drawOval((int) drawLocation[0], (int) drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawProjectiles(@NotNull Graphics g, int @NotNull [] offset,
                                        @NotNull List<AbstractProjectile> projectiles) {
        g.setColor(Color.gray);
        for (AbstractProjectile projectile : projectiles) {
            double actualSize = projectile.getSize();
            double @NotNull []
                    drawSize = new double[] {actualSize, actualSize},
                    actualLocation = projectile.getLocation(),
                    drawLocation = new double[] {
                            actualLocation[0] - drawSize[0] / 2 + offset[0],
                            actualLocation[1] - drawSize[1] / 2 + offset[1]};
            g.fillOval((int) drawLocation[0], (int) drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
        }

    }

    @SuppressWarnings("SameParameterValue")
    private static void drawString(@NotNull Graphics g,
                                   int @NotNull [] location,
                                   @NotNull String text) {
        g.drawString(text, location[0], location[1]);
    }
}