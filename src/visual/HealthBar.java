package visual;

public class HealthBar {
    private Long maxHealth;
    private Long currentHealth;
    private Boolean alive;

    public HealthBar(Long health) {
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.alive = true;
    }

    public Long getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Long maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Long getCurrentHealth() {
        return currentHealth;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void incrementHealthBy(Long rate) {
        if (currentHealth + rate <= maxHealth) {
            currentHealth += rate;
        } else {
            currentHealth = maxHealth;
        }
    }

    public void decrementHealthBy(Long rate) {
        if (currentHealth - rate > 0) {
            currentHealth -= rate;
        } else {
            currentHealth = 0L;
            alive = false;
        }
    }
}
