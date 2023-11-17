package graphical.stubs.tradeTest.models.person;

import graphical.stubs.tradeTest.models.Updatable;

//
public class DeathException extends Updatable.UpdatableException {
    //
    protected DeathException(AliveBeing being) {
        super("Alive being " + being.getName() + " has died.");
    }
}