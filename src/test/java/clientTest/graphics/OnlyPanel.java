package clientTest.graphics;

import javax.swing.*;
import java.awt.*;

public class OnlyPanel extends JPanel {
    private Color background = new Color(15, 30, 50);

    protected OnlyPanel() {
        super();
        setBackground(background);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLayout(g);
        drawLeftPanel(g);
        drawCentralPanel(g);
        drawRightPanel(g);
    }

    private void drawLayout(Graphics g) {
        g.setColor(Color.yellow);
        int
                height = getHeight(),
                sep1 = DefaultLayout.LEFT_PANEL_WIDTH,
                sep2 = sep1 + DefaultLayout.CENTER_WIDTH;
        drawLayoutSeparator(g, sep1, height);
        drawLayoutSeparator(g, sep2, height);
    }

    private void drawLayoutSeparator(Graphics g, int x, int height) {
        g.drawLine(x, 0, x, height);
    }

    private void drawLeftPanel(Graphics g) {
        int[] start = new int[] {0, 0};
        int[] offset = new int[] {5, 20};
        g.setColor(Color.yellow);
        g.drawString("window size: " + getWidth() + ", " + getHeight(),
                start[0] + offset[0],
                start[1] + offset[1]);
    }

    private void drawCentralPanel(Graphics g) {
        int size = DefaultLayout.CENTER_WIDTH; //assumes square
        //TODO: add this
    }

    private void drawRightPanel(Graphics g) {
        int[] start = new int[] {
                DefaultLayout.LEFT_PANEL_WIDTH + DefaultLayout.CENTER_WIDTH,
                0};
        int infoOffset = 400;
        ShipPainter.paint(g, start);
        ShipInfoPainter.paint(g, new int[] {
                start[0],
                start[1] + infoOffset});
    }
}