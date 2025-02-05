package util;

import config.Settings;
import entity.Creature;
import entity.animals.Animal;
import entity.map.Island;
import entity.map.Location;
import entity.plants.Plant;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import static entity.map.Location.newPlant;

public class LocationAnimalServise implements Runnable {

    private Island island;

    public LocationAnimalServise(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        try {
            life();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private void life() throws CloneNotSupportedException {
        List<Location> locations = island.locationsList();
        for (Location location : locations) {
            for (Creature creature : location.getAnimal()) {
                Animal animal = (Animal) creature;
                animal.eat(location, creature);
                animal.move(island, creature);
            }
            Animal.reproduction(location);
        }
    }
}
