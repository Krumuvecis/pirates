package graphical.projectileTests.painters;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.projectiles.ProjectileContainer;

//
public class ProjectilePainter_TopDown extends AbstractProjectilePainter {
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    //
    public ProjectilePainter_TopDown(@NotNull ProjectileContainer projectileContainer,
                                     int @NotNull [] offset, double scale) {
        super(projectileContainer, offset, scale);
    }

    //
    @Override
    public void drawProjectiles(@NotNull Graphics g) {
        g.setColor(PROJECTILE_COLOR);
        super.drawProjectiles(g);
    }
}