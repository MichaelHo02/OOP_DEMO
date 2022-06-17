package vehicle;

public class Car {
    private String name;
    private String honk;
    private Long acceleration;
    private Long deceleration;
    private Long currentSpeed;

    public Car(String name, String honk, Long acceleration, Long deceleration) {
        this.name = name;
        this.honk = honk;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.currentSpeed = 0L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHonk() {
        return honk;
    }

    public void setHonk(String honk) {
        this.honk = honk;
    }

    public Long getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Long acceleration) {
        this.acceleration = acceleration;
    }

    public Long getDeceleration() {
        return deceleration;
    }

    public void setDeceleration(Long deceleration) {
        this.deceleration = deceleration;
    }

    public void accelerate() {
        currentSpeed += acceleration;
    }

    public void decelerate() {
        currentSpeed -= deceleration;
    }

    public void honk() {
        System.out.println(honk);
    }

    public void showName() {
        System.out.println(name);
    }
}
