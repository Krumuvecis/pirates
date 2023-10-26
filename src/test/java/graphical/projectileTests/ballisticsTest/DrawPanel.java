package graphical.projectileTests.ballisticsTest;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import models.coordinates.Location;
import models.projectiles.ProjectileContainer;
import models.guns.AbstractGun;

import graphical.common.graphics.AbstractDrawPanel;
import graphical.common.Observer;
import graphical.projectileTests.painters.AbstractPainter;
import graphical.projectileTests.painters.ProjectilePainter;

//
final class DrawPanel extends AbstractDrawPanel {
    private static final @NotNull Color
            BACKGROUND = new Color(15, 30, 50, 255),
            TEXT_COLOR = new Color(255, 220, 0, 180),
            GUN_COLOR = Color.cyan;
    private static final int @NotNull []
            TEXT_LOCATION = new int[] {30, 30},
            DRAW_OFFSET = new int[] {50, 50};
    private static final int DRAW_SEPARATION = 400;
    private static final double DRAW_SCALE = 100;

    private final @NotNull AbstractPainter
            projectilePainter_topDown,
            projectilePainter_side;

    //
    DrawPanel() {
        super(BACKGROUND);
        @NotNull ProjectileContainer projectileContainer = BallisticsTest.CHUNK_MANAGER.getProjectileContainer();
        projectilePainter_topDown = new ProjectilePainter(
                projectileContainer, null,
                DRAW_OFFSET, DRAW_SCALE);
        projectilePainter_side = new ProjectilePainter(
                projectileContainer, BallisticsTest.OBSERVER,
                new int[] {DRAW_OFFSET[0], DRAW_OFFSET[1] + DRAW_SEPARATION}, DRAW_SCALE);
    }

    //
    @Override
    public void draw(@NotNull Graphics g) {
        //top-down view
        drawGun(g, DRAW_OFFSET, BallisticsTest.GUN);
        projectilePainter_topDown.paint(g);

        //side view
        int @NotNull [] DRAW_OFFSET_2 = new int[] {DRAW_OFFSET[0], DRAW_OFFSET[1] + DRAW_SEPARATION};
        drawCenterCross(g, DRAW_OFFSET_2, BallisticsTest.OBSERVER);
        drawGun(g, DRAW_OFFSET_2, BallisticsTest.GUN);
        projectilePainter_side.paint(g);

        //miscellaneous
        drawString(g, TEXT_COLOR, TEXT_LOCATION, "Testing projectiles' ballistics");
    }

    private static void drawCenterCross(@NotNull Graphics g, int @NotNull [] offset,
                                        @NotNull Observer observer) {
        double length = 100 * DRAW_SCALE;
        drawSingleCoordinateIndicatorLine(g, offset, observer,
                new Location(length, 0, 0), Color.yellow, "x");
        drawSingleCoordinateIndicatorLine(g, offset, observer,
                new Location(0, length, 0), Color.green, "y");
        drawSingleCoordinateIndicatorLine(g, offset, observer,
                new Location(0, 0, length), Color.red, "z");
    }

    private static void drawSingleCoordinateIndicatorLine(@NotNull Graphics g, int @NotNull [] offset,
                                                          @NotNull Observer observer,
                                                          @NotNull Location endLocation,
                                                          @NotNull Color color,
                                                          @Nullable String label) {
        double @NotNull []
                start = observer.getProjection(new Location(0, 0, 0)),
                end = observer.getProjection(endLocation);
        int @NotNull [] drawEnd = new int[] {
                (int) (end[0] / DRAW_SCALE + offset[0]),
                (int) (end[1] / DRAW_SCALE + offset[1])};
        g.setColor(color);
        g.drawLine(
                (int) (start[0] / DRAW_SCALE + offset[0]), (int) (start[1] / DRAW_SCALE + offset[1]),
                drawEnd[0], drawEnd[1]);
        if (label != null) {
            g.drawString(label, drawEnd[0], drawEnd[1]);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawGun(@NotNull Graphics g, int @NotNull [] offset,
                                @NotNull AbstractGun gun) {
        g.setColor(GUN_COLOR);
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