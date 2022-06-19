package component;

import config.Environment;

public class Wing extends Component{
    public Wing(String name, Long frictionBonus, Long wearRate) {
        super(name, frictionBonus, wearRate);
    }

    @Override
    public boolean isRightEnvironment(Environment environment) {
        return false;
    }
}
