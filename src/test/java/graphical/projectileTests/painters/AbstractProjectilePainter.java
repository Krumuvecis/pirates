package graphical.projectileTests.painters;

import java.util.List;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;

//
public abstract class AbstractProjectilePainter {
    private static final int MINIMUM_DRAW_SIZE = 6;
    private final @NotNull ProjectileContainer projectileContainer;
    private final int @NotNull [] offset;
    private double scale;

    //
    protected AbstractProjectilePainter(@NotNull ProjectileContainer projectileContainer,
                                        int @NotNull [] offset, double scale) {
        this.projectileContainer = projectileContainer;
        this.offset = offset;
        this.scale = scale;
    }

    //
    public void setOffset(int @NotNull [] offset) {
        this.offset[0] = offset[0];
        this.offset[1] = offset[1];
    }

    //
    public void setScale(double scale) {
        this.scale = scale;
    }

    //
    protected double getScale() {
        return scale;
    }

    //call this to draw; iterates through every projectile of the container
    public void drawProjectiles(@NotNull Graphics g) {
        @NotNull List<@NotNull AbstractProjectile> projectiles = List.copyOf(projectileContainer.getList());
        for (@NotNull AbstractProjectile projectile : projectiles) {
            drawSingleProjectile(g, projectile);
        }
    }

    //override this for custom drawing
    protected void drawSingleProjectile(@NotNull Graphics g,
                                        @NotNull AbstractProjectile projectile) {
        double @NotNull [] drawSize = getDrawSize(projectile.getSize());
        int @NotNull [] drawLocation = getDrawLocation(
                getLocationProjection(projectile.getLocation()),
                drawSize, offset);
        g.fillOval(drawLocation[0], drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }

    //drawable size of the projectile
    protected double @NotNull [] getDrawSize(double actualSize) {
        return new double[] {
                Math.max(MINIMUM_DRAW_SIZE, actualSize / scale),
                Math.max(MINIMUM_DRAW_SIZE, actualSize / scale)};
    }

    //
    protected double @NotNull [] getLocationProjection(@NotNull Location location) {
        //TODO: finish this
        return new double[] {
                location.getX() / scale,
                location.getY() / scale};
    }

    //converts to suitable drawable location
    protected int @NotNull [] getDrawLocation(double @NotNull [] locationProjection,
                                              double @NotNull [] drawSize,
                                              int @NotNull [] offset) {
        //TODO: maybe move scale to here?
        return new int[] {
                (int) (locationProjection[0] - drawSize[0] / 2 + offset[0]),
                (int) (locationProjection[1] - drawSize[1] / 2 + offset[1])
        };
    }
}