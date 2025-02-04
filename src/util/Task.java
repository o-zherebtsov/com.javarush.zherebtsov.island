package util;

import config.Settings;
import entity.Creature;
import entity.animals.Animal;
import entity.map.Island;
import entity.map.Location;
import entity.plants.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import static entity.map.Location.newPlant;

public class Task {

//    private final Queue<Creature> tasks = new ConcurrentLinkedQueue<>();
//    public static Island island = null;
//
//
//    public Queue<Creature> getTasks() {
//        return tasks;
//    }
//
//    public Task(Island island) {
//
//        Task.island = island;
//
//        for (Location location : island.locationsList()) {
//            for (Creature creature : location.getAnimal()) {
//                location.getLock().lock();
//                tasks.add(creature);
//                location.getLock().unlock();
//            }
//        }
//    }

    private final Creature creature;
    private final Location location;
    private final Island island;

    public Task(Creature creature, Location location, Island island) {
        this.creature = creature;
        this.location = location;
        this.island = island;
    }


    public void doTask() {
        Animal animal = (Animal) creature;
        location.getLock().lock();
        if (animal != null) {
            animal.eat(location, creature);
        }
        location.getLock().unlock();
//        location.getLock().lock();
//        Animal.reproduction(location);
//        location.getLock().unlock();
    }

    public void doTaskMove() throws CloneNotSupportedException {
        Animal animal = (Animal) creature;
        if (animal != null) {
            animal.move(island, creature);
        }
    }
}
