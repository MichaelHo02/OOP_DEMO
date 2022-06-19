package component;

import config.Environment;

public class Propeller extends Component{
    public Propeller(String name, Long frictionBonus, Long wearRate) {
        super(name, frictionBonus, wearRate);
    }

    @Override
    public boolean isRightEnvironment(Environment environment) {
        return false;
    }
}
