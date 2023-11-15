package graphical.common.simpleGraphicalTest;

import java.awt.Point;
import java.awt.Dimension;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.common.graphics.AbstractWindow;
import graphical.common.graphics.WindowConfig;
import graphical.common.graphics.WindowUpdater;

//
public abstract class SimpleGraphicalTest extends AbstractWindow {
    private static final @NotNull String DEFAULT_TITLE = "A graphical test";
    private final @NotNull String title;

    //
    public SimpleGraphicalTest(@Nullable String title, boolean updating) {
        super();
        this.title = Objects.requireNonNullElse(title, DEFAULT_TITLE);
        updateTitle();
        addUpdaterIfUpdating(updating);
    }

    /**
     * Gets the initial window configuration.
     * This method is being called from constructor.
     *
     * @return WindowConfig instance. Null means default.
     */
    @Override
    public @NotNull WindowConfig initialWindowConfig() {
        int @Nullable []
                locationArray = initialWindowLocation(),
                sizeArray = initialWindowSize();
        @Nullable Point location = null;
        if (locationArray != null && locationArray.length >= 2) {
            location = new Point(locationArray[0], locationArray[1]);
        }
        @Nullable Dimension size = null;
        if (sizeArray != null && sizeArray.length >= 2) {
            size = new Dimension(sizeArray[0], sizeArray[1]);
        }
        return new WindowConfig(location, size, WindowConfig.DefaultWindowConfig.DEFAULT_CLOSE_OPERATION);
    }

    //
    public abstract int @Nullable [] initialWindowLocation();

    //
    public abstract int @Nullable [] initialWindowSize();

    /**
     * A string for the window title.
     * Intended for custom titles.
     * This method is being called by updateTitle().
     *
     * @return New string for window title. Null means default.
     */
    @SuppressWarnings({"DataFlowIssue", "RedundantSuppression"})
    @Override
    public @Nullable String getNewTitleString() {
        return title;
    }

    private void addUpdaterIfUpdating(boolean updating) {
        if (updating) {
            new WindowUpdater(this);
        }
    }
}