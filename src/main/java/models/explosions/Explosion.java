package models.explosions;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.bodies.basic.ContainableBody;
import models.bodies.basic.BodyContainer;
import models.bodies.statics.LocationBody;

//
public class Explosion extends LocationBody {
    private double radius, intensity;
    private long remainingTime;

    //time in millis
    public Explosion(BodyContainer<? extends ContainableBody> parent,
                     @NotNull Location location, double radius, double intensity,
                     long duration) {
        super(parent, location);
        this.radius = radius;
        this.intensity = intensity;
        this.remainingTime = duration;
    }

    //
    public double getRadius() {
        return radius;
    }

    //
    public double getIntensity() {
        return intensity;
    }

    //
    public void update(long deltaTime) {
        remainingTime -= deltaTime;
        //TODO: finish this
    }

    //
    public boolean finished() {
        //TODO: finish this
        return remainingTime <= 0;
    }
}