package controller;

import config.Environment;
import config.GameStage;
import item.Item;
import vehicle.*;
import vehicle.ability.Afloat;
import vehicle.ability.Flyable;
import vehicle.ability.Runnable;
import vehicle.ability.Submersible;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private static GameController gameController = null;
    private GameStage gameStage;
    private Vehicle vehicle;
    private final List<Item> items;
    private final List<Environment> environments;
    private Environment randomEnvironment;
    private int direction;

    private GameController() {
        gameStage = GameStage.CHOOSE_VEHICLE;
        items = new ArrayList<>();
        environments = new ArrayList<>();
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
                vehicle.renderConfigVehicle();
            }
            case CONFIG_COMPONENT -> {
                System.out.println("Config components");
                vehicle.renderConfigComponent();
            }
            case CONFIG_ITEM -> {
                System.out.println("Config items");
                renderConfigItem();
            }
            case PLAY_GAME -> {
                Random rand = new Random();
                randomEnvironment = environments.get(rand.nextInt(environments.size()));
                switch (randomEnvironment) {
                    case LAND -> {
                        direction = rand.nextInt(2);
                        System.out.println("1. Move forward");
                        System.out.println("2. Move backward");
                    }
                    case AIR -> {
                        direction = rand.nextInt(2);
                        System.out.println("1. Fly up");
                        System.out.println("2. fly down");
                        System.out.println("3. fly forward");
                        System.out.println("4. fly backward");
                    }
                    case HOLLOW_WATER -> {
                        direction = rand.nextInt(4);
                        System.out.println("1. Swim forward");
                        System.out.println("2. Swim backward");
                        System.out.println("3. Dive up");
                        System.out.println("4. Dive down");
                    }
                    case SHALLOW_WATER -> {
                        direction = rand.nextInt(2);

                        System.out.println("1. Swim forward");
                        System.out.println("2. Swim backward");
                    }
                }
                System.out.println("If press " + direction + " you won't loose health");
            }
            default -> throw new IllegalStateException("Unexpected value");
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
                        vehicle = new Car();
                        environments.addAll(List.of(Environment.LAND));
                    }
                    case "2" -> {
                        new Plane();
                        environments.addAll(List.of(Environment.AIR));
                    }
                    case "3" -> {
                        new Boat();
                        environments.addAll(List.of(Environment.HOLLOW_WATER));
                    }
                    case "4" -> {
                        new SeaPlane();
                        environments.addAll(List.of(Environment.HOLLOW_WATER, Environment.AIR));
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                };
                gameStage = GameStage.CONFIG_VEHICLE;
            }
            case CONFIG_VEHICLE -> {
                if (vehicle.configVehicle(input)) {
                    gameStage = GameStage.CONFIG_COMPONENT;
                }
            }
            case CONFIG_COMPONENT -> {
                if (vehicle.configComponent(input)) {
                    gameStage = GameStage.CONFIG_ITEM;
                }
            }
            case CONFIG_ITEM -> {
                if (configItem(input)) {
                    vehicle.addItems(items);
                    gameStage = GameStage.PLAY_GAME;
                }
            }
            case PLAY_GAME -> {
                int inputInt = Integer.parseInt(input);
                if (inputInt != direction) {
                    vehicle.getHit(Math.random());
                    break;
                }
                switch (randomEnvironment) {
                    case LAND -> {
                        Runnable runnable = vehicle instanceof Runnable ? ((Runnable) vehicle) : null;
                        if (runnable == null) {
                            System.out.println("Cannot move on land");
                            break;
                        }
                        switch (inputInt) {
                            case 1 -> runnable.runForward();
                            case 2 -> runnable.runBackward();
                        }
                    }
                    case AIR -> {
                        Flyable flyable = vehicle instanceof Flyable ? ((Flyable) vehicle) : null;
                        if (flyable == null) {
                            System.out.println("cannot move on air");
                            break;
                        }
                        switch (inputInt) {
                            case 1 -> flyable.flyUp();
                            case 2 -> flyable.flyDown();
                            case 3 -> flyable.flyForward();
                            case 4 -> flyable.flyBackward();
                        }
                    }
                    case HOLLOW_WATER -> {
                        Submersible submersible = vehicle instanceof Submersible ? ((Submersible) vehicle) : null;
                        if (submersible == null) {
                            System.out.println("cannot move on hollow water");
                            break;
                        }
                        switch (inputInt) {
                            case 1 -> submersible.swimForward();
                            case 2 -> submersible.swimBackWard();
                            case 3 -> submersible.diveUp();
                            case 4 -> submersible.diveDown();
                        }
                    }
                    case SHALLOW_WATER -> {
                        Afloat afloat = vehicle instanceof Afloat ? ((Afloat) vehicle) : null;
                        if (afloat == null) {
                            System.out.println("Cannot move on shallow water");
                            break;
                        }
                        switch (inputInt) {
                            case 1 -> afloat.swimForward();
                            case 2 -> afloat.swimBackWard();
                        }
                    }
                }
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
