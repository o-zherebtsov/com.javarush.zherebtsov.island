package entity.animals;

import config.Settings;
import entity.Creature;
import entity.animals.herbivores.*;
import entity.animals.predators.*;
import entity.map.Island;
import entity.map.Location;
import util.Rnd;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal extends Creature {

    public Animal(String name, String icon, double weight, int speed, double needSaturation, int maxCreatureLocation) {
        super(name, icon, weight, speed, needSaturation, maxCreatureLocation);
    }

    public static void reproduction(Location location) {

        for (int i = 0; i < Settings.allAnimal.size(); i++) {

            switch (i) {
                case 0 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Wolf).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Wolf"));
                    }
                }
                case 1 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Snake).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Snake"));
                    }
                }
                case 2 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Fox).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Fox"));
                    }
                }
                case 3 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Bear).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Bear"));
                    }
                }
                case 4 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Eagle).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Eagle"));
                    }
                }
                case 5 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Horse).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Horse"));
                    }
                }
                case 6 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Deer).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Deer"));
                    }
                }
                case 7 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Rabbit).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Rabbit"));
                    }
                }
                case 8 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Mouse).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Mouse"));
                    }
                }
                case 9 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Goat).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Goat"));
                    }
                }
                case 10 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Sheep).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Sheep"));
                    }
                }
                case 11 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Hog).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Hog"));
                    }
                }
                case 12 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Buffalo).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Buffalo"));
                    }
                }
                case 13 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Duck).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Duck"));
                    }
                }
                case 14 -> {
                    long parents = location.getAnimal().stream().filter(x -> x instanceof Caterpillar).count();
                    long children = parents / 2;
                    for (int j = 0; j < children; j++) {
                        location.addCreature(Location.createNewCreatur("Caterpillar"));
                    }
                }
            }

        }
    }

    public void eat(Location location, Creature creature) {
        try {
            boolean go = true;
            double needSaturationStart = 0.0;

            HashMap<String, Integer> eatHunter = switch (creature.getClass().getSimpleName()) {
                case "Wolf" -> Settings.eatWolf;
                case "Caterpillar" -> Settings.eatCaterpillar;
                case "Duck" -> Settings.eatDuck;
                case "Buffalo" -> Settings.eatBuffalo;
                case "Snake" -> Settings.eatSnake;
                case "Fox" -> Settings.eatFox;
                case "Bear" -> Settings.eatBear;
                case "Eagle" -> Settings.eatEagle;
                case "Horse" -> Settings.eatHorse;
                case "Deer" -> Settings.eatDeer;
                case "Rabbit" -> Settings.eatRabbit;
                case "Mouse" -> Settings.eatMouse;
                case "Goat" -> Settings.eatGoat;
                case "Sheep" -> Settings.eatSheep;
                case "Hog" -> Settings.eatHog;
                default -> throw new IllegalStateException("Unexpected value: " + creature.getClass().getName());
            };

            int size = location.getAnimal().size();

            location.getLock().lock();
            while (needSaturationStart < creature.getNeedSaturation() && go) {

                if (!location.getAnimal().isEmpty()) {
                    Creature creatureEat = location.getAnimal().get(Rnd.random(size));

                    if (creatureEat != null && go) {

                        int var = new Random().nextInt(0, 101);

                        if (var <= eatHunter.get(creatureEat.getClass().getSimpleName())) {
                            needSaturationStart = needSaturationStart + creatureEat.getWeight();
                            location.getAnimal().remove(creatureEat);
                            size--;
                            if (creature.getSaturation() < Settings.saturation) {
                                creature.setSaturation(creature.getSaturation() + 1);
                            }
                        } else if (var > eatHunter.get(creatureEat.getClass().getSimpleName()) && eatHunter.get("Plant") != 0) {
                            if (!location.getPlants().isEmpty()) {
                                location.getPlants().remove(location.getPlants().removeFirst());
                                needSaturationStart = needSaturationStart + Settings.weightPlant;
                                if (creature.getSaturation() < Settings.saturation) {
                                    creature.setSaturation(creature.getSaturation() + 1);
                                }
                            }
                        } else {
                            creature.setSaturation(creature.getSaturation() - 1);
                            if (creature.getSaturation() == 0) {
                                location.getAnimal().remove(creature);
                            }
                            go = false;
                        }
                    }
                }
                break;
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } finally {
            location.getLock().unlock();
        }

    }

    public void move(Island island, Creature creature) throws CloneNotSupportedException {
        int rowsLocation = 0;
        int columnsLocation = 0;
        int rowsLocationNew = 0;
        int columnsLocationNew = 0;

        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getColumns(); j++) {
                if (island.getLocation(i, j).equals(creature.getLocation())) {
                    rowsLocation = i;
                    columnsLocation = j;
                }
            }
        }

        int speedNext = new Random().nextInt(0, creature.getSpeed());

        while (speedNext > 0) {
            int xy = new Random().nextInt(0, 3);

            if (xy == 0) {
                rowsLocationNew = rowsLocation + 1;
                if (rowsLocationNew > island.getRows()) {
                    rowsLocationNew = 0;
                }
            }

            if (xy == 1) {
                columnsLocationNew = columnsLocation + 1;
                if (columnsLocationNew > island.getColumns()) {
                    columnsLocationNew = 0;
                }
            }

            if (xy == 2) {
                rowsLocationNew = rowsLocation - 1;
                if (rowsLocationNew < 0) {
                    rowsLocationNew = island.getRows();
                }
            }

            if (xy == 3) {
                columnsLocationNew = columnsLocation - 1;
                if (columnsLocationNew < 0) {
                    columnsLocationNew = island.getColumns();
                }
            }

            long count = island.getLocation(rowsLocationNew, columnsLocationNew).getAnimal().stream().filter(x -> x.getClass() == creature.getClass()).count();
            long max = Settings.maxCreatureLocation.get(creature.getClass());

            if (count < max) {
                island.getLocation(rowsLocationNew, columnsLocationNew).addCreature(creature.clone());
                island.getLocation(rowsLocation, columnsLocation).getAnimal().remove(creature);
            } else {
                speedNext = 0;
            }
            speedNext--;
        }
    }
}
