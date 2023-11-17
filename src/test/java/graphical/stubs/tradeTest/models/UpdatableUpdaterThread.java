package graphical.stubs.tradeTest.models;

import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

import utils.TimeUtils;

//
public class UpdatableUpdaterThread extends AbstractUpdater {
    private final @NotNull Updatable object;

    //
    public UpdatableUpdaterThread(@NotNull Updatable object, long interval) {
        super(interval);
        this.object = object;
        this.start();
    }

    //
    @Override
    public void update() {
        try {
            object.update(getTotalElapsedTimeInSeconds());
        } catch (Updatable.UpdatableException e) {
            System.err.println("Unhandled exception while updating an object of Updatable class.");
            throw new RuntimeException(e);
        }

    }

    private double getTotalElapsedTimeInSeconds() {
        return TimeUtils.getSecondsFromMillis(delayCalculator.getElapsedTime() + delayCalculator.getDelay());
    }
}