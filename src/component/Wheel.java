package component;

public class Wheel {
    private final String name;
    private Long frictionBonus;
    private Long wearRate;

    public Wheel(String name, Long frictionBonus, Long wearRate) {
        this.name = name;
        this.frictionBonus = frictionBonus;
        this.wearRate = wearRate;
    }

    public String getName() {
        return name;
    }

    public void setFrictionBonus(Long frictionBonus) {
        this.frictionBonus = frictionBonus;
    }

    public Long getFrictionBonus() {
        return frictionBonus;
    }

    public Long getWearRate() {
        return wearRate;
    }

    public void setWearRate(Long wearRate) {
        this.wearRate = wearRate;
    }

    public Long applyFrictionBonus() {
        Long returnValue = frictionBonus;
        frictionBonus -= wearRate;
        return returnValue;
    }
}
