package models.bodies.basic;

//
public abstract class ContainableBody {
    private BodyContainer<? extends ContainableBody> parent;

    //
    public ContainableBody(BodyContainer<? extends ContainableBody> parent) {
        this.parent = parent;
    }

    //
    public BodyContainer<? extends ContainableBody> getParent() {
        return parent;
    }

    //
    public void setParent(BodyContainer<? extends ContainableBody> parent) {
        this.parent = parent;
    }
}