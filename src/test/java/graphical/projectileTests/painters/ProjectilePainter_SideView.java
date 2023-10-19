package graphical.projectileTests.painters;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.projectiles.ProjectileContainer;

//
public class ProjectilePainter_SideView extends AbstractProjectilePainter {
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    //
    public ProjectilePainter_SideView(@NotNull ProjectileContainer projectileContainer,
                                      int @NotNull [] offset, double scale) {
        super(projectileContainer, offset, scale);
    }

    //
    @Override
    public void drawProjectiles(@NotNull Graphics g) {
        g.setColor(PROJECTILE_COLOR);
        super.drawProjectiles(g);
    }

    //TODO: rework this in super to include observer angles
    @Override
    protected double @NotNull [] getLocationProjection(@NotNull Location location) {
        return new double[] {
                Math.hypot(location.getX(), location.getY()) / getScale(),
                -location.getZ() / getScale()
        };
    }
}