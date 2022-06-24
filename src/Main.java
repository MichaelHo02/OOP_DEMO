import controller.GameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //todo create an object

        //todo print name

        //todo use the method runForward

        //todo use the method runbackward

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
