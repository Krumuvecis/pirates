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

    private boolean projectileRemovalCheck(@NotNull AbstractProjectile projectile) {
        //TODO: finish this
        return false;
    }
}