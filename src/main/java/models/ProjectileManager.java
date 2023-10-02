package models;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

//
public class ProjectileManager extends AbstractUpdater {
    private static final long THREAD_UPDATE_INTERVAL = 30; // milliseconds

    private final @NotNull List<@NotNull AbstractProjectile> projectiles;

    //
    public ProjectileManager() {
        super(THREAD_UPDATE_INTERVAL);
        projectiles = new ArrayList<>();
        this.start();
    }

    //
    @Override
    public void update() {
        for (int i = 0; i < projectiles.size(); i++) {
            AbstractProjectile projectile = projectiles.get(i);
            projectile.translate(THREAD_UPDATE_INTERVAL);

            if (false) { //TODO: finish this
                projectiles.remove(i);
                i--;
            }
        }
    }

    //
    public void addProjectile(@NotNull AbstractProjectile projectile) {
        projectiles.add(projectile);
    }

    //for graphics and output
    public @NotNull List<@NotNull AbstractProjectile> getProjectiles() {
        return projectiles;
    }
}