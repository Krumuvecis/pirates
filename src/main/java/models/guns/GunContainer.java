package models.guns;

import org.jetbrains.annotations.NotNull;

import models.bodies.statics.StaticBodyContainer;
import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;
import models.ChunkManager;

//
public class GunContainer extends StaticBodyContainer<AbstractGun> {
    private final @NotNull ChunkManager chunkManager;

    //
    public GunContainer(@NotNull ChunkManager chunkManager) {
        super();
        this.chunkManager = chunkManager;
    }

    //
    void addProjectile(@NotNull AbstractProjectile projectile) {
        chunkManager.addProjectile(projectile);
    }

    //
    @NotNull ProjectileContainer getProjectileContainer() {
        return chunkManager.getProjectileContainer();
    }
}