package graphical.stubs.tradeTest.models.person;

import graphical.stubs.tradeTest.models.Updatable;

//
public class DeathException extends Updatable.UpdatableException {
    //
    protected DeathException(Person person) {
        super("Person " + person.getName() + " has died.");
    }
}