package vehicle;

import component.Wheel;
import vehicle.ability.Runnable;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle implements Runnable {
    private final List<Wheel> wheels;

    public Car() {
        wheels = new ArrayList<>();
    }

    @Override
    public void renderConfigComponent() {
        System.out.println(
            "Please enter the following: [number of wheels] [wheels' name] [friction bonus] [wear rate]"
        );
    }

    @Override
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

    @Override
    public void runForward() {
        Long friction = 0L;
        for (Wheel wheel : wheels) {
            friction += wheel.applyFrictionBonus();
        }
        currentSpeed += acceleration + friction;
    }

    @Override
    public void runBackward() {
        Long friction = 0L;
        for (Wheel wheel : wheels) {
            friction += wheel.applyFrictionBonus();
        }
        currentSpeed -= deceleration - friction;
    }
}
