package graphical.projectileTests.painters;

import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

//
public abstract class AbstractPainter {
    private final int @NotNull [] offset;

    //
    AbstractPainter(int @NotNull [] offset) {
        this.offset = offset;
    }

    //
    public int @NotNull [] getOffset() {
        return offset;
    }

    //
    public void setOffset(int @NotNull [] offset) {
        this.offset[0] = offset[0];
        this.offset[1] = offset[1];
    }

    //
    public abstract void paint(@NotNull Graphics g);
}