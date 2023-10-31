package graphical.projectileTests.ballisticsTest;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.GunContainer;
import models.guns.SmallGun;

final class TestGun extends SmallGun {
    private static final double
            GUN_ALTITUDE = 1,
            HORIZONTAL_ANGLE = 0, // degrees
            VERTICAL_ANGLE = 45; // degrees

    TestGun(@NotNull GunContainer parent) {
        super(
                parent,
                new Location(0, 0, GUN_ALTITUDE),
                new Orientation(Math.toRadians(HORIZONTAL_ANGLE), Math.toRadians(VERTICAL_ANGLE), 0));
    }
}