package component;

public class Wheel {
    private final String name;
    private Long frictionBonus;
    private final Long wearRate;

    public Wheel(String name, Long frictionBonus, Long wearRate) {
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
