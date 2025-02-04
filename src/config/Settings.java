package config;

import entity.Creature;
import entity.animals.herbivores.*;
import entity.animals.predators.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {

    // Характеристики дней
    public final static int maxDay = 25;

    // Характеристики острова
    public final static int columnsCount = 10;
    public final static int rowsCount = 10;

    // Характеристики локации
    public final static int maxAnimal = 15;
    public final static int maxWolf = 30;
    public final static int maxSnake = 30;
    public final static int maxFox = 30;
    public final static int maxBear = 5;
    public final static int maxEagle = 20;
    public final static int maxHorse = 20;
    public final static int maxDeer = 20;
    public final static int maxRabbit = 150;
    public final static int maxMouse = 500;
    public final static int maxGoat = 140;
    public final static int maxSheep = 140;
    public final static int maxHog = 50;
    public final static int maxBuffalo = 10;
    public final static int maxDuck = 200;
    public final static int maxCaterpillar = 1000;
    public final static int maxPlant = 200;

    public final static Map<Class<? extends Creature>, Integer> maxCreatureLocation = new HashMap<>();
    static  {
        maxCreatureLocation.put(Wolf.class, maxWolf);
        maxCreatureLocation.put(Snake.class, maxSheep);
        maxCreatureLocation.put(Fox.class, maxFox);
        maxCreatureLocation.put(Bear.class, maxBear);
        maxCreatureLocation.put(Eagle.class, maxEagle);
        maxCreatureLocation.put(Horse.class, maxHorse);
        maxCreatureLocation.put(Deer.class, maxDeer);
        maxCreatureLocation.put(Rabbit.class, maxRabbit);
        maxCreatureLocation.put(Mouse.class, maxMouse);
        maxCreatureLocation.put(Goat.class, maxGoat);
        maxCreatureLocation.put(Sheep.class, maxSheep);
        maxCreatureLocation.put(Hog.class, maxHog);
        maxCreatureLocation.put(Buffalo.class, maxBuffalo);
        maxCreatureLocation.put(Duck.class, maxDuck);
        maxCreatureLocation.put(Caterpillar.class, maxCaterpillar);
    }

    public static ArrayList<Class<? extends Creature>> allAnimal = new ArrayList<>();
    static {
        allAnimal.add(Wolf.class);
        allAnimal.add(Snake.class);
        allAnimal.add(Fox.class);
        allAnimal.add(Bear.class);
        allAnimal.add(Eagle.class);
        allAnimal.add(Horse.class);
        allAnimal.add(Deer.class);
        allAnimal.add(Rabbit.class);
        allAnimal.add(Mouse.class);
        allAnimal.add(Goat.class);
        allAnimal.add(Sheep.class);
        allAnimal.add(Hog.class);
        allAnimal.add(Buffalo.class);
        allAnimal.add(Duck.class);
        allAnimal.add(Caterpillar.class);
    }

    //Характеристика сытости
    public static int saturation = 1;

    //Характеристика Wolf
    public final static String nameWolf = "Wolf";
    public final static String iconWolf = "\uD83D\uDC3A";
    public final static double weightWolf = 50.0;
    public final static int speedWolf = 3;
    public final static double needSaturationWolf = 8.0;
    public static HashMap<String, Integer> eatWolf = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 10}, {"Deer", 15},
                    {"Rabbit", 60}, {"Mouse", 80}, {"Goat", 60}, {"Sheep", 70}, {"Hog", 15}, {"Buffalo", 10},
                    {"Duck", 40}, {"Caterpillar", 0}, {"Plant", 0}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Bear
    public final static String nameBear = "Bear";
    public final static String iconBear = "\uD83D\uDC3B";
    public final static double weightBear = 500.0;
    public final static int speedBear = 2;
    public final static double needSaturationBear = 80.0;
    public static HashMap<String, Integer> eatBear = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 80}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 40}, {"Deer", 80},
                    {"Rabbit", 80}, {"Mouse", 90}, {"Goat", 70}, {"Sheep", 70}, {"Hog", 50}, {"Buffalo", 20},
                    {"Duck", 10}, {"Caterpillar", 0}, {"Plant", 0}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Eagle
    public final static String nameEagle = "Eagle";
    public final static String iconEagle = "\uD83E\uDD85";
    public final static double weightEagle = 6.0;
    public final static int speedEagle = 3;
    public final static double needSaturationEagle = 1.0;
    public static HashMap<String, Integer> eatEagle = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 10}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 90}, {"Mouse", 90}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 80}, {"Caterpillar", 0}, {"Plant", 0}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Fox
    public final static String nameFox = "Fox";
    public final static String iconFox = "\uD83E\uDD8A";
    public final static double weightFox = 8.0;
    public final static int speedFox = 2;
    public final static double needSaturationFox = 2.0;
    public static HashMap<String, Integer> eatFox = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 70}, {"Mouse", 90}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 60}, {"Caterpillar", 40}, {"Plant", 0}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Snake
    public final static String nameSnake = "Snake";
    public final static String iconSnake = "\uD83D\uDC0D";
    public final static double weightSnake = 15.0;
    public final static int speedSnake = 1;
    public final static double needSaturationSnake = 3.0;
    public static HashMap<String, Integer> eatSnake = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 15}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 20}, {"Mouse", 40}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 10}, {"Caterpillar", 0}, {"Plant", 0}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Horse
    public final static String nameHorse = "Horse";
    public final static String iconHorse = "\uD83D\uDC0E";
    public final static double weightHorse = 400.0;
    public final static int speedHorse = 4;
    public final static double needSaturationHorse = 60.0;
    public static HashMap<String, Integer> eatHorse = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Deer
    public final static String nameDeer = "Deer";
    public final static String iconDeer = "\uD83E\uDD8C";
    public final static double weightDeer = 300.0;
    public final static int speedDeer = 4;
    public final static double needSaturationDeer = 50.0;
    public static HashMap<String, Integer> eatDeer = (HashMap<String, Integer>) Stream.of(new Object[][]{
            {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
            {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
            {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Rabbit
    public final static String nameRabbit = "Rabbit";
    public final static String iconRabbit = "\uD83D\uDC07";
    public final static double weightRabbit = 2.0;
    public final static int speedRabbit = 2;
    public final static double needSaturationRabbit = 0.45;
    public static HashMap<String, Integer> eatRabbit = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Mouse
    public final static String nameMouse = "Mouse";
    public final static String iconMouse = "\uD83D\uDC01";
    public final static double weightMouse = 0.05;
    public final static int speedMouse = 1;
    public final static double needSaturationMouse = 0.01;
    public static HashMap<String, Integer> eatMouse = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 90}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Goat
    public final static String nameGoat = "Goat";
    public final static String iconGoat = "\uD83D\uDC10";
    public final static double weightGoat = 60.0;
    public final static int speedGoat = 3;
    public final static double needSaturationGoat = 10.0;
    public static HashMap<String, Integer> eatGoat = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Sheep
    public final static String nameSheep = "Sheep";
    public final static String iconSheep = "\uD83D\uDC11";
    public final static double weightSheep = 70.0;
    public final static int speedSheep = 3;
    public final static double needSaturationSheep = 15.0;
    public static HashMap<String, Integer> eatSheep = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Hog
    public final static String nameHog = "Hog";
    public final static String iconHog = "\uD83D\uDC17";
    public final static double weightHog = 400.0;
    public final static int speedHog = 2;
    public final static double needSaturationHog = 50.0;
    public static HashMap<String, Integer> eatHog = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 90}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Buffalo
    public final static String nameBuffalo = "Buffalo";
    public final static String iconBuffalo = "\uD83D\uDC03";
    public final static double weightBuffalo = 700.0;
    public final static int speedBuffalo = 3;
    public final static double needSaturationBuffalo = 100.0;
    public static HashMap<String, Integer> eatBuffalo = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Duck
    public final static String nameDuck = "Duck";
    public final static String iconDuck = "\uD83E\uDD86";
    public final static double weightDuck = 1.0;
    public final static int speedDuck = 4;
    public final static double needSaturationDuck = 0.15;
    public static HashMap<String, Integer> eatDuck = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 90}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Caterpillar
    public final static String nameCaterpillar = "Caterpillar";
    public final static String iconCaterpillar = "\uD83D\uDC1B";
    public final static double weightCaterpillar = 0.01;
    public final static int speedCaterpillar = 0;
    public final static double needSaturationCaterpillar = 0.0;
    public static HashMap<String, Integer> eatCaterpillar = (HashMap<String, Integer>) Stream.of(new Object[][]{
                    {"Wolf", 0}, {"Snake", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                    {"Rabbit", 0}, {"Mouse", 0}, {"Goat", 0}, {"Sheep", 0}, {"Hog", 0}, {"Buffalo", 0},
                    {"Duck", 0}, {"Caterpillar", 0}, {"Plant", 100}})
            .collect(Collectors.toMap(a -> (String) a[0], a -> (Integer) a[1]));

    //Характеристика Plant
    public final static String namePlant = "Plant";
    public final static String iconPlant = "";
    public final static double weightPlant = 1.0;
    public final static int speedPlant = 0;
    public final static double needSaturationPlant = 0.0;

}
