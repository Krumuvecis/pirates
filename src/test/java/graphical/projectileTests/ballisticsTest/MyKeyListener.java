package graphical.projectileTests.ballisticsTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Orientation;

import graphical.common.Observer;

//
final class MyKeyListener implements KeyListener {
    private final @NotNull Observer observer;

    //
    MyKeyListener(@NotNull Observer observer) {
        this.observer = observer;
    }

    //
    @Override
    public void keyTyped(KeyEvent e) {}

    //
    @Override
    public void keyPressed(KeyEvent e) {
        @NotNull Orientation orientation = observer.getOrientation();
        double delta = 0.1;
        switch (e.getKeyChar()) {
            case 'a', 'A' -> orientation.increase(delta, 0);
            case 'd', 'D' -> orientation.increase(-delta, 0);
            case 'w', 'W' -> orientation.increase(0, -delta);
            case 's', 'S' -> orientation.increase(0, delta);
            default -> {}
        }
    }

    //
    @Override
    public void keyReleased(KeyEvent e) {}
}