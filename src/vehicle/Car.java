package vehicle;

import component.Wheel;
import stat.HealthBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private HealthBar healthBar;
    private String name;
    private String honk;
    private Long acceleration;
    private Long deceleration;
    private Long currentSpeed;
    private List<Wheel> accelerateWheels;
    private List<Wheel> decelerateWheels;

    public Car(String name, String honk, Long acceleration, Long deceleration) {
        this.name = name;
        this.honk = honk;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.currentSpeed = 0L;
        accelerateWheels = new ArrayList<>();
        decelerateWheels = new ArrayList<>();

        accelerateWheels.addAll(Arrays.asList(
                new Wheel("Wheel lv1", 0L, 0L),
                new Wheel("Wheel lv1", 0L, 0L)
        ));

        decelerateWheels.addAll(Arrays.asList(
                new Wheel("Wheel lv1", 0L, 0L),
                new Wheel("Wheel lv1", 0L, 0L)
        ));

        healthBar = new HealthBar(100L, 10L);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHonk() {
        return honk;
    }

    public void setHonk(String honk) {
        this.honk = honk;
    }

    public Long getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Long acceleration) {
        this.acceleration = acceleration;
    }

    public Long getDeceleration() {
        return deceleration;
    }

    public void setDeceleration(Long deceleration) {
        this.deceleration = deceleration;
    }

    public Long getCurrentSpeed() {
        return currentSpeed;
    }

    public List<Wheel> getAccelerateWheels() {
        return accelerateWheels;
    }

    public void setAccelerateWheels(List<Wheel> accelerateWheels) {
        this.accelerateWheels = accelerateWheels;
    }

    public List<Wheel> getDecelerateWheels() {
        return decelerateWheels;
    }

    public void setDecelerateWheels(List<Wheel> decelerateWheels) {
        this.decelerateWheels = decelerateWheels;
    }

    public Long accelerate() {
        Long friction = 0L;
        for (Wheel wheel : accelerateWheels) {
            friction += wheel.applyFrictionBonus();
        }
        currentSpeed += acceleration + friction;
        return currentSpeed;
    }

    public Long decelerate() {
        Long friction = 0L;
        for (Wheel wheel : decelerateWheels) {
            friction += wheel.applyFrictionBonus();
        }
        currentSpeed -= deceleration - friction;
        return currentSpeed;
    }

    public void honk() {
        System.out.println(honk);
    }

    public void showName() {
        System.out.println(name);
    }

    public void getHit() {

    }
}
