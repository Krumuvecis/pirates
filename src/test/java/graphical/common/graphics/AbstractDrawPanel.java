package graphical.common.graphics;

import java.util.Objects;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
public abstract class AbstractDrawPanel extends JPanel {
    private static final @NotNull Color
            DEFAULT_BACKGROUND_COLOR = new Color(0, 0, 0, 255),
            DEFAULT_TEXT_COLOR = new Color(200, 200, 200, 200);

    //
    public AbstractDrawPanel(@Nullable Color background) {
        setBackground(Objects.requireNonNullElse(background, DEFAULT_BACKGROUND_COLOR));
    }

    //overridden super
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    //my draw
    public abstract void draw(@NotNull Graphics g);

    //
    public final void drawString(@NotNull Graphics g, @Nullable Color color,
                                 int @NotNull [] location, @Nullable String text) {
        @NotNull Color textColor = Objects.requireNonNullElse(color, DEFAULT_TEXT_COLOR);
        @NotNull String nonNullText = Objects.requireNonNullElse(text, "");
        GraphicsUtils.drawString(g, textColor, location, nonNullText);
    }
}