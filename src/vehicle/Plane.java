package vehicle;

import vehicle.ability.Flyable;

public class Plane extends Vehicle implements Flyable {
    @Override
    public void renderConfigComponent() {

    }

    @Override
    public boolean configComponent(String input) {
        return false;
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
