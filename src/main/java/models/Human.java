package models;

public class Human extends SizedObject {
    private static final int DEFAULT_DIAMETER = 30;

    private final String name;

    private Human(String name, int x, int y) {
        super(x, y, DEFAULT_DIAMETER);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class HumanGenerator {
        private static int personNumber = 1;

        public static Human getNew() {
            return getNew(0, 0);
        }

        public static Human getNew(int x, int y) {
            Human human = new Human(getNewName(), x, y);
            personNumber++;
            return human;
        }

        private static String getNewName() {
            return "Person-" + personNumber;
        }
    }
}