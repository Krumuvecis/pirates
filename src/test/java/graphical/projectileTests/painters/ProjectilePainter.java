package graphical.projectileTests.painters;

import java.util.Objects;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;

import graphical.common.Observer;

//
public class ProjectilePainter {
    private static final double STRAIGHT_ANGLE = Math.PI / 2;
    private static final int MINIMUM_DRAW_SIZE = 6;
    private static final @NotNull Observer DEFAULT_OBSERVER = new Observer(
            new Location(0, 0, 0),
            new Orientation(3 * STRAIGHT_ANGLE, -STRAIGHT_ANGLE, 0));
    private static final @NotNull Color PROJECTILE_COLOR = Color.gray;

    private final @NotNull ProjectileContainer projectileContainer;
    private final @NotNull Observer observer;
    private final int @NotNull [] offset;
    private double scale;

    //
    public ProjectilePainter(@NotNull ProjectileContainer projectileContainer,
                             @Nullable Observer observer,
                             int @NotNull [] offset, double scale) {
        this.projectileContainer = projectileContainer;
        this.observer = Objects.requireNonNullElse(observer, DEFAULT_OBSERVER);
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
    public double getScale() {
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
    private void drawSingleProjectile(@NotNull Graphics g,
                                        @NotNull AbstractProjectile projectile) {
        double @NotNull [] drawSize = getDrawSize(projectile.getSize());
        int @NotNull [] drawLocation = getDrawLocation(
                getLocationProjection(projectile.getLocation()),
                drawSize, offset);
        g.setColor(PROJECTILE_COLOR);
        g.fillOval(drawLocation[0], drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }

    //drawable size of the projectile
    private double @NotNull [] getDrawSize(double actualSize) {
        return new double[] {
                Math.max(MINIMUM_DRAW_SIZE, actualSize / scale),
                Math.max(MINIMUM_DRAW_SIZE, actualSize / scale)};
    }

    //
    private double @NotNull [] getLocationProjection(@NotNull Location location) {
        double [] projection3d = observer.getProjection(location);
        //TODO: finish this
        return new double[] {
                projection3d[0] / scale,
                projection3d[1] / scale};
    }

    //converts to suitable drawable location
    private int @NotNull [] getDrawLocation(double @NotNull [] locationProjection,
                                              double @NotNull [] drawSize,
                                              int @NotNull [] offset) {
        return new int[] {
                (int) (locationProjection[0] - drawSize[0] / 2 + offset[0]),
                (int) (locationProjection[1] - drawSize[1] / 2 + offset[1])
        };
    }
}