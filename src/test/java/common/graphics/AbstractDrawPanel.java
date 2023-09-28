package common.graphics;

import java.util.Objects;
import java.awt.*;
import javax.swing.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
public abstract class AbstractDrawPanel extends JPanel {
    private static final @NotNull Color DEFAULT_BACKGROUND = new Color(0, 0, 0, 0);

    //
    public AbstractDrawPanel(@Nullable Color background) {
        setBackground(Objects.requireNonNullElse(background, DEFAULT_BACKGROUND));
    }

    //overridden super
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    //my draw
    public abstract void draw(@NotNull Graphics g);
}