package util;

import config.Settings;
import entity.Creature;
import entity.animals.Animal;
import entity.animals.herbivores.*;
import entity.animals.predators.*;
import entity.map.Island;
import entity.map.Location;

public class Statistics implements Runnable {

    private final Island island;

    public Statistics(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        long countWolf = 0;
        long countBear = 0;
        long countEagle = 0;
        long countFox = 0;
        long countSnake = 0;
        long countBuffalo = 0;
        long countCaterpillar = 0;
        long countDeer = 0;
        long countDuck = 0;
        long countGoat = 0;
        long countHog = 0;
        long countHorse = 0;
        long countMouse = 0;
        long countRabbit = 0;
        long countSheep = 0;

        for (Location location : island.locationsList()) {
            countWolf = countWolf + location.getAnimal().stream().filter(x -> x.getClass() == Wolf.class).count();
            countBear = countBear + location.getAnimal().stream().filter(x -> x.getClass() == Bear.class).count();
            countEagle = countEagle + location.getAnimal().stream().filter(x -> x.getClass() == Eagle.class).count();
            countFox = countFox + location.getAnimal().stream().filter(x -> x.getClass() == Fox.class).count();
            countSnake = countSnake + location.getAnimal().stream().filter(x -> x.getClass() == Snake.class).count();
            countBuffalo = countBuffalo + location.getAnimal().stream().filter(x -> x.getClass() == Buffalo.class).count();
            countCaterpillar = countCaterpillar + location.getAnimal().stream().filter(x -> x.getClass() == Caterpillar.class).count();
            countDeer = countDeer + location.getAnimal().stream().filter(x -> x.getClass() == Deer.class).count();
            countDuck = countDuck + location.getAnimal().stream().filter(x -> x.getClass() == Duck.class).count();
            countGoat = countGoat + location.getAnimal().stream().filter(x -> x.getClass() == Goat.class).count();
            countHog = countHog + location.getAnimal().stream().filter(x -> x.getClass() == Hog.class).count();
            countHorse = countHorse + location.getAnimal().stream().filter(x -> x.getClass() == Horse.class).count();
            countMouse = countMouse + location.getAnimal().stream().filter(x -> x.getClass() == Mouse.class).count();
            countRabbit = countRabbit + location.getAnimal().stream().filter(x -> x.getClass() == Rabbit.class).count();
            countSheep = countSheep + location.getAnimal().stream().filter(x -> x.getClass() == Sheep.class).count();
        }
        System.out.print(Settings.iconWolf + ": " + countWolf + " ");
        System.out.print(Settings.iconBear + ": " + countBear + " ");
        System.out.print(Settings.iconEagle + ": " + countEagle + " ");
        System.out.print(Settings.iconFox + ": " + countFox + " ");
        System.out.print(Settings.iconSnake + ": " + countSnake + " ");
        System.out.print(Settings.iconBuffalo + ": " + countBuffalo + " ");
        System.out.print(Settings.iconCaterpillar + ": " + countCaterpillar + " ");
        System.out.print(Settings.iconDeer + ": " + countDeer + " ");
        System.out.print(Settings.iconDuck + ": " + countDuck + " ");
        System.out.print(Settings.iconGoat + ": " + countGoat + " ");
        System.out.print(Settings.iconHog + ": " + countHog + " ");
        System.out.print(Settings.iconHorse + ": " + countHorse + " ");
        System.out.print(Settings.iconMouse + ": " + countMouse + " ");
        System.out.print(Settings.iconRabbit + ": " + countRabbit + " ");
        System.out.print(Settings.iconSheep + ": " + countSheep + " ");
        System.out.println();

    }
}

