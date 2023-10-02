package graphical.projectileTests;

import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

import models.guns.AbstractGun;

//
public class GunShooterThread extends AbstractUpdater {
    private final @NotNull AbstractGun gun;

    //
    public GunShooterThread(@NotNull AbstractGun gun, long interval) {
        super(interval);
        this.gun = gun;
        this.start();
    }

    //
    @Override
    public void update() {
        gun.shoot();
    }
}