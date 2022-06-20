package item;

public class Item {
    private final String name;
    private final Long accelerationBoost;
    private final Long decelerationBoost;
    private final Long healthBoost;

    public Item(String name, Long accelerationBoost, Long decelerationBoost, Long healthBoost) {
        this.name = name;
        this.accelerationBoost = accelerationBoost;
        this.decelerationBoost = decelerationBoost;
        this.healthBoost = healthBoost;
    }

    public String getName() {
        return name;
    }

    public Long getAccelerationBoost() {
        return accelerationBoost;
    }

    public Long getDecelerationBoost() {
        return decelerationBoost;
    }

    public Long getHealthBoost() {
        return healthBoost;
    }
}
