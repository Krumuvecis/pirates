package common.graphics;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs where needed
public class WindowConfig {
    private final @NotNull Point location;
    private final @NotNull Dimension size;
    private final int closeOperation;

    //
    public WindowConfig(@NotNull Point location, @NotNull Dimension size, int closeOperation) {
        this.location = location;
        this.size = size;
        this.closeOperation = closeOperation;
    }

    /**
     * Gets the location of the window.
     *
     * @return Window location Point object.
     */
    public @NotNull Point getLocation() {
        return location;
    }

    /**
     * Gets the size of the window.
     *
     * @return Window size Dimension object.
     */
    public @NotNull Dimension getSize() {
        return size;
    }

    /**
     * Gets the close operation magic constant as from javax.swing.WindowConstants:
     *      DISPOSE_ON_CLOSE    The dispose-window default window close operation.
     *      DO_NOTHING_ON_CLOSE The do-nothing default window close operation.
     *      EXIT_ON_CLOSE       The exit application default window close operation.
     *      HIDE_ON_CLOSE       The hide-window default window close operation.
     *
     * @return Magic constant
     */
    public int getCloseOperation() {
        return closeOperation;
    }

    /**
     * Default window configuration.
     */
    public final static class DefaultWindowConfig extends WindowConfig {
        public static final @NotNull Point DEFAULT_LOCATION = new Point(100, 100);
        public static final @NotNull Dimension DEFAULT_SIZE = new Dimension(600, 400);
        public static final int DEFAULT_CLOSE_OPERATION = WindowConstants.EXIT_ON_CLOSE;

        /**
         * Creates a new DefaultWindowConfig object.
         */
        public DefaultWindowConfig() {
            super(DEFAULT_LOCATION, DEFAULT_SIZE, DEFAULT_CLOSE_OPERATION);
        }
    }
}