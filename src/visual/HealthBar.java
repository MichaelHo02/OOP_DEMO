package visual;

public class HealthBar {
    private double maxHealth;
    private double currentHealth;
    private Boolean alive;

    public HealthBar(double health) {
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.alive = true;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void decrementHealthBy(double rate) {
        if (currentHealth - rate > 0) {
            currentHealth -= rate;
        } else {
            currentHealth = 0L;
            alive = false;
        }
    }
}
