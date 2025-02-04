package entity;

import config.Settings;
import entity.map.Location;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Creature implements Cloneable {

    private final int maxCreatureLocation;
    private final String name;
    private final String icon;
    private final double weight;
    private final int speed;
    private final double needSaturation;
    private final long id = new AtomicLong(System.currentTimeMillis()).incrementAndGet();
    private int saturation = Settings.saturation;
    private Location location;

    @Override
    public Creature clone() throws CloneNotSupportedException {
        return (Creature) super.clone();
    }

    public Creature(String name, String icon, double weight, int speed, double needSaturation, int maxCreatureLocation) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.speed = speed;
        this.needSaturation = needSaturation;
        this.maxCreatureLocation = maxCreatureLocation;
    }

    private final String type = this
            .getClass()
            .getSimpleName();

    public long getId() {
        return id;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public double getNeedSaturation() {
        return needSaturation;
    }

    public int getMaxCreatureLocation() {
        return maxCreatureLocation;
    }

    public void fromLocation(Location location, Creature creature) {
        if (location.equals(creature)) {
            creature.location = location;
        }
    }

    public Location getLocation(){
        return location;
    }
}
