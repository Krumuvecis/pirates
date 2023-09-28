package common.graphics;

import java.util.Objects;
import javax.swing.JFrame;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An abstract window with the most basic features.
 */
public abstract class AbstractWindow extends JFrame {
    private static final @NotNull WindowConfig DEFAULT_WINDOW_CONFIG = new WindowConfig.DefaultWindowConfig();
    private static final @NotNull String DEFAULT_WINDOW_TITLE = "Window title";

    /**
     * Creates a new window with initial configuration and some panels.
     * TODO: maybe remove panel from this constructor.
     */
    public AbstractWindow() {
        super();
        setInitialConfiguration();
        addPanels();
        setVisible(true);
    }

    @SuppressWarnings("MagicConstant")
    private void setInitialConfiguration() {
        @NotNull WindowConfig windowConfig = Objects.requireNonNullElse(
                initialWindowConfig(),
                DEFAULT_WINDOW_CONFIG);
        setSize(windowConfig.getSize());
        setLocation(windowConfig.getLocation());
        setDefaultCloseOperation(windowConfig.getCloseOperation());
        updateTitle();
    }

    /**
     * Overridden for exception handling.
     * Otherwise, works the same as super.setDefaultCloseOperation()
     *
     * @param operation Close operation magic constant.
     */
    @SuppressWarnings("CallToPrintStackTrace")
    @Override
    public final void setDefaultCloseOperation(int operation) {
        try {
            super.setDefaultCloseOperation(operation);
        } catch (IllegalArgumentException e) {
            System.out.println("Default close operation is not a valid magic constant.");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            System.out.println("SecurityManager does not allow invoking System.exit for AbstractWindow");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the initial window configuration.
     * This method is being called by constructor.
     *
     * @return WindowConfig instance. Null means default.
     */
    public abstract @Nullable WindowConfig initialWindowConfig();

    //updates title to getNewTitleString

    /**
     * Updates window title to the output of the method getNewTitleString().
     * Null means default.
     */
    public final void updateTitle() {
        setTitle(Objects.requireNonNullElse(getNewTitleString(), DEFAULT_WINDOW_TITLE));
    }

    /**
     * A string for the window title.
     * Intended for custom titles.
     * This method is being called by updateTitle().
     *
     * @return New string for window title. Null means default.
     */
    public abstract @Nullable String getNewTitleString();

    /**
     * Adds panels to this window.
     * This method is being called by constructor.
     */
    public abstract void addPanels();
}