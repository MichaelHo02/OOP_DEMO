package stat;

public class HealthBar {
    private Long health;
    private Long rate;

    public HealthBar(Long health, Long rate) {
        this.health = health;
        this.rate = rate;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public void incrementHealth() {
        health += rate;
    }

    public void decrementHealth() {
        health -= rate;
    }
}
