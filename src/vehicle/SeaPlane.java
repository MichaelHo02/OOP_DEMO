package vehicle;

import vehicle.ability.Afloat;
import vehicle.ability.Flyable;

public class SeaPlane extends Vehicle implements Flyable, Afloat {
    @Override
    public void renderConfigComponent() {

    }

    @Override
    public boolean configComponent(String input) {
        return false;
    }

    @Override
    public void swimForward() {

    }

    @Override
    public void swimBackWard() {

    }

    @Override
    public void flyUp() {

    }

    @Override
    public void flyDown() {

    }

    @Override
    public void flyForward() {

    }

    @Override
    public void flyBackward() {

    }
}
