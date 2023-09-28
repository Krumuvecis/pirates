package oldClientTest.graphics;

import java.awt.Color;
import java.awt.Graphics;

import oldClientTest.data.Data;
import oldClientTest.models.Human;
import oldClientTest.models.Ship;

//
public class ShipInfoPainter {
    protected static void paint(Graphics g, int[] start) {
        Ship ship = Data.SHIP;
        int[] offset = new int[] {5, 5};
        int textSize = 15;
        int[] textLoc = new int[] {
                start[0] + offset[0],
                start[1] + offset[1] + textSize};
        g.setColor(Color.yellow);
        g.drawString("crew size: " + ship.crew.size(), textLoc[0], textLoc[1]);
        drawCrewInfo(g, textLoc, textSize, 1, ship);
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawCrewInfo(Graphics g,
                                     int[] textLoc, int textSize, int firstLineNumber,
                                     Ship ship) {
        g.setColor(Color.yellow);
        for (int i = 0; i < ship.crew.size(); i++) {
            Human human = ship.crew.get(i);
            int displayIndex = i + 1;
            String printText = displayIndex + ". " + human.getName();
            g.drawString(printText, textLoc[0], textLoc[1] + textSize * (i + firstLineNumber));
        }
    }
}