package graphical.common.graphics;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

//
public final class GraphicsUtils {
    //
    public static void drawString(@NotNull Graphics g, @NotNull Color color,
                                  int @NotNull [] location, @NotNull String text) {
        g.setColor(color);
        try {
            g.drawString(text, location[0], location[1]);
        } catch (NullPointerException ignored) {}
    }
}