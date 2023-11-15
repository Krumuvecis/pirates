package models.bodies.basic;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

//
public class BodyContainer<T extends ContainableBody> {
    private final @NotNull List<@NotNull T> list;

    //
    public BodyContainer() {
        list = new ArrayList<>();
    }

    //
    public @NotNull List<@NotNull T> getList() {
        return list;
    }

    //
    public void add(@NotNull T body) {
        list.add(body);
    }
}