package controller;

import config.Environment;
import config.GameStage;
import item.Item;
import vehicle.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private static GameController gameController = null;
    private GameStage gameStage;
    private Car car;
    private final List<Item> items;
    private final List<Environment> environments;
    private Environment randomEnvironment;
    private int direction;
    private final Random random;

    private GameController() {
        gameStage = GameStage.CHOOSE_VEHICLE;
        items = new ArrayList<>();
        environments = new ArrayList<>();
        random = new Random();
        random.setSeed(Instant.now().getEpochSecond());
    }

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    public void renderMessage() {
        switch (gameStage) {
            case CHOOSE_VEHICLE -> {
                System.out.println("Choose these following type of vehicles");
                System.out.println("1. Car");
                System.out.println("2. Plane");
                System.out.println("3. Boat");
                System.out.println("4. Sea Plane");
            }
            case CONFIG_VEHICLE -> {
                car.renderConfigVehicle();
            }
            case CONFIG_COMPONENT -> {
                System.out.println("Config components");
                car.renderConfigComponent();
            }
            case CONFIG_ITEM -> {
                System.out.println("Config items");
                renderConfigItem();
            }
            case PLAY_GAME -> {
                randomEnvironment = environments.get(random.nextInt(environments.size()));
                System.out.println("You are on: " + randomEnvironment.toString());
                switch (randomEnvironment) {
                    case LAND -> {
                        direction = random.nextInt(1, 3);
                        System.out.println("1. Move forward");
                        System.out.println("2. Move backward");
                    }
                }
                System.out.println("If press " + direction + " you won't loose health");
            }
        }
        System.out.println("Press q to end program");
    }

    public boolean receiveInput(String input) {
        if (input.equals("q")) {
            System.out.println("Quit game");
            return true;
        }
        switch (gameStage) {
            case CHOOSE_VEHICLE -> {
                switch (input) {
                    case "1" -> {
                        car = new Car();
                        environments.addAll(List.of(Environment.LAND));
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                };
                gameStage = GameStage.CONFIG_VEHICLE;
            }
            case CONFIG_VEHICLE -> {
                if (car.configVehicle(input)) {
                    gameStage = GameStage.CONFIG_COMPONENT;
                }
            }
            case CONFIG_COMPONENT -> {
                if (car.configComponent(input)) {
                    gameStage = GameStage.CONFIG_ITEM;
                }
            }
            case CONFIG_ITEM -> {
                if (configItem(input)) {
                    car.addItems(items);
                    gameStage = GameStage.PLAY_GAME;
                }
            }
            case PLAY_GAME -> {
                int inputInt = Integer.parseInt(input);
                if (inputInt != direction) {
                    System.out.println("You got hit!");
                    car.getHit(Math.random() * 20);
                    System.out.println("Your health: " + car.getHealth().getCurrentHealth());
                    if (!car.isAlive()) {
                        System.out.println("Your vehicle is broke");
                        return true;
                    }
                    break;
                }
                switch (randomEnvironment) {
                    case LAND -> {
                        switch (inputInt) {
                            case 1 -> car.runForward();
                            case 2 -> car.runBackward();
                        }
                    }
                }
                System.out.println("Your health: " + car.getHealth().getCurrentHealth());
                System.out.println("Your vehicle speed: " + car.getCurrentSpeed());
                System.out.println("Your vehicle attitude: " + car.getAttitude());
            }
            default -> throw new IllegalStateException("Unexpected value");
        }
        return false;
    }

    public void renderConfigItem() {
        System.out.println(
                "Please enter the following: " +
                        "[name] [acceleration boost] [deceleration boost] [health boost] and repeat"
        );
    }

    public boolean configItem(String input) {
        try {
            String[] strings = input.split("\s");
            for (int i = 0; i < strings.length / 4; i++) {
                int j = i * 4;
                items.add(new Item(
                        strings[j++],
                        Long.parseLong(strings[j++]),
                        Long.parseLong(strings[j++]),
                        Long.parseLong(strings[j]
                        )
                ));
            }
        } catch (Exception e) {
            System.out.println("--Invalid input--");
            return false;
        }
        return true;
    }
}