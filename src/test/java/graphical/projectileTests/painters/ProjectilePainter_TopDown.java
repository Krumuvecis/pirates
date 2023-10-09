package graphical.projectileTests.painters;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.ProjectileManager;

//
public class ProjectilePainter_TopDown extends AbstractProjectilePainter {
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    //
    public ProjectilePainter_TopDown(@NotNull ProjectileManager projectileManager) {
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
                getLocationProjection(projectile.getCoordinates()),
                drawSize, offset);
        g.fillOval(drawLocation[0], drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }
}