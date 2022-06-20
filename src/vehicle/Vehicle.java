package vehicle;

import item.Item;
import visual.HealthBar;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected final HealthBar healthBar;
    protected String name;
    protected Long acceleration;
    protected Long deceleration;
    protected Long currentSpeed;
    protected final List<Item> items;

    public Vehicle() {
        this.name = null;
        this.acceleration = null;
        this.deceleration = null;
        this.currentSpeed = 0L;
        healthBar = new HealthBar(100);
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCurrentSpeed() {
        return currentSpeed;
    }

    public void showName() {
        System.out.println(name);
    }

    public void getHit(double rate) {
        healthBar.decrementHealthBy(rate);
    }

    public void getHealth(Long rate) {
        healthBar.incrementHealthBy(rate);
    }

    public void addItems(List<Item> items) {
        this.items.addAll(items);
        updateStat();
    }

    private void updateStat() {
        for (Item item : items) {
            this.healthBar.setMaxHealth(this.healthBar.getMaxHealth() + item.getHealthBoost());
            this.acceleration += item.getAccelerationBoost();
            this.deceleration += item.getDecelerationBoost();
        }
    }

    public void renderConfigVehicle() {
        System.out.println(
                "Please enter the following: [name] [acceleration] [deceleration]"
        );
    }

    public boolean configVehicle(String input) {
        try {
            String[] strings = input.split("\s");
            this.name = strings[0];
            this.acceleration = Long.parseLong(strings[1]);
            this.deceleration = Long.parseLong(strings[2]);
        } catch (Exception e) {
            System.out.println("--Invalid input--");
            return false;
        }
        return true;
    }

    public abstract void renderConfigComponent();

    public abstract boolean configComponent(String input);
}
