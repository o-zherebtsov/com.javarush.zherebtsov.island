package entity.map;

import config.Settings;
import entity.Creature;
import entity.animals.herbivores.*;
import entity.animals.predators.*;
import entity.plants.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Location {

    private final List<Creature> animal = new CopyOnWriteArrayList<>();
    private List<Plant> plants = new CopyOnWriteArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private int rowsLocation = 0;
    private int columnsLocation = 0;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public void setRowsLocation(int rowsLocation) {
        this.rowsLocation = rowsLocation;
    }

    public void setColumnsLocation(int columnsLocation) {
        this.columnsLocation = columnsLocation;
    }

    public int getRowsLocation() {
        return rowsLocation;
    }

    public int getColumnsLocation() {
        return columnsLocation;
    }

    public List<Creature> getAnimal() {
        return animal;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    private static int locationNumber = 0;

    public boolean addCreature(Creature creature) {
        long count = animal.stream().filter(x -> x.getClass() == creature.getClass()).count();
        long max = Settings.maxCreatureLocation.get(creature.getClass());
        if (animal.contains(creature)) {
            return false;
        } else if (count < max) {
            animal.add(creature);
            return true;
        } else
            return false;
    }

    public Location() {
        lock.lock();
        ArrayList<Creature> creatureArrayList = new ArrayList<>(1000);
        for (Class<? extends Creature> allCreature : Settings.allAnimal) {
            int x = new Random().nextInt(0, Settings.maxCreatureLocation.get(allCreature));
            for (int i = 0; i < x; i++) {
                creatureArrayList.add(createNewCreatur(allCreature.getSimpleName()));
            }
        }
        Collections.shuffle(creatureArrayList);
        animal.addAll(creatureArrayList);
        ArrayList<Plant> plantArrayList = new ArrayList<>(Settings.maxPlant);
        int x = new Random().nextInt(0, Settings.maxPlant);
        for (int i = 0; i < x; i++) {
            plantArrayList.add(newPlant());
        }
        Collections.shuffle(plantArrayList);
        plants.addAll(plantArrayList);
        locationNumber++;
        lock.unlock();
    }

    public static Creature createNewCreatur(String name) {
        Creature creature = switch (name) {
            case "Wolf" ->
                    new Wolf(Settings.nameWolf, Settings.iconWolf, Settings.weightWolf, Settings.speedWolf, Settings.needSaturationWolf, Settings.maxWolf);
            case "Caterpillar" ->
                    new Caterpillar(Settings.nameCaterpillar, Settings.iconCaterpillar, Settings.weightCaterpillar, Settings.speedCaterpillar, Settings.needSaturationCaterpillar, Settings.maxCaterpillar);
            case "Duck" ->
                    new Duck(Settings.nameDuck, Settings.iconDuck, Settings.weightDuck, Settings.speedDuck, Settings.needSaturationDuck, Settings.maxDuck);
            case "Buffalo" ->
                    new Buffalo(Settings.nameBuffalo, Settings.iconBuffalo, Settings.weightBuffalo, Settings.speedBuffalo, Settings.needSaturationBuffalo, Settings.maxBuffalo);
            case "Snake" ->
                    new Snake(Settings.nameSnake, Settings.iconSnake, Settings.weightSnake, Settings.speedSnake, Settings.needSaturationSnake, Settings.maxSnake);
            case "Fox" ->
                    new Fox(Settings.nameFox, Settings.iconFox, Settings.weightFox, Settings.speedFox, Settings.needSaturationFox, Settings.maxFox);
            case "Bear" ->
                    new Bear(Settings.nameBear, Settings.iconBear, Settings.weightBear, Settings.speedBear, Settings.needSaturationBear, Settings.maxBear);
            case "Eagle" ->
                    new Eagle(Settings.nameEagle, Settings.iconEagle, Settings.weightEagle, Settings.speedEagle, Settings.needSaturationEagle, Settings.maxEagle);
            case "Horse" ->
                    new Horse(Settings.nameHorse, Settings.iconHorse, Settings.weightHorse, Settings.speedHorse, Settings.needSaturationHorse, Settings.maxHorse);
            case "Deer" ->
                    new Deer(Settings.nameDeer, Settings.iconDeer, Settings.weightDeer, Settings.speedDeer, Settings.needSaturationDeer, Settings.maxDeer);
            case "Rabbit" ->
                    new Rabbit(Settings.nameRabbit, Settings.iconRabbit, Settings.weightRabbit, Settings.speedRabbit, Settings.needSaturationRabbit, Settings.maxRabbit);
            case "Mouse" ->
                    new Mouse(Settings.nameMouse, Settings.iconMouse, Settings.weightMouse, Settings.speedMouse, Settings.needSaturationMouse, Settings.maxMouse);
            case "Goat" ->
                    new Goat(Settings.nameGoat, Settings.iconGoat, Settings.weightGoat, Settings.speedGoat, Settings.needSaturationGoat, Settings.maxGoat);
            case "Sheep" ->
                    new Sheep(Settings.nameSheep, Settings.iconSheep, Settings.weightSheep, Settings.speedSheep, Settings.needSaturationSheep, Settings.maxSheep);
            case "Hog" ->
                    new Hog(Settings.nameHog, Settings.iconHog, Settings.weightHog, Settings.speedHog, Settings.needSaturationHog, Settings.maxHog);
            default -> throw new IllegalStateException("Unexpected value: " + name);
        };
        return creature;
    }

    public static Plant newPlant() {
        return new Plant(Settings.namePlant, Settings.iconPlant, Settings.weightPlant, Settings.speedPlant, Settings.needSaturationPlant, Settings.maxPlant);
    }
}

    

