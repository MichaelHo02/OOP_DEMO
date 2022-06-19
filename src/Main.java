import controller.GameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = GameController.getGameController();
        while (true) {
            System.out.println("--------------------------------------------");
            gameController.renderMessage();
            System.out.print("Enter input: ");
            String input = scanner.nextLine();
            if (gameController.receiveInput(input)) {
                break;
            }
        }
    }
}
