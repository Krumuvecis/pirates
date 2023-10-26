package graphical.projectileTests.painters;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.coordinates.Location;

import graphical.common.Observer;

//
public abstract class Abstract3DSpherePainter extends Abstract3DPainter {
    private static final int MINIMUM_DRAW_SIZE = 6;

    //
    Abstract3DSpherePainter(@Nullable Observer observer,
                            int @NotNull [] offset, double scale) {
        super(observer, offset, scale);
    }

    //override this for custom drawing
    public void drawSingleSphere(@NotNull Graphics g,
                                  @NotNull Location location, double realSize,
                                  @NotNull Color color) {
        double @NotNull [] drawSize = getDrawSize(realSize);
        int @NotNull [] drawLocation = getDrawLocation(
                getLocationProjection(location),
                drawSize, getOffset());
        g.setColor(color);
        g.fillOval(drawLocation[0], drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }

    //drawable size of the sphere
    private double @NotNull [] getDrawSize(double actualSize) {
        double scale = getScale();
        return new double[] {
                Math.max(MINIMUM_DRAW_SIZE, actualSize / scale),
                Math.max(MINIMUM_DRAW_SIZE, actualSize / scale)};
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