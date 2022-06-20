package item;

public class Item {
    private String name;
    private Long accelerationBoost;
    private Long decelerationBoost;
    private Long healthBoost;

    public Item(String name, Long accelerationBoost, Long decelerationBoost, Long healthBoost) {
        this.name = name;
        this.accelerationBoost = accelerationBoost;
        this.decelerationBoost = decelerationBoost;
        this.healthBoost = healthBoost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccelerationBoost() {
        return accelerationBoost;
    }

    public void setAccelerationBoost(Long accelerationBoost) {
        this.accelerationBoost = accelerationBoost;
    }

    public Long getDecelerationBoost() {
        return decelerationBoost;
    }

    public void setDecelerationBoost(Long decelerationBoost) {
        this.decelerationBoost = decelerationBoost;
    }

    public Long getHealthBoost() {
        return healthBoost;
    }

    public void setHealthBoost(Long healthBoost) {
        this.healthBoost = healthBoost;
    }
}
