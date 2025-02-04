import config.Settings;
import entity.Creature;
import entity.animals.Animal;
import entity.animals.predators.Wolf;
import entity.map.Island;
import entity.map.Location;
import util.LocationAnimalServise;
import util.Rnd;
import util.Statistics;
import util.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Location location = new Location();
        System.out.println(location.getAnimal().size());
        System.out.println(location.getAnimal());
        synchronized (location) {
            if (location.getAnimal(). isEmpty()) {
                return;
            }
        }
        location.getLock().lock();
        for (Creature creature : location.getAnimal()) {
            Animal animal = (Animal) creature;
            animal.eat(location, creature);
        }
        location.getLock().unlock();
        System.out.println(location.getAnimal().size());
        System.out.println(location.getAnimal());
        
        Animal.reproduction(location);
        System.out.println(location.getAnimal().size());
        System.out.println(location.getAnimal());
    }
}