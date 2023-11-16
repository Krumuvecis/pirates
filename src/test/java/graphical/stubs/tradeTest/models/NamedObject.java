package graphical.stubs.tradeTest.models;

import org.jetbrains.annotations.NotNull;

//
public abstract class NamedObject {
    private final @NotNull String name;

    //
    protected NamedObject(@NotNull String name) {
        this.name = name;
    }

    //
    public final @NotNull String getName() {
        return name;
    }
}