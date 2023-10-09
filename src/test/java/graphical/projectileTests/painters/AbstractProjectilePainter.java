package graphical.projectileTests.painters;

import java.util.List;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import models.AbstractProjectile;
import models.ProjectileManager;

//
public abstract class AbstractProjectilePainter {
    private final @NotNull ProjectileManager projectileManager;

    //
    protected AbstractProjectilePainter(@NotNull ProjectileManager projectileManager) {
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
}