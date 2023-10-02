package models;

import org.jetbrains.annotations.NotNull;

//
public abstract class AbstractProjectile {
    private final @NotNull Coordinates coordinates;
    @SuppressWarnings("FieldMayBeFinal")
    private double speed;

    //
    public AbstractProjectile(@NotNull Coordinates coordinates, double speed) {
        this.coordinates = coordinates;
        this.speed = speed;
    }

    //
    public @NotNull Coordinates getCoordinates() {
        return coordinates;
    }

    //
    public double getSpeed() {
        return speed;
    }

    //
    public void translate(double time) {
        double @NotNull [] location = coordinates.getLocation();
        double angle = coordinates.getAngle();
        location[0] += speed * Math.cos(angle) * time / 1000;
        location[1] += speed * Math.sin(angle) * time / 1000;
    }

    //
    public abstract double getSize();

    //
    public static final class SmallProjectile extends AbstractProjectile {
        private static final double SIZE = 10;

        //
        public SmallProjectile(@NotNull Coordinates coordinates, double speed) {
            super(coordinates, speed);
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
        public BigProjectile(@NotNull Coordinates coordinates, double speed) {
            super(coordinates, speed);
        }

        //
        @Override
        public double getSize() {
            return SIZE;
        }
    }
}