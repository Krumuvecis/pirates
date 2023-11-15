package models.explosions;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import models.bodies.statics.LocationBodyContainer;

//
public class ExplosionContainer extends LocationBodyContainer<Explosion> {
    //
    public ExplosionContainer() {
        //
    }

    //time in millis
    public void update(long timeInterval) {
        @NotNull List<@NotNull Explosion> explosions = this.getList();
        for (int i = 0; i < explosions.size(); i++) {
            @NotNull Explosion explosion = explosions.get(i);
            explosion.update(timeInterval);
            if (explosion.finished()) {
                explosions.remove(i);
                i--;
            }
        }
    }
}