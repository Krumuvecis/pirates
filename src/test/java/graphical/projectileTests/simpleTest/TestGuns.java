package graphical.projectileTests.simpleTest;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.GunContainer;
import models.guns.SmallGun;
import models.guns.BigGun;

//
final class TestGuns {
    private static final double
            GUN_ALTITUDE = 1,
            VERTICAL_ANGLE = 15, // degrees
            SEPARATION = 20;

    //
    private static @NotNull Location getNewLocation(double y) {
        return new Location(0, y, GUN_ALTITUDE);
    }

    //angles in degrees
    private static @NotNull Orientation getNewOrientation(double horizontal) {
        return new Orientation(
                Math.toRadians(horizontal),
                Math.toRadians(VERTICAL_ANGLE),
                0);
    }

    //
    public final static class TestGun_small extends SmallGun {
        private static final double HORIZONTAL_ANGLE = 0; // degrees

        public TestGun_small(@NotNull GunContainer parent) {
            super(
                    parent,
                    getNewLocation(SEPARATION / 2), //TODO: revert to 0
                    getNewOrientation(HORIZONTAL_ANGLE));
        }
    }

    //
    public final static class TestGun_big extends BigGun {
        private static final double HORIZONTAL_ANGLE = 0; // degrees

        public TestGun_big(@NotNull GunContainer parent) {
            super(
                    parent,
                    getNewLocation(SEPARATION),
                    getNewOrientation(HORIZONTAL_ANGLE));
        }
    }
}