import java.util.Scanner;

public class Game {
    public static void menu() {
        System.out.println("1 — Start new game\n2 — Records\n3 — History\n4 — Quit the game");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Write name for Player 1");
            String name1 = scanner.next();
            System.out.println("Player 1 name: " + name1);
            System.out.println("Write name for Player 2");
            String name2 = scanner.next();
            System.out.println("Player 2 name: " + name2);
            Board newBoard = new Board();
            newBoard.printBoard();
        } else if (choice == 2) {
            System.out.println("Work in progress");
            menu();
        } else if (choice == 3) {
            System.out.println("Work in progress");
            menu();
        } else {
            System.out.println("Are you sure?\n1 — Leave\n2 — Return to menu");
            int exitChoice = scanner.nextInt();
            if (exitChoice == 1) {
                System.exit(0);
            } else if (exitChoice == 2){
                menu();
            } else {
                System.out.println("Choose correct option\n");
                menu();
            }
        }
    }
    public static void menuOpener() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1) {
            menu();
        } else if (choice == 2) {
            System.out.print("Have a nice day!");
            System.exit(0);
        } else {
            System.out.print("Choose correct option");
            menuOpener();
        }
    }
    public static void gameMenu() {
        System.out.println("Hello! Ready to start?");
        System.out.println("1 — Yes, 2 — No");
        menuOpener();
    }
}
