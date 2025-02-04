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

public class LocationAnimalServise {

    private final Creature creature;
    private final Island island;

    public Queue<Task> getTasks() {
        return tasks;
    }

    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public LocationAnimalServise(Creature creature, Island island) {
        this.creature = creature;
        this.island = island;
    }

//    @Override
//    public void run() {
//        processOneCell();
//    }

    public void processOneCell(Location location) {
        location.getLock().lock();
        location.getAnimal().forEach(creature1 -> {
            tasks.add(new Task(creature, location, island));
        });
        location.getLock().unlock();

//        tasks.forEach(Task::doTask);

    }
}
