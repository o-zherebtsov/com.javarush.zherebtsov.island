package entity.animals.predators;

import entity.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, double weight, int speed, double needSaturation, int maxCreatureLocation) {
        super(name, icon, weight, speed, needSaturation, maxCreatureLocation);
    }
}
