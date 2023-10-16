package models.guns;

import models.ChunkManager;
import models.bodies.statics.StaticBodyContainer;
import models.projectiles.AbstractProjectile;
import models.projectiles.ProjectileContainer;
import org.jetbrains.annotations.NotNull;

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