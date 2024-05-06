import java.util.Scanner;

public class Board {
    private enum ChessFieldState {White, Black, Empty}

    private static final ChessFieldState[][] chessStates = new ChessFieldState[][]{
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White},
            {ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty, ChessFieldState.White, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
            {ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty},
            {ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black, ChessFieldState.Empty, ChessFieldState.Black},
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
                case Black -> System.out.print((char) 0x26AB);
                case White -> System.out.print((char) 0x26AA);
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
        while (i < 8) {
            chessLine(i++);
        }
        lineHead();
        alphabetLine();
    }
    private void moveValidityCheck(Cell from, Cell to) {
        int xAbsDiff = Math.abs(from.getX() - to.getX());
        int yAbsDiff = Math.abs(from.getY() - to.getY());
        if (chessStates[from.getY()][from.getX()] == ChessFieldState.Empty) {
            throw new IllegalArgumentException("There is no checker in your cell. Try it again");
        }  //my variant
        if (xAbsDiff != yAbsDiff) {
            throw new IllegalArgumentException("Move not by diagonal");
        }
        if (xAbsDiff == 0) {
            throw new IllegalArgumentException("You can`t move a checker to itself`s position");
        }
        if (xAbsDiff > 2) {
            throw new IllegalArgumentException("Your move is too long");
        }
        if (xAbsDiff == 2 | chessStates[from.getY()][from.getX()] != chessStates[to.getY() - 1][to.getX() - 1] && chessStates[from.getY()][from.getX()] != chessStates[to.getY() + 1][to.getX() + 1] && chessStates[from.getY()][from.getX()] != chessStates[to.getY() + 1][to.getX() - 1] && chessStates[from.getY()][from.getX()] != chessStates[to.getY() - 1][to.getX() + 1]) {
            throw new IllegalArgumentException("No enemy checker, move is not possible");
        }
        if (chessStates[to.getY()][to.getX()] != ChessFieldState.Empty | xAbsDiff == 1) {
            throw new IllegalArgumentException("Target cell isn`t empty");
        }
    }
    public void move(Cell from, Cell to) {
        moveValidityCheck(from, to);
        System.out.println("There is no checker in your cell. Try it again");
        System.out.println("fromX: " + from.getX() + ", fromY: " + from.getY() + ", toX: " + to.getX() + ", toY: " + to.getY());
        System.out.println(chessStates[from.getY()][from.getX()]);
        System.out.println(chessStates[to.getY()][to.getX()]);
        ChessFieldState cellMem = chessStates[from.getY()][from.getX()];
        chessStates[from.getY()][from.getX()] = chessStates[to.getY()][to.getX()];
        chessStates[to.getY()][to.getX()] = cellMem;
    }
}
