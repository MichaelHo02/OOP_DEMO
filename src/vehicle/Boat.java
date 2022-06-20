package vehicle;

import component.Propeller;
import vehicle.ability.Afloat;

import java.util.ArrayList;
import java.util.List;

public class Boat extends Vehicle implements Afloat {
    private final List<Propeller> propellers;

    public Boat() {
        propellers = new ArrayList<>();
    }

    @Override
    public void renderConfigComponent() {
        System.out.println(
                "Please enter the following: [number of propellers] [propellers' name] [friction bonus] [wear rate]"
        );
    }

    @Override
    public boolean configComponent(String input) {
        try {
            String[] strings = input.split("\s");
            for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
                propellers.add(new Propeller(strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3])));
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
}
