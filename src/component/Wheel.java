package component;

import config.Environment;

public class Wheel extends Component {
    public Wheel(String name, Long frictionBonus, Long wearRate) {
        super(name, frictionBonus, wearRate);
    }

    @Override
    public boolean isRightEnvironment(Environment environment) {
        return environment.equals(Environment.LAND);
    }
}
