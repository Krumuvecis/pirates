package graphical.stubs.tradeTest.models.person;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphical.stubs.tradeTest.models.Updatable;

//
public abstract class Person extends AliveBeing {
    private static final Energy.EnergyInitialParameters DEFAULT_ENERGY_PARAMETERS = new Energy.EnergyInitialParameters(
            100, 5);
    private static final Health.HealthInitialParameters DEFAULT_HEALTH_PARAMETERS = new Health.HealthInitialParameters(
            100,
            0.8, 2,
            0.2, 5);
    public static final @Nullable PersonAction DEFAULT_ACTION = null;
    private @Nullable PersonAction action;

    //
    protected Person(@NotNull String name) {
        super(name, DEFAULT_ENERGY_PARAMETERS, DEFAULT_HEALTH_PARAMETERS);
        action = DEFAULT_ACTION;
    }

    //
    public final void setAction(@Nullable PersonAction action) {
        this.action = action;
    }

    //
    public final @Nullable PersonAction getAction() {
        return action;
    }

    //
    @Override
    public void act(double timeInterval) {
        if (action == null) {
            //TODO: person idle, determine next action here
            decideAction();
        } else {
            try {
                action.update(timeInterval);
            } catch (UpdatableException e) {
                System.err.println("Unhandled exception while performing action for person " + getName());
                throw new RuntimeException(e);
            }
        }
    }

    private void decideAction() {
        if (needsToEat()) {
            double defaultFoodAmount = 30;
            setAction(new Action_Eat(this, defaultFoodAmount));
            return;
        }
    }

    private boolean needsToEat() {
        //TODO: finish this, check energy & health better
        double
                relativeEnergy = getEnergy().getRelativeValue(),
                relativeHealth = getHealth().getRelativeValue();
        return relativeEnergy <= 0.2 || (relativeHealth < 1 && relativeEnergy < 0.8);
    }

    //
    public static abstract class PersonAction implements Updatable {
        public static final @NotNull String
                IDLE_TITLE = "Idle",
                IDLE_DESCRIPTION = "Awaiting decision";
        private final @NotNull String
                title,
                description;
        private final @NotNull Person person;
        private final boolean resetOnCompletion;

        //
        protected PersonAction(@NotNull String title, @NotNull String description,
                               @NotNull Person person, boolean resetOnCompletion) {
            this.title = title;
            this.description = description;
            this.person = person;
            this.resetOnCompletion = resetOnCompletion;
        }

        //
        public final @NotNull String getTitle() {
            return title;
        }

        //
        public final @NotNull String getDescription() {
            return description;
        }

        //
        protected final @NotNull Person getPerson() {
            return person;
        }

        @Override
        public void update(double timeInterval) throws UpdatableException {
            continuousAction(timeInterval);
            if (checkIfFinished()) {
                finishingAction();
                if (resetOnCompletion) {
                    person.setAction(null);
                }
            }
        }

        //
        abstract void continuousAction(double timeInterval);

        //
        abstract void finishingAction();

        //
        abstract boolean checkIfFinished();
    }

    public static abstract class TimedAction extends PersonAction {
        private final double duration;
        private double remainingTime;

        //
        TimedAction(@NotNull String title, @NotNull String description,
                    @NotNull Person person, boolean resetOnCompletion, double duration) {
            super(title, description, person, resetOnCompletion);
            this.duration = duration;
            remainingTime = duration;
        }

        public double getDuration() {
            return duration;
        }

        public double getRemainingTime() {
            return remainingTime;
        }

        @Override
        public void update(double timeInterval) throws UpdatableException {
            remainingTime -= timeInterval;
            super.update(timeInterval);
        }

        //
        @Override
        boolean checkIfFinished() {
            return remainingTime <= 0;
        }
    }

    static class Action_Eat extends TimedAction {
        private static final @NotNull String
                TITLE = "Eat",
                DESCRIPTION = "Consuming food";
        private static final double
                DEFAULT_DURATION = 1.5,
                FOOD_TO_ENERGY_RATIO = 1;
        private final double foodAmount;

        Action_Eat(@NotNull Person person, double foodAmount) {
            super(TITLE, DESCRIPTION, person, true, DEFAULT_DURATION);
            this.foodAmount = foodAmount;
        }

        //
        @Override
        void continuousAction(double timeInterval) {
            //nothing happens here
        }

        @Override
        void finishingAction() {
            getPerson().getEnergy().increaseValue(foodAmount * FOOD_TO_ENERGY_RATIO);
            //TODO: remove food item
        }
    }
}