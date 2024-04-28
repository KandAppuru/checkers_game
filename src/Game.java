import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    static Pattern pattern = Pattern.compile("^\\s*[a-hA-H][1-8]\\s*[,\\-~>]{0,2}\\s*[a-hA-H][1-8]\\s*$");
    private Board board;
    Scanner scanner = new Scanner(System.in);

    private void menu() {
        System.out.println("1 — Start new game\n2 — Records\n3 — History\n4 — Quit the game");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Write name for Player 1");
            String name1 = scanner.next();
            System.out.println("Player 1 name: " + name1);
            System.out.println("Write name for Player 2");
            String name2 = scanner.next();
            System.out.println("Player 2 name: " + name2);
            board = new Board();
            board.printBoard();
            do {
                try {
                    String[] moveAction = askToMove(scanner);
                    Cell moveTo = getCellMoveTo(moveAction);
                    Cell moveFrom = getCellMoveFrom(moveAction);
                    board.move(moveFrom, moveTo);
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    continue;
                }
                board.printBoard();
            } while (true);
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
            } else if (exitChoice == 2) {
                menu();
            } else {
                System.out.println("Choose correct option\n");
                menu();
            }
        }
    }

    private Cell getCellMoveFrom(String[] moveAction) {
        String from = moveAction[0].toLowerCase();
        return new Cell(from.charAt(0) - 'a', from.charAt(1) - '1');
    }

    private Cell getCellMoveTo(String[] moveAction) {
        String to = moveAction[1].toLowerCase();
        return new Cell(to.charAt(0) - 'a', to.charAt(1) - '1');
    }

    public String[] askToMove(Scanner scanner) {
        System.out.println("To make a move, use following regular expression:\n[current checker`s position on a desk][>][final checker`s position]\nExample: A1>C3");
        System.out.println("Waiting for your move");
        String move = scanner.next();
        boolean isValid = pattern.matcher(move).matches();
        if (!isValid) {
            throw new IllegalArgumentException("Can`t recognize your move. Please try again.");
        }
        return move.trim().split("[ ,\\-~>]+");
    }

    private void menuOpener() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            menu();
        } else if (choice == 2) {
            System.out.print("Have a nice day!");
            System.exit(0);
        } else {
            System.out.print("Choose correct option");
            menuOpener();
        }
    }

    public void gameMenu() {
        System.out.println("Hello! Ready to start?");
        System.out.println("1 — Yes, 2 — No");
        menuOpener();
    }
}
