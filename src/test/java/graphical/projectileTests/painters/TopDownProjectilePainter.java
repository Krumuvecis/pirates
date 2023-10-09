package graphical.projectileTests.painters;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.ProjectileManager;

//
public class TopDownProjectilePainter extends AbstractProjectilePainter {
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    //
    public TopDownProjectilePainter(@NotNull ProjectileManager projectileManager) {
        super(projectileManager);
    }

    //
    @Override
    public void drawProjectiles(@NotNull Graphics g, int @NotNull [] offset) {
        g.setColor(PROJECTILE_COLOR);
        super.drawProjectiles(g, offset);
    }

    //
    @Override
    protected void drawSingleProjectile(@NotNull Graphics g, int @NotNull [] offset,
                                        @NotNull AbstractProjectile projectile) {
        double @NotNull [] drawSize = getDrawSize(projectile.getSize());
        int @NotNull [] drawLocation = getDrawLocation(
                projectile.getCoordinates().getLocation(),
                drawSize, offset);
        g.fillOval(drawLocation[0], drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }

    private static double @NotNull [] getDrawSize(double actualSize) {
        return new double[] {actualSize, actualSize};
    }

    private static int @NotNull [] getDrawLocation(double @NotNull [] actualLocation,
                                                   double @NotNull [] drawSize,
                                                   int @NotNull [] offset) {
        return new int[] {
                (int) (actualLocation[0] - drawSize[0] / 2 + offset[0]),
                (int) (actualLocation[1] - drawSize[1] / 2 + offset[1])
        };
    }
}