package graphical.projectileTest;

import models.ProjectileManager;

//
public class ProjectileTest {
    private static final ProjectileManager PROJECTILE_MANAGER;

    static {
        PROJECTILE_MANAGER = new ProjectileManager();
    }

    //
    public static void main(String[] args) {
        new Window();
    }
}