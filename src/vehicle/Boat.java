package vehicle;

import vehicle.ability.Afloat;

public class Boat extends Vehicle implements Afloat {
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
}
