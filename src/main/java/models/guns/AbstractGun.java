package models.guns;

import org.jetbrains.annotations.NotNull;

import models.Coordinates;
import models.AbstractProjectile;
import models.ProjectileManager;

//
public abstract class AbstractGun {
    private final @NotNull Coordinates coordinates;
    private final @NotNull ProjectileManager projectileManager;

    //
    public AbstractGun(@NotNull Coordinates coordinates,
                       @NotNull ProjectileManager projectileManager) {
        this.coordinates = coordinates;
        this.projectileManager = projectileManager;
    }

    //
    public @NotNull Coordinates getCoordinates() {
        return coordinates;
    }

    //
    public abstract double getMuzzleVelocity();

    //
    public abstract @NotNull AbstractProjectile getNewProjectile();

    //
    public void shoot() {
        projectileManager.addProjectile(getNewProjectile());
    }
}