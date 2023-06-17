package models;

public abstract class SizedObject extends LocatableObject {
    private final int diameter;

    public SizedObject(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}