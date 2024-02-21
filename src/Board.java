public class Board {

    private enum ChessFieldState {White, Black, Empty}

    private static final ChessFieldState[][] chessStates = new ChessFieldState[][] {
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
}
