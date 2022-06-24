package vehicle;

public class Car {
    /**
     * They are attributes
     * Todo: add modifiers
     */
    String name;
    Long acceleration;
    Long deceleration;
    Long currentSpeed;
    Long attitude;

    /**
     * This is constructor
     */
    public Car() {
        this.name = null;
        this.acceleration = null;
        this.deceleration = null;
        this.currentSpeed = 0L;
        this.attitude = 100L;
    }

    /**
     * They are methods
     * Todo: add modifiers
     */
    public void runForward() {
        currentSpeed += acceleration;
    }

    public void runBackward() {
        currentSpeed -= deceleration;
    }
}
