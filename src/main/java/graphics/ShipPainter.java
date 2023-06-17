package graphics;

import java.awt.*;

import models.Human;
import models.Ship;
import data.Data;

class ShipPainter {
    @SuppressWarnings("SuspiciousNameCombination")
    protected static void paint(Graphics g, int[] start) {
        Ship ship = Data.SHIP;
        g.setColor(ship.color);
        int[] offset = new int[] {100, 100};
        int[] shipStart = new int[] {start[0] + offset[0], start[1] + offset[1]};
        g.drawRect(shipStart[0], shipStart[1], ship.length, ship.width);

        double scale = 1.0; //TODO: elevate this
        drawCrew(g, shipStart, scale, ship);
    }

    private static void drawCrew(Graphics g, int[] start, double scale, Ship ship) {
        for (Human human : ship.crew) {
            drawHuman(g, start, scale, human);
        }
    }

    private static void drawHuman(Graphics g, int[] start, double scale, Human human) {
        Color humanColor = new Color(150, 20, 60);
        g.setColor(humanColor);
        double
                diameter = human.getDiameter() * scale,
                radius = diameter / 2;
        int[] location = human.getLocation();
        g.drawOval(
                (int)(start[0] + location[0] - radius),
                (int)(start[1] + location[1] - radius),
                (int)(diameter), (int)(diameter));
    }
}