package graphical.projectileTests.painters;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.coordinates.Location;
import models.coordinates.Orientation;

import graphical.common.Observer;

//
public abstract class Abstract3DPainter extends AbstractPainter {
    private static final double STRAIGHT_ANGLE = Math.PI / 2;
    private static final @NotNull Observer DEFAULT_OBSERVER = new Observer(
            new Location(0, 0, 0),
            new Orientation(3 * STRAIGHT_ANGLE, -STRAIGHT_ANGLE, 0));

    private final @NotNull Observer observer;
    private double scale;

    //
    Abstract3DPainter(@Nullable Observer observer,
                      int @NotNull [] offset, double scale) {
        super(offset);
        this.scale = scale;
        this.observer = Objects.requireNonNullElse(observer, DEFAULT_OBSERVER);
    }

    //
    public void setScale(double scale) {
        this.scale = scale;
    }

    //
    public double getScale() {
        return scale;
    }

    //
    public double @NotNull [] getLocationProjection(@NotNull Location location) {
        double [] projection3d = observer.getProjection(location);
        double scale = getScale();
        //TODO: finish this
        return new double[] {
                projection3d[0] / scale,
                projection3d[1] / scale};
    }
}