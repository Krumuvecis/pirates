package graphical.projectileTests.painters;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;

import graphical.common.Observer;

//
public class ProjectilePainter extends Abstract3DSpherePainter {
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    private final @NotNull ProjectileContainer projectileContainer;

    //
    public ProjectilePainter(@NotNull ProjectileContainer projectileContainer,
                             @Nullable Observer observer,
                             int @NotNull [] offset, double scale) {
        super(observer, offset, scale);
        this.projectileContainer = projectileContainer;
    }

    //call this to draw; iterates through every projectile of the container
    @Override
    public void paint(@NotNull Graphics g) {
        @NotNull List<@NotNull AbstractProjectile> projectiles = List.copyOf(projectileContainer.getList());
        for (@NotNull AbstractProjectile projectile : projectiles) {
            drawSingleSphere(
                    g,
                    projectile.getLocation(), projectile.getSize(),
                    PROJECTILE_COLOR);
        }
    }
}