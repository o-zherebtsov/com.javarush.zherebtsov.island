package entity.plants;

import entity.Creature;

public class Plant extends Creature {
    public Plant(String name, String icon, double weight, int speed, double needSaturation, int maxCreatureLocation) {
        super(name, icon, weight, speed, needSaturation, maxCreatureLocation);
    }
}
