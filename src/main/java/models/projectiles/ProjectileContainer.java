package models.projectiles;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import utils.TimeUtils;
import models.coordinates.Location;
import models.explosions.Explosion;
import models.bodies.dynamic.LocationVelocityBodyContainer;
import models.ChunkManager;

//
public class ProjectileContainer extends LocationVelocityBodyContainer<AbstractProjectile> {
    private final @NotNull ChunkManager chunkManager;

    //
    public ProjectileContainer(@NotNull ChunkManager chunkManager) {
        super();
        this.chunkManager = chunkManager;
    }

    //time in millis
    public void update(long timeInterval) {
        @NotNull List<@NotNull AbstractProjectile> projectiles = this.getList();
        double timeInSeconds = TimeUtils.getSecondsFromMillis(timeInterval);
        for (int i = 0; i < projectiles.size(); i++) {
            @NotNull AbstractProjectile projectile = projectiles.get(i);
            projectile.translate(timeInSeconds);
            if (projectileRemovalCheck(projectile)) {
                projectiles.remove(i);
                i--;
                chunkManager.addExplosion(new Explosion(
                        chunkManager.getExplosionContainer(),
                        new Location(projectile.getLocation().getAsArray()),
                        10, 10, 400));
            }
        }
    }

    //TODO: improve this
    private boolean projectileRemovalCheck(@NotNull AbstractProjectile projectile) {
        double lowestPoint = projectile.getLocation().getZ() - projectile.getSize() / 2;
        return lowestPoint <= 0;
    }
}