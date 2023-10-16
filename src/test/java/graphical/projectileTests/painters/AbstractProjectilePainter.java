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

    //
    protected AbstractProjectilePainter(@NotNull ProjectileContainer projectileContainer) {
        this.projectileContainer = projectileContainer;
    }

    //call this to draw
    public void drawProjectiles(@NotNull Graphics g, int @NotNull [] offset) {
        @NotNull List<AbstractProjectile> projectiles = projectileContainer.getList();
        for (AbstractProjectile projectile : projectiles) {
            drawSingleProjectile(g, offset, projectile);
        }
    }

    //override this for custom drawing
    protected abstract void drawSingleProjectile(@NotNull Graphics g, int @NotNull [] offset,
                                                 @NotNull AbstractProjectile projectile);

    //
    protected double @NotNull [] getDrawSize(double actualSize) {
        return new double[] {actualSize, actualSize};
    }

    //
    protected double @NotNull [] getLocationProjection(@NotNull Location location) {
        //TODO: finish this
        return new double[] {location.getX(), location.getY()};
    }

    //
    protected int @NotNull [] getDrawLocation(double @NotNull [] locationProjection,
                                                   double @NotNull [] drawSize,
                                                   int @NotNull [] offset) {
        return new int[] {
                (int) (locationProjection[0] - drawSize[0] / 2 + offset[0]),
                (int) (locationProjection[1] - drawSize[1] / 2 + offset[1])
        };
    }
}