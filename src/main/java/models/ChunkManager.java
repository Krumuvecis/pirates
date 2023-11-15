package models;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

import models.explosions.Explosion;
import models.explosions.ExplosionContainer;
import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;
import models.guns.GunContainer;

//
public class ChunkManager extends AbstractUpdater {
    private static final long THREAD_UPDATE_INTERVAL = 40; // milliseconds
    private final @NotNull ExplosionContainer explosions;
    private final @NotNull ProjectileContainer projectiles;
    private final @NotNull GunContainer guns;

    //
    public ChunkManager() {
        super(THREAD_UPDATE_INTERVAL);
        explosions = new ExplosionContainer();
        projectiles = new ProjectileContainer(this);
        guns = new GunContainer(this);
        this.start();
    }

    //
    @Override
    public void update() {
        explosions.update(THREAD_UPDATE_INTERVAL);
        projectiles.update(THREAD_UPDATE_INTERVAL);
    }

    //
    public void addExplosion(@NotNull Explosion explosion) {
        explosions.add(explosion);
    }

    //
    public void addProjectile(@NotNull AbstractProjectile projectile) {
        projectiles.add(projectile);
    }

    //
    public @NotNull ExplosionContainer getExplosionContainer() {
        return explosions;
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