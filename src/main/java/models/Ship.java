package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Ship {
    //

    //TODO: add a room
    //Room
    public final List<Human> crew = new ArrayList<>();
    public int length, width;
    public Color color = Color.yellow;

    private Ship(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void addCrewMember(Human human) {
        crew.add(human);
    }

    public static class ShipGenerator {
        private static final Random RANDOM = new Random();
        private static final int DEFAULT_INITIAL_CREW_SIZE = 5;
        private static final int[] DEFAULT_SIZE = new int[] {200, 100};

        public static Ship getNew() {
            Ship ship = new Ship(DEFAULT_SIZE[0], DEFAULT_SIZE[1]);
            addInitialCrew(ship, DEFAULT_INITIAL_CREW_SIZE);
            return ship;
        }

        private static void addInitialCrew(Ship ship, int crewSize) {
            int[] shipSize = new int[] {ship.length, ship.width};
            for (int i = 0; i < crewSize; i++) {
                Human human = Human.HumanGenerator.getNew();
                int radius = human.getDiameter() / 2;
                int[] location = getRandomLocation(shipSize, radius);
                human.setLocation(location[0], location[1]);

                ship.addCrewMember(human);
            }
        }

        private static int[] getRandomLocation(int[] size, int offset) {
            return new int[] {
                    getRandomLocation_OneDimensional(size[0], offset),
                    getRandomLocation_OneDimensional(size[1], offset)};
        }

        private static int getRandomLocation_OneDimensional(int max, int offset) {
            try {
                int range = max - offset * 2;
                if (range < 0) {
                    throw new Exception("Negative range!");
                }
                return offset + RANDOM.nextInt(range);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}