package graphical.common;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.bodies.statics.StaticBody;

//
public class Observer extends StaticBody {
    //
    public Observer(@NotNull Location location, @NotNull Orientation orientation) {
        super(null, location, orientation);
    }

    //
    public double @NotNull [] getProjection(@NotNull Location location) {
        double
                x = location.getX(),
                y = location.getY(),
                z = location.getZ(),
                phi = getOrientation().getHorizontal(),
                theta = getOrientation().getVertical();
        return new double[] {
                y * Math.cos(phi) - x * Math.sin(phi),
                (x * Math.cos(phi) + y * Math.sin(phi)) * Math.sin(theta) - z * Math.cos(theta),
                0 //TODO: finish this
        };
    }
}