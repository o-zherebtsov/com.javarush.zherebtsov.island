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
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Island island = new Island(Settings.rowsCount, Settings.columnsCount);
        island.locationFactory();
        Statistics statistics = new Statistics(island);
        statistics.run();

        int day = 1;

        while (day <= Settings.maxDay) {
            for (Location location : island.locationsList()) {
                for (Creature creature : location.getAnimal()) {
                    Animal animal = (Animal) creature;
                    animal.eat(location, creature);
                }
                Animal.reproduction(location);
                for (Creature creature : location.getAnimal()) {
                    Animal animal = (Animal) creature;
                    animal.move(island, creature);
                }
            }


            statistics.run();

            day++;
        }
    }
}