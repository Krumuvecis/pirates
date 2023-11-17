package graphical.stubs.tradeTest.models;

//
public interface Updatable {
    //time in seconds
    void update(double timeInterval) throws UpdatableException;

    //
    abstract class UpdatableException extends Exception {
        public UpdatableException(String message) {
            super(message);
        }
    }
}