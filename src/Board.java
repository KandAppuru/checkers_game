import java.util.Scanner;
import java.util.regex.Pattern;

public class Board {

    private enum ChessFieldState {White, Black, Empty}

    private static final ChessFieldState[][] chessStates = new ChessFieldState[][] {
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
    };

    private void alphabetLine() {
        String alphabetLine = "\t\tA\t\tB\t\tC\t\tD\t\tE\t\tF\t\tG\t\tH";
        System.out.println(alphabetLine);
    }
    private void chessLine(int lineNumber) {
        lineHead();
        lineBody(lineNumber);
    }
    private void lineBody(int lineNumber) {
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
    private void lineHead() {
        System.out.print("\t");
        String lineHeadBrick = "+-------";
        int i = 0;
        while (i < 8) {
            System.out.print(lineHeadBrick);
            i++;
        }
        System.out.println("+");
    }

    public void printBoard() {
        alphabetLine();
        int i = 0;
        while(i < 8) {
            chessLine(i++);
        }
        lineHead();
        alphabetLine();
    }
    static Pattern pattern = Pattern.compile("^\\s*[a-hA-H][1-8]\\s*[,\\-~>]{0,2}\\s*[a-hA-H][1-8]\\s*$");
    public void move() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("To make a move, use following regular expression:\n[current checker`s position on a desk][>][final checker`s position]\nExample: A1>C3");
            System.out.println("Waiting for your move");
            String move = scanner.nextLine();
            if (move.equals("0")) break;
            boolean result = pattern.matcher(move).matches();//и это
            System.out.println("Is move valid? " + result);
            String[] splitresults = move.trim().split("[ ,\\-~>]+");//нужно это
            String from = splitresults[0].toLowerCase();
            int fromX = from.charAt(0)-'a';
            int fromY = from.charAt(1)-'1';
            String to = splitresults[1].toLowerCase();
            int toX = to.charAt(0)-'a';
            int toY = to.charAt(1)-'1';
            System.out.println("fromX: " + fromX + ", fromY: " + fromY + ", toX: " + toX + ", toY: " + toY);
            System.out.println(chessStates[fromY][fromX]);
            System.out.println(chessStates[toY][toX]);
            System.out.println("splitresults:");
            for (String splitresult : splitresults) {
                System.out.println(splitresult);
            }
        } while (true);
    }
}
