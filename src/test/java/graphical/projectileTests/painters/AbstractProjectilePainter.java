package graphical.projectileTests.painters;

import java.util.List;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;

//
public abstract class AbstractProjectilePainter {
    private final @NotNull ProjectileContainer projectileContainer;
    private final int @NotNull [] offset;

    //
    protected AbstractProjectilePainter(@NotNull ProjectileContainer projectileContainer,
                                        int @NotNull [] offset) {
        this.projectileContainer = projectileContainer;
        this.offset = offset;
    }

    //
    public void setOffset(int @NotNull [] offset) {
        this.offset[0] = offset[0];
        this.offset[1] = offset[1];
    }

    //call this to draw; iterates through every projectile of the container
    public void drawProjectiles(@NotNull Graphics g) {
        @NotNull List<@NotNull AbstractProjectile> projectiles = projectileContainer.getList();
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
        //TODO: add scale here
        return new double[] {actualSize, actualSize};
    }

    //
    protected double @NotNull [] getLocationProjection(@NotNull Location location) {
        //TODO: finish this
        return new double[] {location.getX(), location.getY()};
    }

    //converts to suitable drawable location
    protected int @NotNull [] getDrawLocation(double @NotNull [] locationProjection,
                                              double @NotNull [] drawSize,
                                              int @NotNull [] offset) {
        //TODO: add scale to linear coordinate conversion, maybe here?
        return new int[] {
                (int) (locationProjection[0] - drawSize[0] / 2 + offset[0]),
                (int) (locationProjection[1] - drawSize[1] / 2 + offset[1])
        };
    }
}