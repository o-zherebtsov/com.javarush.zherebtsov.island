package entity.animals.herbivores;

import entity.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, double weight, int speed, double needSaturation, int maxCreatureLocation) {
        super(name, icon, weight, speed, needSaturation, maxCreatureLocation);
    }
}
