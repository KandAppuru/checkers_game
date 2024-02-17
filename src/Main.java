import java.util.Scanner;

public class Main {
    enum ChessFieldState {White, Black, Empty}

    static ChessFieldState [][] chessStates = new ChessFieldState[][] {
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White},
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
            {ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
    };
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
            chessDesk();
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
                System.out.println("Choose correct option");
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
    public static void main(String[] args) {
        gameMenu();
    }
    public static void chessDesk() {
        alphabetLine();
        int i = 0;
        while(i < 8) {
            chessLine(i++);
        }
        lineHead();
        alphabetLine();
    }
    public static void alphabetLine() {
        String alphabetLine = "\t\tA\t\tB\t\tC\t\tD\t\tE\t\tF\t\tG\t\tH";
        System.out.println(alphabetLine);
    }
    public static void chessLine(int lineNumber) {
        lineHead();
        lineBody(lineNumber);
    }
    public static void lineBody(int lineNumber) {
        System.out.print(lineNumber + 1);
        System.out.print("\t");
        String lineBodyBegin = "|\t";
        String lineBodyEnd = "\t";

        int i = 0;
        while (i < 8) {
            System.out.print(lineBodyBegin);
            switch (chessStates[lineNumber][i]) {
                case Black -> System.out.print((char)0x26AB);
                case White -> System.out.print((char)0x26AA);
                case Empty -> System.out.print("");
            }
            System.out.print(lineBodyEnd);
            i++;
        }
        System.out.println("| " + (lineNumber + 1));
    }
    public static void lineHead() {
        System.out.print("\t");
        String lineHeadBrick = "+-------";
        int i = 0;
        while (i < 8) {
            System.out.print(lineHeadBrick);
            i++;
        }
        System.out.println("+");
    }
}


