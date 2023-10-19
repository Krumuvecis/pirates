package models.projectiles;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import models.bodies.dynamic.LocationVelocityBodyContainer;

//
public class ProjectileContainer extends LocationVelocityBodyContainer<AbstractProjectile> {
    //
    public ProjectileContainer() {
        super();
        //
    }

    //time in millis
    public void update(long timeInterval) {
        @NotNull List<@NotNull AbstractProjectile> projectiles = this.getList();

        for (int i = 0; i < projectiles.size(); i++) {
            @NotNull AbstractProjectile projectile = projectiles.get(i);
            projectile.translate(timeInterval);

            if (projectileRemovalCheck(projectile)) {
                projectiles.remove(i);
                i--;
            }
        }
    }

    //TODO: improve this
    private boolean projectileRemovalCheck(@NotNull AbstractProjectile projectile) {
        double lowestPoint = projectile.getLocation().getZ() - projectile.getSize() / 2;
        return lowestPoint <= 0;
    }
}