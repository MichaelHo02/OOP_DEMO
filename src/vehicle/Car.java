package vehicle;

import component.Wheel;
import item.Item;
import visual.HealthBar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    /**
     * They are attributes
     * Todo: add modifiers
     */
    private final HealthBar healthBar;
    private String name;
    private Long acceleration;
    private Long deceleration;
    private Long currentSpeed;
    private Long attitude;
    private final List<Wheel> wheels;
    private final List<Item> items;

    /**
     * This is constructor
     */
    public Car() {
        this.name = null;
        this.acceleration = null;
        this.deceleration = null;
        this.currentSpeed = 0L;
        this.attitude = 100L;
        healthBar = new HealthBar(100);
        wheels = new ArrayList<>();
        items = new ArrayList<>();
    }

    /**
     * They are methods
     * Todo: add modifiers
     */
    public void runForward() {
        currentSpeed += acceleration;
    }

    public void runBackward() {
        currentSpeed -= deceleration;
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

    public void renderConfigComponent() {
        System.out.println(
                "Please enter the following: [number of wheels] [wheels' name] [friction bonus] [wear rate]"
        );
    }

    public boolean configComponent(String input) {
        try {
            String[] strings = input.split("\s");
            for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
                wheels.add(new Wheel(strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3])));
            }
        } catch (Exception e) {
            System.out.println("--Invalid input--");
            return false;
        }
        return true;
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

    public void getHit(double rate) {
        healthBar.decrementHealthBy(rate);
    }

    public HealthBar getHealth() {
        return healthBar;
    }

    public boolean isAlive() {
        return healthBar.getAlive();
    }

    public Long getCurrentSpeed() {
        return currentSpeed;
    }

    public Long getAttitude() {
        return attitude;
    }
}
