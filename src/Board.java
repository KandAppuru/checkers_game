public class Board {

    enum ChessFieldState {White, Black, Empty}

    static final Main.ChessFieldState[][] chessStates = new Main.ChessFieldState[][] {
            {Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty},
            {Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White},
            {Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty, Main.ChessFieldState.White, Main.ChessFieldState.Empty},
            {Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty},
            {Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty, Main.ChessFieldState.Empty},
            {Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black},
            {Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty},
            {Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black, Main.ChessFieldState.Empty, Main.ChessFieldState.Black},
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

    private void chessDesk() {
        alphabetLine();
        int i = 0;
        while(i < 8) {
            chessLine(i++);
        }
        lineHead();
        alphabetLine();
    }
}
