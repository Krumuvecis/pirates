package models;

import java.util.List;

import models.guns.GunContainer;
import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;

//
public class ChunkManager extends AbstractUpdater {
    private static final long THREAD_UPDATE_INTERVAL = 30; // milliseconds
    private final @NotNull ProjectileContainer projectiles;
    private final @NotNull GunContainer guns;

    //
    public ChunkManager() {
        super(THREAD_UPDATE_INTERVAL);
        projectiles = new ProjectileContainer();
        guns = new GunContainer(this);
        this.start();
    }

    //
    @Override
    public void update() {
        projectiles.update(THREAD_UPDATE_INTERVAL);
    }

    //
    public void addProjectile(@NotNull AbstractProjectile projectile) {
        projectiles.add(projectile);
    }

    //
    public @NotNull ProjectileContainer getProjectileContainer() {
        return projectiles;
    }

    //
    public @NotNull GunContainer getGunContainer() {
        return guns;
    }

    //for graphics and output
    public @NotNull List<@NotNull AbstractProjectile> getProjectiles() {
        return projectiles.getList();
    }
}