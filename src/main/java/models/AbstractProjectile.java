package models;

import org.jetbrains.annotations.NotNull;

//
public abstract class AbstractProjectile {
    private final double @NotNull [] location;
    @SuppressWarnings("FieldMayBeFinal")
    private double angle, speed;

    //
    public AbstractProjectile(double @NotNull [] location, double angle, double speed) {
        this.location = location;
        this.angle = angle;
        this.speed = speed;
    }

    //
    public void translate(double time) {
        location[0] += speed * Math.cos(angle) * time / 1000;
        location[1] += speed * Math.sin(angle) * time / 1000;
    }

    //
    public double @NotNull [] getLocation() {
        return location;
    }

    //
    public double getAngle() {
        return angle;
    }

    //
    public double getSpeed() {
        return speed;
    }

    //
    public abstract double getSize();

    //
    public static final class SmallProjectile extends AbstractProjectile {
        private static final double SIZE = 10;

        //
        public SmallProjectile(double @NotNull [] location, double angle, double speed) {
            super(location, angle, speed);
        }

        //
        @Override
        public double getSize() {
            return SIZE;
        }
    }

    //
    public static final class BigProjectile extends AbstractProjectile {
        private static final double SIZE = 30;

        //
        public BigProjectile(double @NotNull [] location, double angle, double speed) {
            super(location, angle, speed);
        }

        //
        @Override
        public double getSize() {
            return SIZE;
        }
    }
}