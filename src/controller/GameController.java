package controller;

import config.GameStage;
import vehicle.*;

public class GameController {
    private static GameController gameController = null;
    private GameStage gameStage;
    private Vehicle vehicle;

    private GameController() {
        gameStage = GameStage.CHOOSE_VEHICLE;
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
            case NAME_VEHICLE -> {
                System.out.println("Choose the name for your vehicle");
            }
            case CONFIG_COMPONENT -> {
                System.out.println("Config component");
                vehicle.renderConfigComponent();
            }
            case ADD_ITEM -> {
                System.out.println("Add items");
            }
            case PLAY_GAME -> {
                System.out.println("Running");
                System.out.println("1. Press increase pedal");
                System.out.println("2. Press decrease pedal");
                System.out.println("3. Press up arrow");
                System.out.println("4. Press down arrow");
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
                vehicle = switch (input) {
                    case "1" -> new Car();
                    case "2" -> new Plane();
                    case "3" -> new Boat();
                    case "4" -> new SeaPlane();
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                };
                gameStage = GameStage.NAME_VEHICLE;
            }
            case NAME_VEHICLE -> {
                vehicle.setName(input);
                gameStage = GameStage.CONFIG_COMPONENT;
            }
            case CONFIG_COMPONENT -> {
                vehicle.configComponent(input);
            }
            case ADD_ITEM -> {
                System.out.println("Add item");
            }
            case PLAY_GAME -> {
                switch (input) {
//                    case "1" -> vehicle.forward();
//                    case "2" -> vehicle.backward();
//                    case "3" -> vehicle.up();
//                    case "4" -> vehicle.down();
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                }
            }
            default -> {

            }
        }
        return false;
    }
}
