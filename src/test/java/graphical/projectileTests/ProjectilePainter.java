package graphical.projectileTests;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;

//
public class ProjectilePainter {
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    //
    public static void drawProjectiles(@NotNull Graphics g, int @NotNull [] offset,
                                       @NotNull List<AbstractProjectile> projectiles) {
        g.setColor(PROJECTILE_COLOR);
        for (AbstractProjectile projectile : projectiles) {
            drawSingleProjectile(g, offset, projectile);
        }
    }

    private static void drawSingleProjectile(@NotNull Graphics g, int @NotNull [] offset,
                                             @NotNull AbstractProjectile projectile) {
        double actualSize = projectile.getSize();
        double @NotNull []
                drawSize = new double[] {actualSize, actualSize},
                actualLocation = projectile.getCoordinates().getLocation(),
                drawLocation = new double[] {
                        actualLocation[0] - drawSize[0] / 2 + offset[0],
                        actualLocation[1] - drawSize[1] / 2 + offset[1]};
        g.fillOval((int) drawLocation[0], (int) drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }
}