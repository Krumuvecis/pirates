package models;

public abstract class LocatableObject {
    private final int[] location;

    public LocatableObject() {
        this(0, 0);
    }

    public LocatableObject(int x, int y) {
        location = new int[] {x, y};
    }

    public void setLocation(int x, int y) {
        location[0] = x;
        location[1] = y;
    }

    public int[] getLocation() {
        return location;
    }
}