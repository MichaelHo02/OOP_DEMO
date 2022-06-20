package vehicle;

import component.Wing;
import vehicle.ability.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Vehicle implements Flyable {
    private final List<Wing> wings;

    public Plane() {
        wings = new ArrayList<>();
    }

    @Override
    public void renderConfigComponent() {
        System.out.println(
                "Please enter the following: [number of wings] [wings' name] [friction bonus] [wear rate]"
        );
    }

    @Override
    public boolean configComponent(String input) {
        try {
            String[] strings = input.split("\s");
            for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
                wings.add(new Wing(strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3])));
            }
        } catch (Exception e) {
            System.out.println("--Invalid input--");
            return false;
        }
        return true;
    }

    @Override
    public void flyUp() {
        Long friction = 0L;
        for (Wing wing : wings) {
            friction += wing.applyFrictionBonus();
        }
        attitude += acceleration / 2 - friction;
    }

    @Override
    public void flyDown() {
        Long friction = 0L;
        for (Wing wing : wings) {
            friction += wing.applyFrictionBonus();
        }
        attitude -= acceleration / 2 + friction;
    }

    @Override
    public void flyForward() {
        Long friction = 0L;
        for (Wing wing : wings) {
            friction += wing.applyFrictionBonus();
        }
        currentSpeed += acceleration + friction;
    }

    @Override
    public void flyBackward() {
        Long friction = 0L;
        for (Wing wing : wings) {
            friction += wing.applyFrictionBonus();
        }
        currentSpeed -= deceleration - friction;
    }
}
