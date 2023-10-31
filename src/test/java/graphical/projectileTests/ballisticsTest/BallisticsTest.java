package graphical.projectileTests.ballisticsTest;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

import models.coordinates.Location;
import models.coordinates.Orientation;
import models.guns.AbstractGun;
import models.guns.SmallGun;
import models.ChunkManager;

import graphical.common.graphics.WindowConfig;
import graphical.common.graphics.WindowUpdater;
import graphical.common.simpleGraphicalTest.SimpleGraphicalTest;
import graphical.common.Observer;
import graphical.projectileTests.GunShooterThread;

//
public class BallisticsTest extends SimpleGraphicalTest {
    protected static final @NotNull ChunkManager CHUNK_MANAGER;
    private static final @NotNull String WINDOW_TITLE = "Ballistics test";
    private static final @NotNull WindowConfig WINDOW_CONFIG = new WindowConfig(
            new Point(100, 100),
            new Dimension(1400, 600),
            WindowConstants.EXIT_ON_CLOSE);
    protected static final @NotNull Observer OBSERVER = new Observer(
            new Location(0, 0, 0),
            new Orientation(Math.toRadians(290), Math.toRadians(-30), 0));
    protected static final @NotNull AbstractGun GUN;
    private static final double
            GUN_ALTITUDE = 15,
            HORIZONTAL_ANGLE = Math.toRadians(0),
            VERTICAL_ANGLE = Math.toRadians(45);

    static {
        CHUNK_MANAGER = new ChunkManager();
        GUN = new SmallGun(
                CHUNK_MANAGER.getGunContainer(),
                new Location(0, 0, GUN_ALTITUDE),
                new Orientation(HORIZONTAL_ANGLE, VERTICAL_ANGLE, 0));
    }

    //
    public static void main(String[] args) {
        new GunShooterThread(GUN, 700);
        new BallisticsTest();
    }

    /**
     * Creates a new window.
     */
    private BallisticsTest() {
        super(WINDOW_TITLE);
        addKeyListener(new MyKeyListener(OBSERVER));
        new WindowUpdater(this);
    }

    /**
     * Gets the initial window configuration.
     * This method is being called from constructor.
     *
     * @return WindowConfig instance. Null means default.
     */
    @Override
    public @NotNull WindowConfig initialWindowConfig() {
        return WINDOW_CONFIG;
    }

    /**
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    @Override
    public void addPanels() {
        add(new DrawPanel());
    }

    //
    @SuppressWarnings("ClassCanBeRecord")
    private static class MyKeyListener implements KeyListener {
        private final @NotNull Observer observer;

        //
        MyKeyListener(@NotNull Observer observer) {
            this.observer = observer;
        }

        @Override
        public void keyTyped(KeyEvent e) {}

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

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}