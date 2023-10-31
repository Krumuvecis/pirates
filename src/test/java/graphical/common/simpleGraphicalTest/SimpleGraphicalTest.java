package graphical.common.simpleGraphicalTest;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.common.graphics.AbstractWindow;

//
public abstract class SimpleGraphicalTest extends AbstractWindow {
    private static final @NotNull String DEFAULT_TITLE = "A graphical test";
    private final @NotNull String title;

    //
    public SimpleGraphicalTest(@Nullable String title) {
        super();
        this.title = Objects.requireNonNullElse(title, DEFAULT_TITLE);
        updateTitle();
    }

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
}