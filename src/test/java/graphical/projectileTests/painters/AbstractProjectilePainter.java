package graphical.projectileTests.painters;

import java.util.List;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.projectiles.AbstractProjectile;
import models.ChunkManager;

//
public abstract class AbstractProjectilePainter {
    private final @NotNull ChunkManager projectileManager;

    //
    protected AbstractProjectilePainter(@NotNull ChunkManager projectileManager) {
        this.projectileManager = projectileManager;
    }

    //call this to draw
    public void drawProjectiles(@NotNull Graphics g, int @NotNull [] offset) {
        @NotNull List<AbstractProjectile> projectiles = projectileManager.getProjectiles();
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

    //TODO: finish this
    protected double @NotNull [] getLocationProjection(@NotNull Coordinates coordinates) {
        return coordinates.getLocation();
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