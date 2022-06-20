package component;

public abstract class Component {
    protected final String name;
    protected Long frictionBonus;
    protected Long wearRate;

    public Component(String name, Long frictionBonus, Long wearRate) {
        this.name = name;
        this.frictionBonus = frictionBonus;
        this.wearRate = wearRate;
    }

    public String getName() {
        return name;
    }

    public Long applyFrictionBonus() {
        Long returnValue = frictionBonus;
        frictionBonus -= wearRate;
        return returnValue;
    }
}
