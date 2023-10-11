package models.bodies;

import org.jetbrains.annotations.NotNull;

//
public interface NamedBodyInterface {
    //
    @NotNull String getName();

    //
    void setName(@NotNull String name);
}