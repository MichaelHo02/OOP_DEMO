package vehicle;

import component.Propeller;
import component.Wing;
import vehicle.ability.Afloat;
import vehicle.ability.Flyable;

import java.util.ArrayList;
import java.util.List;

public class SeaPlane extends Vehicle implements Flyable, Afloat {
    private final List<Wing> wings;
    private final List<Propeller> propellers;

    public SeaPlane() {
        wings = new ArrayList<>();
        propellers = new ArrayList<>();
    }

    @Override
    public void renderConfigComponent() {
        System.out.println(
                """
                            Please enter the following:
                            [number of wings] [wings' name] [friction bonus] [wear rate]
                            [number of propellers] [propellers' name] [friction bonus] [wear rate]
                        """
        );
    }

    @Override
    public boolean configComponent(String input) {
        try {
            String[] strings = input.split("\s");
            for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
                wings.add(new Wing(strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3])));
            }
            for (int i = 0; i < Integer.parseInt(strings[4]); i++) {
                propellers.add(new Propeller(strings[5], Long.parseLong(strings[6]), Long.parseLong(strings[7])));
            }
        } catch (Exception e) {
            System.out.println("--Invalid input--");
            return false;
        }
        return true;
    }

    @Override
    public void swimForward() {
        Long friction = 0L;
        for (Propeller propeller : propellers) {
            friction += propeller.applyFrictionBonus();
        }
        currentSpeed += acceleration + friction;
    }

    @Override
    public void swimBackWard() {
        Long friction = 0L;
        for (Propeller propeller : propellers) {
            friction += propeller.applyFrictionBonus();
        }
        currentSpeed -= deceleration - friction;
    }

    @Override
    public void flyUp() {
        Long friction = 0L;
        for (Wing wing : wings) {
            friction += wing.applyFrictionBonus();
        }
        attitude += acceleration / 2 + friction;
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
        for (Propeller propeller : propellers) {
            friction += propeller.applyFrictionBonus();
        }
        currentSpeed += acceleration + friction;
    }

    @Override
    public void flyBackward() {
        Long friction = 0L;
        for (Propeller propeller : propellers) {
            friction += propeller.applyFrictionBonus();
        }
        currentSpeed -= deceleration - friction;
    }
}
