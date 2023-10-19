package graphical.projectileTests.ballisticsTest;

import java.awt.Color;
import java.awt.Graphics;

import graphical.projectileTests.painters.ProjectilePainter_SideView;
import models.projectiles.ProjectileContainer;
import org.jetbrains.annotations.NotNull;

import models.guns.AbstractGun;

import graphical.common.graphics.AbstractDrawPanel;
import graphical.projectileTests.painters.AbstractProjectilePainter;
import graphical.projectileTests.painters.ProjectilePainter_TopDown;

//
final class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50, 255),
            TEXT_COLOR = new Color(255, 220, 0, 180);
    private static final int @NotNull []
            TEXT_LOCATION = new int[] {30, 30},
            DRAW_OFFSET = new int[] {50, 50};
    private static final int DRAW_SEPARATION = 400;

    private final @NotNull AbstractProjectilePainter
            projectilePainter_topDown,
            projectilePainter_side;

    //
    DrawPanel() {
        super(BACKGROUND);
        @NotNull ProjectileContainer projectileContainer = BallisticsTest.CHUNK_MANAGER.getProjectileContainer();
        projectilePainter_topDown = new ProjectilePainter_TopDown(
                projectileContainer,
                DRAW_OFFSET);
        projectilePainter_side = new ProjectilePainter_SideView(
                projectileContainer,
                new int[] {DRAW_OFFSET[0], DRAW_OFFSET[1] + DRAW_SEPARATION});
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        drawGun(g, DRAW_OFFSET, BallisticsTest.GUN);
        projectilePainter_topDown.drawProjectiles(g);
        int @NotNull [] DRAW_OFFSET_2 = new int[] {DRAW_OFFSET[0], DRAW_OFFSET[1] + DRAW_SEPARATION};
        int horizonLineLength = 1200;
        g.setColor(new Color(120, 140, 200));
        g.drawLine(
                DRAW_OFFSET_2[0],
                DRAW_OFFSET_2[1],
                DRAW_OFFSET_2[0] + horizonLineLength,
                DRAW_OFFSET_2[1]);
        drawGun(g, DRAW_OFFSET_2, BallisticsTest.GUN);
        projectilePainter_side.drawProjectiles(g);
        drawString(g, TEXT_COLOR, TEXT_LOCATION, "Testing projectiles' ballistics");
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawGun(@NotNull Graphics g, int @NotNull [] offset,
                                @NotNull AbstractGun gun) {
        g.setColor(Color.cyan);
        double @NotNull []
                drawSize = new double[] {10, 10},
                actualLocation = new double[] {
                        gun.getLocation().getX(),
                        gun.getLocation().getY()},
                drawLocation = new double[] {
                        actualLocation[0] - drawSize[0] / 2 + offset[0],
                        actualLocation[1] - drawSize[1] / 2 + offset[1]};
        g.drawOval((int) drawLocation[0], (int) drawLocation[1], (int) drawSize[0], (int) drawSize[1]);
    }
}